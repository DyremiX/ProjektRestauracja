package Restauracja;

class EkranService implements Ekrany{
    //ArrayList<Zamowienie> zamowienia;
        /*Wskazuje jedno z 6 wyswitlanych na ekranie zamowien
        Po wcisinieciu Przycisko serve wskazywane przez nie zamowienie zostanie usuniete z ekranu*/
    int cursor;
    Zamowienie poprzednieZamowienie;
    int iloscZamowien;

    EkranService(){
        this.cursor = 0;
        this.iloscZamowien = 0;
        this.poprzednieZamowienie = null;
    }

    /**
     * Przycisk serve - kasuje wydane zamowienie z ekranu
     */
    @Override
    public void przycisk1() {

    }

    /**
     * Przycisk select - zmienia pozycję kursora sluzacego do kasowania konkretnego zamowienia
     */
    @Override
    public void przycisk2() {

    }

    /**
     * Przycisk przywolaj - przywoluje ostatnio skasowane zamowienie
     */
    @Override
    public void przycisk3() {

    }

    /**
     * Zwraca informacje o typie ekranu
     * @return typEkranu
     */
    @Override
    public typEkranu typEkranu() {
        return typEkranu.Service;
    }

    /**
     * Zwraca informacje czy ekran jest aktynwy
     * @return czyAktywny
     */
    @Override
    public boolean czyAktywny(){
        return true;
    }

    /**
     * Dodaje nowe zamowienie do ekranu
     * @param _zamowienie Obiekt zamowienie
     */
    @Override
    public void dodajZamowienie(Zamowienie _zamowienie) {

    }

    /**
     * Wyswietla aktualna zawartosc ekranu
     * @return Zwraca zawartosc ekranu w formie stringa
     */
    @Override
    public String wypiszZawartosc() {
        return null;
    }
}