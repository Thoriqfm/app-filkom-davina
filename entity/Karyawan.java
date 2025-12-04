package entity;

public class Karyawan {

    private final String nama;
    private final String alamat;
    private final String noTelp;
    private final String jenisKelamin;
    private final String kategoriKaryawan;
    private boolean tersedia;

    public Karyawan(String nama, String alamat, String noTelp, String jenisKelamin, String kategoriKaryawan) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.kategoriKaryawan = kategoriKaryawan;
        this.tersedia = true;
    }

    public void bekerja() {
        System.out.println(nama + " sedang bekerja sebagai " + kategoriKaryawan);
    }

    public void tampilkanData() {
        System.out.println("==================================");
        System.out.println("Nama          : " + nama);
        System.out.println("Alamat        : " + alamat);
        System.out.println("No. Telp      : " + noTelp);
        System.out.println("Jenis Kelamin : " + jenisKelamin);
        System.out.println("Kategori      : " + kategoriKaryawan);
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getKategoriKaryawan() {
        return kategoriKaryawan;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
