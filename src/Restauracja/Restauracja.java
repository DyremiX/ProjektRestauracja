package Restauracja;

import java.util.ArrayList;
import java.util.Scanner;

public class Restauracja {
    int numerRestauracji;
    String adresRestauracji;
    String nazwaRestauracji;
    ArrayList<Ekrany> listEkranow;
    ArrayList<Zamowienie> historiaZamowien;


    /**
     * Tworzy obiekt klasy Restauracja zarzadzajacy calym systemem
     * @param iloscEkranowKuchnia Ile ekranow typu kucnia jest zainstalowanych w restauracji
     */
    Restauracja(int numerRestauracji, String adresRestauracji, String nazwaRestauracji, int iloscEkranowKuchnia){
        listEkranow = new ArrayList<Ekrany>();
        historiaZamowien = new ArrayList<Zamowienie>();

        this.numerRestauracji = numerRestauracji;
        this.adresRestauracji = adresRestauracji;
        this.nazwaRestauracji = nazwaRestauracji;

        listEkranow.add(new EkranService());
        listEkranow.add(new EkranGrill());
        listEkranow.add(new EkranKurczak());

        for(int i = 0; i < iloscEkranowKuchnia; i++){
            listEkranow.add(new EkranKuchnia());
        }
    }

    void zarzadzajEkranService (){
        Scanner scanner = new Scanner(System.in);
        Ekrany ekranService = listEkranow.get(0);
        while (true){
            System.out.println("///Ekran service///");
            System.out.println(ekranService.wypiszZawartosc());
            System.out.println("Dotepne przyciski:\n1 - serve\n 2 - next\n 3 - przywolaj\n0 - wyjdz");
            int opcja = scanner.nextInt();

            if(opcja == 0)
                break;

            if(opcja < 1 || opcja > 3)
                continue;

            switch (opcja) {
                case 1 -> ekranService.przycisk1();
                case 2 -> ekranService.przycisk2();
                case 3 -> ekranService.przycisk3();
            }

            System.out.println("\\\\\\Ekran service\\\\\\");
            System.out.println("\n\n\n\n");
        }
        scanner.close();
    }

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

                if(wybranyTypEkranu == 5){

                }
            }
        }
        //scanner.close();
    }


}
