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
        int aktualnaIlosc = getListaProduktow().get(idProduktu);
        getListaProduktow().put(idProduktu, aktualnaIlosc+ilosc);
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
                ", listaProduktow=" + getListaProduktow() +
                '}';
    }

	HashMap<Integer, Integer> getListaProduktow() {
		return listaProduktow;
	}
}
