import java.util.Scanner;

public class Hasta {
    String ad;
    String soyad;
    private String tc;
    private String parola;
    boolean kontrol;
    Scanner inp = new Scanner(System.in);

    public Hasta(String ad,String soyad){
        this.ad=ad;
        this.soyad=soyad ;
    }

    public void girisBilgileri(String girilenTc,String girilenParola) {
       boolean girisBilgileriSonucu=this.tc.equals(girilenTc) && this.parola.equals(girilenParola);
        if(girisBilgileriSonucu==true){
            System.out.println("Giris Basarili!");
            kontrol=true;
        }
        else{
            System.out.println("Giriş başarısız. TC veya parola yanlış.");
            kontrol=false;
        }
    }

    public String getTc() {
        return tc;
    }

    public void setTc() {
        int hak = 0;
        while (hak < 3) {
            System.out.print("Lütfen kimlik numaranizi giriniz: ");
            tc = inp.nextLine();

            if (tc.length() == 11) {
                break;
            } else {
                hak++;
                if (hak == 3) {
                    System.out.println("Cikisiniz yapiliyor...!");
                } else {
                    System.out.println("Tekrar deneyiniz!");
                }
            }
        }
    }
    public void kontrol(){
        if(kontrol==false){
            System.exit(0);
        }
    }

    public String getParola() {
        return parola;
    }

    public void setParola() {
        int parolaHakki=0;
        while (parolaHakki < 3) {
            System.out.print("Lütfen sifrenizi giriniz: ");
            parola = inp.nextLine();
            if((parola.length()==8))
            {
                System.out.println();
                break;
            }
            else {
                parolaHakki++;
                if (parolaHakki == 3) {
                    System.out.println("Cikisiniz yapiliyor...!");
                } else {
                    System.out.println("Tekrar deneyiniz!");
                }
            }
        }
    }

}
