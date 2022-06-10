package Restauracja;

interface Kasy{
    /**
     * Funkcja rozpoaczynajaca tworzenie nowego zamowienia
     */
    void rozpocznijZamowienie();
    /**
     * Funckja dodajaca do aktualnie otwartego zamowienia produkt
     * @param idProduktu idProduktu dodawanego do zamowienia
     */
    void dodajProdukt(int idProduktu);
    /**
     * Fukcja zamykajaca zamowienie
     */
    void zamknijZamowienie();
    /**
     * Funkcja zmieniajaca status zamowienia na oplacone
     */
    void oplacZamowienie();
}
