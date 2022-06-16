package Restauracja;

//import java.util.ArrayList;
import java.util.HashMap;

//import Utils.Pair;

public class Zamowienie {
    double cena;
    boolean czyOplacone;
    HashMap<Integer, Integer> listaProduktow;

    /**
     * Konstruktor tworzacy obiekt zamowienie
     */
    Zamowienie(){
        listaProduktow = new  HashMap<Integer, Integer>();
    }

    /**
     * Funkcja dodajaca do zamowienia produkt i jego zamowiona ilosc
     * @param idProduktu id produktu dodawanego do zamowienia
     * @param ilosc ilosc produktu dodawanego do zamowienia
     */
    void dodajProdukt(int idProduktu,int ilosc){
        int aktualnaIlosc = listaProduktow.get(idProduktu);
        listaProduktow.put(idProduktu, aktualnaIlosc+ilosc);
    }

    /**
     * Funckja dodajaca do zamowienia 1 produkt
     * @param idProduktu id produktu dodawanego do zamowienia
     */
    void dodajProdukt(int idProduktu){
    	dodajProdukt(idProduktu,1);
    }

    /**
     * Funckja zwracajaca informacje o zamowieniu
     * @return string zawierajacy liste zamowionych produktow, ilosc etc.
     */
    public String wyswietl(){
        return "";
    }

    /**
     * Funckja zmieniajaca status zamowienia jako oplacone
     */
    void oplacZamowienie(){
        czyOplacone = true;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "cena=" + cena +
                ", czyOplacone=" + czyOplacone +
                ", listaProduktow=" + listaProduktow +
                '}';
    }
    /**
     * Zwraca
     * @return lista obiektów Produkt i ich liczba
     */
	public HashMap<Produkty, Integer> getListaProduktowIIlosci() {
		HashMap<Produkty,Integer> lista=new HashMap<>();
		for (int ID : listaProduktow.keySet()) {
			lista.put(Produkty.getProductFromID(ID), listaProduktow.get(ID));
		}
		return lista;
	}
}
