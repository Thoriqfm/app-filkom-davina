package entity;

public class TransaksiTravel extends Transaksi {

    private String tujuan;
    private String namaSupir;
    private String merkMobil;
    private String noPlatMobil;
    private double hargaPerKm;
    private double jarak;

    public TransaksiTravel(String idTransaksi, String namaPelanggan, String noTelpPelanggan, String statusTransaksi, String tujuan, String namaSupir, String merkMobil, String noPlatMobil, double hargaPerKm, double jarak) {
        super(idTransaksi, namaPelanggan, noTelpPelanggan, statusTransaksi);
        this.tujuan = tujuan;
        this.namaSupir = namaSupir;
        this.merkMobil = merkMobil;
        this.noPlatMobil = noPlatMobil;
        this.hargaPerKm = hargaPerKm;
        this.jarak = jarak;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getNamaSupir() {
        return namaSupir;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public String getNoPlatMobil() {
        return noPlatMobil;
    }

    public double getHargaPerKm() {
        return hargaPerKm;
    }

    public double getJarak() {
        return jarak;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Tujuan          : " + tujuan);
        System.out.println("Nama Supir     : " + namaSupir);
        System.out.println("Merk Mobil     : " + merkMobil);
        System.out.println("No. Plat Mobil : " + noPlatMobil);
        System.out.println("Harga per Km   : " + hargaPerKm);
        System.out.println("Jarak          : " + jarak + " km");
    }

    @Override
    public double hitungTotal() {
        return hargaPerKm * jarak;
    }
}
