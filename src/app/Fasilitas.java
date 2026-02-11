package app;

public class Fasilitas implements KomponenFasilitas {
    private final String deskripsi;
    private final double biaya;

    public Fasilitas(String deskripsi, double biaya) {
        this.deskripsi = deskripsi;
        this.biaya = biaya;
    }

    @Override
    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public double getBiaya() {
        return biaya;
    }
}
