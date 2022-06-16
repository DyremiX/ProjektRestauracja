package Restauracja;

import java.util.HashMap;

interface Produkt {
    String wydruk();
    static enum rodzajMiesa {
        Kurczak,
        Mieso,
        Brak
    }


    rodzajMiesa rodzajMiesa();
    public static final HashMap<Integer, Produkt> IDProduktow = new HashMap<Integer, Produkt>();
    public static void dodajProdukt(Produkt produkt) {
    	IDProduktow.put(produkt.getIDproduktu(), produkt);
    }
    public static Produkt getProductFromID(int ID) {
    	return IDProduktow.get(ID);
    }
    int getMieso1();
    int getMieso2();
    int getMieso3();
    double getCenaProduktu();
    int getIDproduktu();
}
