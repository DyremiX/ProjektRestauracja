package Restauracja;
import java.util.Scanner;
import  cash.Karta;


public class Kiosk implements Kasy {
	int ID_Kiosku;
    Zamowienie obslugiwane_zamowienie;
    
    public Kiosk(int iD_Kiosku) {
		super();
		ID_Kiosku = iD_Kiosku;
	}

	@Override
	public void rozpocznijZamowienie() {
		Scanner x = new Scanner(System.in);
		obslugiwane_zamowienie = new Zamowienie();
		System.out.println("Witamy w McDonald's, prosimy podaæ zamówienie, wpisuj¹c odpowienie nr");
		System.out.println("w menu (na klawiaturze) i klikaj¹c enter.");
		System.out.println("1. Big mac - 5,45 z³");
		System.out.println("2. 6 nuggetsów - 5,50 z³");
		System.out.println("3. 12 nuggetsów i 12 stripsów - 35,89 z³");
		while (true) {
			switch(x.nextInt()){
			case 1:
				dodajProdukt(new ProduktMieso(null, 13.0, 2, 0, 0), null);
				System.out.print("Dodano Bigmac do zamówienia. Aby opuœciæ menu wpisz 10.");
				break;
			case 2:
				dodajProdukt(null, new ProduktKurczak("6Nuggetsów", 12.0, 0, 0, 6));
				System.out.print("Dodano 6 nuggetsów do zamówienia. Aby opuœciæ menu wpisz 10.");
				break;
			case 3:
				dodajProdukt(null, new ProduktKurczak("12Nuggetsów", 24.0, 0, 0, 12));
				System.out.print("Dodano 12 nuggetsów do zamówienia. Aby opuœciæ menu wpisz 10.");
				break;
			case 10:
				System.out.print("Podsumowanie zamówienia: ");
				for(ProduktKurczak s : obslugiwane_zamowienie.produkty_kurczak) {
					System.out.println(s.nazwaProduktu);
				}
				System.out.println("Koszt zamówienia wynosi: " + obslugiwane_zamowienie.Wartosc_zamowienia);
				x.close();
				return;
			}
		}
	}

	@Override
    public void dodajProdukt(ProduktMieso x, ProduktKurczak y) {
        obslugiwane_zamowienie.dodaj_produkt(x,y);
    }

	@Override
	public void zamknijZamowienie() {
		// TODO Auto-generated method stub	
	}

	public Boolean oplacZamowienie(Karta card) {
		if(card.Withdraw(obslugiwane_zamowienie.getWartosc_zamowienia())) {
			zamknijZamowienie();
			return true;
		}else {
			return false;
		}
		
	}
	
}
