package crud;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GafasRepository repository = new GafasFileRepository();
        GafasService service = new GafasService(repository);
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Crear gafas");
            System.out.println("2. Actualizar gafas");
            System.out.println("3. Buscar gafas por ID");
            System.out.println("4. Eliminar gafas");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearGafas(scanner, service);
                    break;
                case 2:
                    actualizarGafas(scanner, service);
                    break;
                case 3:
                    buscarGafas(scanner, service);
                    break;
                case 4:
                    eliminarGafas(scanner, service);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void crearGafas(Scanner scanner, GafasService service) {
        System.out.println("Ingrese los datos de las gafas:");
        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Tipo: ");
        String tipo = scanner.next();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Marca: ");
        String marca = scanner.next();

        if (service.createGafas(id, tipo, precio, marca)) {
            System.out.println("Gafas creadas exitosamente.");
        } else {
            System.out.println("No se pudo crear las gafas.");
        }
    }

    private static void actualizarGafas(Scanner scanner, GafasService service) {
        System.out.print("Ingrese el ID de las gafas a actualizar: ");
        int id = scanner.nextInt();

        Gafas gafas = service.findGafas(id);
        if (gafas != null) {
            System.out.println("Ingrese los nuevos datos de las gafas:");
            System.out.print("Tipo: ");
            String tipo = scanner.next();

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            System.out.print("Marca: ");
            String marca = scanner.next();

            if (service.updateGafas(id, tipo, precio, marca)) {
                System.out.println("Gafas actualizadas exitosamente.");
            } else {
                System.out.println("No se pudo actualizar las gafas.");
            }
        } else {
            System.out.println("No se encontraron gafas con el ID proporcionado.");
        }
    }

    private static void buscarGafas(Scanner scanner, GafasService service) {
        System.out.print("Ingrese el ID de las gafas a buscar: ");
        int id = scanner.nextInt();

        Gafas gafas = service.findGafas(id);
        if (gafas != null) {
            System.out.println("Gafas encontradas: " + gafas.getTipo() + ", " + gafas.getPrecio() + ", " + gafas.getMarca());
        } else {
            System.out.println("No se encontraron gafas con el ID proporcionado.");
        }
    }

    private static void eliminarGafas(Scanner scanner, GafasService service) {
        System.out.print("Ingrese el ID de las gafas a eliminar: ");
        int id = scanner.nextInt();

        if (service.deleteGafas(id)) {
            System.out.println("Gafas eliminadas exitosamente.");
        } else {
            System.out.println("No se pudo eliminar las gafas.");
        }
    }
}
