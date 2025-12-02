package cmd.app;

import entity.Karyawan;
import entity.Mobil;
import java.util.Scanner;
import service.karyawan_service;
import service.mobil_service;

public class mainTravel {

    private static final mobil_service mobilService = new mobil_service();
    private static final karyawan_service karyawanService = new karyawan_service();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== SISTEM FILKOM TOUR AND TRAVEL ===");
            System.out.println("1. Kelola Data Mobil");
            System.out.println("2. Kelola Data Karyawan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
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
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);

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
}
