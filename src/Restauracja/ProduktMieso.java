package Restauracja;

class ProduktMieso implements Produkty{
    final String nazwaProduktu;
    final double cenaProduktu;
    final int mieso101;
    final int mieso41;
    final int miesoThicker;

    /**
     * Tworzy nowy produkt z miesem
     * @param _nazwa Nazwa produktu miesnego
     * @param _cena Cena
     * @param m10 Ilosc kotletow 10:1
     * @param m4 Ilosc kotletow 4:1
     * @param mT Ilosc kotletow Thicker
     */
    ProduktMieso(String _nazwa, double _cena, int m10, int m4, int mT){
        this.nazwaProduktu = _nazwa;
        this.cenaProduktu = _cena;
        this.mieso101 = m10;
        this.mieso41 = m4;
        this.miesoThicker = mT;
    }

    @Override
    public void wydruk() {

    }
    public rodzajMiesa rodzajMiesa() {
    	return rodzajMiesa.Mieso;
    }

	@Override
	public int getMieso1() {
		return mieso101;
	}

	@Override
	public int getMieso2() {
		return mieso41;
	}

	@Override
	public int getMieso3() {
		return miesoThicker;
	}
	public double getCenaProduktu() {
		return cenaProduktu;
	};
}
