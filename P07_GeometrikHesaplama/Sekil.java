package JavaProjects.P07_GeometrikHesaplama;

public class Sekil {

    double uzunKenar;
    double kisaKenar;
    double yariCap;
    double Kenar;


    public Sekil(double uzunKenar, double kisaKenar) {
        this.uzunKenar = uzunKenar;
        this.kisaKenar = kisaKenar;
    }

    public Sekil(double a) {
      this.yariCap = a;
      this.Kenar = a;
    }

    public double cevreHesaplama() {
        return (uzunKenar + kisaKenar) * 2;
    }

    public double alanHesaplama() {
        return uzunKenar * kisaKenar;
    }

    public double alanHesaplamaCember() {
        return yariCap * yariCap * 3.14;
    }
    public double KareCevreHesaplama(){

        return 4*Kenar;
    }
    public double KareAlanHesaplama(){

        return Kenar*Kenar;
    }
}
