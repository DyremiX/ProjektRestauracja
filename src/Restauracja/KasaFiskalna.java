package Restauracja;

import exceptions.IDDoesNotExistException;
import exceptions.TooManyItemsException;

class KasaFiskalna implements Kasy{
    int nrKasy;
    int zalogowanyPracownik;
    Zamowienie obslugiwane_zamowienie;

    /**
     * Tworzy now¹ kasê o danym numerze
     * @param nrKasy
     */
    KasaFiskalna (int nrKasy){
        this.nrKasy = nrKasy;
    }
    public int getID() {
    	return nrKasy;
    }

    void zalogujPracownika (int zalogowanyPracownik){
        if(obslugiwane_zamowienie == null) this.zalogowanyPracownik = zalogowanyPracownik;
    }
    /**
     * Funkcja rozpoaczynajaca tworzenie nowego zamowienia
     */
    @Override
    public void rozpocznijZamowienie() {
        obslugiwane_zamowienie = new Zamowienie();
    }

    /**
     * Funckja dodajaca do aktualnie otwartego zamowienia produkt
     * @param id idProduktu dodawanego do zamowienia
     * @param n ilosc produktÃ³w
     */
    @Override
    public void dodajProdukt(int id, int n) {
    	try {
    		if(!Produkt.IDProduktow.containsKey(id)) throw new IDDoesNotExistException(id);
    		if(n>20) throw new TooManyItemsException(n);
    		obslugiwane_zamowienie.dodajProdukt(id,n);
    	}
    	catch(IDDoesNotExistException exc) {
    		System.out.println(exc);
    	}
    	catch(TooManyItemsException exc) {
    		System.out.println(exc);
    	}
    }

    /**
     * Fukcja zamykajaca zamowienie i zwracajÄ…ca je
     * @return obiekt zamowienie
     */
    @Override
    public Zamowienie zamknijZamowienie() {
        obslugiwane_zamowienie.oplacZamowienie();
        return obslugiwane_zamowienie;
    }

    /**
     * Funkcja zmieniajaca status zamowienia na oplacone
     */
    public void oplacZamowienie() {
    	obslugiwane_zamowienie.oplacZamowienie();
    }

    /**
     * Funckja zwracajaca informacje o wszystkich dostepnych produktach
     * @return string zawierajacy pelna liste produktow i ich ceny
     */
    public void wyswietlProdukty(){
    	String lista = "";
    	for(int ID : Produkt.IDProduktow.keySet()) {
    		Produkt p = Produkt.getProductFromID(ID);
    		lista += "\n " + p.wydruk();
    	}
        System.out.println("Wszystkie produkty: " + lista);
    }

    /**
     * Funkcja zwracajÄ…ca informacje o aktualnym zamowieniu
     * @return informacje o aktualnym zamowieniu
     */
    public void wyswietlZamowienie(){
        System.out.println(obslugiwane_zamowienie.wyswietl());
    }
}
