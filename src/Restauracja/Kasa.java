package Restauracja;

class Kasa_Fiskalna implements Kasy{
    int nrKasy;
    int zalogowanyPracownik;
    Zamowienie obslugiwane_zamowienie;
    //Sterownik_ekranow sterownik;

    
    Kasa_Fiskalna (int nrKasy){//Sterownik_ekranow sterownik){
        this.nrKasy = nrKasy;
        //this.sterownik = sterownik;
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
     * @param idProduktu idProduktu dodawanego do zamowienia
     */
    @Override
    public void dodajProdukt(int x, int y) {
        obslugiwane_zamowienie.dodajProdukt(x,y);
    }

    /**
     * Fukcja zamykajaca zamowienie
     */
    @Override
    public void zamknijZamowienie() {
        obslugiwane_zamowienie = null;
    }

    /**
     * Funkcja zmieniajaca status zamowienia na oplacone
     */
    public void oplacZamowienie() {
    	
    }
}
