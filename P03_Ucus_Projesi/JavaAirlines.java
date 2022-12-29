package JavaProjects.P03_Ucus_Projesi;

import java.util.Scanner;

import static JavaProjects.P03_Ucus_Projesi.Methods.ucus;


public class JavaAirlines {

    public static void main(String[] args) {



/*
        Scanner input = new Scanner(System.in);
        System.out.print("javaAirlines'a hos geldiniz..\n ANKARA, IZMIR, VAN rotasından birini seciniz : ");
        String sehir = input.next().toUpperCase();
        System.out.println("Tek yon icin 'T'\n gidis donus  icin 'GD' giriniz");
        String ucustipi=input.next().toLowerCase();
        System.out.println("Lutfen Ad Soyad giriniz");
        input.nextLine();//onemli
        String adSoyad=input.nextLine();
        System.out.println("yasinizi giriniz");
        int yas=input.nextInt();*/
        Yolcu yolcu1=new Yolcu();
        ucus(yolcu1.getAdSoyad(), yolcu1.getSehir(), yolcu1.getUcusTipi(),yolcu1.getYolcuYas());
        //1..bilet hazirlama yolu==>Scanner yorumda yukarisi calisinca pojo classa bilgilere gore bilet hazirlanir.

        //Yolcu yolcu2=new Yolcu("Van","gd","Aynur Gul",67);
        //ucus(yolcu2.getAdSoyad(),yolcu2.getSehir(),yolcu2.getUcusTipi(),yolcu2.getYolcuYas());
        //2.. bilet hazirlama yolu==>CONSTRUCTOR ici doldurulup bilet hazirlanabilir.
         //Yolcu yolcu1=new Yolcu();
       // ucus(yolcu1.setAdSoyad(adSoyad),yolcu1.setSehir(sehir),yolcu1.setUcusTipi(ucustipi),yolcu1.setYolcuYas(yas));
      //3 yol ==>kullanicidan data alip da calistirilabilir. yukaridaki scanner kismi yorumdan cikarilip calistirilmali


    }
}
