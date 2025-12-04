package cmd.app;

import entity.Karyawan;
import entity.Mobil;
import entity.Transaksi;
import entity.TransaksiSewa;
import entity.TransaksiTravel;
import java.util.ArrayList;
import java.util.Scanner;
import service.karyawan_service;
import service.mobil_service;
import service.transaksi_service;

public class mainTravel {

    private static final mobil_service mobilService = new mobil_service();
    private static final karyawan_service karyawanService = new karyawan_service();
    private static final transaksi_service transaksiService = new transaksi_service();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== SISTEM FILKOM TOUR AND TRAVEL ===");
            System.out.println("1. Kelola Data Mobil");
            System.out.println("2. Kelola Data Karyawan");
            System.out.println("3. Kelola Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    menuMobil();
                    break;
                case 2:
                    menuKaryawan();
                    break;
                case 3:
                    menuTransaksi();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);

        input.close();
    }

    private static void menuMobil() {
        int pilihan;

        do {
            System.out.println("\n=== MENU MOBIL ===");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. Lihat Semua Mobil");
            System.out.println("3. Update Mobil");
            System.out.println("4. Hapus Mobil");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMobil();
                    break;
                case 2:
                    mobilService.tampilkanSemuaMobil();
                    break;
                case 3:
                    updateMobil();
                    break;
                case 4:
                    hapusMobil();
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahMobil() {
        System.out.println("\n--- Tambah Mobil ---");
        System.out.print("No. Plat      : ");
        String noPlat = input.nextLine();
        System.out.print("Merk Mobil    : ");
        String merkMobil = input.nextLine();
        System.out.print("Warna Mobil   : ");
        String warnaMobil = input.nextLine();
        System.out.print("Tahun Keluaran: ");
        int tahunKeluaran = input.nextInt();
        input.nextLine();

        Mobil mobil = new Mobil(noPlat, merkMobil, warnaMobil, tahunKeluaran);
        mobilService.tambahMobil(mobil);
    }

    private static void updateMobil() {
        System.out.println("\n--- Update Mobil ---");
        System.out.print("Masukkan no. plat mobil yang ingin diupdate: ");
        String noPlat = input.nextLine();

        System.out.print("No. Plat Baru      : ");
        String noPolatBaru = input.nextLine();
        System.out.print("Merk Mobil Baru    : ");
        String merkMobilBaru = input.nextLine();
        System.out.print("Warna Mobil Baru   : ");
        String warnaMobilBaru = input.nextLine();
        System.out.print("Tahun Keluaran Baru: ");
        int tahunKeluaranBaru = input.nextInt();
        input.nextLine();

        Mobil mobilBaru = new Mobil(noPolatBaru, merkMobilBaru, warnaMobilBaru, tahunKeluaranBaru);
        mobilService.replaceMobil(noPlat, mobilBaru);
    }

    private static void hapusMobil() {
        System.out.println("\n--- Hapus Mobil ---");
        System.out.print("Masukkan no. plat mobil yang ingin dihapus: ");
        String noPlat = input.nextLine();
        mobilService.hapusMobil(noPlat);
    }

    private static void menuKaryawan() {
        int pilihan;

        do {
            System.out.println("\n=== MENU KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Lihat Semua Karyawan");
            System.out.println("3. Update Karyawan");
            System.out.println("4. Hapus Karyawan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahKaryawan();
                    break;
                case 2:
                    karyawanService.tampilkanSemuaKaryawan();
                    break;
                case 3:
                    updateKaryawan();
                    break;
                case 4:
                    hapusKaryawan();
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
    }

    private static void tambahKaryawan() {
        System.out.println("\n--- Tambah Karyawan ---");
        System.out.print("Nama          : ");
        String nama = input.nextLine();
        System.out.print("Alamat        : ");
        String alamat = input.nextLine();
        System.out.print("No. Telp      : ");
        String noTelp = input.nextLine();
        System.out.print("Jenis Kelamin : ");
        String jenisKelamin = input.nextLine();

        System.out.println("Kategori Karyawan:");
        System.out.println("1. Supir Travel");
        System.out.println("2. Supir RentCar");
        System.out.println("3. Admin");
        System.out.print("Pilih (1-3)   : ");
        int kategori = input.nextInt();
        input.nextLine();

        String kategoriKaryawan = "";
        switch (kategori) {
            case 1:
                kategoriKaryawan = "Supir Travel";
                break;
            case 2:
                kategoriKaryawan = "Supir RentCar";
                break;
            case 3:
                kategoriKaryawan = "Admin";
                break;
            default:
                kategoriKaryawan = "Tidak Diketahui";
                break;
        }

        Karyawan karyawan = new Karyawan(nama, alamat, noTelp, jenisKelamin, kategoriKaryawan);
        karyawanService.tambahKaryawan(karyawan);
    }

    private static void updateKaryawan() {
        System.out.println("\n--- Update Karyawan ---");
        System.out.print("Masukkan nama karyawan yang ingin diupdate: ");
        String nama = input.nextLine();

        System.out.print("Nama Baru          : ");
        String namaBaru = input.nextLine();
        System.out.print("Alamat Baru        : ");
        String alamatBaru = input.nextLine();
        System.out.print("No. Telp Baru      : ");
        String noTelpBaru = input.nextLine();
        System.out.print("Jenis Kelamin Baru : ");
        String jenisKelaminBaru = input.nextLine();

        System.out.println("Kategori Karyawan:");
        System.out.println("1. Supir Travel");
        System.out.println("2. Supir RentCar");
        System.out.println("3. Admin");
        System.out.print("Pilih (1-3)        : ");
        int kategori = input.nextInt();
        input.nextLine();

        String kategoriKaryawanBaru = "";
        switch (kategori) {
            case 1:
                kategoriKaryawanBaru = "Supir Travel";
                break;
            case 2:
                kategoriKaryawanBaru = "Supir RentCar";
                break;
            case 3:
                kategoriKaryawanBaru = "Admin";
                break;
            default:
                kategoriKaryawanBaru = "Tidak Diketahui";
                break;
        }

        Karyawan karyawanBaru = new Karyawan(namaBaru, alamatBaru, noTelpBaru, jenisKelaminBaru, kategoriKaryawanBaru);
        karyawanService.replaceKaryawan(nama, karyawanBaru);
    }

    private static void hapusKaryawan() {
        System.out.println("\n--- Hapus Karyawan ---");
        System.out.print("Masukkan nama karyawan yang ingin dihapus: ");
        String nama = input.nextLine();
        karyawanService.deleteKaryawan(nama);
    }

    private static void menuTransaksi() {
        int pilihan;

        do {
            System.out.println("\n=== MENU TRANSAKSI ===");
            System.out.println("1. Pemesanan Travel dengan Supir");
            System.out.println("2. Pemesanan Sewa Mobil");
            System.out.println("3. Lihat Semua Transaksi");
            System.out.println("4. Update Status Transaksi");
            System.out.println("5. Hapus Transaksi");
            System.out.println("6. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-6): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    // Tamabahn validasi ketersediaan mobil dan supir
                    if (mobilService.getDaftarMobil().isEmpty()) {
                        System.out.println("\n✗ Tidak bisa melakukan transaksi!");
                        System.out.println("  Belum ada data mobil. Silakan tambahkan mobil terlebih dahulu.");
                        break;
                    }
                    if (karyawanService.getDaftarKaryawan().isEmpty()) {
                        System.out.println("\n✗ Tidak bisa melakukan transaksi!");
                        System.out.println("  Belum ada data karyawan. Silakan tambahkan supir terlebih dahulu.");
                        break;
                    }
                    if (!mobilService.adaMobilTersedia()) {
                        System.out.println("\n✗ Tidak ada mobil yang tersedia saat ini.");
                        System.out.println("  Semua mobil sedang digunakan.");
                        break;
                    }
                    if (!karyawanService.adaSupirTravelTersedia()) {
                        System.out.println("\n✗ Tidak ada supir travel yang tersedia saat ini.");
                        System.out.println("  Semua supir sedang bertugas atau belum ada supir travel.");
                        break;
                    }
                    tambahTransaksiTravel();
                    break;
                case 2:
                    // Tambah validasi ketersediaan mobil
                    if (mobilService.getDaftarMobil().isEmpty()) {
                        System.out.println("\n✗ Tidak bisa melakukan transaksi!");
                        System.out.println("  Belum ada data mobil. Silakan tambahkan mobil terlebih dahulu.");
                        break;
                    }
                    if (!mobilService.adaMobilTersedia()) {
                        System.out.println("\n✗ Tidak ada mobil yang tersedia saat ini.");
                        System.out.println("  Semua mobil sedang digunakan.");
                        break;
                    }
                    tambahTransaksiSewa();
                    break;
                case 3:
                    transaksiService.tampilkanSemuaTransaksi();
                    break;
                case 4:
                    updateStatusTransaksi();
                    break;
                case 5:
                    hapusTransaksi();
                    break;
                case 6:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    private static void tambahTransaksiTravel() {
        System.out.println("\n--- Pemesanan Travel dengan Supir ---");

        System.out.print("ID Transaksi      : ");
        String idTransaksi = input.nextLine();
        System.out.print("Nama Pelanggan    : ");
        String namaPelanggan = input.nextLine();
        System.out.print("No. Telp          : ");
        String noTelp = input.nextLine();
        System.out.print("Tujuan            : ");
        String tujuan = input.nextLine();

        // menampilkan mobil yng tesedia
        ArrayList<Mobil> mobilTersedia = mobilService.getMobilTersedia();
        System.out.println("\nMobil Tersedia:");
        for (int i = 0; i < mobilTersedia.size(); i++) {
            System.out.println((i + 1) + ". " + mobilTersedia.get(i).getMerkMobil()
                    + " (No. Plat: " + mobilTersedia.get(i).getNoPlat() + ")");
        }

        System.out.print("\n Pilih mobil (1-" + mobilTersedia.size() + "): ");
        int pilihanMobil = input.nextInt();
        input.nextLine();

        // Seleksi pilihan
        if (pilihanMobil < 1 || pilihanMobil > mobilTersedia.size()) {
            System.out.println("Pilihan mobil tidak valid!");
            return;
        }

        Mobil mobilDipilih = mobilTersedia.get(pilihanMobil - 1);

        // menampilkan supir yang tersedia
        ArrayList<Karyawan> supirTersedia = karyawanService.getSupirTravelTersedia();
        System.out.println("\nSupir Travel Tersedia:");
        for (int i = 0; i < supirTersedia.size(); i++) {
            System.out.println((i + 1) + ". " + supirTersedia.get(i).getNama());
        }

        System.out.print("Pilih supir (1-" + supirTersedia.size() + "): ");
        int pilihanSupir = input.nextInt();
        input.nextLine();

        // Seleksi pilihan
        if (pilihanSupir < 1 || pilihanSupir > supirTersedia.size()) {
            System.out.println("Pilihan supir tidak valid!");
            return;
        }

        Karyawan supirDipilih = supirTersedia.get(pilihanSupir - 1);

        System.out.print("Harga per Km      : ");
        double hargaPerKm = input.nextDouble();
        System.out.print("Jarak (km)        : ");
        double jarakKm = input.nextDouble();
        input.nextLine();

        // Set mobil dan supir menjadi tidak tersedia
        mobilDipilih.setTersedia(false);
        supirDipilih.setTersedia(false);

        TransaksiTravel transaksi = new TransaksiTravel(
                idTransaksi, namaPelanggan, noTelp, "Pending", tujuan,
                supirDipilih.getNama(), mobilDipilih.getMerkMobil(),
                mobilDipilih.getNoPlat(), hargaPerKm, jarakKm
        );

        transaksiService.tambahTransaksi(transaksi);

        System.out.println("\n✓ Transaksi berhasil dibuat!");
        System.out.println("  Mobil " + mobilDipilih.getMerkMobil() + " dan supir "
                + supirDipilih.getNama() + " sekarang sedang digunakan.");

    }

    private static void tambahTransaksiSewa() {
        System.out.println("\n--- Pemesanan Sewa Mobil ---");

        System.out.print("ID Transaksi      : ");
        String idTransaksi = input.nextLine();
        System.out.print("Nama Pelanggan    : ");
        String namaPelanggan = input.nextLine();
        System.out.print("No. Telp          : ");
        String noTelp = input.nextLine();

        // menampilka mobil yang tersedia
        ArrayList<Mobil> mobilTersedia = mobilService.getMobilTersedia();
        System.out.println("\n=== MOBIL YANG TERSEDIA ===");
        for (int i = 0; i < mobilTersedia.size(); i++) {
            System.out.println((i + 1) + ". " + mobilTersedia.get(i).getMerkMobil()
                    + " (" + mobilTersedia.get(i).getNoPlat() + ")");
        }

        // input
        System.out.print("\nPilih mobil (1-" + mobilTersedia.size() + "): ");
        int pilihanMobil = input.nextInt();
        input.nextLine();

        // Seleksi pilihan
        if (pilihanMobil < 1 || pilihanMobil > mobilTersedia.size()) {
            System.out.println("✗ Pilihan tidak valid!");
            return;
        }

        Mobil mobilDipilih = mobilTersedia.get(pilihanMobil - 1);

        System.out.print("Lama Sewa (hari)  : ");
        int lamaSewa = input.nextInt();
        System.out.print("Harga per Hari    : ");
        double hargaPerHari = input.nextDouble();
        input.nextLine();

        System.out.print("Dengan Supir? (y/n): ");
        String pilihan = input.nextLine();
        boolean denganSupir = pilihan.equalsIgnoreCase("y");

        String namaSupir = "";
        Karyawan supirDipilih = null;

        // Seleksi jika dengan supir
        if (denganSupir) {
            // Cek apakah ada supir rentcar tersedia
            if (!karyawanService.adaSupirRentCarTersedia()) {
                System.out.println("\n✗ Tidak ada supir rentcar yang tersedia!");
                System.out.println("  Transaksi dibatalkan.");
                return;
            }

            // Tampilkan supir rentcar yang tersedia
            ArrayList<Karyawan> supirTersedia = karyawanService.getSupirRentCarTersedia();
            System.out.println("\n=== SUPIR RENTCAR YANG TERSEDIA ===");
            for (int i = 0; i < supirTersedia.size(); i++) {
                System.out.println((i + 1) + ". " + supirTersedia.get(i).getNama());
            }

            System.out.print("\nPilih supir (1-" + supirTersedia.size() + "): ");
            int pilihanSupir = input.nextInt();
            input.nextLine();

            if (pilihanSupir < 1 || pilihanSupir > supirTersedia.size()) {
                System.out.println("✗ Pilihan tidak valid!");
                return;
            }

            supirDipilih = supirTersedia.get(pilihanSupir - 1);
            namaSupir = supirDipilih.getNama();

            // Set supir menjadi tidak tersedia
            supirDipilih.setTersedia(false);
        }

        // Set mobil menjadi tidak tersedia
        mobilDipilih.setTersedia(false);

        TransaksiSewa transaksi = new TransaksiSewa(
                idTransaksi, namaPelanggan, noTelp, "Pending", mobilDipilih.getMerkMobil(),
                mobilDipilih.getNoPlat(), lamaSewa, hargaPerHari, denganSupir, namaSupir
        );
        transaksiService.tambahTransaksi(transaksi);

        System.out.println("\n✓ Transaksi berhasil dibuat!");
        System.out.println("  Mobil " + mobilDipilih.getMerkMobil() + " sekarang sedang digunakan.");
        if (denganSupir) {
            System.out.println("  Supir " + namaSupir + " sekarang sedang bertugas.");
        }
    }

    private static void updateStatusTransaksi() {
        System.out.println("\n--- Update Status Transaksi ---");
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = input.nextLine();

        // Cari transaksi
        Transaksi transaksi = transaksiService.cariTransaksi(idTransaksi);
        if (transaksi == null) {
            System.out.println("✗ Transaksi tidak ditemukan!");
            return;
        }

        System.out.println("\nPilih Status Baru:");
        System.out.println("1. Pending");
        System.out.println("2. Selesai");
        System.out.println("3. Dibatalkan");
        System.out.print("Pilih (1-3): ");
        int pilihan = input.nextInt();
        input.nextLine();

        String status = "";
        switch (pilihan) {
            case 1:
                status = "Pending";
                break;
            case 2:
                status = "Selesai";
                break;
            case 3:
                status = "Dibatalkan";
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        // Jika status berubah menjadi selesai atau dibatalkan, kembalikan mobil dan supir
        if (status.equalsIgnoreCase("Selesai") || status.equalsIgnoreCase("Dibatalkan")) {
            if (transaksi instanceof TransaksiTravel) {
                TransaksiTravel transaksiTravel = (TransaksiTravel) transaksi;
                // Kembalikan mobil
                Mobil mobil = mobilService.cariMobilByPlat(transaksiTravel.getNoPlatMobil());
                if (mobil != null) {
                    mobil.setTersedia(true);
                    System.out.println("Mobil " + mobil.getMerkMobil() + " kembali tersedia.");
                }

                // Kembalikan supir
                Karyawan supir = karyawanService.cariKaryawanByNama(transaksiTravel.getNamaSupir());
                if (supir != null) {
                    supir.setTersedia(true);
                    System.out.println("Supir " + supir.getNama() + " kembali tersedia.");
                }

            } else if (transaksi instanceof TransaksiSewa) {
                TransaksiSewa transaksiSewa = (TransaksiSewa) transaksi;

                // Kembalikan mobil
                Mobil mobil = mobilService.cariMobilByPlat(transaksiSewa.getNoPlatMobil());
                if (mobil != null) {
                    mobil.setTersedia(true);
                    System.out.println("Mobil " + mobil.getMerkMobil() + " kembali tersedia.");
                }

                // Kembalikan supir jika ada
                if (transaksiSewa.isDenganSupir()) {
                    Karyawan supir = karyawanService.cariKaryawanByNama(transaksiSewa.getNamaSupir());
                    if (supir != null) {
                        supir.setTersedia(true);
                        System.out.println("  → Supir " + supir.getNama() + " kembali tersedia.");
                    }
                }
            }
        }

        transaksiService.updateStatusTransaksi(idTransaksi, status);
    }

    private static void hapusTransaksi() {
        System.out.println("\n--- Hapus Transaksi ---");
        System.out.print("Masukkan ID Transaksi yang ingin dihapus: ");
        String idTransaksi = input.nextLine();
        transaksiService.hapusTransaksi(idTransaksi);
    }
}
