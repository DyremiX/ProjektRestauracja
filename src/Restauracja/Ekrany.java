package Restauracja;

interface Ekrany{
    /**
     * Typy ekranow
     */
    enum typEkranu {
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