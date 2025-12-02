package service;

import entity.Mobil;
import java.util.ArrayList;

public class mobil_service {

    private final ArrayList<Mobil> daftarMobil = new ArrayList<>();

    // Create - menambahkan mobil baru
    public void tambahMobil(Mobil mobil) {
        daftarMobil.add(mobil);
        System.out.println("Mobil berhasil ditambahkan.");
    }

    // Read - menampilkan semua mobil
    public void tampilkanSemuaMobil() {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada data mobil");
            return;
        } else {
            System.out.println("\n== Daftar mobil Filkom Tour and Travel ==");
            for (int i = 0; i < daftarMobil.size(); i++) {
                System.out.println("Mobil ke-" + (i + 1));
                daftarMobil.get(i).tampilkanData();
            }
        }
    }

    // Update - memperbarui data mobil berdasarkan noPlat
    public void replaceMobil(String noPlat, Mobil mobilBaru) {
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getNoPlat().equals(noPlat)) {
                daftarMobil.set(i, mobilBaru);
                System.out.println("Data mobil berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Mobil dengan No. Plat " + noPlat + " tidak ditemukan.");
    }

    // Delete - menghapus mobil berdasarkan noPlat
    public void hapusMobil(String noPlat) {
        for (int i = 0; i < daftarMobil.size(); i++) {
            if (daftarMobil.get(i).getNoPlat().equals(noPlat)) {
                daftarMobil.remove(i);
                System.out.println("Mobil dengan No. Plat " + noPlat + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mobil dengan No. Plat " + noPlat + " tidak ditemukan.");
    }

    public ArrayList<Mobil> getDaftarMobil() {
        return daftarMobil;
    }

}
