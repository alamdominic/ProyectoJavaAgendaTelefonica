package src;

import java.util.Comparator;

public class ContactoComparator implements Comparator<Contacto>{
    @Override
    public int compare(Contacto contacto1, Contacto contacto2) {
        // Manejo de null
        if (contacto1 == null && contacto2 == null) {
            return 0; // Ambos son null, son iguales
        }
        if (contacto1 == null) {
            return -1; // contacto1 es null, va antes que contacto2
        }
        if (contacto2 == null) {
            return 1; // contacto2 es null, va antes que contacto1
        }

        // Comparación por nombre
        int firstNameComparison = contacto1.getFirstName().compareTo(contacto2.getFirstName());
        if (firstNameComparison == 0) {
            return contacto1.getSecondName().compareTo(contacto2.getSecondName());
        }
        return firstNameComparison;
    }
}
