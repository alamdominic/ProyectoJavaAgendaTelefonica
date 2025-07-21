package src;

import java.util.Arrays;

public class Agenda {
    private Contacto[] contactos;
    private int capacidad;
    public Agenda() {
        this(10);
    }

    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new Contacto[capacidad];
    }

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
    public boolean agendaLlena() {
        return espaciosLibres() == 0;
    }
    public int espaciosLibres() {
        int libres = 0;
        for (Contacto contacto : contactos) {
            if (contacto == null) {
                libres++;
            }
        }
        return libres;
    }


    public boolean existeContacto(Contacto contacto) {
        for (Contacto contactoRegistrado : contactos) {
            if (contactoRegistrado != null && contactoRegistrado.equals(contacto)) {
                return true;
            }
        }
        return false;
    }

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

    public void buscarContacto(String nombre, String apellido){
        for (Contacto contactoRegistrado : contactos) {
            if(contactoRegistrado != null && contactoRegistrado.getFirstName().equalsIgnoreCase(nombre) && contactoRegistrado.getSecondName().equalsIgnoreCase(apellido)){
                System.out.println("Teléfono: " + contactoRegistrado.getNumber());
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }

    public void listarContactos(){
        Arrays.sort(contactos, new ContactoComparator());
        System.out.println("Lista de contactos");
        for (Contacto contactoRegistrado : contactos) {
            if (contactoRegistrado != null) {
                System.out.println(contactoRegistrado.getFirstName() + " " + contactoRegistrado.getSecondName() + " - " + contactoRegistrado.getNumber());
            }
        }
    }
}
