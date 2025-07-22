package src;

import java.util.Arrays;

// Clase que representa una agenda de contactos
public class Agenda {
    private Contacto[] contactos;  // Arreglo de contactos
    private int capacidad;         // Capacidad máxima de la agenda

    // Constructor por defecto: agenda de 10 contactos
    public Agenda() {
        this(10);
    }

    // Constructor con capacidad personalizada
    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new Contacto[capacidad];
    }

    // Método para añadir un nuevo contacto a la agenda
    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena.");
            return false;
        }

        if (existeContacto(c)) {
            System.out.println("Este contacto ya existe.");
            return false;
        }

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contactos[i] = c;
                System.out.println("Contacto añadido.");
                return true;
            }
        }
        return false;
    }

    // Verifica si la agenda está llena
    public boolean agendaLlena() {
        return espaciosLibres() == 0;
    }

    // Cuenta cuántos espacios libres hay
    public int espaciosLibres() {
        int libres = 0;
        for (Contacto contacto : contactos) {
            if (contacto == null) {
                libres++;
            }
        }
        return libres;
    }

    // Verifica si el contacto ya está en la agenda
    public boolean existeContacto(Contacto contacto) {
        for (Contacto contactoRegistrado : contactos) {
            if (contactoRegistrado != null && contactoRegistrado.equals(contacto)) {
                return true;
            }
        }
        return false;
    }

    // Elimina un contacto existente
    public boolean eliminarContacto(Contacto contacto) {
        for (int i = 0; i < contactos.length; i++) {
            if(contactos[i] != null && contactos[i].equals(contacto)){
                contactos[i] = null;
                System.out.println("Contacto: " + contacto.getFirstName() + " " + contacto.getSecondName() + " fue eliminado con éxito");
                return true;
            }
        }
        System.out.println("Error al intentar eliminar el contacto: contacto no encontrado");
        return false;
    }

    // Busca y muestra el teléfono de un contacto específico
    public void buscarContacto(String nombre, String apellido){
        for (Contacto contactoRegistrado : contactos) {
            if(contactoRegistrado != null && contactoRegistrado.getFirstName().equalsIgnoreCase(nombre) && contactoRegistrado.getSecondName().equalsIgnoreCase(apellido)){
                System.out.println("Teléfono: " + contactoRegistrado.getNumber());
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }

    // Muestra todos los contactos ordenados
    public void listarContactos(){
        if (espaciosLibres() == contactos.length) {
            System.out.println("No hay contactos actualmente");
            return;
        }
        Arrays.sort(contactos, new ContactoComparator());        
        System.out.println("Lista de contactos");
        for (Contacto contactoRegistrado : contactos) {
            if (contactoRegistrado != null) {
                System.out.println(contactoRegistrado.getFirstName() + " " + contactoRegistrado.getSecondName() + " - " + contactoRegistrado.getNumber());
            }
        }
    }
}
