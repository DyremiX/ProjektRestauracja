package Restauracja;

//import Restauracja.Produkty.rodzajMiesa;

class ProduktKurczak implements Produkty{
    final String nazwaProduktu;
    final double cenaProduktu;
    int idProduktu;
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
    ProduktKurczak(String _nazwa, double _cena,int id, int kS, int kCh, int kN){
        this.nazwaProduktu = _nazwa;
        this.cenaProduktu = _cena;
        this.idProduktu = id;
        this.kurczakStrips = kS;
        this.kurczakChick = kCh;
        this.kurczakNuggets = kN;
    }

    @Override
    public String wydruk() {
    	return "Id: "+idProduktu+" Nazwa: "+nazwaProduktu+" Cena: "+cenaProduktu;
    }
    public rodzajMiesa rodzajMiesa() {
    	return rodzajMiesa.Kurczak;
    }
    @Override
	public int getMieso1() {
		return kurczakStrips;
	}

	@Override
	public int getMieso2() {
		return kurczakChick;
	}

	@Override
	public int getMieso3() {
		return kurczakNuggets;
	}
	public double getCenaProduktu() {
		return cenaProduktu;
	}
	public int getIDproduktu() {
		return idProduktu;
	}
}
