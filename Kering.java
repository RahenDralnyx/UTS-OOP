public class Kering extends Barang {
    private Boolean hancur;

    // fix: nama constructor harus sama dengan nama class (Kering, bukan kering)
    public Kering(String nama, Double harga, Boolean hancur) {
        super(nama, harga);
        this.hancur = hancur;
    }

    public Boolean getHancur() {
        return this.hancur;
    }

    public void setHancur(Boolean hancur) {
        this.hancur = hancur;
    }
}
