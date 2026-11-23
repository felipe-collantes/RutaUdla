package interfaz;

import modelo.Disponibilidad;
import modelo.Estimacion;
import modelo.Novedad;
import modelo.ObjetoOlvidado;
import modelo.Parada;
import modelo.ReporteMovimiento;
import modelo.Ruta;
import modelo.ServicioTransporte;
import modelo.Usuario;
import negocio.GestorEstimaciones;
import negocio.GestorNovedades;
import negocio.GestorReportes;
import negocio.GestorRutasServicios;
import negocio.GestorUsuarios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipalConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GestorRutasServicios gestorRutasServicios = new GestorRutasServicios();
        GestorReportes gestorReportes = new GestorReportes();
        GestorEstimaciones gestorEstimaciones = new GestorEstimaciones();
        GestorNovedades gestorNovedades = new GestorNovedades();
        GestorUsuarios gestorUsuarios = new GestorUsuarios();

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n==========================================");
            System.out.println("              RUTA UDLA                   ");
            System.out.println("==========================================");
            System.out.println("1. Rutas, paradas y servicios");
            System.out.println("2. Reportes de movimiento y disponibilidad");
            System.out.println("3. Estimaciones de tiempos");
            System.out.println("4. Novedades y objetos olvidados");
            System.out.println("5. Usuarios y confiabilidad");
            System.out.println("0. Salir");
            System.out.println("==========================================");

            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> subMenuRutasServicios(scanner, gestorRutasServicios);
                case 2 -> subMenuReportesDisponibilidad(scanner, gestorReportes);
                case 3 -> subMenuEstimaciones(scanner, gestorEstimaciones);
                case 4 -> subMenuNovedadesObjetos(scanner, gestorNovedades);
                case 5 -> subMenuUsuarios(scanner, gestorUsuarios);
                case 0 -> System.out.println("\nSaliendo de RutaUDLA. ¡Éxito en la entrega!");
                default -> System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    // =========================================================
    // 1. RUTAS, PARADAS Y SERVICIOS
    // =========================================================
    private static void subMenuRutasServicios(Scanner scanner, GestorRutasServicios gestor) {
        int sub = -1;
        while (sub != 0) {
            System.out.println("\n--- [1] Rutas, paradas y servicios ---");
            System.out.println("1. Consultar rutas registradas");
            System.out.println("2. Consultar recorrido / buscar parada en una ruta");
            System.out.println("3. Consultar servicios / calcular costo de viajes");
            System.out.println("0. Volver al menú principal");
            sub = leerEntero(scanner, "Elija una opción: ");

            switch (sub) {
                case 1 -> {
                    List<Ruta> rutas = gestor.consultarRutas();
                    System.out.println("Total de rutas: " + rutas.size());
                    for (Ruta r : rutas) {
                        System.out.println("- ID: " + r.getIdRuta() + " | Nombre: " + r.getNombre()
                                + " | " + r.getOrigen() + " -> " + r.getDestino()
                                + " (" + r.getSentido() + ")");
                    }
                }
                case 2 -> {
                    int idRuta = leerEntero(scanner, "Ingrese ID de la ruta: ");
                    Ruta ruta = gestor.buscarRuta(idRuta);
                    if (ruta != null) {
                        System.out.println(ruta.consultarRecorrido());
                        System.out.print("Ingrese nombre de parada a buscar (o deje vacío para omitir): ");
                        String nombreParada = scanner.nextLine().trim();
                        if (!nombreParada.isEmpty()) {
                            Parada p = ruta.buscarParada(nombreParada);
                            if (p != null) {
                                p.mostrarInformacion();
                            } else {
                                System.out.println("Parada no encontrada en la ruta.");
                            }
                        }
                    } else {
                        System.out.println("Ruta no encontrada.");
                    }
                }
                case 3 -> {
                    int viajes = leerEntero(scanner, "Ingrese cantidad de viajes: ");
                    // Ajusta aquí al método real de GestorRutasServicios que obtenga el ServicioTransporte
                    // por ejemplo: gestor.consultarServicios() o gestor.obtenerServicio(...)
                    List<ServicioTransporte> servicios = gestor.consultarServicios();
                    if (servicios != null && !servicios.isEmpty()) {
                        ServicioTransporte servicio = servicios.get(0);
                        System.out.println("Servicio: " + servicio.getTipo()
                                + " | Tarifa: " + servicio.consultarTarifa()
                                + " | Costo (" + viajes + " viajes): " + servicio.calcularCosto(viajes));
                    } else {
                        System.out.println("No hay servicios registrados para calcular tarifa.");
                    }
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // =========================================================
    // 2. REPORTES DE MOVIMIENTO Y DISPONIBILIDAD
    // =========================================================
    private static void subMenuReportesDisponibilidad(Scanner scanner, GestorReportes gestor) {
        int sub = -1;
        while (sub != 0) {
            System.out.println("\n--- [2] Reportes de movimiento y disponibilidad ---");
            System.out.println("1. Registrar reporte de movimiento");
            System.out.println("2. Consultar reportes registrados");
            System.out.println("3. Validar / corroborar un reporte");
            System.out.println("4. Registrar / consultar disponibilidad de servicio");
            System.out.println("0. Volver al menú principal");
            sub = leerEntero(scanner, "Elija una opción: ");

            switch (sub) {
                case 1 -> {
                    int idReporte = leerEntero(scanner, "ID del reporte: ");
                    System.out.print("Tipo de movimiento (SALIDA / LLEGADA): ");
                    String tipo = scanner.nextLine().trim();

                    // Ajusta este constructor de 3 argumentos al constructor real de ReporteMovimiento
                    ReporteMovimiento rep = new ReporteMovimiento(idReporte, tipo, LocalDateTime.now());
                    boolean ok = gestor.registrarReporte(rep);
                    System.out.println(ok ? "Reporte registrado correctamente." : "No se pudo registrar el reporte.");
                }
                case 2 -> {
                    List<ReporteMovimiento> lista = gestor.consultarReportes();
                    System.out.println("Total de reportes: " + lista.size());
                    for (ReporteMovimiento rep : lista) {
                        System.out.println("- ID: " + rep.getIdReporte()
                                + " | Tipo: " + rep.getTipoMovimiento()
                                + " | FechaHora: " + rep.getFechaHora()
                                + " | Estado: " + rep.getEstadoCorroboracion());
                    }
                }
                case 3 -> {
                    int idReporte = leerEntero(scanner, "ID del reporte a validar/corroborar: ");
                    ReporteMovimiento rep = gestor.buscarReporte(idReporte);
                    if (rep != null) {
                        System.out.println("Validar: " + rep.validarReporte());
                        rep.corroborarReporte();
                        System.out.println("Reporte corroborado. Estado actual: " + rep.getEstadoCorroboracion());
                    } else {
                        System.out.println("Reporte no encontrado.");
                    }
                }
                case 4 -> {
                    int idDisp = leerEntero(scanner, "ID de disponibilidad: ");
                    System.out.print("Estado del servicio (DISPONIBLE / DEMORADO / FUERA_DE_SERVICIO): ");
                    String estado = scanner.nextLine().trim();

                    Disponibilidad disp = new Disponibilidad(idDisp, estado, LocalDateTime.now());
                    gestor.registrarDisponibilidad(disp);
                    System.out.println("Disponibilidad registrada. Estado consultado: " + disp.consultarEstado());
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // =========================================================
    // 3. ESTIMACIONES DE TIEMPOS
    // =========================================================
    private static void subMenuEstimaciones(Scanner scanner, GestorEstimaciones gestor) {
        int sub = -1;
        while (sub != 0) {
            System.out.println("\n--- [3] Estimaciones de tiempos ---");
            System.out.println("1. Registrar estimación");
            System.out.println("2. Consultar intervalo, salida y llegada por ID");
            System.out.println("3. Listar todas las estimaciones");
            System.out.println("0. Volver al menú principal");
            sub = leerEntero(scanner, "Elija una opción: ");

            switch (sub) {
                case 1 -> {
                    int idEst = leerEntero(scanner, "ID de estimación: ");
                    double intervalo = leerDouble(scanner, "Intervalo en minutos: ");
                    double espera = leerDouble(scanner, "Espera en minutos: ");

                    Estimacion est = new Estimacion(idEst, intervalo, espera, LocalDateTime.now());
                    boolean ok = gestor.registrarEstimacion(est);
                    System.out.println(ok ? "Estimación registrada." : "No se pudo registrar la estimación.");
                }
                case 2 -> {
                    int idEst = leerEntero(scanner, "ID de estimación: ");
                    Estimacion est = gestor.buscarEstimacion(idEst);
                    if (est != null) {
                        System.out.println("Intervalo (min): " + gestor.consultarIntervalo(idEst));
                        System.out.println("Salida estimada: " + gestor.consultarSalida(idEst));
                        System.out.println("Llegada estimada: " + gestor.consultarLlegada(idEst));
                    } else {
                        System.out.println("Estimación no encontrada.");
                    }
                }
                case 3 -> {
                    List<Estimacion> lista = gestor.consultarEstimaciones();
                    System.out.println("Total estimaciones: " + lista.size());
                    for (Estimacion e : lista) {
                        System.out.println("- ID: " + e.getIdEstimacion()
                                + " | Intervalo: " + e.getIntervaloMinutos()
                                + " | Espera: " + e.getEsperaMinutos()
                                + " | Hora base: " + e.getHoraEstimada());
                    }
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // =========================================================
    // 4. NOVEDADES Y OBJETOS OLVIDADOS
    // =========================================================
    private static void subMenuNovedadesObjetos(Scanner scanner, GestorNovedades gestor) {
        int sub = -1;
        while (sub != 0) {
            System.out.println("\n--- [4] Novedades y objetos olvidados ---");
            System.out.println("1. Registrar novedad / incidente");
            System.out.println("2. Actualizar estado de novedad");
            System.out.println("3. Consultar novedades activas y todas");
            System.out.println("4. Registrar objeto olvidado / encontrado");
            System.out.println("5. Actualizar estado o listar objetos olvidados");
            System.out.println("0. Volver al menú principal");
            sub = leerEntero(scanner, "Elija una opción: ");

            switch (sub) {
                case 1 -> {
                    int idNov = leerEntero(scanner, "ID de novedad: ");
                    System.out.print("Tipo (RETRASO / INTERRUPCION / OTRO): ");
                    String tipo = scanner.nextLine().trim();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine().trim();
                    System.out.print("Estado inicial (ACTIVA / EN_REVISION / RESUELTA): ");
                    String estado = scanner.nextLine().trim();

                    Novedad nov = new Novedad(idNov, tipo, desc, LocalDateTime.now(), estado);
                    boolean ok = gestor.registrarNovedad(nov);
                    System.out.println(ok ? "Novedad registrada." : "No se pudo registrar la novedad.");
                }
                case 2 -> {
                    int idNov = leerEntero(scanner, "ID de novedad a actualizar: ");
                    System.out.print("Nuevo estado (ej. RESUELTA): ");
                    String nuevoEstado = scanner.nextLine().trim();
                    boolean ok = gestor.actualizarEstadoNovedad(idNov, nuevoEstado);
                    System.out.println(ok ? "Estado actualizado." : "No se pudo actualizar (verifique el ID).");
                }
                case 3 -> {
                    System.out.println("Novedades activas: " + gestor.consultarNovedadesActivas().size());
                    for (Novedad n : gestor.consultarNovedades()) {
                        System.out.println("- ID: " + n.getIdNovedad()
                                + " | Tipo: " + n.getTipo()
                                + " | Estado: " + n.getEstado()
                                + " | Desc: " + n.getDescripcion());
                    }
                }
                case 4 -> {
                    int idObj = leerEntero(scanner, "ID de objeto: ");
                    System.out.print("Tipo de reporte (PERDIDO / ENCONTRADO): ");
                    String tipoRep = scanner.nextLine().trim();
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine().trim();
                    System.out.print("Características: ");
                    String caract = scanner.nextLine().trim();
                    System.out.print("Estado inicial (REPORTADO / ENTREGADO): ");
                    String estado = scanner.nextLine().trim();

                    ObjetoOlvidado obj = new ObjetoOlvidado(idObj, tipoRep, desc, caract, estado);
                    boolean ok = gestor.registrarObjetoOlvidado(obj);
                    System.out.println(ok ? "Objeto registrado." : "No se pudo registrar el objeto.");
                }
                case 5 -> {
                    int idObj = leerEntero(scanner, "ID de objeto para actualizar estado (0 para solo listar): ");
                    if (idObj != 0) {
                        System.out.print("Nuevo estado: ");
                        String nuevoEstado = scanner.nextLine().trim();
                        boolean ok = gestor.actualizarEstadoObjeto(idObj, nuevoEstado);
                        System.out.println(ok ? "Estado del objeto actualizado." : "No se pudo actualizar.");
                    }
                    for (ObjetoOlvidado o : gestor.consultarObjetosOlvidados()) {
                        System.out.println("- ID: " + o.getIdObjeto()
                                + " | Tipo: " + o.getTipoReporte()
                                + " | Estado: " + o.getEstado()
                                + " | Desc: " + o.getDescripcion());
                    }
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    // =========================================================
    // 5. USUARIOS Y CONFIABILIDAD
    // =========================================================
    private static void subMenuUsuarios(Scanner scanner, GestorUsuarios gestor) {
        int sub = -1;
        while (sub != 0) {
            System.out.println("\n--- [5] Usuarios y confiabilidad ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Evaluar / consultar confiabilidad de usuario");
            System.out.println("3. Consultar estadísticas y listar usuarios");
            System.out.println("0. Volver al menú principal");
            sub = leerEntero(scanner, "Elija una opción: ");

            switch (sub) {
                case 1 -> {
                    int idUsuario = leerEntero(scanner, "ID de usuario: ");
                    System.out.print("Alias: ");
                    String alias = scanner.nextLine().trim();
                    System.out.print("Estado (ACTIVO / INACTIVO): ");
                    String estado = scanner.nextLine().trim();

                    // Ajusta este constructor de 3 argumentos al constructor real de Usuario
                    Usuario u = new Usuario(idUsuario, alias, estado);
                    boolean ok = gestor.registrarUsuario(u);
                    System.out.println(ok ? "Usuario registrado." : "No se pudo registrar (ID duplicado o nulo).");
                }
                case 2 -> {
                    int idUsuario = leerEntero(scanner, "ID de usuario: ");
                    int p1 = leerEntero(scanner, "Primer parámetro para calcularConfiabilidad: ");
                    int p2 = leerEntero(scanner, "Segundo parámetro para calcularConfiabilidad: ");
                    double resultado = gestor.consultarConfiabilidad(idUsuario, p1, p2);
                    if (resultado >= 0) {
                        System.out.println("Confiabilidad calculada: " + resultado);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.println(gestor.consultarEstadisticas());
                    for (Usuario u : gestor.consultarUsuarios()) {
                        System.out.println("- ID: " + u.getIdUsuario()
                                + " | Alias: " + u.getAlias()
                                + " | Estado: " + u.getEstado()
                                + " | Confiabilidad: " + u.getConfiabilidad());
                    }
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}