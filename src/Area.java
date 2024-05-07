import java.util.List;

public class Area {
    int id_area;
    String nombre_area;
    int idDepartamento;

    // Constructor
    public Area(int id_area, String nombre_area, int idDepartamento) {
        this.id_area = id_area;
        this.nombre_area = nombre_area;
        this.idDepartamento = idDepartamento;
    }

    public int getId_area() {
        return id_area;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    // Método para registrar un área
    public void registrarArea(List<Area> listaAreas, Area area) {
        listaAreas.add(area);
        System.out.println("Área registrada correctamente.");
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    // Método para consultar un área por su ID
    public void consultarAreaPorId(List<Area> listaAreas, int id_area) {
        for (Area a : listaAreas) {
            if (a.id_area == id_area) {
                System.out.println("ID: " + a.id_area);
                System.out.println("Nombre: " + a.nombre_area);
                System.out.println("ID Departamento: " + a.idDepartamento);
                return;
            }
        }
        System.out.println("No se encontró ningún área con el ID proporcionado.");
    }
}
