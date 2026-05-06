import java.util.ArrayList;
import java.util.List;

// fix: constructor dan semua method harus di DALAM kurung kurawal class
public class Kasir {
    private static int counter = 1;
    private int id;
    private String nama;
    private List<Order> order; // fix: list<order> → List<Order>

    public Kasir(String nama) { // fix: nama constructor (Kasir), hapus koma ekstra
        this.id = counter++;
        this.nama = nama;
        this.order = new ArrayList<>();
    }

    public Order buatOrder(String tanggal) {
        Order o = new Order(tanggal, this);
        this.order.add(o);
        return o;
    }

    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public List<Order> getOrder() {
        return this.order;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
