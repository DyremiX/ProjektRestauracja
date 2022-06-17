package Restauracja;

import java.io.Serializable;
import java.util.HashMap;

interface Produkt extends Serializable{
	/**
	 * wypisuje zformatowan� informacje o produkcie
	 * @return String
	 */
    String wydruk();
    /**
     * Rodzaje zam�wie�
     * @author kotruper
     *
     */
    static enum rodzajMiesa {
        Kurczak,
        Mieso,
        Brak
    }
    public static boolean czyZainicjalizowano = false;
    
    public static HashMap<Integer,Produkt> IDProduktow = new HashMap<>();
    
    public static void dodajProdukt(Produkt p) {
    	IDProduktow.put(p.getIDproduktu(), p);
    }
    
    public static Produkt getProductFromID(int ID) {
    	return IDProduktow.get(ID);
    }

    rodzajMiesa rodzajMiesa();
    
    /**
     * Zwraca ilo�� mi�sa 1 w produkcie
     * @return ilo�� mi�sa 1
     */
    int getMieso1();
    /**
     * Zwraca ilo�� mi�sa 2 w produkcie
     * @return ilo�� mi�sa 2
     */
    int getMieso2();
    /**
     * Zwraca ilo�� mi�sa 3 w produkcie
     * @return ilo�� mi�sa 3
     */
    int getMieso3();
    double getCenaProduktu();
    int getIDproduktu();
}
