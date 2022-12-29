package JavaProjects.P03_Ucus_Projesi;

public class Yolcu {


   private String sehir="ankara";
   private String ucusTipi="gd";
   private int yolcuYas=66;
    private String adSoyad="mehmet yilmaz";
    public Yolcu(){}
    public Yolcu(String sehir, String ucusTipi,String adSoyad, int yolcuYas) {
        this.sehir = sehir;
        this.ucusTipi = ucusTipi;
        this.yolcuYas = yolcuYas;
        this.adSoyad=adSoyad;
    }

    public String getSehir() {
        return sehir;
    }

    public String setSehir(String sehir) {
        this.sehir = sehir;
        return sehir;
    }

    public String getUcusTipi() {
        return ucusTipi;
    }

    public String setUcusTipi(String ucusTipi) {
        this.ucusTipi = ucusTipi;
        return ucusTipi;
    }

    public int getYolcuYas() {
        return yolcuYas;
    }

    public int setYolcuYas(int yolcuYas) {
        this.yolcuYas = yolcuYas;
        return yolcuYas;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
        return adSoyad;
    }

}
