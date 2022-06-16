package Restauracja;

//import java.util.ArrayList;
import java.util.HashMap;

//import Utils.Pair;

public class Zamowienie {
    double cena;
    boolean czyOplacone;
    HashMap<Produkty, Integer> listaProduktow;

    /**
     * Konstruktor tworzacy obiekt zamowienie
     */
    Zamowienie(){
        listaProduktow = new  HashMap<Produkty, Integer>();
    }

    /**
     * Funkcja dodajaca do zamowienia produkt i jego zamowiona ilosc
     * @param idProduktu id produktu dodawanego do zamowienia
     * @param ilosc ilosc produktu dodawanego do zamowienia
     */
    void dodajProdukt(int idProduktu,int ilosc){
    	Produkty p = Produkty.getProductFromID(idProduktu);
        int aktualnaIlosc = listaProduktow.get(p);
        listaProduktow.put(p, aktualnaIlosc+ilosc);
        cena+=p.getCenaProduktu()*ilosc;
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
    	return "Stan zamowienia: " +
                "cena: " + cena +
                ", op≥acone: " + ((czyOplacone)? "tak" : "nie") +
                ", Zamowione produkty: " + listaProduktow +
                '}';
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
     * @return lista obiekt√≥w Produkt i ich liczba
     */
	public HashMap<Produkty, Integer> getListaProduktowIIlosci() {
		return this.listaProduktow;
	}
}
