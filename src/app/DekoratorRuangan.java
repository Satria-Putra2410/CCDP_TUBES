package app;

public class DekoratorRuangan implements Ruangan {
    private final Ruangan dibungkus;
    private final KomponenFasilitas fasilitasTambahan;

    public DekoratorRuangan(Ruangan dibungkus, KomponenFasilitas fasilitasTambahan) {
        this.dibungkus = dibungkus;
        this.fasilitasTambahan = fasilitasTambahan;
    }

    @Override
    public String getJenis() {
        return dibungkus.getJenis();
    }

    @Override
    public KebijakanPenggunaan getKebijakan() {
        return dibungkus.getKebijakan();
    }

    @Override
    public KomponenFasilitas getFasilitas() {
        PaketFasilitas paket = new PaketFasilitas("Fasilitas");
        paket.tambah(dibungkus.getFasilitas());
        paket.tambah(fasilitasTambahan);
        return paket;
    }

    @Override
    public double getTarifDasarPerJam() {
        return dibungkus.getTarifDasarPerJam();
    }

    @Override
    public Ruangan salin() {
        return new DekoratorRuangan(dibungkus.salin(), fasilitasTambahan);
    }
}
