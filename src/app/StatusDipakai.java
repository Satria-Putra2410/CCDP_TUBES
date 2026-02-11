package app;

public class StatusDipakai implements StatusReservasi {
    @Override
    public String getNama() {
        return "Dipakai";
    }

    @Override
    public void setujui(Reservasi reservasi) {
        throw new IllegalStateException("Sudah dipakai");
    }

    @Override
    public void mulai(Reservasi reservasi) {
        throw new IllegalStateException("Sudah mulai");
    }

    @Override
    public void selesai(Reservasi reservasi) {
        reservasi.setStatus(new StatusSelesai());
    }

    @Override
    public void batalkan(Reservasi reservasi) {
        reservasi.setStatus(new StatusDibatalkan());
    }
}
