package app;

public class StrategiHargaPerJam implements StrategiHarga {
    @Override
    public double hitung(Reservasi reservasi) {
        double biayaRuangan = reservasi.getRuangan().getTarifDasarPerJam() * reservasi.getDurasiJam();
        double biayaFasilitas = reservasi.getFasilitas().getBiaya();
        return biayaRuangan + biayaFasilitas;
    }
}
