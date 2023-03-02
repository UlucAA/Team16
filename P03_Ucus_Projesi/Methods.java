package JavaProjects.P03_Ucus_Projesi;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class Methods {
    static Scanner scanner = new Scanner(System.in);

    //--------------------------------------BİLET YAZDIRMA METHODU -----------------------------------------------------------------------------
    public static void main(String[] args) {

    }
    static void fisIsteme(String isim, String sehir, String yon, int yas, double tutar) {


        DateFormat DFormat = DateFormat.getDateInstance();
        Calendar cal = Calendar.getInstance();
        String curr_date = DFormat.format(cal.getTime());
        int curr_hour = LocalDateTime.now().getHour();
        int min = LocalDateTime.now().getMinute();

        System.out.println("===================================");

        System.out.println("Java  Airlines ");
        System.out.println("İstanbul Sabiha Gökçen ISG");
        System.out.println("Flight No: " + LocalDateTime.now().getYear() + LocalDateTime.now().getHour() +
                "  Gate Number:" + sehir.toUpperCase() + Math.round(Math.random() * 10));
        System.out.print("İşlem Tarihi: ");
        System.out.print(curr_date);
        System.out.println("");
        System.out.print("İşlem Saati:");
        System.out.println("  " + curr_hour + ":" + min);

        System.out.println("===================================");

        System.out.println("FROM: Istanbul     Hedef: " + sehir.toUpperCase());
        System.out.println("Müşteri Adı: " + isim.toUpperCase());
        System.out.println("Tek yön / Gidiş Dönüş: " + yon);
        System.out.println("Yolcu yaşı: " + yas);
        System.out.println("Toplam Ödeme: " + tutar + "$");

        System.out.println("===================================");

        System.out.println("İyi yolculuklar dileriz");
        System.out.println("TechPro Airlines Corp.Ⓒ 2022");

    }//fiş isteme

    public static void ucus(String isim, String hedef, String yon, int yas) {

        double ucretB = 50;
        double ucretC = 70;
        double ucretD = 90;

        switch (hedef.toUpperCase()) {

            case "ANKARA":
                ucretB = yasKontrol(hedef, yon, yas, ucretB);
                fisIsteme(isim, hedef, yon, yas, ucretB);
                break;
            case "IZMIR":
                ucretC = yasKontrol(hedef, yon, yas, ucretC);
                fisIsteme(isim, hedef, yon, yas, ucretC);
                break;
            case "VAN":
                ucretD = yasKontrol(hedef, yon, yas, ucretD);
                fisIsteme(isim, hedef, yon, yas, ucretD);
                break;

        }

        System.out.println("Biletiniz hazırlanmıştır.");
    }

    private static double yasKontrol(String hedef, String yon, int yas, double ucret) {

        if (yon.equalsIgnoreCase("gd")) {

            if (yas > 0 && yas < 12) {

                ucret = indirim12YasAlti(ucret);
                ucret = ciftYonIndirim(ucret);
                System.out.println(hedef + " şehrine GİDİŞ DÖNÜŞ fiyatınız: " + ucret+ "$");

            } else if (yas >= 12 && yas < 24) {

                ucret= indirim12ve24Yas(ucret);
                ucret = ciftYonIndirim(ucret);
                System.out.println(hedef+ " şehrineGİDİŞ DÖNÜŞ fiyatınız: " + ucret + "$");

            } else if (yas > 65 && yas <= 100) {

                ucret = indirim65yas(ucret);
                ucret = ciftYonIndirim(ucret);
                System.out.println(hedef + " şehrine GİDİŞ DÖNÜŞ fiyatınız: " + ucret + "$");

            } else {
                ucret = ciftYonIndirim(ucret);
                System.out.println(hedef + "  şehri için GİDİŞ-DÖNÜŞ bilet fiyatınız: " + ucret+ "$");
            }

        } else if (yon.equalsIgnoreCase("t")) {
            if (yas > 0 && yas < 12) {

                ucret = indirim12YasAlti(ucret);
                System.out.println(hedef + "şehrine gidiş fiyatınız: " + ucret + "$");

            } else if (yas >= 12 && yas < 24) {

                ucret = indirim12ve24Yas(ucret);
                System.out.println(hedef + " şehrine gidiş fiyatınız: " + ucret + "$");

            } else if (yas > 65 && yas <= 100) {

                ucret = indirim65yas(ucret);
                System.out.println(hedef + " şehrine gidiş fiyatınız: " + ucret + "$");
            } else {
                System.out.println("İndirimsiz yolcu. " + hedef + " şehri için bilet fiyatınız: " + ucret + "$");
            }

        } else {
            System.out.println("Lütfen geçerli bir yön girişi yapınız");
        }

        return ucret;
    }






    public static double indirim12YasAlti(double ucret) {
        System.out.println("12 yaş altı olduğunuz için %50 indirim uygulanacaktır");
        return ucret * 0.5;
    }

    public static double indirim12ve24Yas(double ucret) {
        System.out.println("12-24 yaş aralığında olduğunuz için %10 indirim uygulanacaktır");
        return ucret * 0.9;
    }


    public static double indirim65yas(double ucret) {
        System.out.println("65 üstü yaş aralığında olduğunuz için %30 indirim uygulanacaktır");
        return ucret * 0.7;
    }


    public static double ciftYonIndirim(double ucret) {

        System.out.println("Gidiş-Dönüş aldığınız için %20 indirim uygulanacaktır.");
        return ucret * 0.8 * 2;
    }

}


