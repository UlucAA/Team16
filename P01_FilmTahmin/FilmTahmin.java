package JavaProjects.P01_FilmTahmin;

import java.util.*;

public class FilmTahmin {


    /*
     TASK :
      yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının film ismini  görmeden
      filmin index nosuna göre sectiriniz
      seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
      sağlayan method create ediniz...
      Ahanda TRICK...
      kullanıcının sectiği filmin harf sayısını  console yazdırınız.
      kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
      kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
      kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
      kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.

     */
    //terminalde ciktinin istenen duzende olmasi adina;
    public static final String sadeceSiyah = "\u001B[30m";
    public static final String kalin= "\u001B[1m";
    public static final String egimli= "\u001B[3m";
    public static final String griSatirCizgi= "\u001B[47m";

    public static void main(String[] args) {
        System.out.println(sadeceSiyah + kalin + egimli + griSatirCizgi +
                "I=I=I==I===I=====I WELCOME TO THE MOVIE PREDICTION GAME! I=====I===I==I=I=I");
        System.out.println("1 ile " + movies.size() + " arasinda bir rakam ya da sayi giriniz.");
        int selectToIndex;

        while (true) {
            try {
                selectToIndex = input.nextInt();
                if (selectToIndex < 0 || selectToIndex > movies.size())
                    throw new ArithmeticException();
                else
                    break;
            } catch (ArithmeticException e) {
                System.out.println("1 ile " + movies.size() + " arasında bir deger girmelisiniz!");
            } catch (InputMismatchException e) {
                String str = input.nextLine();
                System.out.println("Uyumsuz eslesme, lutfen tekrar deneyiniz!");

            }

        }
        getMovie(movies,selectToIndex-1);

    }

    //==>> Bir film list'i olusturunuz.
    public static List<String> movies = new ArrayList<>
            (Arrays.asList("INCEPTION", "OLDBOY", "INTERSTELLAR", "PRESTIGE", "NOSTALGIA", "OBLIVION", "STALKER", "SPARTACUS", "AMOUR", "SOLARIS"));
    //ps: class'in icinde her yerden ulasabilmek adina "static" keyword. List tercihi ise sirali cagirma olmadigindan.
    //==>> yukaridaki film listinde bulunan filmlerden herhangi birisini kullanicinin film ismini  gormeden filmin index nosuna göre sectiriniz
    public static Scanner input = new Scanner(System.in);
    //==>> seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini saglayan method create ediniz...
    private static void getMovie(List<String> movie, int index) {
        StringBuilder tahminFilm = new StringBuilder(FilmTahmin.movies.get(index).replaceAll("\\w","-"));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // ps1: Burada StringBuilder tercih edilmesinin nedeni constructor'in icine parametreleri yazabilme istencidir.//
        // ps2: Movie_Prediction class'inda olusturulan movies objemiz cagirildi.                                      //
        // ps3: Kullanici filmi alenen goremesin diye de harflerin tamami replaceAll() method'u ile "_" cevrildi.      //
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //==>>   kullanıcının sectiği filmin harf sayısını  console yazdırınız.
        System.out.println(sadeceSiyah + kalin + egimli + tahminFilm);
        //==>>  kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
        System.out.println(sadeceSiyah + kalin + egimli + griSatirCizgi +
                movie.get(index).length() + " harften olusan yabanci filmi sectiniz. Sectiginiz bu filmi tahmin etmek icin; " +
                2*movie.get(index).length() + " hakkiniz vardir!");

        //do-whle loop kullanilacak olma sebebi; bir adet durum sozkonusu olmasi.
        char letter = ' '; //harf girdisi olacagindan
        int yanlisTahminSayisi = 0; //yanlis harf girildiginde sayisini elde edebilmek icin
        int dogruTahminSayisi = 0;
        StringBuilder str = new StringBuilder();
        do{
            //==>>    kullanıcının her tahmininde kalan hak sayısını console yazdırınız
            //==>>   kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
            System.out.println("Yanlis girilen tahmin sayisi/rakami: " + (yanlisTahminSayisi - dogruTahminSayisi) +
                    "/" + 2*movie.get(index).length() + "\nIcinize dogan harfi giriniz lutfen: ");
            letter = input.next().toUpperCase().charAt(0); //tahmin edilen harfin alimi
            str.append(letter);//kullanicidan alinan harfin str'e assign edilmesi
            if(!tahminFilm.toString().contains(str)){
                yanlisTahminSayisi++;//index ile tercih edilen filmde girilen harfin olmamasi durumu icin
            }
            for(int i = 0; i<tahminFilm.length(); i++){
                if(movie.get(index).charAt(i)==letter){
                    if(!tahminFilm.toString().contains(movie.get(index).substring(i,i+1))){
                        dogruTahminSayisi++;
                    }
                    tahminFilm.setCharAt(i,letter);//tahmin dogru ise; tahmin edilecek filmin indexine bu harfi yerlestir.
                }
            }
            if(tahminFilm.toString().equalsIgnoreCase(movie.get(index))){
                System.out.println("CONGRATULATIONS!" + "\n" + "Result: " + tahminFilm);
                break;
            }
            System.out.println(tahminFilm);
        }while((yanlisTahminSayisi - dogruTahminSayisi) != 2*movie.get(index).length());
        if ((yanlisTahminSayisi - dogruTahminSayisi) == 2 * movie.get(index).length()) {
            System.out.println("yanlis tahmin sayisi :" + (yanlisTahminSayisi - dogruTahminSayisi));
            System.out.println("agam game over  yine bekleriz ... tahmin edemedigin film :" + movie.get(index));
        }
    }

}

