package entity;

public class Mobil {

    private final String noPlat;
    private final String merkMobil;
    private final String warnaMobil;
    private final int tahunKeluaran;

    public String getNoPlat() {
        return noPlat;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public int getTahunKeluaran() {
        return tahunKeluaran;
    }

    public Mobil(String noPlat, String merkMobil, String warnaMobil, int tahunKeluaran) {
        this.noPlat = noPlat;
        this.merkMobil = merkMobil;
        this.warnaMobil = warnaMobil;
        this.tahunKeluaran = tahunKeluaran;
    }

    public void nyalakanMesin() {
        System.out.println("Mobil " + merkMobil + " dengan plat " + noPlat + " sedang dinyalakan...");
    }

    public void tampilkanData() {
        System.out.println("==================================");
        System.out.println("No. Plat        : " + noPlat);
        System.out.println("Merk Mobil      : " + merkMobil);
        System.out.println("Warna Mobil     : " + warnaMobil);
        System.out.println("Tahun Keluaran  : " + tahunKeluaran);
    }
}
