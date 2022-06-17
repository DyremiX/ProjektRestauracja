package Restauracja;

import java.io.Serializable;
import java.util.HashMap;

interface Produkt extends Serializable{
	/**
	 * wypisuje zformatowan¹ informacje o produkcie
	 * @return String
	 */
    String wydruk();
    /**
     * Rodzaje zamówieñ
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
     * Zwraca iloœæ miêsa 1 w produkcie
     * @return iloœæ miêsa 1
     */
    int getMieso1();
    /**
     * Zwraca iloœæ miêsa 2 w produkcie
     * @return iloœæ miêsa 2
     */
    int getMieso2();
    /**
     * Zwraca iloœæ miêsa 3 w produkcie
     * @return iloœæ miêsa 3
     */
    int getMieso3();
    double getCenaProduktu();
    int getIDproduktu();
}
