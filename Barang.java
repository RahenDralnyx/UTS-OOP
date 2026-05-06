public class Barang {
    private static int counter = 1;
    protected int id;
    protected String nama;
    protected Double harga;

    public Barang(String nama, Double harga) {
        this.id = counter++;
        this.nama = nama;
        this.harga = harga; // fix: sebelumnya di-comment
    }

    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public Double getHarga() {
        return this.harga; // fix: sebelumnya di-comment
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
}
