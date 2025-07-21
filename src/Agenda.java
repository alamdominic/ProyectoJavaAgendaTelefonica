package src;
import javax.naming.ldap.ControlFactory;

public class Agenda {
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
                System.out.println("Contacto: " + contacto.getFirstName() + contacto.getSecondName() + " fue eliminado con éxito");
                return true;
            }
        }
        System.out.println("Error al intentar eliminar el contacto: contacto no encontrado");
        return false;
    }

    public void buscarContacto(String nombre){
        for (Contacto contactoRegistrado : contactos) {
            if(contactoRegistrado != null && contactoRegistrado.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Teléfono: " + contactoRegistrado.getNumber());
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }

    public void listarContactos(){
        System.out.println("Lista de contactos");
        for (Contacto contactoRegistrado : contactos) {
            if (contactoRegistrado != null) {
                System.out.println(contactoRegistrado);
            }
        }
    }


}
