package app;

public class StrategiHargaPaket implements StrategiHarga {
    private final int jamPaket;
    private final double tarifPaket;

    public StrategiHargaPaket(int jamPaket, double tarifPaket) {
        this.jamPaket = jamPaket;
        this.tarifPaket = tarifPaket;
    }

    @Override
    public double hitung(Reservasi reservasi) {
        double biayaRuangan = (reservasi.getDurasiJam() <= jamPaket)
                ? tarifPaket
                : tarifPaket + (reservasi.getDurasiJam() - jamPaket) * reservasi.getRuangan().getTarifDasarPerJam();
        double biayaFasilitas = reservasi.getFasilitas().getBiaya();
        return biayaRuangan + biayaFasilitas;
    }
}
