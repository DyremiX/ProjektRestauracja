package Restauracja;

import java.io.Serializable;

interface Ekran extends Serializable{
    /**
     * Typy ekranow
     */
    static enum typEkranu {
        Kuchnia,
        Grill,
        Kurczak,
        Service
    }
    
    void przycisk1();
    void przycisk2();
    void przycisk3();
    /**
     * Zwraca informacje o typie ekranu
     * @return typEkranu
     */
    typEkranu typEkranu();
    /**
     * Zwraca iloœæ zamówieñ przypisana dla danego ekranu
     * @return iloœæ zamówieñ
     */
    int ileZamowien();

    /**
     * Zwraca informacje czy ekran jest aktynwy
     * @return czyAktywny
     */
    boolean czyAktywny();
    /**
     * Dodaje nowe zamowienie do ekranu
     * @param _zamowienie Obiekt zamowienie
     */
    void dodajZamowienie(Zamowienie _zamowienie);
    /**
     * Wyswietla aktualna zawartosc ekranu
     * @return Zwraca zawartosc ekranu w formie stringa
     */
    String wypiszZawartosc();

}