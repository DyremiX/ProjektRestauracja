package Restauracja;
import java.util.Scanner;
import  cash.Karta;
import exceptions.IDDoesNotExistException;
import exceptions.TooManyItemsException;


public class Kiosk implements Kasy {
	int ID_Kiosku;
    Zamowienie obslugiwane_zamowienie;
    /**
     * tworzy nowy kiosk o danym id
     * @param iD_Kiosku
     */
    public Kiosk(int iD_Kiosku) {
		ID_Kiosku = iD_Kiosku;
	}
    public int getID() {
    	return ID_Kiosku;
    }

	@Override
	public void rozpocznijZamowienie() {
		Scanner x = new Scanner(System.in);
		obslugiwane_zamowienie = new Zamowienie();
		wyswietlProdukty();
		System.out.println("Proszę wpisać odpowiednie id produktu a następnie ilość ([id] [ilość]).");
		int id,ilosc;
		while(true) {
			id = x.nextInt();
			if(id == 0) break;
			ilosc = x.nextInt();
			dodajProdukt(id, ilosc);
			System.out.printf("Dodano %d %s do twojego zamówienia \n",ilosc,Produkt.IDProduktow.get(id));
			System.out.printf("Aby opuścić stan wprowadzania produktów prosze wpisać 0.");
		}
				System.out.println("Koszt zamówienia wynosi: " + obslugiwane_zamowienie.cena);
				return;
			
	}
	
	public void wyswietlProdukty() {
		String lista = "";
    	for(int ID : Produkt.IDProduktow.keySet()) {
    		Produkt p = Produkt.getProductFromID(ID);
    		lista += "\n " + p.wydruk();
    	}
    	System.out.println("Wszystkie produkty: " + lista);
	}

	@Override
    public void dodajProdukt(int id, int n) {
		try {
    		if(!Produkt.IDProduktow.containsKey(id)) throw new IDDoesNotExistException(id);
    		if(n>20) throw new TooManyItemsException(n);
    		obslugiwane_zamowienie.dodajProdukt(id,n);
    	}
    	catch(IDDoesNotExistException exc) {
    		System.out.println(exc);
    	}
    	catch(TooManyItemsException exc) {
    		System.out.println(exc);
    	}
    }

	@Override
	public Zamowienie zamknijZamowienie() {
		//System.out.print("Dziękujemy za Zakupy");
		return obslugiwane_zamowienie;
	}

	@Override
	public void wyswietlZamowienie() {
		System.out.println(obslugiwane_zamowienie.wyswietl());
	}

	public Boolean oplacZamowienie(Karta card) {
		System.out.print(obslugiwane_zamowienie);
		if(card.Withdraw(obslugiwane_zamowienie.cena)) {
			obslugiwane_zamowienie.oplacZamowienie();
			zamknijZamowienie();
			return true;
		}else {
			System.out.println("ODMOWA.");
			return false;
		}
		
	}
	
}
