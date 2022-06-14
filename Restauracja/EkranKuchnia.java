package Restauracja;

class EkranKuchnia implements Ekrany{
    //ArrayList<Zamowienie> zamowienia;
    boolean czyAktywny;


    /**
     * Tworzy nowy ekran typu Kuchnia w restauracji
     */
    EkranKuchnia(){
        //this.zamowienia = new ArrayList<Zamowienie>();
        this.czyAktywny = false;
    }

    /**
     * Przycisk serve - kasuje najstarsze zamowienie z ekranu
     */
    @Override
    public void przycisk1() {

    }

    /**
     * Przycisk przywolaj - pokazuje ostatnie skasowane zamowienie
     */
    @Override
    public void przycisk2() {

    }

    /**
     * Przycisk wlaczStrone - aktywuje/dezaktywuje ekran tak ze moga splywac do niego nowe zamowienia
     */
    @Override
    public void przycisk3() {
        this.czyAktywny = !this.czyAktywny;
    }

    /**
     * Zwraca informacje o typie ekranu
     * @return typEkranu
     */
    @Override
    public typEkranu typEkranu() {
        return typEkranu.Kuchnia;
    }

    /**
     * Zwraca informacje czy ekran jest aktynwy
     * @return czyAktywny
     */
    @Override
    public boolean czyAktywny(){
        return this.czyAktywny;
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
        return  "";
    }
}
