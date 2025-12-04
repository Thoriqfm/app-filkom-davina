package service;

import entity.Transaksi;
import java.util.ArrayList;

public class transaksi_service {

    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // CREATE
    public void tambahTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
        System.out.println("✓ Transaksi berhasil ditambahkan!");
    }

    // READ
    public void tampilkanSemuaTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada data transaksi.");
            return;
        }
        System.out.println("\n=== DAFTAR TRANSAKSI ===");
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println("\nTransaksi ke-" + (i + 1));
            daftarTransaksi.get(i).tampilkanDetail();
        }
    }

    // UPDATE STATUS
    public void updateStatusTransaksi(String idTransaksi, String statusBaru) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equals(idTransaksi)) {
                t.setStatusTransaksi(statusBaru);
                System.out.println("✓ Status transaksi berhasil diupdate!");
                return;
            }
        }
        System.out.println("✗ Transaksi tidak ditemukan!");
    }

    // DELETE
    public void hapusTransaksi(String idTransaksi) {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            if (daftarTransaksi.get(i).getIdTransaksi().equals(idTransaksi)) {
                daftarTransaksi.remove(i);
                System.out.println("✓ Transaksi berhasil dihapus!");
                return;
            }
        }
        System.out.println("✗ Transaksi tidak ditemukan!");
    }

    // Method tambahan - cari berdasarkan ID
    public Transaksi cariTransaksi(String idTransaksi) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equals(idTransaksi)) {
                return t;
            }
        }
        return null;
    }
}
