package JavaProjects.P05_HalukMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KullaniciGiris {


        public static String kisi;
        public static String kisiSifre;
        public static List<String> kullanici = new ArrayList<String>(Arrays.asList("muhammed", "yusuf"));
        public static List<String> kullaniciSifre = new ArrayList<String>(Arrays.asList("6161", "5858"));

        public static boolean kulKont = false;
        public static boolean kulSifKont = false;
        public static boolean kartSifUygunluk = false;

        public static void Kullanici() {

        Scanner scan = new Scanner(System.in);
        //String kartNoGir;
        do {
            System.out.print("Lutfen kullanici adinizi giriniz : ");
            kisi = scan.nextLine();
            kisi = kisi.replaceAll("\\s", "");

            if (kullanici.contains(kisi)) {
                kulKont = true;
            }
        }
        while (kulKont == false);


        do { //  sifrede kullanici adi ile sifre uyuşma kontrolü yaptık.
            System.out.print("Lutfen sifrenizi giriniz : ");
            kisiSifre = scan.nextLine();
            kisiSifre = kisiSifre.trim();

            if (kullaniciSifre.contains(kisiSifre)) {
                if (kullanici.indexOf(kisi) == kullaniciSifre.indexOf(kisiSifre)) {
                    kulSifKont = true;
                }
            }
        } while (kulSifKont == false);

        if (kulKont == true && kulSifKont == true) {
            if ((kullanici.indexOf(kisi) == 0) && (kullaniciSifre.indexOf(kisiSifre) == 0)) {
                StciEkran.StciEkran();
            }
            if ((kullanici.indexOf(kisi) == 1) && (kullaniciSifre.indexOf(kisiSifre) == 1)) { //veya else li dene
                MstriEkran.Ekran();
            }
        }
    }
    }

