package app;

public class Reservasi {
    private final String id;
    private final String namaMahasiswa;
    private final Ruangan ruangan;
    private final int durasiJam;
    private final KomponenFasilitas fasilitas;
    private final StrategiHarga strategiHarga;
    private final String catatan;
    private StatusReservasi status;

    private Reservasi(Builder builder) {
        this.id = builder.id;
        this.namaMahasiswa = builder.namaMahasiswa;
        this.ruangan = builder.ruangan;
        this.durasiJam = builder.durasiJam;
        this.fasilitas = builder.fasilitas;
        this.strategiHarga = builder.strategiHarga;
        this.catatan = builder.catatan;
        this.status = new StatusDiminta();
    }

    public String getId() {
        return id;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public Ruangan getRuangan() {
        return ruangan;
    }

    public int getDurasiJam() {
        return durasiJam;
    }

    public KomponenFasilitas getFasilitas() {
        return fasilitas;
    }

    public StrategiHarga getStrategiHarga() {
        return strategiHarga;
    }

    public String getCatatan() {
        return catatan;
    }

    public String getStatus() {
        return status.getNama();
    }

    void setStatus(StatusReservasi status) {
        this.status = status;
    }

    public void setujui() {
        status.setujui(this);
    }

    public void mulai() {
        status.mulai(this);
    }

    public void selesai() {
        status.selesai(this);
    }

    public void batalkan() {
        status.batalkan(this);
    }

    public double hitungTotalBiaya() {
        return strategiHarga.hitung(this);
    }

    public static class Builder {
        private String id;
        private String namaMahasiswa;
        private Ruangan ruangan;
        private int durasiJam;
        private KomponenFasilitas fasilitas;
        private StrategiHarga strategiHarga = new StrategiHargaPerJam();
        private String catatan = "";

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder namaMahasiswa(String namaMahasiswa) {
            this.namaMahasiswa = namaMahasiswa;
            return this;
        }

        public Builder ruangan(Ruangan ruangan) {
            this.ruangan = ruangan;
            return this;
        }

        public Builder durasiJam(int durasiJam) {
            this.durasiJam = durasiJam;
            return this;
        }

        public Builder fasilitas(KomponenFasilitas fasilitas) {
            this.fasilitas = fasilitas;
            return this;
        }

        public Builder strategiHarga(StrategiHarga strategiHarga) {
            this.strategiHarga = strategiHarga;
            return this;
        }

        public Builder catatan(String catatan) {
            this.catatan = catatan;
            return this;
        }

        public Reservasi bangun() {
            if (ruangan == null) {
                throw new IllegalStateException("Ruangan wajib diisi");
            }
            if (durasiJam <= 0) {
                throw new IllegalStateException("Durasi harus positif");
            }
            if (!ruangan.getKebijakan().bolehReservasi(durasiJam)) {
                throw new IllegalStateException("Durasi melanggar aturan ruangan");
            }
            if (fasilitas == null) {
                fasilitas = ruangan.getFasilitas();
            }
            return new Reservasi(this);
        }
    }
}
