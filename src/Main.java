import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int idAsistencia = 1;
    private static List<Asistencia> asistencias = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Departamento> departamentos = new ArrayList<>();
        List<Area> areas = new ArrayList<>();
        List<Trabajador> trabajadores = new ArrayList<>();
        Trabajador usuarioActual = null;

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar Departamento");
            System.out.println("2. Registrar Área");
            System.out.println("3. Registrar Trabajador");
            System.out.println("4. Listar Departamentos");
            System.out.println("5. Listar Áreas");
            System.out.println("6. Listar Trabajadores");
            System.out.println("7. Iniciar Sesión");
            System.out.println("8. Listar Sesiones");
            System.out.println("9. Descontar sueldo trabajador");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = obtenerEntero(scanner, "Por favor, ingrese una opción valida: ");

            switch (opcion) {
                case 1:
                    registrarDepartamento(scanner, departamentos);
                    break;
                case 2:
                    registrarArea(scanner, areas, departamentos);
                    break;
                case 3:
                    registrarTrabajador(scanner, trabajadores, areas);
                    break;
                case 4:
                    listarDepartamentos(departamentos);
                    break;
                case 5:
                    listarAreas(areas);
                    break;
                case 6:
                    listarTrabajadores(trabajadores);
                    break;
                case 7:
                    usuarioActual = iniciarSesion(scanner, trabajadores);
                    if (usuarioActual != null) {
                        registrarAsistencia(usuarioActual);
                        menuTrabajador(scanner, usuarioActual, trabajadores);
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;
                case 8:
                    listarSesiones(asistencias);
                    break;
                case 9:
                    descontarSueldoTrabajador(scanner, trabajadores);
                    break;
                case 10:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
        scanner.close();
    }

    // Método para obtener un entero
    private static int obtenerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(mensaje);
                scanner.next(); // Consumir la entrada incorrecta del usuario
            }
        }
    }

    // Método para obtener un decimal
    private static double obtenerDecimal(Scanner scanner, String mensaje) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print(mensaje);
                scanner.next(); // Consumir la entrada incorrecta del usuario
            }
        }
    }

    // Método para registrar un departamento
    private static void registrarDepartamento(Scanner scanner, List<Departamento> departamentos) {
        System.out.print("Ingrese el ID del departamento: ");
        int id = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();
        Departamento departamento = new Departamento(id, nombre);
        departamentos.add(departamento);
        System.out.println("Departamento registrado correctamente.");
    }

    // Método para registrar un área
    private static void registrarArea(Scanner scanner, List<Area> areas, List<Departamento> departamentos) {
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados. Registre un departamento primero.");
            return;
        }
        System.out.print("Ingrese el ID del área: ");
        int id = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese el nombre del área: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del departamento al que pertenece: ");
        int idDepartamento = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Verificar si el departamento existe
        Departamento departamento = null;
        for (Departamento dep : departamentos) {
            if (dep.getId_departamento() == idDepartamento) {
                departamento = dep;
                break;
            }
        }
        if (departamento == null) {
            System.out.println("El departamento especificado no existe.");
            return;
        }

        Area area = new Area(id, nombre, idDepartamento);
        areas.add(area);
        System.out.println("Área registrada correctamente.");
    }

    // Método para registrar un trabajador
    private static void registrarTrabajador(Scanner scanner, List<Trabajador> trabajadores, List<Area> areas) {
        if (areas.isEmpty()) {
            System.out.println("No hay áreas registradas. Registre un área primero.");
            return;
        }
        System.out.print("Ingrese el ID del trabajador: ");
        int id = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese el RUC del trabajador: ");
        String ruc = scanner.nextLine();
        System.out.print("Ingrese el nombre del trabajador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido paterno del trabajador: ");
        String apPaterno = scanner.nextLine();
        System.out.print("Ingrese el sexo del trabajador: ");
        String sexo = scanner.nextLine();
        System.out.print("Ingrese el teléfono del trabajador: ");
        int telefono = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese la fecha de nacimiento del trabajador: ");
        String fechaNacimiento = scanner.nextLine();
        System.out.print("Ingrese la dirección del trabajador: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico del trabajador: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese la contraseña del trabajador: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese el sueldo del trabajador: ");
        double sueldo = obtenerDecimal(scanner, "Por favor, ingrese un número decimal válido: ");
        System.out.print("Ingrese el ID del área al que pertenece el trabajador: ");
        int idArea = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada

        // Verificar si el área existe
        Area area = null;
        for (Area a : areas) {
            if (a.getId_area() == idArea) {
                area = a;
                break;
            }
        }
        if (area == null) {
            System.out.println("El área especificada no existe.");
            return;
        }

        Trabajador trabajador = new Trabajador(id, ruc, nombre, apPaterno, sexo, telefono, sueldo, fechaNacimiento, direccion, correo, contraseña, idArea);
        trabajadores.add(trabajador);
        System.out.println("Trabajador registrado correctamente.");
    }

    // Método para iniciar sesión como trabajador
    private static Trabajador iniciarSesion(Scanner scanner, List<Trabajador> trabajadores) {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        for (Trabajador t : trabajadores) {
            if (t.getCorreo().equals(correo) && t.getContraseña().equals(contraseña)) {
                return t;
            }
        }
        return null;
    }

    // Menú para el trabajador autenticado
    private static void menuTrabajador(Scanner scanner, Trabajador trabajador, List<Trabajador> trabajadores) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Trabajador ---");
            System.out.println("1. Consultar mis datos");
            System.out.println("2. Actualizar mis datos");
            System.out.println("3. Dar de baja mi cuenta");
            System.out.println("4. Listar mis asistencias");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            int opcion = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    trabajador.consultarTrabajador(trabajadores, trabajador.getId_trabajador());
                    break;
                case 2:
                    actualizarDatosTrabajador(scanner, trabajador);
                    break;
                case 3:
                    trabajador.darBajaTrabajador(trabajadores, trabajador.getId_trabajador());
                    salir = true;
                    break;
                case 4:
                    listarAsistencias(trabajador);
                    break;
                case 5:
                    cerrarSesion(trabajador);
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void listarAsistencias(Trabajador trabajador) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("--- Asistencias del Trabajador ---");
        boolean encontrada = false;
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getCorreoUsuario().equals(trabajador.getCorreo())) {
                encontrada = true;
                String fechaInicio = asistencia.getFechaInicioSesion().format(formatter);
                String fechaCierre = asistencia.getFechaCierreSesion() != null ? asistencia.getFechaCierreSesion().format(formatter) : "Sesión aún abierta";
                System.out.println("ID Asistencia: " + asistencia.getIdAsistencia() +
                        ", Fecha Inicio: " + fechaInicio +
                        ", Fecha Cierre: " + fechaCierre);
            }
        }
        if (!encontrada) {
            System.out.println("No hay asistencias registradas para este trabajador.");
        }
    }

    private static void cerrarSesion(Trabajador trabajador) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getCorreoUsuario().equals(trabajador.getCorreo()) && asistencia.getFechaCierreSesion() == null) {
                asistencia.cerrarSesion(LocalDateTime.now());
                System.out.println("Sesión cerrada correctamente.");
                return;
            }
        }
    }

    // Método para actualizar datos del trabajador
    private static void actualizarDatosTrabajador(Scanner scanner, Trabajador trabajador) {
        System.out.print("Ingrese el nuevo teléfono: ");
        int telefono = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese la nueva dirección: ");
        String direccion = scanner.nextLine();
        trabajador.setTelefono(telefono);
        trabajador.setDireccion(direccion);
        System.out.println("Datos actualizados correctamente.");
    }

    private static void listarDepartamentos(List<Departamento> departamentos) {
        System.out.println("--- Departamentos Registrados ---");
        for (Departamento departamento : departamentos) {
            System.out.println("ID: " + departamento.getId_departamento() + ", Nombre: " + departamento.getNombre_departamento());
        }
    }

    // Método para listar áreas
    private static void listarAreas(List<Area> areas) {
        System.out.println("--- Áreas Registradas ---");
        for (Area area : areas) {
            System.out.println("ID: " + area.getId_area() + ", Nombre: " + area.getNombre_area() + ", ID Departamento: " + area.getIdDepartamento());
        }
    }

    // Método para listar trabajadores
    private static void listarTrabajadores(List<Trabajador> trabajadores) {
        System.out.println("--- Trabajadores Registrados ---");
        for (Trabajador trabajador : trabajadores) {
            System.out.println("ID: " + trabajador.getId_trabajador() + ", Nombre: " + trabajador.getNombre() + ", Apellido: " + trabajador.getAp_paterno() + ", Sueldo: " + trabajador.getSueldo());
        }
    }

    private static void registrarAsistencia(Trabajador trabajador) {
        asistencias.add(new Asistencia(idAsistencia++, trabajador.getCorreo(), LocalDateTime.now()));
    }

    private static void listarSesiones(List<Asistencia> asistencias) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("--- Asistencias Registradas ---");
        for (Asistencia asistencia : asistencias) {
            String fechaInicio = asistencia.getFechaInicioSesion().format(formatter);
            String fechaCierre = asistencia.getFechaCierreSesion() != null ? asistencia.getFechaCierreSesion().format(formatter) : "Sesión aún abierta";
            System.out.println("ID: " + asistencia.getIdAsistencia() + ", Correo: " + asistencia.getCorreoUsuario() + ", Fecha y Hora Inicio: " + fechaInicio + ", Fecha y Hora Cierre: " + fechaCierre);
        }
    }

    private static void descontarSueldoTrabajador(Scanner scanner, List<Trabajador> trabajadores) {
        try {
            System.out.print("Ingrese el ID del trabajador al que desea descontar el sueldo: ");
            int idTrabajador = obtenerEntero(scanner, "Por favor, ingrese un número entero válido: ");
            scanner.nextLine(); // Limpiar el buffer de entrada

            Trabajador trabajador = null;
            for (Trabajador t : trabajadores) {
                if (t.getId_trabajador() == idTrabajador) {
                    trabajador = t;
                    break;
                }
            }

            if (trabajador == null) {
                System.out.println("No se encontró ningún trabajador con el ID proporcionado.");
            } else {
                System.out.print("Ingrese el monto a descontar del sueldo: ");
                double monto = obtenerDecimal(scanner, "Por favor, ingrese un número decimal válido: ");
                scanner.nextLine(); // Limpiar el buffer de entrada
                trabajador.descontarSueldo(monto);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese un valor numérico válido.");
            scanner.nextLine(); // Limpiar el buffer de entrada
        }
    }
}