package Restauracja;
import  cash.Karta;


public class Kiosk implements Kasy {
	int ID_Kiosku;
    Zamowienie obslugiwane_zamowienie;
    
    public Kiosk(int iD_Kiosku, Zamowienie obslugiwane_zamowienie) {
		super();
		ID_Kiosku = iD_Kiosku;
		this.obslugiwane_zamowienie = obslugiwane_zamowienie;
	}

	@Override
	public void rozpocznijZamowienie() {
		obslugiwane_zamowienie = new Zamowienie();
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
