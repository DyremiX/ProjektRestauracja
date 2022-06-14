package Restauracja;

import java.util.ArrayList;

public class Zamowienie {
	ArrayList<ProduktMieso> produkty_miesne;
	ArrayList<ProduktKurczak> produkty_kurczak;
	double Wartosc_zamowienia;
	public double getWartosc_zamowienia() {
		return Wartosc_zamowienia;
	}
	public Zamowienie() {
		super();
		Wartosc_zamowienia = 0;
	}
	public void dodaj_produkt(ProduktMieso x,  ProduktKurczak y) {
		produkty_miesne.add(x);
		produkty_kurczak.add(y);
		Wartosc_zamowienia += x.cenaProduktu + y.cenaProduktu;
	}
}
