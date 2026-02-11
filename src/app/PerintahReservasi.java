package app;

public class PerintahReservasi implements Perintah {
    private final LayananReservasi layanan;
    private final Reservasi reservasi;
    private boolean sudahEksekusi;

    public PerintahReservasi(LayananReservasi layanan, Reservasi reservasi) {
        this.layanan = layanan;
        this.reservasi = reservasi;
    }

    @Override
    public void eksekusi() {
        layanan.tambahReservasi(reservasi);
        sudahEksekusi = true;
    }

    @Override
    public void batal() {
        if (sudahEksekusi) {
            layanan.batalkanReservasi(reservasi.getId());
        }
    }
}
