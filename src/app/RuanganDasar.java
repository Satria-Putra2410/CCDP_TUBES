package app;

public class RuanganDasar implements Ruangan {
    private final String jenis;
    private final KebijakanPenggunaan kebijakan;
    private final KomponenFasilitas fasilitas;
    private final double tarifDasarPerJam;

    public RuanganDasar(String jenis, KebijakanPenggunaan kebijakan, KomponenFasilitas fasilitas, double tarifDasarPerJam) {
        this.jenis = jenis;
        this.kebijakan = kebijakan;
        this.fasilitas = fasilitas;
        this.tarifDasarPerJam = tarifDasarPerJam;
    }

    private RuanganDasar(RuanganDasar lain) {
        this.jenis = lain.jenis;
        this.kebijakan = lain.kebijakan;
        this.fasilitas = lain.fasilitas;
        this.tarifDasarPerJam = lain.tarifDasarPerJam;
    }

    @Override
    public String getJenis() {
        return jenis;
    }

    @Override
    public KebijakanPenggunaan getKebijakan() {
        return kebijakan;
    }

    @Override
    public KomponenFasilitas getFasilitas() {
        return fasilitas;
    }

    @Override
    public double getTarifDasarPerJam() {
        return tarifDasarPerJam;
    }

    @Override
    public Ruangan salin() {
        return new RuanganDasar(this);
    }
}
