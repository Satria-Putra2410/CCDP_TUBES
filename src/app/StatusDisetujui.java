package app;

public class StatusDisetujui implements StatusReservasi {
    @Override
    public String getNama() {
        return "Disetujui";
    }

    @Override
    public void setujui(Reservasi reservasi) {
        throw new IllegalStateException("Sudah disetujui");
    }

    @Override
    public void mulai(Reservasi reservasi) {
        reservasi.setStatus(new StatusDipakai());
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
