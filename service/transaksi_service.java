package service;

import entity.*;
import java.util.ArrayList;

public class transaksi_service {

    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Create
    public void tambahTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
        System.out.println("✓ Transaksi berhasil ditambahkan!");
    }

    // Read
    public void tampilkanSemuaTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada data transaksi.");
            return;
        }
        System.out.println("\n=== DATA TRANSAKSI FILKOM TOUR AND TRAVEL ===");
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println("\nTransaksi ke-" + (i + 1));
            daftarTransaksi.get(i).tampilkanDetail();
        }
    }

    // Update status
    public void updateStatusTransaksi(String idTransaksi, String statusBaru) {
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi().equals(idTransaksi)) {
                transaksi.setStatusTransaksi(statusBaru);
                System.out.println("✓ Status transaksi berhasil diperbarui!");
                return;
            }
        }
        System.out.println("✗ Transaksi dengan ID " + idTransaksi + " tidak ditemukan!");
    }

    // Delete
    public void hapusTransaksi(String idTransaksi) {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            if (daftarTransaksi.get(i).getIdTransaksi().equals(idTransaksi)) {
                daftarTransaksi.remove(i);
                System.out.println("✓ Transaksi berhasil dihapus!");
                return;
            }
        }
        System.out.println("✗ Transaksi dengan ID " + idTransaksi + " tidak ditemukan!");
    }

    // (Opsional) cari berdasarkan ID
    public Transaksi cariTransaksiById(String idTransaksi) {
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi().equals(idTransaksi)) {
                return transaksi;
            }

        }
        return null;
    }
}
