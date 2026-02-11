package app;

public interface Ruangan {
    String getJenis();
    KebijakanPenggunaan getKebijakan();
    KomponenFasilitas getFasilitas();
    double getTarifDasarPerJam();
    Ruangan salin();
}
