package app;

public class StrategiHargaEvent implements StrategiHarga {
    private final double diskon;

    public StrategiHargaEvent(double diskon) {
        this.diskon = diskon;
    }

    @Override
    public double hitung(Reservasi reservasi) {
        double biayaRuangan = reservasi.getRuangan().getTarifDasarPerJam() * reservasi.getDurasiJam();
        double biayaFasilitas = reservasi.getFasilitas().getBiaya();
        double total = biayaRuangan + biayaFasilitas;
        return total - (total * diskon);
    }
}
