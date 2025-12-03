package cmd.app;

import entity.Karyawan;
import entity.Mobil;
import entity.TransaksiSewa;
import entity.TransaksiTravel;
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
                    tambahTransaksiTravel();
                    break;
                case 2:
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
        System.out.print("Nama Supir        : ");
        String namaSupir = input.nextLine();
        System.out.print("Merk Mobil        : ");
        String merkMobil = input.nextLine();
        System.out.print("No. Plat Mobil    : ");
        String noPlat = input.nextLine();
        System.out.print("Harga per Km      : ");
        double hargaPerKm = input.nextDouble();
        System.out.print("Jarak (km)        : ");
        double jarakKm = input.nextDouble();
        input.nextLine();

        TransaksiTravel transaksi = new TransaksiTravel(
                idTransaksi, namaPelanggan, noTelp, "Pending", tujuan,
                namaSupir, merkMobil, noPlat, hargaPerKm, jarakKm
        );
        transaksiService.tambahTransaksi(transaksi);
    }

    private static void tambahTransaksiSewa() {
        System.out.println("\n--- Pemesanan Sewa Mobil ---");

        System.out.print("ID Transaksi      : ");
        String idTransaksi = input.nextLine();
        System.out.print("Nama Pelanggan    : ");
        String namaPelanggan = input.nextLine();
        System.out.print("No. Telp          : ");
        String noTelp = input.nextLine();
        System.out.print("Merk Mobil        : ");
        String merkMobil = input.nextLine();
        System.out.print("No. Plat Mobil    : ");
        String noPlat = input.nextLine();
        System.out.print("Lama Sewa (hari)  : ");
        int lamaSewa = input.nextInt();
        System.out.print("Harga per Hari    : ");
        double hargaPerHari = input.nextDouble();
        input.nextLine();

        System.out.print("Dengan Supir? (y/n): ");
        String pilihan = input.nextLine();
        boolean denganSupir = pilihan.equalsIgnoreCase("y");

        String namaSupir = "";
        if (denganSupir) {
            System.out.print("Nama Supir        : ");
            namaSupir = input.nextLine();
        }

        TransaksiSewa transaksi = new TransaksiSewa(
                idTransaksi, namaPelanggan, noTelp, "Pending", merkMobil,
                noPlat, lamaSewa, hargaPerHari, denganSupir, namaSupir
        );
        transaksiService.tambahTransaksi(transaksi);
    }

    private static void updateStatusTransaksi() {
        System.out.println("\n--- Update Status Transaksi ---");
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = input.nextLine();

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

        transaksiService.updateStatusTransaksi(idTransaksi, status);
    }

    private static void hapusTransaksi() {
        System.out.println("\n--- Hapus Transaksi ---");
        System.out.print("Masukkan ID Transaksi yang ingin dihapus: ");
        String idTransaksi = input.nextLine();
        transaksiService.hapusTransaksi(idTransaksi);
    }
}
