package src;

import java.util.Scanner;

public class AgendaAPP {
    public static void main(String[] args) {
        // Se crea un escáner para leer entradas del usuario por consola
        Scanner sc = new Scanner(System.in);

        // Se instancia una nueva agenda telefónica
        Agenda agenda = new Agenda();

        int opcion; // Variable para almacenar la opción del menú seleccionada por el usuario

        // Bucle principal que muestra el menú y espera la opción del usuario
        do {
            // Menú principal
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
            
            opcion = sc.nextInt(); // Lee la opción elegida
            sc.nextLine(); // Limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    // Añadir un nuevo contacto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    String telefono;
                    boolean telefonoValido = false;

                    // Bucle para validar el número telefónico ingresado
                    do {
                        System.out.print("Teléfono: ");
                        telefono = sc.nextLine();

                        try {
                            // Validación: debe tener exactamente 10 dígitos numéricos
                            if (!telefono.matches("\\d{10}")) {
                                throw new IllegalArgumentException(
                                    "El número debe tener exactamente 10 dígitos numéricos.");
                            }
                            telefonoValido = true; // El número es válido
                        } catch (IllegalArgumentException e) {
                            System.out.println("❌ Error: " + e.getMessage());
                        }

                    } while (!telefonoValido);

                    // Se añade el contacto con nombre y apellido en minúsculas para estandarizar
                    agenda.añadirContacto(new Contacto(nombre.toLowerCase(), apellido.toLowerCase(), telefono));
                    break;

                case 2:
                    // Buscar contacto por nombre y apellido
                    System.out.print("Nombre: ");
                    String nombreBuscar = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoBuscar = sc.nextLine();
                    agenda.buscarContacto(nombreBuscar, apellidoBuscar);
                    break;

                case 3:
                    // Eliminar un contacto
                    System.out.print("Nombre: ");
                    String nombreEliminar = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEliminar = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nombreEliminar, apellidoEliminar, ""));
                    break;

                case 4:
                    // Verificar si un contacto existe
                    System.out.print("Nombre: ");
                    String nombreExiste = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoExiste = sc.nextLine();
                    boolean existe = agenda.existeContacto(new Contacto(nombreExiste, apellidoExiste, ""));
                    System.out.println(existe ? "Existe" : "No existe");
                    break;

                case 5:
                    // Mostrar lista de todos los contactos
                    agenda.listarContactos();
                    break;

                case 6:
                    // Ver si la agenda está llena
                    System.out.println(agenda.agendaLlena() ? "Agenda llena" : "Hay espacio");
                    break;

                case 7:
                    // Mostrar cuántos espacios libres hay en la agenda
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;

                case 0:
                    // Salir del programa
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    // Manejo de opción inválida
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0); // El programa se repite hasta que se seleccione la opción 0 (Salir)

        // Se cierra el escáner al finalizar el programa
        sc.close();
    }
}
