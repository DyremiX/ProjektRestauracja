package Restauracja;

class ProduktKurczak implements Produkty{
    String nazwaProduktu;
    double cenaProduktu;
    int kurczakStrips;
    int kurczakChick;
    int kurczakNuggets;

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
}
