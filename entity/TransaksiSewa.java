package entity;

public class TransaksiSewa extends Transaksi {

    private String merkMobil;
    private String noPlatMobil;
    private int lamaSewa; // dalam hari
    private double hargaPerHari;
    private boolean denganSupir;
    private String namaSupir;

    public TransaksiSewa(String idTransaksi, String namaPelanggan, String noTelpPelanggan, String statusTransaksi, String merkMobil, String noPlatMobil, int lamaSewa, double hargaPerHari, boolean denganSupir, String namaSupir) {
        super(idTransaksi, namaPelanggan, noTelpPelanggan, statusTransaksi);
        this.merkMobil = merkMobil;
        this.noPlatMobil = noPlatMobil;
        this.lamaSewa = lamaSewa;
        this.hargaPerHari = hargaPerHari;
        this.denganSupir = denganSupir;
        this.namaSupir = namaSupir;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public String getNoPlatMobil() {
        return noPlatMobil;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public double getHargaPerHari() {
        return hargaPerHari;
    }

    public boolean isDenganSupir() {
        return denganSupir;
    }

    public String getNamaSupir() {
        return namaSupir;
    }

    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Merk Mobil     : " + merkMobil);
        System.out.println("No. Plat Mobil : " + noPlatMobil);
        System.out.println("Lama Sewa      : " + lamaSewa + " hari");
        System.out.println("Harga per Hari : " + hargaPerHari);
        System.out.println("Dengan Supir   : " + (denganSupir ? "Ya" : "Tidak"));
        if (denganSupir) {
            System.out.println("Nama Supir     : " + namaSupir);
        }
    }

    @Override
    public double hitungTotal() {
        double total = hargaPerHari * lamaSewa;
        if (denganSupir) {
            total += 100000 * lamaSewa; // biaya tambahan supir per hari
        }
        return total;
    }
}
