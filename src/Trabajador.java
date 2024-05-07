import java.util.List;

public class Trabajador {
    int id_trabajador;
    String ruc;
    String nombre;
    String ap_paterno;
    String sexo;
    int telefono;
    double sueldo;
    String fecha_nacimiento;
    String direccion;
    String correo;
    String contraseña;
    int idArea;

    public Trabajador(int id_trabajador, String ruc, String nombre, String ap_paterno, String sexo, int telefono, double sueldo, String fecha_nacimiento, String direccion, String correo, String contraseña, int idArea) {
        this.id_trabajador = id_trabajador;
        this.ruc = ruc;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
        this.idArea = idArea;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    // Método para registrar un trabajador
    public void registrarTrabajador(List<Trabajador> listaTrabajadores, Trabajador trabajador) {
        listaTrabajadores.add(trabajador);
        System.out.println("Trabajador registrado correctamente.");
    }

    // Método para consultar un trabajador
    public void consultarTrabajador(List<Trabajador> listaTrabajadores, int id_trabajador) {
        for (Trabajador t : listaTrabajadores) {
            if (t.id_trabajador == id_trabajador) {
                System.out.println("ID: " + t.id_trabajador);
                System.out.println("RUC: " + t.ruc);
                System.out.println("Nombre: " + t.nombre);
                System.out.println("Apellido Paterno: " + t.ap_paterno);
                System.out.println("Sexo: " + t.sexo);
                System.out.println("Teléfono: " + t.telefono);
                System.out.println("Fecha de nacimiento: " + t.fecha_nacimiento);
                System.out.println("Dirección: " + t.direccion);
                System.out.println("Correo: " + t.correo);
                System.out.println("ID Área: " + t.idArea);
                return;
            }
        }
        System.out.println("No se encontró ningún trabajador con el ID proporcionado.");
    }

    // Método para actualizar un trabajador
    public void actualizarTrabajador(List<Trabajador> listaTrabajadores, int id_trabajador, Trabajador trabajadorActualizado) {
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i).id_trabajador == id_trabajador) {
                listaTrabajadores.set(i, trabajadorActualizado);
                System.out.println("Trabajador actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún trabajador con el ID proporcionado.");
    }

    // Método para dar de baja a un trabajador
    public void darBajaTrabajador(List<Trabajador> listaTrabajadores, int id_trabajador) {
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if (listaTrabajadores.get(i).id_trabajador == id_trabajador) {
                listaTrabajadores.remove(i);
                System.out.println("Trabajador dado de baja correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún trabajador con el ID proporcionado.");
    }

    // Método para autenticar un trabajador por correo y contraseña
    public boolean autenticarTrabajador(List<Trabajador> listaTrabajadores, String correo, String contraseña) {
        for (Trabajador t : listaTrabajadores) {
            if (t.correo.equals(correo) && t.contraseña.equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public void descontarSueldo(double monto) {
        this.sueldo -= monto;
        System.out.println("Se ha descontado S/" + monto + " del sueldo del trabajador.");
    }
}