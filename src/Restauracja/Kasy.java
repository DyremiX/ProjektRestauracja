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
    void dodajProdukt(int x, int y);
    /**
     * Fukcja zamykajaca zamowienie
     */
    void zamknijZamowienie();
}
