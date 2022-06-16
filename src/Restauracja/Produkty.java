package Restauracja;

import java.util.HashMap;

interface Produkty {
    void wydruk();
    static enum rodzajMiesa {
        Kurczak,
        Mieso,
        Brak
    }


    rodzajMiesa rodzajMiesa();
    public static final HashMap<Integer, Produkty> IDProduktow = new HashMap<Integer, Produkty>();
    public static void dodajProdukt(int ID,Produkty produkt) {
    	IDProduktow.put(ID, produkt);
    }
    public static Produkty getProductFromID(int ID) {
    	return IDProduktow.get(ID);
    }
    int getMieso1();
    int getMieso2();
    int getMieso3();
    double getCenaProduktu();
}
