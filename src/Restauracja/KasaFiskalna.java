package Restauracja;

import exceptions.IDDoesNotExistException;
import exceptions.TooManyItemsException;

class KasaFiskalna implements Kasy{
    int nrKasy;
    int zalogowanyPracownik;
    Zamowienie obslugiwane_zamowienie;


    KasaFiskalna (int nrKasy){
        this.nrKasy = nrKasy;
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
     * @param x idProduktu dodawanego do zamowienia
     * @param y ilosc produktów
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
     * Fukcja zamykajaca zamowienie i zwracająca je
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
    	obslugiwane_zamowienie = null;
    }

    /**
     * Funckja zwracajaca informacje o wszystkich dostepnych produktach
     * @return string zawierajacy pelna liste produktow i ich ceny
     */
    public String wyswietlProdukty(){
    	String lista = "";
    	for(int ID : Produkt.IDProduktow.keySet()) {
    		Produkt p = Produkt.getProductFromID(ID);
    		lista += "\n " + p.wydruk();
    	}
    	return "Wszystkie produkty: " + lista;
    }

    /**
     * Funkcja zwracająca informacje o aktualnym zamowieniu
     * @return informacje o aktualnym zamowieniu
     */
    public String wyswietlZamowienie(){
        return obslugiwane_zamowienie.wyswietl();
    }
}
