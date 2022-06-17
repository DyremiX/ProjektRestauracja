package Restauracja;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.HashMap;

//import Utils.Pair;

public class Zamowienie implements Serializable{
    double cena;
    boolean czyOplacone;
    HashMap<Produkt, Integer> listaProduktow;

    /**
     * Konstruktor tworzacy obiekt zamowienie
     */
    Zamowienie(){
        listaProduktow = new  HashMap<Produkt, Integer>();
        cena=0;
        czyOplacone=false;
    }
    
    
    
    /**
     * Funkcja dodajaca do zamowienia produkt i jego zamowiona ilosc
     * @param idProduktu id produktu dodawanego do zamowienia
     * @param ilosc ilosc produktu dodawanego do zamowienia
     */
    void dodajProdukt(int idProduktu,int ilosc){
    	Produkt p = Produkt.getProductFromID(idProduktu);
        if(listaProduktow.get(p) != null){
            int aktualnaIlosc = listaProduktow.get(p);
            listaProduktow.put(p, aktualnaIlosc+ilosc);
        }else{
            listaProduktow.put(p, ilosc);
        }

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
    	String lista="";
    	for(Produkt p:listaProduktow.keySet()) {
    		lista+="\n Iloœæ: "+listaProduktow.get(p)+", "+p.wydruk();
    	}
    	return "Stan zamowienia: " +
                "Cena: " + cena +
                ", Op³acone: " + ((czyOplacone)? "tak" : "nie") +
                ", Zamowione produkty: " + lista;
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
     * Zwraca listê produktów i ich liczbe w zamówieniu
     * @return lista obiektów Produkt i ich liczba
     */
	public HashMap<Produkt, Integer> getListaProduktowIIlosci() {
		return this.listaProduktow;
	}
}
