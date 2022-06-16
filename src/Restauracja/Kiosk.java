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
		wyswietl_menu();
		System.out.println("Proszę wpisać odpowiednie id produktu a następnie ilość ([id] [ilość]).");
		int id,ilosc;
		while(true) {
			id = x.nextInt();
			if(id == 99999) break;
			ilosc = x.nextInt();
			dodajProdukt(x.nextInt(), x.nextInt());
			System.out.printf("Dodano %d %s do twojego zamówienia \n",ilosc,Produkt.IDProduktow.get(id));
			System.out.printf("Aby opuścić stan wprowadzania produktów prosze wpisać 0.");
		}
				System.out.println("Koszt zamówienia wynosi: " + obslugiwane_zamowienie.cena);
				x.close();
				return;
			
	}
	
	public void wyswietl_menu() {
		for(Produkt x :  Produkt.IDProduktow.values()) {
			x.wydruk();
		}
	}

	@Override
    public void dodajProdukt(int x, int y) {
        obslugiwane_zamowienie.dodajProdukt(x, y);
    }

	@Override
	public Zamowienie zamknijZamowienie() {
		//System.out.print("Dziękujemy za Zakupy");
		return obslugiwane_zamowienie;
	}

	@Override
	public String wyswietlProdukty() {
		return null;
	}

	@Override
	public String wyswietlZamowienie() {
		return obslugiwane_zamowienie.wyswietl();
	}

	public Boolean oplacZamowienie(Karta card) {
		System.out.print(obslugiwane_zamowienie);
		if(card.Withdraw(obslugiwane_zamowienie.cena)) {
			obslugiwane_zamowienie.czyOplacone = true;
			zamknijZamowienie();
			return true;
		}else {
			System.out.println("ODMOWA.");
			return false;
		}
		
	}
	
}
