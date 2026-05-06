import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static final String[][] MENU_KERING;
    static final String[][] MENU_BASAH;

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   SISTEM KASIR PEMESANAN       ");
        System.out.println("=================================");
        System.out.println("\n--- DATA KASIR ---");
        System.out.print("Nama Kasir : ");
        String namaKasir = scanner.nextLine();

        // fix: sebelumnya new Customer(var1, var2) — class Customer tidak ada di UML
        // Sesuai UML, yang ada adalah class Kasir dengan 1 parameter (nama)
        Kasir kasir = new Kasir(namaKasir);
        System.out.println(">> Kasir ID : " + kasir.getId());

        String tanggal = LocalDate.now().toString();
        Order order = kasir.buatOrder(tanggal);
        System.out.println(">> Order ID : " + order.getId());

        boolean lanjut = true;
        while (lanjut) {
            tampilkanMenu();
            System.out.print("\nPilih nomor menu (0 = selesai): ");
            int pilihan = Integer.parseInt(scanner.nextLine().trim());

            if (pilihan == 0) {
                if (order.getItems().isEmpty()) {
                    System.out.println("!! Belum ada item yang dipilih!");
                } else {
                    lanjut = false;
                }
            } else {
                // fix: sebelumnya pakai MenuItem/cariMenu yang return Food/Drink
                // Sekarang menggunakan Barang, Kering, Basah sesuai UML
                Barang item = cariMenu(pilihan);
                if (item == null) {
                    System.out.println("!! Menu tidak ditemukan.");
                } else {
                    System.out.print("   Jumlah: ");
                    int jumlah = Integer.parseInt(scanner.nextLine().trim());
                    for (int i = 0; i < jumlah; i++) {
                        order.tambahItem(item);
                    }
                    System.out.println(">> " + item.getNama() + " x" + jumlah + " ditambahkan.");
                }
            }
        }

        System.out.println();
        order.cetakOrder();
        scanner.close();
    }

    static void tampilkanMenu() {
        System.out.println("\n========== DAFTAR MENU ==========");
        System.out.println("--- Barang Kering ---");
        for (String[] item : MENU_KERING) {
            System.out.printf("  [%s] %-20s Rp%s%n", item[0], item[1], formatHarga(item[2]));
        }
        System.out.println("--- Barang Basah ---");
        for (String[] item : MENU_BASAH) {
            String status = item[3].equals("true") ? "(dingin)" : "(hangat)";
            System.out.printf("  [%s] %-20s Rp%s %s%n", item[0], item[1], formatHarga(item[2]), status);
        }
        System.out.println("=================================");
    }

    static String formatHarga(String harga) {
        int nilai = Integer.parseInt(harga);
        return String.format("%,d", nilai).replace(',', '.');
    }

    static Barang cariMenu(int nomor) {
        for (String[] item : MENU_KERING) {
            if (Integer.parseInt(item[0]) == nomor) {
                // fix: sebelumnya new Food(...) — ganti dengan new Kering(...)
                return new Kering(item[1], Double.parseDouble(item[2]), false);
            }
        }
        for (String[] item : MENU_BASAH) {
            if (Integer.parseInt(item[0]) == nomor) {
                // fix: sebelumnya new Drink(...) — ganti dengan new Basah(...)
                return new Basah(item[1], Double.parseDouble(item[2]), Boolean.parseBoolean(item[3]));
            }
        }
        return null;
    }

    static {
        scanner = new Scanner(System.in);
        // fix: MENU_KERING hanya 3 kolom (id, nama, harga) — kolom ke-4 dihapus karena
        // Kering hanya punya field hancur:Boolean, bukan kategori String
        MENU_KERING = new String[][]{
            {"1", "Citato",       "25000"},
            {"2", "Lays",         "30000"},
            {"3", "Popcorn",      "50000"}
        };
        MENU_BASAH = new String[][]{
            {"4", "Teh Kotak",    "8000",  "true"},
            {"5", "Teh Botol",    "15000", "true"},
            {"6", "Teh Guci",     "5000",  "false"}
        };
    }
}
