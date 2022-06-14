package Restauracja;

import java.util.ArrayList;
import java.util.HashMap;

import Utils.Pair;

public class Zamowienie {
    double cena;
    boolean czyOplacone;
    HashMap<Integer, Integer> listaProduktow;

    Zamowienie(){
        listaProduktow = new  HashMap<Integer, Integer>();
    }

    void dodajProdukt(int idProduktu){
        int aktualnaIlosc = listaProduktow.get(idProduktu);
        listaProduktow.put(idProduktu, ++aktualnaIlosc);
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
}
