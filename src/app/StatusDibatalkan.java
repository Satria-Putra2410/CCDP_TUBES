package app;

public class StatusDibatalkan implements StatusReservasi {
    @Override
    public String getNama() {
        return "Dibatalkan";
    }

    @Override
    public void setujui(Reservasi reservasi) {
        throw new IllegalStateException("Reservasi dibatalkan");
    }

    @Override
    public void mulai(Reservasi reservasi) {
        throw new IllegalStateException("Reservasi dibatalkan");
    }

    @Override
    public void selesai(Reservasi reservasi) {
        throw new IllegalStateException("Reservasi dibatalkan");
    }

    @Override
    public void batalkan(Reservasi reservasi) {
        throw new IllegalStateException("Sudah dibatalkan");
    }
}
