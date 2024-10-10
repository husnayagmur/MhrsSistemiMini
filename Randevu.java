import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Randevu {
    private String tarih;
    private String saat;
    private String doktorAdi;
    private boolean iptalEdildi;
    private String poliklinik;

    public int randevuSayisi;
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    private final String[] doktorlar = {
            "Ali Yılmaz", "Ayse Kaya",
            "Efnan Demir", "Esma Şahin", "İbrahim Çelik",
            "Veli Aydın", "Salih Şen", "Saadet Arslan",
            "Hüsna Yağmur", "İrem Özdemir",
            "Kaan Kılıç", "Gülperi Kaplan",
            "Mihri Polat",
            "Zehra Öztürk", "Deniz Akay",
            "Orhan Songür", "Kağan Ateş",
            "Ela Sönmez", "Duru Güneş", "Asel Bekiroğlu",
            "Lina Su", "Aslan Soy", "Ibrahim Akgül"
    };

    public Randevu() {}

    public void randevuAl() {
        Scanner scanner = new Scanner(System.in);
        LocalDate tarih = null;
        boolean poliklinikKontrolL = false;

        while (!poliklinikKontrolL) {
            System.out.print("Poliklinik: ");
            String poliklinik = scanner.nextLine();
            String[] poliklinikAd = {
                    "Dahiliye",
                    "Dermatoloji",
                    "Fizik Tedavi ve Rehabilitasyon",
                    "Göz Hastalıkları",
                    "Kadın Hastalıkları ve Doğum",
                    "Kardiyoloji",
                    "Kulak Burun Boğaz",
                    "Ortopedi ve Travmatoloji",
                    "Psikiyatri",
                    "Üroloji"
            };

            for (String p : poliklinikAd) {
                if (p.equalsIgnoreCase(poliklinik)) {
                    poliklinikKontrolL = true;
                    this.poliklinik = poliklinik;
                    break;
                }
            }

            if (poliklinikKontrolL) {
                doktorKontrol();
            } else {
                System.out.println("Geçersiz poliklinik! Lütfen geçerli bir poliklinik giriniz.");
            }
        }

        while (true) {
            try {
                System.out.print("Randevu Tarihi (GG/AA/YYYY): ");
                String tarihInput = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                tarih = LocalDate.parse(LocalDate.parse(tarihInput, formatter).toString());
                // Tarih geçerli mi? (bugünden büyük mü?)
                if (tarih.isAfter(LocalDate.now())) {
                    this.tarih = tarih.toString();
                    break; // Geçerli tarih, döngüden çık
                } else {
                    System.out.println("Geçersiz tarih! Randevu tarihi bugünden sonraki bir tarih olmalı.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Hatalı format! Lütfen GG/AA/YYYY formatında bir tarih girin.");
            }
        }

        System.out.print("Randevu Saati (HH:MM): ");
        saat = scanner.nextLine();

        // Yeni randevu oluşturuluyor
        System.out.println("Randevunuz başarıyla oluşturuldu:\nPoliklinik: " + poliklinik + "\nTarih: " + tarih + "\nSaat: " + saat + "\nDoktor: " + doktorAdi);
        this.randevuSayisi++;
    }

    private void doktorKontrol() {
        while (true) {
            try {
                if (poliklinik == null) {
                    throw new IllegalArgumentException("Poliklinik bilgisi boş olamaz!");
                }

                // Randevu'nun poliklinik bilgisine göre hekim seçimi
                switch (poliklinik) {
                    case "Dahiliye":
                        System.out.println("Hekim:");
                        doktorSec("Ali Yılmaz", "Ayse Kaya");
                        break;

                    case "Dermatoloji":
                        System.out.println("Hekim:");
                        doktorSec("Efnan Demir", "Esma Şahin", "İbrahim Çelik");
                        break;

                    case "Göz Hastalıkları":
                        System.out.println("Hekim:");
                        doktorSec("Veli Aydın", "Salih Şen", "Saadet Arslan");
                        break;

                    case "Fizik Tedavi ve Rehabilitasyon":
                        System.out.println("Hekim:");
                        doktorSec("Hüsna Yağmur", "İrem Özdemir");
                        break;

                    case "Kadın Hastalıkları ve Doğum":
                        System.out.println("Hekim:");
                        doktorSec("Kaan Kılıç", "Gülperi Kaplan");
                        break;

                    case "Kardiyoloji":
                        System.out.println("Hekim:");
                        doktorSec("Mihri Polat");
                        break;

                    case "Kulak Burun Boğaz":
                        System.out.println("Hekim:");
                        doktorSec("Zehra Öztürk", "Deniz Akay");
                        break;

                    case "Ortopedi ve Travmatoloji":
                        System.out.println("Hekim:");
                        doktorSec("Orhan Songür", "Kağan Ateş");
                        break;

                    case "Psikiyatri":
                        System.out.println("Hekim:");
                        doktorSec("Ela Sönmez", "Duru Güneş", "Asel Bekiroğlu");
                        break;

                    case "Üroloji":
                        System.out.println("Hekim:");
                        doktorSec("Lina Su", "Aslan Soy", "Ibrahim Akgül");
                        break;

                    default:
                        throw new IllegalArgumentException("Geçersiz poliklinik");
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Lütfen geçerli bir poliklinik giriniz ve tekrar deneyiniz.");
            }
        }
    }

    private void doktorSec(String... doktorlar) {
        for (int i = 0; i < doktorlar.length; i++) {
            System.out.println((i + 1) + ") " + doktorlar[i]);
        }
        System.out.println("Hekim Seçiniz:");
        try {
            Scanner scanner = new Scanner(System.in);
            int doktorTercih = scanner.nextInt();
            if (doktorTercih > 0 && doktorTercih <= doktorlar.length) {
                System.out.println("Hekim: " + doktorlar[doktorTercih - 1]);
                this.doktorAdi = doktorlar[doktorTercih - 1];
            } else {
                throw new IllegalArgumentException("Geçersiz seçim, tekrar deneyin.");
            }
        } catch (Exception e) {
            System.out.println("Lütfen geçerli bir sayı giriniz.");
            Scanner scanner = new Scanner(System.in);
            scanner.next();  // Geçersiz girdiyi temizle
        }
    }

    public void randevuBilgileriGoster() {
        if (iptalEdildi) {
            System.out.println("Bu randevu iptal edilmiştir.");
        } else {
                System.out.println("Randevu Bilgileri: " + tarih + " - " + saat + " Doktor: " + doktorAdi);
        }
    }

    public void randevuIptalEt() {
        if (!iptalEdildi&&randevuSayisi!=0) {
            this.iptalEdildi = true;
            System.out.println("Randevunuz iptal edildi.");
            this.iptalEdildi = false;
        } else if(randevuSayisi==0) {
            System.out.println("Randevu Bulunmamaktadır.");
        }else {
            System.out.println("Bu randevu zaten iptal edilmiş.");
        }
    }
}
