package FinalOdev;

import java.util.ArrayList;

public class Kursiyer implements Hesaplama{
	private int kursiyerId;
	private String AdSoyad;
	private int kursiyerYas;
	public ArrayList<Kurs> alinanKurslar;
	
	

	public Kursiyer(int kursiyerId, String adSoyad, int kursiyerYas, ArrayList<Kurs> alinanKurslar) {
		super();
		this.kursiyerId = kursiyerId;
		AdSoyad = adSoyad;
		this.kursiyerYas = kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}

	public int getKursiyerId() {
		return kursiyerId;
	}

	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}

	public String getAdSoyad() {
		return AdSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		AdSoyad = adSoyad;
	}

	public int getKursiyerYas() {
		return kursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}

	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}

	public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {
		this.alinanKurslar = alinanKurslar;
	}

	@Override
	public double BorcHesapla(int kursSayisi) {
		// TODO Auto-generated method stub
		double borc;
		int fiyat=500;
		if(kursSayisi==1) {
			borc=fiyat;
		}
		else if(kursSayisi==2) {
			borc=fiyat+(fiyat-fiyat*0.2);
		}
		else if(kursSayisi==3) {
			borc=fiyat+fiyat+(fiyat-fiyat*0.25);
		}
		else {
			borc=kursSayisi*(fiyat-fiyat*0.1);
		}
		return borc;
	}
}
