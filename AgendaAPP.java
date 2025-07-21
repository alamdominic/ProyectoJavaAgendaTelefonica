import java.util.Scanner;

public class AgendaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda(); // se puede cambiar por new Agenda(20)

        int opcion;
        do {
            System.out.println("\nAGENDA TELEFÓNICA");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Ver si contacto existe");
            System.out.println("5. Listar contactos");
            System.out.println("6. Ver si agenda está llena");
            System.out.println("7. Ver espacios libres");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    agenda.añadirContacto(new Contacto(nombre, telefono));
                    break;
                case 2:
                    System.out.print("Nombre a buscar: ");
                    agenda.buscarContacto(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nombre del contacto a eliminar: ");
                    agenda.eliminarContacto(new Contacto(sc.nextLine(), ""));
                    break;
                case 4:
                    System.out.print("Nombre a verificar: ");
                    boolean existe = agenda.existeContacto(new Contacto(sc.nextLine(), ""));
                    System.out.println(existe ? "Existe" : "No existe");
                    break;
                case 5:
                    agenda.listarContactos();
                    break;
                case 6:
                    System.out.println(agenda.agendaLlena() ? "Agenda llena" : "Hay espacio");
                    break;
                case 7:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;
                case 0:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
        sc.close();
    }
}
