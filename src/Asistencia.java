import java.time.LocalDateTime;

public class Asistencia {
    private int idAsistencia;
    private String correoUsuario;
    private LocalDateTime fechaInicioSesion;
    private LocalDateTime fechaCierreSesion;

    public Asistencia(int idAsistencia, String correoUsuario, LocalDateTime fechaInicioSesion) {
        this.idAsistencia = idAsistencia;
        this.correoUsuario = correoUsuario;
        this.fechaInicioSesion = fechaInicioSesion;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public LocalDateTime getFechaInicioSesion() {
        return fechaInicioSesion;
    }

    public LocalDateTime getFechaCierreSesion() {
        return fechaCierreSesion;
    }

    public void cerrarSesion(LocalDateTime fechaCierreSesion) {
        this.fechaCierreSesion = fechaCierreSesion;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "idAsistencia=" + idAsistencia +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", fechaInicioSesion=" + fechaInicioSesion +
                ", fechaCierreSesion=" + fechaCierreSesion +
                '}';
    }
}
