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


    rodzajMiesa rodzajMiesa();
    public static final HashMap<Integer, Produkt> IDProduktow = new HashMap<Integer, Produkt>();
    /**
     * Dodaje produkt i jego id do listy produkt�w
     * @param produkt
     */
    public static void dodajProdukt(Produkt produkt) {
    	IDProduktow.put(produkt.getIDproduktu(), produkt);
    }
    /**
     * Zwraca Produkt na bazie podanego ID
     * @param ID
     * @return produkt z danym ID
     */
    public static boolean czyZainicjalizowano = false;
    public static Produkt getProductFromID(int ID) {
    	return IDProduktow.get(ID);
    }
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
