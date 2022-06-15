package Restauracja;

//import java.util.ArrayList;
import java.util.HashMap;

//import Utils.Pair;

public class Zamowienie {
    double cena;
    boolean czyOplacone;
    HashMap<Integer, Integer> listaProduktow;

    Zamowienie(){
        listaProduktow = new  HashMap<Integer, Integer>();
    }

    void dodajProdukt(int idProduktu,int ilosc){
        int aktualnaIlosc = listaProduktow.get(idProduktu);
        listaProduktow.put(idProduktu, aktualnaIlosc+ilosc);
    }
    void dodajProdukt(int idProduktu){
    	dodajProdukt(idProduktu,1);
    }

    public String wyswietl(){
        return "";
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
