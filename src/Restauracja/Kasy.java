package Restauracja;

import java.io.Serializable;

interface Kasy extends Serializable{
    /**
     * Funkcja rozpoaczynajaca tworzenie nowego zamowienia
     */
    void rozpocznijZamowienie();
    /**
     * Funckja dodajaca do aktualnie otwartego zamowienia produkt
     * @param x idProduktu dodawanego do zamowienia
     * @param y ilosc produktow
     */
    void dodajProdukt(int x, int y);
    /**
     * Fukcja zamykajaca zamowienie
     */
    Zamowienie zamknijZamowienie();

    /**
     * Funckja zwracajaca informacje o wszystkich dostepnych produktach
     * @return string zawierajacy pelna liste produktow i ich ceny
     */
     String wyswietlProdukty();

    /**
     * Funkcja zwracająca informacje o aktualnym zamowieniu
     * @return informacje o aktualnym zamowieniu
     */
    String wyswietlZamowienie();
    
    int getID();

}
