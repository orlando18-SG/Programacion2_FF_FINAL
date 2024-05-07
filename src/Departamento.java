import java.util.List;

public class Departamento {
    int id_departamento;
    String nombre_departamento;

    // Constructor
    public Departamento(int id_departamento, String nombre_departamento) {
        this.id_departamento = id_departamento;
        this.nombre_departamento = nombre_departamento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    // Método para registrar un departamento
    public void registrarDepartamento(List<Departamento> listaDepartamentos, Departamento departamento) {
        listaDepartamentos.add(departamento);
        System.out.println("Departamento registrado correctamente.");
    }

    // Método para consultar un departamento por su ID
    public void consultarDepartamento(List<Departamento> listaDepartamentos, int id_departamento) {
        for (Departamento d : listaDepartamentos) {
            if (d.id_departamento == id_departamento) {
                System.out.println("ID: " + d.id_departamento);
                System.out.println("Nombre: " + d.nombre_departamento);
                return;
            }
        }
        System.out.println("No se encontró ningún departamento con el ID proporcionado.");
    }
}