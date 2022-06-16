package Restauracja;

import java.util.ArrayList;
import java.util.Scanner;

public class Restauracja {
    int numerRestauracji;
    String adresRestauracji;
    String nazwaRestauracji;
    int iloscEkranowKuchnia;
    ArrayList<Ekrany> listEkranow;
    ArrayList<Zamowienie> historiaZamowien;

    int iloscEkranowKuchniaAktywnych;
    int ostatnioPrzydzielonyEK;

    static ArrayList<Produkty> listaProduktow;


    /**
     * Tworzy obiekt klasy Restauracja zarzadzajacy calym systemem
     * @param numerRestauracji Numer porządkowy restauracji
     * @param adresRestauracji Adres restauracji
     * @param nazwaRestauracji Nazwa restauracji
     * @param iloscEkranowKuchnia Ile ekranow typu kucnia jest zainstalowanych w restauracji
     */
    Restauracja(int numerRestauracji, String adresRestauracji, String nazwaRestauracji, int iloscEkranowKuchnia){
        listEkranow = new ArrayList<Ekrany>();
        historiaZamowien = new ArrayList<Zamowienie>();

        this.numerRestauracji = numerRestauracji;
        this.adresRestauracji = adresRestauracji;
        this.nazwaRestauracji = nazwaRestauracji;
        this.iloscEkranowKuchnia = iloscEkranowKuchnia;

        listEkranow.add(new EkranService());
        listEkranow.add(new EkranGrill());
        listEkranow.add(new EkranKurczak());

        for(int i = 0; i < iloscEkranowKuchnia; i++){
            listEkranow.add(new EkranKuchnia());
        }

    }

    /**
     * Funckja pomocnicza sprawdzajaca ilosc aktualnie aktywnych ekranow kuchnia
     */
    void ileEkranowKuchniaAktywnych(){
        int i; int s = 0;
        for(i = 3; i < (3+iloscEkranowKuchnia);i++){
            Ekrany ekranKuchnia = listEkranow.get(i);
            if(ekranKuchnia.czyAktywny())
                s++;
        }
        if(s == 0){
            //ERROR
        }
        this.iloscEkranowKuchniaAktywnych = s;
    }

    void podzielZamowienie(Zamowienie _zamowienie){
        int i;
        for(i = 0; i < 3; i++){
            listEkranow.get(i).dodajZamowienie(_zamowienie);
        }

        ileEkranowKuchniaAktywnych();

        for(i = 3; i < (3+iloscEkranowKuchnia);i++){
            Ekrany ekranKuchnia = listEkranow.get(i);
            if(iloscEkranowKuchniaAktywnych == 1){
                if(ekranKuchnia.czyAktywny()){
                    ekranKuchnia.dodajZamowienie(_zamowienie);
                    ostatnioPrzydzielonyEK = i;
                    break;
                }
            } else if (iloscEkranowKuchniaAktywnych == 0) {
                //ERROR
            }else {
                if(ekranKuchnia.czyAktywny() && ostatnioPrzydzielonyEK != i){
                    ekranKuchnia.dodajZamowienie(_zamowienie);
                    ostatnioPrzydzielonyEK = i;
                    break;
                }
            }

        }

    }

    /**
     * Funckja pomocnicza systemu zarzadzania ekranami z jednego komputera
     * @param wybranyEkran aktualnie wybrany ekran
     * @return zwraca 0 jesli wyjscie, -1 jest blad, 1 jesli poprawnie wykonano funckje
     */
    int zarzadzajPrzyciskami (Ekrany wybranyEkran){
        Scanner scanner = new Scanner(System.in);
        int opcja = scanner.nextInt();

        if(opcja == 0)
            return 0;

        if(opcja < 1 || opcja > 3)
            return -1;

        switch (opcja) {
            case 1 -> wybranyEkran.przycisk1();
            case 2 -> wybranyEkran.przycisk2();
            case 3 -> wybranyEkran.przycisk3();
        }
        scanner.close();
        return 1;
    }

    /**
     * Funckja do zarzadzania ekranem serwis
     */
    void zarzadzajEkranService (){
        Scanner scanner = new Scanner(System.in);
        Ekrany wybranyEkran = listEkranow.get(0);
        while (true){
            System.out.println("///Ekran service///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - serve\n 2 - next\n 3 - przywolaj\n0 - wyjdz");

            int wynik = zarzadzajPrzyciskami(wybranyEkran);
            if(wynik == 0)
                break;

            if(wynik == -1)
                System.out.println("ERROR");

            System.out.println("\\\\\\Ekran service\\\\\\");
            System.out.println("\n\n\n\n");
        }
        scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem kuchnia
     */
    void zarzadzajEkranKuchnia (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("///Wybierz Ekran Kuchnia///");
            System.out.println("Dostępne ekrany: " + this.iloscEkranowKuchnia);
            System.out.println("Wybierz ekran wpisujac jego numer od: 3 do " + 2 + this.iloscEkranowKuchnia);
            System.out.println("Wpisz 0 aby wyjsc.");
            int opcja = scanner.nextInt();

            if(opcja == 0)
                break;

            if(opcja < 3 || opcja > (2+this.iloscEkranowKuchnia))
                continue;

            Ekrany wybranyEkran = listEkranow.get(opcja);
            while (true){
                System.out.println("///Ekran kuchnia///");
                System.out.println(wybranyEkran.wypiszZawartosc());
                System.out.println("Dotepne przyciski:\n1 - serve\n 2 - przywolaj\n 3 - wlacz\n0 - wyjdz");

                int wynik = zarzadzajPrzyciskami(wybranyEkran);
                if(wynik == 0)
                    break;

                if(wynik == -1)
                    System.out.println("ERROR");

                System.out.println("\\\\\\Ekran kuchnia\\\\\\");
                System.out.println("\n\n\n\n");
            }
        }
        scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem kurczak
     */
    void zarzadzajEkranKurczak (){
        Scanner scanner = new Scanner(System.in);
        Ekrany wybranyEkran = listEkranow.get(0);
        while (true){
            System.out.println("///Ekran kurczak///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - kasujStripsy \n 2 - kasujChick\n 3 - kasujNuggets\n0 - wyjdz");

            int wynik = zarzadzajPrzyciskami(wybranyEkran);
            if(wynik == 0)
                break;

            if(wynik == -1)
                System.out.println("ERROR");

            System.out.println("\\\\\\Ekran kurczak\\\\\\");
            System.out.println("\n\n\n\n");
        }
        scanner.close();
    }

    /**
     * Funckja do zarzadzania ekranem grill
     */
    void zarzadzajEkranGrill (){
        Scanner scanner = new Scanner(System.in);
        Ekrany wybranyEkran = listEkranow.get(0);
        while (true){
            System.out.println("///Ekran grill///");
            System.out.println(wybranyEkran.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - kasuj10:1 \n 2 - kasuj4:1\n 3 - kasujThicker\n0 - wyjdz");

            int wynik = zarzadzajPrzyciskami(wybranyEkran);
            if(wynik == 0)
                break;

            if(wynik == -1)
                System.out.println("ERROR");

            System.out.println("\\\\\\Ekran grill\\\\\\");
            System.out.println("\n\n\n\n");
        }
        scanner.close();
    }

    void zarzadzajKasa(){

    }

    /**
     * Funckja pomocnicza do zarzadzania ekranami
     */
    void aktywuj(){
        int wybranyTypEkranu = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(wybranyTypEkranu == 0){
                System.out.println("Wybierz ekran, ktorym chcesz zarzadzac:\n1 - EkanService\n2 - EkranKuchnia\n3 - EkranGrill\n4 - EkranKurczak\n5 - Kasy");
                wybranyTypEkranu = scanner.nextInt();
                if(wybranyTypEkranu < 1 || wybranyTypEkranu > 5){
                    wybranyTypEkranu = 0;
                    continue;
                }

                switch (wybranyTypEkranu){
                    case 1:
                        zarzadzajEkranService();
                        break;
                    case 2:
                        zarzadzajEkranKuchnia();
                        break;
                    case 3:
                        zarzadzajEkranGrill();
                        break;
                    case 4:
                        zarzadzajEkranKurczak();
                        break;
                    case 5:
                        zarzadzajKasa();
                        break;
                }

            }
        }
        //scanner.close();
    }


}
