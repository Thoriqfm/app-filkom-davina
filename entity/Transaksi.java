package entity;

public class Transaksi {

    protected final String idTransaksi;
    protected final String namaPelanggan;
    protected final String noTelpPelanggan;
    protected String statusTransaksi;

    // Constructor
    public Transaksi(String idTransaksi, String namaPelanggan, String noTelpPelanggan, String statusTransaksi) {
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.noTelpPelanggan = noTelpPelanggan;
        this.statusTransaksi = "Pending";
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNoTelpPelanggan() {
        return noTelpPelanggan;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String status) {
        this.statusTransaksi = status;
    }

    public void tampilkanDetail() {
        System.out.println("================================");
        System.out.println("ID Transaksi    : " + idTransaksi);
        System.out.println("Nama Pelanggan  : " + namaPelanggan);
        System.out.println("No. Telp        : " + noTelpPelanggan);
        System.out.println("Status          : " + statusTransaksi);
    }

    // method untuk menghitung total default
    public double hitungTotal() {
        return 0.0;
    }

}
