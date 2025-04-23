package FinalOdev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int secim;
		int kursId,kursiyerId,kursiyerYas;
		String kursAd,AdSoyad;
		ArrayList<Kursiyer>kursiyerler=new ArrayList<Kursiyer>();
		ArrayList<Kurs>kurslar=new ArrayList<Kurs>();
		File myFile1=new File("C:\\Users\\ASUS\\OneDrive\\Masaüstü\\kurs.txt");
		if(!myFile1.exists()) {
			System.out.println("Kurs dosyasi bulunamadi!!!");
			return;
		}
		FileReader fr1=new FileReader(myFile1);
		BufferedReader br1=new BufferedReader(fr1);
		String okunan1;
		String[] okunanDizi1;
		while((okunan1=br1.readLine())!=null) {
			okunanDizi1=okunan1.split("%");
			kurslar.add(new Kurs(Integer.parseInt(okunanDizi1[0]),okunanDizi1[1]));
		}
		fr1.close();
		br1.close();
		
		File myFile2=new File("C:\\Users\\ASUS\\OneDrive\\Masaüstü\\kursiyer.txt");
		if(!myFile2.exists()) {
			System.out.println("Kurs dosyasi bulunamadi!!!");
			return;
		}
		FileReader fr2=new FileReader(myFile2);
		BufferedReader br2=new BufferedReader(fr2);
		String okunan2= new String(Files.readAllBytes(Paths.get("C:\\Users\\ASUS\\OneDrive\\Masaüstü\\kursiyer.txt")));;
		String[] okunanDizi2;
		okunanDizi2=okunan2.split("\\*");
		for(String oku:okunanDizi2) {
			if(oku.trim().isEmpty()) {
				continue;
			}
			oku=oku.replaceAll("[\\n\\r]", "");
			String[] ok2=oku.split("\\+");
			int id=0,yas=0;
			String ad=null;
			ArrayList<Kurs> alinankurslar=new ArrayList<>();
			for(int i=0;i<ok2.length;i++) {
				String[] ok4=ok2[i].split("%");
				if(ok4.length==3) {
					id=Integer.parseInt(ok4[0]);
					ad=ok4[1];
					yas=Integer.parseInt(ok4[2]);
				}
				else if(ok4.length==2) {
					alinankurslar.add(new Kurs(Integer.parseInt(ok4[0]),ok4[1]));
				}
			}
			kursiyerler.add(new Kursiyer(id,ad,yas,alinankurslar));
		}
		fr2.close();
		br2.close();
		while(true){
			System.out.println("");
			System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤❤️❤️❤️ANAMENU❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
			System.out.println("❤️Secim1:Kurs Ekle                                       ❤️");
			System.out.println("❤️Secim2:Kurs Listele                                    ❤️");
			System.out.println("❤️Secim3:Kurs Ara                                        ❤️");
			System.out.println("❤️Secim4:Kurs Sil                                        ❤️");
			System.out.println("❤️Secim5:Kursiyer Ekle                                   ❤️");
			System.out.println("❤️Secim6:Kursiyer Ara                                    ❤️");
			System.out.println("❤️Secim7:Kursiyer Sil                                    ❤️");
			System.out.println("❤️Secim8:Kursiyer Listele                                ❤️");
			System.out.println("❤️Secim9:Kursiyerleri Ayrintili                          ❤️");
			System.out.println("❤️Secim10:Kursiyerin Odeyeceği Tutari Hesapla            ❤️");
			System.out.println("❤️Secim11:Cikis                                          ❤️");
			System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️");
			System.out.print("Lutfen yapmak istediginiz islemi seciniz:");
			secim=scan.nextInt();
			scan.nextLine();
			switch(secim) {
			case 1:
				System.out.println("Kurs ekleme islemi baslatiliyor...");
				System.out.print("Lutfen eklenecek kursun id bilgisini giriniz:");
				kursId=scan.nextInt();
				scan.nextLine();
				System.out.print("Lutfen eklenecek kursun adini giriniz:");
				kursAd=scan.nextLine();
				boolean varMi1=false;
				for(Kurs kr:kurslar) {
					if(kr.getKursId()==kursId) {
						varMi1=true;
					}
				}
				if(varMi1==false) {
					kurslar.add(new Kurs(kursId,kursAd));
					System.out.println("Kurs basarili bir sekilde eklendi❤️");
				}
				else {
					System.out.println("Girdiginiz id bilgisinde kurs bulunmaktadir!!!");
				}
				break;
			case 2:
				System.out.println("Kurs listeleme islemi baslatiliyor...");
				System.out.println("Kurs Id		Kurs Ad");
				for(Kurs kr:kurslar) {
					System.out.println(kr.getKursId()+"		"+kr.getKursAd());
				}
				break;
			case 3:
				System.out.println("Kurs arama islemi baslatiliyor...");
				System.out.print("Lutfen aranacak kursun adini giriniz:");
				kursAd=scan.nextLine();
				boolean varMi2=false;
				for(Kurs kr:kurslar) {
					if(kr.getKursAd().contains(kursAd)) {
						System.out.println("Aranan kurs bulundu❤️");
						System.out.println("Kurs Id		Kurs Ad");
						System.out.println(kr.getKursId()+"		"+kr.getKursAd());
						varMi2=true;
					}
				}
				if(varMi2==false) {
					System.out.println("Aranan kurs bulunamadi:(");
				}
				break;
			case 4:
				System.out.println("Kurs silme islemi baslatiliyor...");
				System.out.print("Lutfen silmek istediginiz kursun adini giriniz:");
				kursAd=scan.nextLine();
				boolean varMi3=false;
				for(Kursiyer ks:kursiyerler) {
					for(Kurs kr:ks.alinanKurslar) {
						if(kr.getKursAd().contains(kursAd)) {
							varMi3=true;
						}
					}
				}
				int syc=0;
				if(varMi3==false) {
					for(Kurs kr:kurslar) {
						if(kr.getKursAd().contains(kursAd)) {
							kurslar.remove(kr);
							System.out.println("Kurs basarili bir sekilde silindi❤️");
							syc++;
							break;
						}
					}
				}
				else {
					System.out.println("Silmek istediginiz kursu alan kursiyer/kursiyerler bulundugu icin kurs silinemedi:(");
					syc++;
				}
				if(syc==0) {
					System.out.println("Silmek istediginiz kurs bulunamadi:(");
				}
				break;
			case 5:
				System.out.println("Kursiyer ekleme islemi baslatiliyor...");
				boolean varMi4=false;
				System.out.print("Lutfen eklenecek kursiyerin id bilgisini giriniz:");
				kursiyerId=scan.nextInt();
				scan.nextLine();
				System.out.print("Lutfen eklenecek kursiyerin ad soyad bilgisini giriniz:");
				AdSoyad=scan.nextLine();
				System.out.print("Lutfen eklenecek kursiyerin yas bilgisini giriniz:");
				kursiyerYas=scan.nextInt();
				scan.nextLine();
				int kursSayisi;
				System.out.print("Lutfen eklenecek kursiyerin alacagi kurs sayisi bilgisini giriniz:");
				kursSayisi=scan.nextInt();
				scan.nextLine();
				ArrayList<Kurs> alinankurslar=new ArrayList<>();
				for(int i=0;i<kursSayisi;i++) {
					System.out.print("Lutfen eklenecek kursun id bilgisini giriniz:");
					kursId=scan.nextInt();
					scan.nextLine();
					System.out.print("Lutfen eklenecek kursun adini giriniz:");
					kursAd=scan.nextLine();
					alinankurslar.add(new Kurs(kursId,kursAd));
				}
				for (Kursiyer ks:kursiyerler) {
					if(ks.getKursiyerId()==kursiyerId) {
						varMi4=true;
					}
				}
				if(varMi4==false) {
					kursiyerler.add(new Kursiyer(kursiyerId,AdSoyad,kursiyerYas,alinankurslar));
					System.out.println("Kursiyer basarili bir sekilde eklendi❤️");
				}
				else {
					System.out.println("Girdiginiz id bilgisine ait kursiyer bulunmaktadir!!!");
				}
				break;
			case 6:
				System.out.println("Kursiyer arama islemi baslatiliyor...");
				boolean varMi5=false;
				System.out.print("Lutfen aranacak kursiyerin ad soyad bilgisini giriniz:");
				AdSoyad=scan.nextLine();
				for(Kursiyer ks:kursiyerler) {
					if(ks.getAdSoyad().contains(AdSoyad)) {
						varMi5=true;
						System.out.println("Aranan kursiyer bulundu❤️");
						System.out.println(ks.getKursiyerId()+" "+ks.getAdSoyad()+" "+ks.getKursiyerYas());
						for(Kurs kr:ks.alinanKurslar) {
							System.out.println(kr.getKursId()+" "+kr.getKursAd());
						}
					}
				}
				if(varMi5==false) {
					System.out.println("Girilen ad soyad bilgisine ait kursiyer bulunamadi:(");
				}
				
				break;
			case 7:
				System.out.println("Kursiyer silme islemi baslatiliyor...");
				System.out.print("Lutfen silmek istediginiz kursiyerin id bilgisini giriniz:");
				kursiyerId=scan.nextInt();
				boolean varMi6=false;
				for(Kursiyer ks:kursiyerler) {
					if(ks.getKursiyerId()==kursiyerId) {
						kursiyerler.remove(ks);
						varMi6=true;
						System.out.println("Kursiyer basarili bir sekilde silindi❤️");
						break;
					}
				}
				if(varMi6==false) {
					System.out.println("Silinecek kursiyer bulunamadi:(");
				}
				break;
			case 8:
				System.out.println("Tum kursiyerler:");
				for(Kursiyer ks:kursiyerler) {
					System.out.println(ks.getKursiyerId()+" "+ks.getAdSoyad()+" "+ks.getKursiyerYas());
				}
				break;
			case 9:
				System.out.println("Tum kursiyerler ve aldiklari kurslar:");
				for(Kursiyer ks:kursiyerler) {
					System.out.println(ks.getKursiyerId()+" "+ks.getAdSoyad()+" "+ks.getKursiyerYas());
					for(Kurs kr:ks.alinanKurslar) {
						System.out.println("\t"+kr.getKursId()+" "+kr.getKursAd());
					}
				}
				break;
			case 10:
				System.out.println("Kursiyerin odeyecegi tutar hesaplaniyor...");
				System.out.print("Lutfen borcu hesaplanacak kursiyerin id bilgisini giriniz:");
				kursiyerId=scan.nextInt();
				boolean varMi7=false;
				for(Kursiyer ks:kursiyerler) {
					if(ks.getKursiyerId()==kursiyerId) {
						int kursSayisi1=0;
						for(Kurs kr:ks.alinanKurslar) {
							kursSayisi1+=1;
						}
						System.out.println("Kursiyerin borcu:"+ks.BorcHesapla(kursSayisi1));
					}
				}
				break;
			case 11:
				FileWriter fw1=new FileWriter(myFile1);
				BufferedWriter bw1=new BufferedWriter(fw1);
				for(Kurs kr:kurslar) {
					bw1.write(kr.getKursId()+"%"+kr.getKursAd()+"\n");
				}
				bw1.flush();
				FileWriter fw2=new FileWriter(myFile2);
				BufferedWriter bw2=new BufferedWriter(fw2);
				for(Kursiyer ks:kursiyerler) {
					bw2.write("*"+ks.getKursiyerId()+"%"+ks.getAdSoyad()+"%"+ks.getKursiyerYas()+"\n");
					for(Kurs kr:ks.alinanKurslar) {
						bw2.write("+"+kr.getKursId()+"%"+kr.getKursAd()+"\n");
					}
				}
				bw2.flush();
				System.out.println("Cikis yapiliyor...");
				return;
			default:
				System.out.println("Lutfen gecerli deger giriniz!!!");
				break;	
			}
		}
	}
}
