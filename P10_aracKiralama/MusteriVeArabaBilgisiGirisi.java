package JavaProjects.P10_aracKiralama;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusteriVeArabaBilgisiGirisi extends AracTalebi {
    public static final String kirmizi = "\u001B[31m";
    public static final String yesil = "\u001B[32m";
    public static final String sari = "\u001B[33m";
    public static final String mavi = "\u001B[34m";
    public static final String mor = "\u001B[35m";
    public static final String fullKoyuSiyahSatirCizgi = "\u001B[40m";

    static List<AracTalebi> aracTalebiList = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    static int toplamGun;

    public static void aracTalep() throws InterruptedException {
        System.out.println("Lutfen araci alacaginiz sehri giriniz:");
        String sehir = scan.next();
        System.out.println("Lutfen teslim alacaginiz gunu ve ayi giriniz:(Ornek: 02.12 ) (Ornek: 12.04)");
        String alisGunu = scan.next();
        System.out.println("Lutfen teslim alacaginiz saati giriniz: Tr klavyesi ise (15,00) giriniz degilse (Ornek: 16.00) ");
        double alisSaati = scan.nextDouble();
        System.out.println("Lutfen teslim edeceginiz gunu ve ayi  giriniz: (Ornek: 03.12 )(Ornek: 13.04)");
        String teslimGunu = scan.next();
        System.out.println("Lutfen teslim edeceginiz saati giriniz: Tr klavyesi ise (16,00) giriniz degilse (Ornek: 16.00)");
        double teslimSaati = scan.nextDouble();

        System.out.println("************************************");
        String aGun=alisGunu.substring(0,2); //12.04
        int intAGunu= Integer.parseInt(aGun);
        String aAy= alisGunu.substring(3);
        int intAAy = Integer.parseInt(aAy);
        System.out.println("Alis tarihi: "+intAGunu+"."+intAAy);

        String tGun=teslimGunu.substring(0,2); //12.04
        int intTGunu= Integer.parseInt(tGun);
        String tAy= teslimGunu.substring(3);
        int intTAy = Integer.parseInt(tAy);
        System.out.println("Teslim tarihi: "+intTGunu+"."+intTAy);

        System.out.println("************************************");
        if (intAAy>intTAy) {
            System.out.println("Alis gunu Teslim gununden sonra olamaz");
            aracTalep();
        }else if(intAGunu>intTGunu){
            System.out.println("Alis gunu Teslim gununden sonra olamaz");
            aracTalep();
        }
        toplamGun= (intTAy-intAAy)*30 + (intTGunu-intAGunu);
        System.out.println("Odenecek toplam gun sayisi: "+toplamGun);
        System.out.println("************************************");
        System.out.print(kirmizi+"Menuden Cikis isleminiz gerceklestirilmektedir  "+(char)9951);
        for (int i=0;i<12;i++){
            Thread.sleep(500);
            System.out.print(" "+(char)9951);
        }
        System.out.println();
        islemMenusu();
    }

    public static void getAraba(String marka, String model, String yakitTipi,String vites, Integer gunlukUcret){
    aracTalebiList.stream().
            filter(t-> t.getMarka().equalsIgnoreCase(marka) && t.getModel().equalsIgnoreCase(model)&&
            t.getYakitTipi().equalsIgnoreCase(yakitTipi)&& t.getVites().equalsIgnoreCase(vites)).
            forEach(System.out::println);
    }



    public static void arabalar() throws InterruptedException {

        AracTalebi arferrariTupluOtomatik = new AracTalebi("Alfa Romeo-Ferrari", "Ferrari 066/7", "tuplu", "otomatik", 1500);
        AracTalebi atrbpTupluOtomatik = new AracTalebi("AlphaTauri-RBPT", "Red Bull RBPTH001", "tuplu", "otomatik", 1300);
        AracTalebi renaultTupluOtomatik = new AracTalebi("Alpine-Renault", "Renault A522", "tuplu", "otomatik", 1500);
        AracTalebi astonMartinMTupluOtomatik = new AracTalebi("Aston Martin Aramco-Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1300);
        AracTalebi ferrariTupluOtomatik = new AracTalebi("Ferrari", "Ferrari 066/7 ", "tuplu", "otomatik", 1800);
        AracTalebi haasFerrariTupluOtomatik = new AracTalebi("Haas-Ferrari", "Ferrari 066/7", "tuplu", "otomatik", 1600);
        AracTalebi mcLarenMercedesTupluOtomatik = new AracTalebi("McLaren-Mercedes", "Mercedes-AMG F1 M13 ", "tuplu", "otomatik", 2000);
        AracTalebi mercedesTupluOtomatik = new AracTalebi("Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1800);
        AracTalebi oracleRBTupluOtomatik = new AracTalebi("Oracle Red Bull Racing-RBPT", "Red Bull RBPTH001", "tuplu", "otomatik", 2000);
        AracTalebi williamsMercedesTupluOtomatik = new AracTalebi("Williams-Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1900);

        aracTalebiList.add(arferrariTupluOtomatik);
        aracTalebiList.add(atrbpTupluOtomatik);
        aracTalebiList.add(renaultTupluOtomatik);
        aracTalebiList.add(astonMartinMTupluOtomatik);
        aracTalebiList.add(ferrariTupluOtomatik);
        aracTalebiList.add(haasFerrariTupluOtomatik);
        aracTalebiList.add(mcLarenMercedesTupluOtomatik);
        aracTalebiList.add(mercedesTupluOtomatik);
        aracTalebiList.add(oracleRBTupluOtomatik);
        aracTalebiList.add(williamsMercedesTupluOtomatik);

        System.out.println("\n Lutfen talep ettiginiz aracin numarasini giriniz : \n1 : Alfa Romeo-Ferrari " +
                "\n2 : AlphaTauri-RBPT \n3 : Alpine-Renault \n4 : Aston Martin Aramco-Mercedes" +
                "\n5 : Ferrari" + "\n6 : Haas-Ferrari\n7 : McLaren-Mercedes" +
                "\n8 : Mercedes\n9 : Oracle Red Bull Racing-RBPT\n10: Williams-Mercedes" +
                "\n11: Yeni arac talebi");
        int tercih = scan.nextInt();
        switch (tercih){
            case 1:
                getAraba("Alfa Romeo-Ferrari", "Ferrari 066/7", "tuplu", "otomatik", 1500);
                int odenecek_Ucret1= toplamGun*1500;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret1);
                islemMenusu();
                break;
            case 2:
                getAraba("AlphaTauri-RBPT", "Red Bull RBPTH001", "tuplu", "otomatik", 1300);
                int odenecek_Ucret2= toplamGun*1300;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret2);
                islemMenusu();
                break;
            case 3:
                getAraba("Alpine-Renault", "Renault A522", "tuplu", "otomatik", 1500);
                int odenecek_Ucret3= toplamGun*1500;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret3);
                islemMenusu();
                break;
            case 4:
                getAraba("Aston Martin Aramco-Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1300);
                int odenecek_Ucret4= toplamGun*1300;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret4);
                islemMenusu();
                break;
            case 5:
                getAraba("Ferrari", "Ferrari 066/7 ", "tuplu", "otomatik", 1800);
                int odenecek_Ucret5= toplamGun*1800;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret5);
                islemMenusu();
                break;
            case 6:
                getAraba("Haas-Ferrari", "Ferrari 066/7", "tuplu", "otomatik", 1600);
                int odenecek_Ucret6= toplamGun*1600;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret6);
                islemMenusu();
                break;
            case 7:
                getAraba("McLaren-Mercedes", "Mercedes-AMG F1 M13 ", "tuplu", "otomatik", 2000);
                int odenecek_Ucret7= toplamGun*2000;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret7);
                islemMenusu();
                break;
            case 8:
                getAraba("Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1800);
                int odenecek_Ucret8= toplamGun*1800;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret8);
                islemMenusu();
                break;
            case 9:
                getAraba("Oracle Red Bull Racing-RBPT", "Red Bull RBPTH001", "tuplu", "otomatik", 2000);
                int odenecek_Ucret9= toplamGun*2000;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret9);
                islemMenusu();
                break;
            case 10:
                getAraba("Williams-Mercedes", "Mercedes-AMG F1 M13", "tuplu", "otomatik", 1900);
                int odenecek_Ucret10= toplamGun*1900;
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret10);
                islemMenusu();
                break;

            case 11:
                System.out.println("Lutfen talep ettiginiz yeni arac markasini giriniz");
                String yeniMarka = scan.nextLine();
                scan.nextLine();
                System.out.println("Lutfen talep ettiginiz yeni model  giriniz");
                String yeniModel = scan.nextLine();
                System.out.println("Lutfen talep ettiginiz yakit tipi giriniz");
                String yeniYakitTipi = scan.nextLine();
                System.out.println("Lutfen talep ettiginiz  vites tipi giriniz");
                String yeniVitesTipi = scan.nextLine();


                getAraba(yeniMarka," "+yeniModel," "+yeniYakitTipi," "+yeniVitesTipi,250);
                int odenecek_Ucret13= toplamGun*2500;
                System.out.println("************************************");
                System.out.println("Odeyeceginiz toplam ucret: "+ odenecek_Ucret13);
                System.out.println("************************************");

                islemMenusu();
                break;
            default:
                System.out.println("Lutfen gecerli bir arac talep numarasi giriniz");
                arabalar();
        }


    }
    public static void musteriBilgisi() throws InterruptedException {
        System.out.println("************************************");
        System.out.println("Lutfen adinizi giriniz");
        String ad= scan.next();
        System.out.println("Lutfen soyadinizi giriniz: ");
        String Soyad=scan.next();
        System.out.println("Lutfen tc'nizi giriniz: ");
        String id = scan.next();
        //scan.next();
        System.out.println("Lutfen telefon numaranizi giriniz: ");
        String tlf = scan.next();
        //scan.next();
        System.out.println("Lutfen yasinizi giriniz: ");
        int yas = scan.nextInt();

        System.out.println("************************************");

        System.out.println("Ad Soyad: "+ad+" "+Soyad+"\ntc: "+id+"\nTelefon: "+tlf+"\nYas: "+yas);

        System.out.println("************************************");
       // odemeBilgileri();
        System.out.print(kirmizi+"Menuden cikis isleminiz gerceklestirilmektedir  "+(char)9951);
        for (int i=0;i<6;i++){
            Thread.sleep(500);
            System.out.print(" "+(char)9951);
        }
        System.out.println();
        islemMenusu();
    }
    public static void odemeBilgileri() {
        System.out.println("Lutfen kredi karti numaranizi 12 haneli olarak giriniz: ");
        String kKarti = scan.next();

        if (kKarti.matches("[0-9]{12}")) {
            System.out.println("Gecerli kart numarasi");
            System.out.println("Odemeniz Basari ile Gerceklesmistir. Iyi gunler dileriz...");
            playMusic(filePath);
        } else {
            System.out.println("Gecersiz kart numarasi..Tekrar deneyiniz");
            odemeBilgileri();
        }
System.exit(0);
    }
    public static void cikis() throws InterruptedException {
        System.out.print(kirmizi+"Cikis isleminiz gerceklestirilmektedir  "+(char)9760);
        for (int i=0;i<6;i++){
            Thread.sleep(600);
            System.out.print(" "+(char)9760);
        }System.exit(0);}

    public static void islemMenusu() throws InterruptedException {
            boolean secim = true;
            do {
                System.out.println(fullKoyuSiyahSatirCizgi+mor+"Yapmak istediginiz islem icin bir secenek seciniz\n"+
                        mavi+ "Arac Talep icin 1\n"+
                        yesil+"Arabalari listelemek icin 2\n"+
                        sari+ "Musteri Bilgisi icin 3\n"+
                        mor + "Odeme Bilgisi icin 4\n"+
                        kirmizi+"Cikis yapmak icin 5");
                String secenek= scan.next();

                switch (secenek){
                    case "1" :
                        aracTalep();
                        secim=false;
                        break;
                    case "2" :
                        arabalar();
                        secim=false;
                        break;

                    case "3" :
                        musteriBilgisi();
                        secim=false;
                        break;
                    case "4" :
                        odemeBilgileri();
                        secim=false;
                        break;

                    case "5":
                        playMusic(filePath);
                        //cikis();
                       // secim=false;
                        break;
                    default:
                        System.out.println(kirmizi+"Yanlis bir secenek girdiniz , Lutfen tekrar giris yapiniz");

                        islemMenusu();
                }
            }while (secim);
        }
    Clip clip;

    String status;

    AudioInputStream audioInputStream;
    static String filePath  ;

    public MusteriVeArabaBilgisiGirisi()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void playMusic(String filePath1){
        try
        {
            filePath = "P10_aracKiralama/TechproMentorCanBey.wav";
            MusteriVeArabaBilgisiGirisi audioPlayer =
                    new MusteriVeArabaBilgisiGirisi();

            audioPlayer.play();
boolean secim=true;
            while (secim)
            {
                cikis();
                secim=false;
            }

        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }





    public void play()
    {
        clip.start();
        status = "play";
    }




}

