package service;

import entity.Karyawan;
import java.util.ArrayList;

public class karyawan_service {

    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    // CREATE - Menambah karyawan
    public void tambahKaryawan(Karyawan karyawan) {
        daftarKaryawan.add(karyawan);
        System.out.println("✓ Karyawan berhasil ditambahkan!");
    }

    // READ - Menampilkan semua karyawan
    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Tidak ada data karyawan.");
            return;
        }
        System.out.println("\n=== DATA KARYAWAN FILKOM TOUR AND TRAVEL ===");
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            System.out.println("\nKaryawan ke-" + (i + 1));
            daftarKaryawan.get(i).tampilkanData();
        }
    }

    // UPDATE - Replace karyawan berdasarkan nama
    public void replaceKaryawan(String nama, Karyawan karyawanBaru) {
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            if (daftarKaryawan.get(i).getNama().equals(nama)) {
                daftarKaryawan.set(i, karyawanBaru);
                System.out.println("✓ Karyawan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("✗ Karyawan dengan nama " + nama + " tidak ditemukan!");
    }

    // DELETE - Hapus karyawan berdasarkan nama
    public void deleteKaryawan(String nama) {
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            if (daftarKaryawan.get(i).getNama().equals(nama)) {
                daftarKaryawan.remove(i);
                System.out.println("✓ Karyawan berhasil dihapus!");
                return;
            }
        }
        System.out.println("✗ Karyawan dengan nama " + nama + " tidak ditemukan!");
    }

    public ArrayList<Karyawan> getDaftarKaryawan() {
        return daftarKaryawan;
    }
}
