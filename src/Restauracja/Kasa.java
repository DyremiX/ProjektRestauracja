package Restauracja;

class Kasa implements Kasy{
    int nrKasy;
    int zalogowanyPracownik;
    Zamowienie obslugiwane_zamowienie;
    //Sterownik_ekranow sterownik;

    
    Kasa (int nrKasy){//Sterownik_ekranow sterownik){
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
    public void dodajProdukt(int idProduktu) {
        //obslugiwane_zamowienie.dodajZamowienie(idProduktu);
    }

    /**
     * Fukcja zamykajaca zamowienie
     */
    @Override
    public void zamknijZamowienie() {
        //sterownik.dodajZamowienie(obslugiwane_zamowienie);
        obslugiwane_zamowienie = null;
    }

    /**
     * Funkcja zmieniajaca status zamowienia na oplacone
     */
    @Override
    public void oplacZamowienie() {

    }
}