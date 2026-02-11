package app;

public class StatusDiminta implements StatusReservasi {
    @Override
    public String getNama() {
        return "Diminta";
    }

    @Override
    public void setujui(Reservasi reservasi) {
        reservasi.setStatus(new StatusDisetujui());
    }

    @Override
    public void mulai(Reservasi reservasi) {
        throw new IllegalStateException("Tidak bisa mulai sebelum disetujui");
    }

    @Override
    public void selesai(Reservasi reservasi) {
        throw new IllegalStateException("Tidak bisa selesai sebelum mulai");
    }

    @Override
    public void batalkan(Reservasi reservasi) {
        reservasi.setStatus(new StatusDibatalkan());
    }
}
