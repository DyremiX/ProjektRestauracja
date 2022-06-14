package Restauracja;

import java.util.ArrayList;

class EkranService implements Ekrany{
    //ArrayList<Zamowienie> zamowienia;
        /*Wskazuje jedno z 6 wyswitlanych na ekranie zamowien
        Po wcisinieciu Przycisko serve wskazywane przez nie zamowienie zostanie usuniete z ekranu*/
    int cursor;
    Zamowienie poprzednieZamowienie;
    int iloscZamowien;
    ArrayList<Zamowienie> zamowieniaNaEkranie;
    boolean czyPrzywolano;

    EkranService(){
        this.zamowieniaNaEkranie = new ArrayList<Zamowienie>();
        this.cursor = 0;
        this.iloscZamowien = 0;
        this.poprzednieZamowienie = null;
        this.czyPrzywolano = false;
    }

    /**
     * Przycisk serve - kasuje wydane zamowienie z ekranu
     */
    @Override
    public void przycisk1() {
        zamowieniaNaEkranie.remove(this.cursor);
    }

    /**
     * Przycisk select - zmienia pozycję kursora sluzacego do kasowania konkretnego zamowienia
     */
    @Override
    public void przycisk2() {
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
        String zawartosc = "";
        for(int i = 0; i < zamowieniaNaEkranie.size(); i++){
            if(i == 6)
                break;
            if(i == this.cursor)
                zawartosc += "*";
            zawartosc += zamowieniaNaEkranie.get(i).wyswietl() + "\n";
        }

        if(czyPrzywolano){
            zawartosc += poprzednieZamowienie.wyswietl();
        }


        return zawartosc;
    }