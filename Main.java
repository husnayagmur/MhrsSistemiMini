import java.util.Date;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Hasta hasta1 = new Hasta("Hüsna", "Yagmur");


        hasta1.setTc();
        hasta1.setParola();

        hasta1.girisBilgileri("12345678912","12345678");
        hasta1.kontrol();
        Randevu randevu=new Randevu();
       System.out.println("Lütfen yapmak istediginiz islemi seciniz: ");
       System.out.println("1)Randevu Al");
       System.out.println("2)Randevu İptal");
        System.out.println("3)Randevu Bilgileri");
       int secim=inp.nextInt();
       switch (secim){
           case 1: randevu.randevuAl();
               System.out.println("Lütfen yapmak istediginiz islemi seciniz: ");
               System.out.println("1)Randevu İptal");
               System.out.println("2)Randevu Bilgileri");
               System.out.println("3)Çıkış");
               int secim1=inp.nextInt();
               switch (secim1){
                   case 1:randevu.randevuIptalEt();
                   case 2:randevu.randevuBilgileriGoster();
                   case 3:break;
               }

           case 2:randevu.randevuIptalEt();
               System.out.println("Lütfen yapmak istediginiz islemi seciniz: ");
               System.out.println("1)Randevu Al");
               System.out.println("2)Randevu Bilgileri");
               System.out.println("3)Çıkış");
               int secim2=inp.nextInt();
               switch (secim2){
                   case 1:randevu.randevuAl();
                   case 2:randevu.randevuBilgileriGoster();
                   case 3:break;
               }
           case 3:randevu.randevuBilgileriGoster();
               System.out.println("Lütfen yapmak istediginiz islemi seciniz: ");
               System.out.println("1)Randevu Al");
               System.out.println("2)Randevu İptal Et");
               System.out.println("3)Çıkış");
               int secim3=inp.nextInt();
               switch (secim3){
                   case 1:randevu.randevuAl();
                   case 2:randevu.randevuIptalEt();
                   case 3:break;
               }
       }
    }
}