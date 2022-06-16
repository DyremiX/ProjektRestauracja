package Restauracja;

import java.util.ArrayList;

class EkranService implements Ekran{
    ArrayList<Zamowienie> zamowienia;
        /*Wskazuje jedno z 6 wyswitlanych na ekranie zamowien
        Po wcisinieciu Przycisko serve wskazywane przez nie zamowienie zostanie usuniete z ekranu*/
    int cursor;
    Zamowienie poprzednieZamowienie;
    int iloscZamowien;

    boolean isActive;
    boolean wyswietlOstatnie;

    ArrayList<Zamowienie> zamowieniaNaEkranie;
    boolean czyPrzywolano;


    EkranService(){
        this.zamowieniaNaEkranie = new ArrayList<Zamowienie>();
        this.cursor = 0;
        this.iloscZamowien = 0;
        this.poprzednieZamowienie = null;

        this.zamowienia = new ArrayList<>();
        this.isActive=true;

        this.czyPrzywolano = false;

    }

    /**
     * Przycisk serve - kasuje wydane zamowienie z ekranu
     */
    @Override
    public void przycisk1() {

    	if(iloscZamowien>0) {
    	poprzednieZamowienie=zamowienia.get(cursor);
    	zamowienia.remove(cursor);
    	przycisk2();
    	}

        zamowieniaNaEkranie.remove(this.cursor);

    }

    /**
     * Przycisk select - zmienia pozycję kursora sluzacego do kasowania konkretnego zamowienia
     */
    @Override
    public void przycisk2() {

    	if(iloscZamowien==0) {
    		cursor=0;
    	}
    	else {
    		cursor++;
    		cursor%=6;
    	}

        this.cursor++;
        if(this.cursor == this.iloscZamowien || this.cursor > 5){
            this.cursor = 0;
        }

    }

    /**
     * Przycisk przywolaj - przywoluje ostatnio skasowane zamowienie
     */
    @Override
    public void przycisk3() {
    	wyswietlOstatnie=!wyswietlOstatnie;
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
        		if(i==cursor)
        			zamowieniaString+=">>";
        		zamowieniaString+=z.toString();
        		if(i==cursor)
        			zamowieniaString+="<<";
        		zamowieniaString+="\n";
        	}
        	return "Aktualne Zamowienia: "+zamowieniaString;
        }
    }
    /**
     * Zwraca aktualna ilosc zamowien na ekranie
     * @return int: ilosc zamowien na ekranie
     */
	@Override
	public int ileZamowien() {
		return iloscZamowien;
	}
}
