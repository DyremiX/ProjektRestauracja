package Restauracja;

import java.util.ArrayList;

class EkranKuchnia implements Ekran{
    ArrayList<Zamowienie> zamowienia;
    boolean czyAktywny;
    Zamowienie poprzednieZamowienie;
    int iloscZamowien;
    boolean wyswietlOstatnie;


    /**
     * Tworzy nowy ekran typu Kuchnia w restauracji
     */
    EkranKuchnia(){
        this.zamowienia = new ArrayList<Zamowienie>();
        this.czyAktywny = false;
        this.iloscZamowien=0;
        this.wyswietlOstatnie=false;
        this.poprzednieZamowienie=null;
    }

    /**
     * Przycisk serve - kasuje najstarsze zamowienie z ekranu
     */
    @Override
    public void przycisk1() {
    	if(iloscZamowien>0) {
    		iloscZamowien--;
    		poprzednieZamowienie=zamowienia.get(0);
    		zamowienia.remove(0);
    	}
    }

    /**
     * Przycisk przywolaj - pokazuje ostatnie skasowane zamowienie
     */
    @Override
    public void przycisk2() {
    	wyswietlOstatnie=!wyswietlOstatnie;
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
    	zamowienia.add(_zamowienie);
    	iloscZamowien++;
    }

    /**
     * Wyswietla aktualna zawartosc ekranu
     * @return Zwraca zawartosc ekranu w formie stringa
     */
    @Override
    public String wypiszZawartosc() {
    	if(wyswietlOstatnie) {
    		return "Poprzednie Zamowienie: " +poprzednieZamowienie.wyswietl();
    	}
    	else {
    		String zamowieniaString="";
        	for(int i=0;i<6;i++) {
        		Zamowienie z=zamowienia.get(i);
        		zamowieniaString+=z.toString();
        		zamowieniaString+="\n";
        	}
        	return "Aktualne Zamowienia:\n "+zamowieniaString;
        }
    }

	@Override
	public int ileZamowien() {
		return iloscZamowien;
	}
}
