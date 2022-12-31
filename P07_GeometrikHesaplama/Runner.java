package JavaProjects.P07_GeometrikHesaplama;

public class Runner {

    public static <Yaricap> void main(String[] args) {

        Cember cember = new Cember(5);
        System.out.println("Çemberin yaricapi==>" + cember.yariCap);
        System.out.println();
        System.out.println("Çemberin çevresi ==> : " + String.format("%.2f",cember.cevreHesaplama()));
        System.out.println();
        System.out.println("Çemberin alani ==> " + cember.alanHesaplamaCember());
        System.out.println("***************************************************************");
        Kare kare = new Kare(9);
        System.out.println("Karenin kenar uzunluğu==>" + kare.Kenar);
        System.out.println();
        System.out.println("Karenin alani ==> " + kare.KareAlanHesaplama());
        System.out.println();
        System.out.println("Karenin çevresi ==> " + kare.KareCevreHesaplama());
        System.out.println("***************************************************************");
        Dikdortgen dikdörtgen = new Dikdortgen(15, 7);
        System.out.println();
        System.out.println("Dikdörtgenin uzun kenari:"+ dikdörtgen.uzunKenar+" "+ "Dikdörtgenin kisa kenari: "+ dikdörtgen.kisaKenar);
        System.out.println();
        System.out.println("Dikdörtgenin alani==> " + dikdörtgen.alanHesaplama());
        System.out.println();
        System.out.println("Dikdörtgenin çevresi==> " + dikdörtgen.cevreHesaplama());
        System.out.println("***************************************************************");

    }

}
