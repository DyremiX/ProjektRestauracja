<<<<<<< HEAD
package Restauracja;

import java.util.ArrayList;

class EkranKurczak implements Ekrany{
    int miesaStrips;
    int miesaChick;
    int miesaNuggets;
    
    int iloscZamowien;
    ArrayList<Zamowienie> zamowienia;
    boolean isActive;
    /**
     * Tworzy nowy ekran typu Grill w restauracji
     */
    EkranKurczak(){
        this.miesaStrips = 0;
        this.miesaChick = 0;
        this.miesaNuggets = 0;
        this.isActive=true;
        this.iloscZamowien=0;
    }
    /**
     * Przycisk Strips - kasuje z ekranu 8 mies Strips
     */
    @Override
    public void przycisk1() {
        if(this.miesaStrips <= 8)
            this.miesaStrips = 0;
        else
            this.miesaStrips -= 8;
    }

    /**
     * Przycisk Chick - kasuje z ekranu 6 mies Chick
     */
    @Override
    public void przycisk2() {
        if(this.miesaChick <= 6)
            this.miesaChick = 0;
        else
            this.miesaChick -= 6;
    }

    /**
     * Przycisk Nuggets - kasuje z ekranu 20 mies Nuggets
     */
    @Override
    public void przycisk3() {
        if(this.miesaNuggets <= 20)
            this.miesaNuggets = 0;
        else
            this.miesaNuggets -= 20;
    }

    /**
     * Zwraca informacje o typie ekranu
     *
     * @return typEkranu
     */
    @Override
    public typEkranu typEkranu() {
        return typEkranu.Kurczak;
    }

    /**
     * Zwraca informacje czy ekran jest aktynwy
     * @return czyAktywny
     */
    @Override
    public boolean czyAktywny(){
        return isActive;
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
     *
     * @return Zwraca zawartosc ekranu w formie stringa
     */
    @Override
    public String wypiszZawartosc() {
        return "";
    }
	/**
     * Zwraca aktualna ilosc zamowien na ekranie
     * @return int: ilosc zamowien na ekranie
     */
	@Override
	public int ileZamowien() {
		return iloscZamowien;
	}
=======
package Restauracja;

class EkranKurczak implements Ekrany{
    int miesaStrips;
    int miesaChick;
    int miesaNuggets;

    /**
     * Tworzy nowy ekran typu Grill w restauracji
     */
    EkranKurczak(){
        this.miesaStrips = 0;
        this.miesaChick = 0;
        this.miesaNuggets = 0;
    }
    /**
     * Przycisk Strips - kasuje z ekranu 8 mies Strips
     */
    @Override
    public void przycisk1() {
        if(this.miesaStrips <= 8)
            this.miesaStrips = 0;
        else
            this.miesaStrips -= 8;
    }

    /**
     * Przycisk Chick - kasuje z ekranu 6 mies Chick
     */
    @Override
    public void przycisk2() {
        if(this.miesaChick <= 6)
            this.miesaChick = 0;
        else
            this.miesaChick -= 6;
    }

    /**
     * Przycisk Nuggets - kasuje z ekranu 20 mies Nuggets
     */
    @Override
    public void przycisk3() {
        if(this.miesaNuggets <= 20)
            this.miesaNuggets = 0;
        else
            this.miesaNuggets -= 20;
    }

    /**
     * Zwraca informacje o typie ekranu
     *
     * @return typEkranu
     */
    @Override
    public typEkranu typEkranu() {
        return typEkranu.Kurczak;
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
     *
     * @return Zwraca zawartosc ekranu w formie stringa
     */
    @Override
    public String wypiszZawartosc() {
        return "";
    }
>>>>>>> refs/remotes/origin/master
}