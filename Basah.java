public class Basah extends Barang {
    private Boolean frozen;

    // fix: nama constructor harus sama dengan nama class (Basah, bukan basah)
    public Basah(String nama, Double harga, Boolean frozen) {
        super(nama, harga);
        this.frozen = frozen;
    }

    public Boolean getFrozen() {
        return this.frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
