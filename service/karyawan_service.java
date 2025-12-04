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

    // Mendapat daftar supir travel yang tersedia
    public ArrayList<Karyawan> getSupirTravelTersedia() {
        ArrayList<Karyawan> supirTersedia = new ArrayList<>();
        // for each
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getKategoriKaryawan().equalsIgnoreCase("Supir Travel") && karyawan.isTersedia()) {
                supirTersedia.add(karyawan);
            }
        }
        return supirTersedia;
    }

    // mendapat daftar supir rentcar yang tersedia
    public ArrayList<Karyawan> getSupirRentCarTersedia() {
        ArrayList<Karyawan> supirTersedia = new ArrayList<>();
        // for each
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getKategoriKaryawan().equalsIgnoreCase("Supir Rentcar") && karyawan.isTersedia()) {
                supirTersedia.add(karyawan);
            }
        }
        return supirTersedia;
    }

    // Mencari karyawan berdasarkan nama
    public Karyawan cariKaryawanByNama(String nama) {
        // for each
        for (Karyawan karyawan : daftarKaryawan) {
            if (karyawan.getNama().equals(nama)) {
                return karyawan;
            }
        }
        return null;
    }

    // cek apakah ada supir travel tersedia
    public boolean adaSupirTravelTersedia() {
        return !getSupirTravelTersedia().isEmpty();
    }

    // cek apakah ada supir rentcar tersedia
    public boolean adaSupirRentCarTersedia() {
        return !getSupirRentCarTersedia().isEmpty();
    }
}
