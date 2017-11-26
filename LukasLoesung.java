import java.lang.Math;

public class LukasLoesung {
  public static void main(String[] args) {

    // Tests der Listen
    Liste liste = new Liste();

    liste.vorneEinfuegen(new Datenelement("Lukasteilchen", 22));
	liste.vorneEinfuegen(new Datenelement("Danyloteilchen", 11));
	liste.vorneEinfuegen(new Datenelement("Albertteilchen", 33));

    System.out.println("Das erste Teilchen wiegt: " + liste.ersterGeben().inhaltGeben().gewichtGeben() + " willkürliche Einheiten.");
    System.out.println("Das schwerste Teilchen wiegt: " + liste.maximalgewichtGeben());

    liste.vorneEntnehmen();
    System.out.println("Ein Teilchen ist jetzt verwahrlost.");
    System.out.println("Nun wiegt das aktuelle erste Teilchen: " + liste.ersterGeben().inhaltGeben().gewichtGeben() + " willkürliche Einheiten.");
    System.out.println("Und das schwerste Teilchen wiegt: " + liste.maximalgewichtGeben());

    System.out.println("Die Teilchen innerhalb der Liste wiegen gemeinsam: " + liste.gesamtgewichtGeben() + " willkürliche Einheiten.");

  }
}

class Datenelement {
  String bezeichner;
  int gewicht;

  Datenelement(String b, int g) {
  	this.bezeichner = b;
    this.gewicht = g;
  }

  String bezeichnerGeben() { return this.bezeichner; }
  int gewichtGeben() { return this.gewicht; }
}

class Liste {
  Listenelement erster;

  Liste() {
  	this.erster = new Abschluss();
  }

  Listenelement ersterGeben() {
    return erster;
  }

  int gesamtgewichtGeben() {
  	return erster.gesamtgewichtGeben();
  }

   void vorneEinfuegen(Datenelement e) {
    this.erster = new Knoten(this.erster, e);
   }

  Listenelement vorneEntnehmen() {
    Listenelement temp_element = this.ersterGeben();
    this.erster = this.ersterGeben().naechsterGeben();
    return temp_element;
  }

  int maximalgewichtGeben() { return this.ersterGeben().maximalgewichtGeben(0);}
}

abstract class Listenelement {
  Listenelement() {}

  abstract int gesamtgewichtGeben();
  abstract Listenelement naechsterGeben();
  abstract Datenelement inhaltGeben();
  abstract int maximalgewichtGeben(int max);
}

class Knoten extends Listenelement {
  Listenelement naechster;
  Datenelement inhalt;

  Knoten(Listenelement n, Datenelement i) {
   	this.naechster = n;
    this.inhalt = i;
  }

  Listenelement naechsterGeben() { return this.naechster; }
  Datenelement inhaltGeben() { return this.inhalt; }
  int gesamtgewichtGeben() { return this.inhaltGeben().gewichtGeben() + this.naechsterGeben().gesamtgewichtGeben(); }

  int maximalgewichtGeben(int max) {
    if (max > this.inhaltGeben().gewichtGeben()) {
      return this
        .naechsterGeben()
        .maximalgewichtGeben(max);
    }

    return this
      .naechsterGeben()
      .maximalgewichtGeben(this.inhaltGeben().gewichtGeben());
  }
}

class Abschluss extends Listenelement {
  Abschluss() {}
  int gesamtgewichtGeben() { return 0; }
  Listenelement naechsterGeben() { return null; }
  Datenelement inhaltGeben() { return null; }
  int maximalgewichtGeben(int max) { return max; }
}
