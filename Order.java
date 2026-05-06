import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    public int id;
    public String tanggal;
    public double total;
    private List<Barang> transaksi; // fix: Order<barang> → List<Barang>
    private Kasir kasir;

    public Order(String tanggal, Kasir kasir) {
        this.id = counter++;
        this.tanggal = tanggal; // fix: sebelumnya this.tambahbarang (field tidak ada)
        this.total = 0.0;
        this.transaksi = new ArrayList<>();
        this.kasir = kasir;
    }

    public void tambahItem(Barang barang) {
        this.transaksi.add(barang);
    }

    public double hitungTotal() {
        this.total = 0.0;
        for (Barang b : this.transaksi) {
            this.total += b.getHarga();
        }
        return this.total;
    }

    public void cetakOrder() {
        System.out.println("========== STRUK ORDER ==========");
        System.out.println("Order ID  : " + this.id);
        System.out.println("Tanggal   : " + this.tanggal);
        System.out.println("Kasir     : " + this.kasir.getNama());
        System.out.println("---------------------------------");
        System.out.println("Item yang dipesan:");
        for (Barang b : this.transaksi) {
            System.out.printf("  - %-20s Rp%.0f%n", b.getNama(), b.getHarga());
        }
        System.out.println("=================================");
        System.out.printf("Total     : Rp%.0f%n", this.hitungTotal());
    }

    public int getId() {
        return this.id;
    }

    public double getTotal() {
        return this.total;
    }

    public List<Barang> getItems() {
        return this.transaksi;
    }

    public Kasir getKasir() {
        return this.kasir;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }
}
