package Restauracja;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

import exceptions.IDDoesNotExistException;
import exceptions.NoActiveObjectsException;
import exceptions.ObjectDoesntExist;
import exceptions.ObjectNotActiveException;
import exceptions.WrongNumberException;

public class Restauracja implements Serializable{
    int numerRestauracji;
    String adresRestauracji;
    String nazwaRestauracji;
    int iloscEkranowKuchnia;
    ArrayList<Ekran> listEkranow;
    ArrayList<Kasy> listKas;
    ArrayList<Zamowienie> historiaZamowien;

    int iloscEkranowKuchniaAktywnych;
    int ostatnioPrzydzielonyEK;

    static ArrayList<Produkt> listaProduktow;


    /**
     * Tworzy obiekt klasy Restauracja zarzadzajacy calym systemem
     *
     * @param numerRestauracji    Numer porzÄ…dkowy restauracji
     * @param adresRestauracji    Adres restauracji
     * @param nazwaRestauracji    Nazwa restauracji
     * @param iloscEkranowKuchnia Ile ekranow typu kucnia jest zainstalowanych w restauracji
     */
    public Restauracja(int numerRestauracji, String adresRestauracji, String nazwaRestauracji, int iloscEkranowKuchnia) {
        this.listEkranow = new ArrayList<Ekran>();
        historiaZamowien = new ArrayList<Zamowienie>();

        this.numerRestauracji = numerRestauracji;
        this.adresRestauracji = adresRestauracji;
        this.nazwaRestauracji = nazwaRestauracji;
        this.iloscEkranowKuchnia = iloscEkranowKuchnia;

        listEkranow.add(new EkranService());
        listEkranow.add(new EkranGrill());
        listEkranow.add(new EkranKurczak());
        
        listKas.add(new KasaFiskalna(1));
        listKas.add(new Kiosk(2));

        for (int i = 0; i < iloscEkranowKuchnia; i++) {
            this.listEkranow.add(new EkranKuchnia());
        }

        //System.out.println(listEkranow.get(1).wypiszZawartosc());
        //System.out.println(listEkranow.get(2).wypiszZawartosc());
        //System.out.println(listEkranow.get(2).wypiszZawartosc());

        if(Produkt.IDProduktow.size() == 0){
            Produkt.dodajProdukt(new ProduktMieso("BigMac", 17.60, 0, 2, 0, 0));
            Produkt.dodajProdukt(new ProduktMieso("Cheeseburger", 5.5, 1, 1, 0, 0));
            Produkt.dodajProdukt(new ProduktMieso("Hamburger", 4.9, 2, 1, 0, 0));
            Produkt.dodajProdukt(new ProduktMieso("Jalapeno Burger", 5.5, 3, 1, 0, 0));
            Produkt.dodajProdukt(new ProduktMieso("McRoyal", 16.70, 4, 0, 1, 0));
            Produkt.dodajProdukt(new ProduktMieso("WiesMac", 16.70, 5, 0, 1, 0));
            Produkt.dodajProdukt(new ProduktMieso("McRoyal Podwojny", 19.70, 6, 0, 2, 0));
            Produkt.dodajProdukt(new ProduktMieso("WiesMac Podwojny", 19.70, 7, 0, 2, 0));
            Produkt.dodajProdukt(new ProduktMieso("Maestro Grand Classic", 21.9, 8, 0, 0, 1));
            Produkt.dodajProdukt(new ProduktMieso("Maestro Bacon&Cheddar", 21.9, 9, 0, 0, 1));

            Produkt.dodajProdukt(new ProduktKurczak("Wrap Chrupiacy Klasyczny", 17.3, 10, 2, 0, 0));
            Produkt.dodajProdukt(new ProduktKurczak("Wrap Bekon Deluxe", 17.8, 11, 2, 0, 0));
            Produkt.dodajProdukt(new ProduktKurczak("Chikker", 6.5, 12, 1, 0, 0));
            Produkt.dodajProdukt(new ProduktKurczak("McChicken", 14.6, 13, 0, 1, 0));
            Produkt.dodajProdukt(new ProduktKurczak("Salatka Premium", 18.5, 14, 0, 1, 0));
            Produkt.dodajProdukt(new ProduktKurczak("6 McNuggets", 14.1, 15, 0, 0, 6));
            Produkt.dodajProdukt(new ProduktKurczak("9 McNuggets", 16.6, 16, 0, 0, 9));
            Produkt.dodajProdukt(new ProduktKurczak("20 McNuggets", 26.4, 17, 0, 0, 20));
        }


    }

    /**
     * Funckja pomocnicza sprawdzajaca ilosc aktualnie aktywnych ekranow kuchnia
     */
    void ileEkranowKuchniaAktywnych() {
        int i;
        int s = 0;
        for (i = 3; i < (3 + iloscEkranowKuchnia); i++) {
            Ekran ekranKuchnia = listEkranow.get(i);
            if (ekranKuchnia.czyAktywny())
                s++;
        }
        if (s == 0) {
            //ERROR
        }
        this.iloscEkranowKuchniaAktywnych = s;
    }
    /**
     * Funkcja równo dziel¹ca zamówienie miêdzy ekranami kuchnii
     * @param _zamowienie - zamówienie do podzielenia miêdzy ekranami
     */

    void podzielZamowienie(Zamowienie _zamowienie) {
        int i;
        for (i = 0; i < 3; i++) {
            listEkranow.get(i).dodajZamowienie(_zamowienie);
        }

        ileEkranowKuchniaAktywnych();

        for (i = 3; i < (3 + iloscEkranowKuchnia); i++) {
            Ekran ekranKuchnia = listEkranow.get(i);
            if (iloscEkranowKuchniaAktywnych == 1) {
                if (ekranKuchnia.czyAktywny()) {
                    ekranKuchnia.dodajZamowienie(_zamowienie);
                    ostatnioPrzydzielonyEK = i;
                    break;
                }
            } else if (iloscEkranowKuchniaAktywnych == 0) {
                //ERROR
            } else {
                if (ekranKuchnia.czyAktywny() && ostatnioPrzydzielonyEK != i) {
                    ekranKuchnia.dodajZamowienie(_zamowienie);
                    ostatnioPrzydzielonyEK = i;
                    break;
                }
            }

        }

    }

    /**
     * Funckja pomocnicza systemu zarzadzania ekranami z jednego komputera
     *
     * @param wybranyEkran aktualnie wybrany ekran
     * @return zwraca 0 jesli wyjscie, -1 jest blad, 1 jesli poprawnie wykonano funckje
     */
    int zarzadzajPrzyciskami(Ekran wybranyEkran) {
        Scanner scanner = new Scanner(System.in);
        int opcja = scanner.nextInt();

        if (opcja == 0)
            return 0;

        if (opcja < 1 || opcja > 3)
            return -1;

        switch (opcja) {
            case 1 -> wybranyEkran.przycisk1();
            case 2 -> wybranyEkran.przycisk2();
            case 3 -> wybranyEkran.przycisk3();
        }

        opcja = 0;
        return 1;
    }

    /**
     * Funckja do zarzadzania ekranem serwis
     */
    void zarzadzajEkranService() {
        Scanner scanner = new Scanner(System.in);
        Ekran wybranyEkran = listEkranow.get(0);
        while (true) {
            System.out.println("///Ekran service///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - serve\n 2 - next\n 3 - przywolaj\n0 - wyjdz");

            try{
                int wynik = zarzadzajPrzyciskami(wybranyEkran);
                if (wynik == 0 )
                    break;

                if (wynik == -1)
                    throw  new ObjectDoesntExist(0);


            }catch (Exception ex){
                System.out.println("BLAD! " + ex.getMessage());
            }


            System.out.println("\\\\\\Ekran service\\\\\\");
            System.out.println("\n\n\n\n");
        }

        //scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem kuchnia
     */
    void zarzadzajEkranKuchnia() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("///Wybierz Ekran Kuchnia///");
            System.out.println("Dostï¿½pne ekrany: " + this.iloscEkranowKuchnia);
            System.out.println("Wybierz ekran wpisujac jego numer od: 3 do " + (2 + this.iloscEkranowKuchnia));
            System.out.println("Wpisz 0 aby wyjsc.");
            int opcja = scanner.nextInt();

            if (opcja == 0)
                break;

            if (opcja < 3 || opcja > (2 + this.iloscEkranowKuchnia))
                continue;

            Ekran wybranyEkran = listEkranow.get(opcja);
            while (true) {
                System.out.println("///Ekran kuchnia///");
                System.out.println(wybranyEkran.wypiszZawartosc());
                System.out.println("Dotepne przyciski:\n1 - serve\n 2 - przywolaj\n 3 - wlacz\n0 - wyjdz");

                try{
                    int wynik = zarzadzajPrzyciskami(wybranyEkran);
                    if (wynik == 0)
                        break;

                    if (wynik == -1)
                        throw  new ObjectDoesntExist(0);
                }catch (Exception ex){
                    System.out.println("BLAD! " + ex.getMessage());
                }


                System.out.println("\\\\\\Ekran kuchnia\\\\\\");
                System.out.println("\n\n\n\n");
            }
        }

        //scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem kurczak
     */
    void zarzadzajEkranKurczak() {
        Scanner scanner = new Scanner(System.in);
        Ekran wybranyEkran = listEkranow.get(2);
        while (true) {
            System.out.println("///Ekran kurczak///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - kasujStripsy \n 2 - kasujChick\n 3 - kasujNuggets\n0 - wyjdz");

            try{
                int wynik = zarzadzajPrzyciskami(wybranyEkran);
                if (wynik == 0)
                    break;

                if (wynik == -1)
                    throw  new ObjectDoesntExist(0);
            }catch (Exception ex){
                System.out.println("BLAD! " + ex.getMessage());
            }

            System.out.println("\\\\\\Ekran kurczak\\\\\\");
            System.out.println("\n\n\n\n");
            
        }

        //scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem grill
     */
    void zarzadzajEkranGrill() {
        Scanner scanner = new Scanner(System.in);
        Ekran wybranyEkran = listEkranow.get(1);
        while (true) {
            System.out.println("///Ekran grill///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dostepne przyciski:\n1 - kasuj10:1 \n 2 - kasuj4:1\n 3 - kasujThicker\n0 - wyjdz");

            try {
                int wynik = zarzadzajPrzyciskami(wybranyEkran);
                if (wynik == 0)
                    break;

                if (wynik == -1)
                    throw  new ObjectDoesntExist(0);
            }catch (Exception ex){
                System.out.println("BLAD! " + ex.getMessage());
            }

            System.out.println("\\\\\\Ekran grill\\\\\\");
            System.out.println("\n\n\n\n");
            
        }

        //scanner.close();
    }
    /**
     * Funkcja do zarz¹dzania kas¹
     */
    void zarzadzajKasami(){
    	Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("///Wybór kasy///");
            System.out.println("Dostepne kasy:\1.Kasa Fiskalna \n 2.Kiosk \n 0.Wyjdz");

            int wynik = scanner.nextInt();
            if (wynik == 0)
                break;

            if (wynik<0||wynik>listKas.size()+1)
            	continue;
            
            Kasy kasa=listKas.get(wynik-1);
            switch(wynik) {
            case 1 -> zarzadzajKasa(kasa);
            case 2 -> zarzadzajKasa(kasa);
            }

            System.out.println("\\\\\\Wybór kasy\\\\\\");
            System.out.println("\n\n\n\n");
        	}
    	}
    void zarzadzajKasa(Kasy k) {
    	Scanner scanner = new Scanner(System.in);
    	while(true) {
    		System.out.println("///Kasa Fiskalna Nr."+k.getID()+"///");
	        System.out.println("Dostepne opcje:\n 1 - Zacznij zamowienie \n 2 - Dodaj produkt\n 3 - Zamknij zamowienie\n 4 - Wyœwietl Produkty\n 5 - Wyœwietl Zamowienie\n 0 - wyjdz");
	        int wynik = scanner.nextInt();
	        if (wynik == 0)
	            break;
	
	        if (wynik<0||wynik>5)
	        	continue;
	        int ID=0;
	        int ilosc=0;
	        if (wynik == 2) {
	        	System.out.println("///Wpisz ID produktu i iloœæ");
	        	try {
	        		ID=scanner.nextInt();
	        		ilosc=scanner.nextInt();
	        		if(!Produkt.IDProduktow.containsKey(ID)) throw new IDDoesNotExistException(ID);
	        		if(ilosc < -1) throw new WrongNumberException(ilosc);
	        	}
	        	catch(IDDoesNotExistException exc){
	        		System.out.println(exc);
	        		continue;
	        	}
	        	catch(WrongNumberException exc){
	        		System.out.println(exc);
	        		continue;
	        	}
	        }
	        switch(wynik) {
	        case 1 -> k.rozpocznijZamowienie();
	        case 2 -> k.dodajProdukt(ID,ilosc);
	        case 3 -> podzielZamowienie(k.zamknijZamowienie());
	        case 4 -> k.wyswietlProdukty();
	        case 5 -> k.wyswietlZamowienie();
	        }
    	}
    	
    }

    /* Ehh
    void wyborEkranu() {
    	Scanner scanner = new Scanner(System.in);
    	while(true) {
    		try {
    		System.out.println("///Zarzadzanie Ekranami///");
    		System.out.println("Wybierz ekran wpisujac jego numer od: 1 do " + listEkranow.size());
    		System.out.println("Wpisz 0 aby wyjsc.");
    		System.out.println("Dostepne Ekrany:");
    		
    		int aktywne=0;
    		
    		for(int i=0; i<listEkranow.size(); i++) {
    			Ekran e=listEkranow.get(i);
    			String typEkranu = e.typEkranu().toString();
    			String isActive = (e.czyAktywny() ? ("") : (" - Nieaktywny"));
    			
    			System.out.println((i+1) + ". Ekran " + typEkranu + isActive);
    			
    			if(e.czyAktywny())
    				aktywne++;
    		}
    		
    		if(aktywne==0) throw new NoActiveObjectsException("Ekran");
    		
            int opcja = scanner.nextInt();

            if(opcja == 0)
                break;

            if(opcja < 0 || opcja > listEkranow.size())
                continue;
            
            Ekran wybranyEkran = listEkranow.get(opcja-1);
            
            if(!wybranyEkran.czyAktywny()) throw new ObjectNotActiveException(opcja);
            
            switch(wybranyEkran.typEkranu()){
            	case Service -> zarzadzajEkranService(wybranyEkran);
            	case Grill -> zarzadzajEkranGrill(wybranyEkran);
            	case Kurczak -> zarzadzajEkranKurczak(wybranyEkran);
            	case Kuchnia -> zarzadzajEkranKuchnia(wybranyEkran);
            }
            
            System.out.println("\\\\\\Zarzadzanie Ekranami\\\\\\\n");
    		System.out.println("\n\n\n\n");
    		}
    		catch(ObjectNotActiveException exc) {
    			System.out.println(exc);
    		}
    		catch(NoActiveObjectsException exc) {
    			System.out.println(exc);
    		}
    	}
    	//scanner.close();
    }
	*/

    /**
     * Funckja pomocnicza do zarzadzania ekranami
     */
    public void aktywuj() {
        Scanner _scanner;
        while (true) {
            
            int wybranyTypEkranu = 0;
            _scanner = new Scanner(System.in);
            if (wybranyTypEkranu >= 0 && wybranyTypEkranu < 6) {
                System.out.println("Wybierz czym chcesz zarzadzac:\n1 - EkanService\n2 - EkranKuchnia\n3 - EkranGrill\n4 - EkranKurczak\n5 - Kasy");


                    wybranyTypEkranu = _scanner.nextInt();
                    System.out.println(wybranyTypEkranu);
                    if(wybranyTypEkranu == 99)
                        break;
                    if (wybranyTypEkranu < 1 || wybranyTypEkranu > 5) {
                        //throw new ObjectDoesntExist(wybranyTypEkranu);
                    }

                    switch (wybranyTypEkranu) {
                        case 1 -> zarzadzajEkranService();
                        case 2 -> zarzadzajEkranKuchnia();
                        case 3 -> zarzadzajEkranGrill();
                        case 4 -> zarzadzajEkranKurczak();
                        case 5 -> zarzadzajKasami();
                    }

            }
            wybranyTypEkranu=0;
        }

        //
    }


}
