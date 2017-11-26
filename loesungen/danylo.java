import java.lang.Math; // headers MUST be above the first class


public class MAIN{
  public static void main(String[] args) {
    
	  
	  LISTE liste = new LISTE();
	    
	  DATENELEMENT e1 = new DATENELEMENT("e1", 1);
	  DATENELEMENT e2 = new DATENELEMENT("e2", 2);
	  DATENELEMENT e3 = new DATENELEMENT("e3", 3);
	  	
	  liste.VorneEinfügen(e1);
	  liste.VorneEinfügen(e2);
	  liste.VorneEinfügen(e3);	         
	  
  }
}


class LISTE{
	
  LISTENELEMENT erster;
  
  LISTE(){}
  
  LISTENELEMENT ErsterGeben(){
    
	  return erster;

  }
	
  DATENELEMENT InhaltErsterGeben(){
  
	  return erster.InhaltGeben();
  
  }

  int GesamtgewichtGeben() {
	
	  return erster.GesamtgewichtGeben();
    
  }
  
  void VorneEinfügen(DATENELEMENT i) {
	  
	  erster = new KNOTEN(this.erster, i);
	  	  
  } 
}


class DATENELEMENT{
	
  String bezeichner;
  int gewicht;
  
  DATENELEMENT(String b, int g){
    
  	bezeichner = b;
    gewicht = g;
  
  }
	
  int GewichtGeben(){
  	
    return gewicht;
  
  }

}


abstract class LISTENELEMENT{
	
	LISTENELEMENT(){}
	  
	abstract LISTENELEMENT NächsterGeben();
	abstract DATENELEMENT InhaltGeben();
	abstract KNOTEN HintenEinfügen(DATENELEMENT i);
	abstract DATENELEMENT InhaltLetzterGeben(DATENELEMENT i);
	abstract int GesamtgewichtGeben();

}


class KNOTEN extends LISTENELEMENT{
	 
	LISTENELEMENT nächster;
	DATENELEMENT inhalt;
	
	KNOTEN(LISTENELEMENT n, DATENELEMENT i){
		
		nächster = n;
		inhalt = i;
	}
	
	void NächsterSetzen(LISTENELEMENT n){
		
		nächster = n;
		
	}
	
	void InhaltSetzen(DATENELEMENT i){
		
		inhalt = i;
		
	}
	
	LISTENELEMENT NächsterGeben(){
		
		return nächster;
	}
	
	DATENELEMENT InhaltGeben(){
		
		return inhalt;
		
	}
	
	KNOTEN HintenEinfügen(DATENELEMENT i) {
		
		nächster = nächster.HintenEinfügen(i);
		
		return this;
		
	}
	
	DATENELEMENT InhaltLetzterGeben(DATENELEMENT i) {
		
		return nächster.InhaltLetzterGeben(i);
		
	}
	
	int GesamtgewichtGeben() {
		
		return inhalt.GewichtGeben() + nächster.GesamtgewichtGeben();
	}
}


class ABSCHLUSS extends LISTENELEMENT{
	
	  LISTENELEMENT NächsterGeben(){
  	
	  return this;
    
	  }
		
	  DATENELEMENT InhaltGeben() {
		
		return null;
	  }
		
	  KNOTEN HintenEinfügen(DATENELEMENT i) {
				  		  
		return new KNOTEN(this, i);
		
	  }
		
	  DATENELEMENT InhaltLetzterGeben(DATENELEMENT i) {
		
		return i;
		
	  }
		
	  int GesamtgewichtGeben() {
		
		return 0;
	  }
	
}

