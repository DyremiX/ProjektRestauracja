package Restauracja;

import Restauracja.Produkty.rodzajMiesa;

class ProduktKurczak implements Produkty{
    final String nazwaProduktu;
    final double cenaProduktu;
    final int kurczakStrips;
    final int kurczakChick;
    final int kurczakNuggets;
    

    /**
     * Tworzy nowy produkt
     * @param _nazwa Nazwa produktu
     * @param _cena Cena
     * @param kS Ilosc Stripsow
     * @param kCh Ilosc kotletow z Kurczaka
     * @param kN Ilosc nuggetsow
     */
    ProduktKurczak(String _nazwa, double _cena, int kS, int kCh, int kN){
        this.nazwaProduktu = _nazwa;
        this.cenaProduktu = _cena;
        this.kurczakStrips = kS;
        this.kurczakChick = kCh;
        this.kurczakNuggets = kN;
    }

    @Override
    public void wydruk() {

    }
    public rodzajMiesa rodzajMiesa() {
    	return rodzajMiesa.Kurczak;
    }
}
