package src;

import java.util.Comparator;

public class ContactoComparator implements Comparator<Contacto>{
    @Override
    public int compare(Contacto contacto1, Contacto contacto2) {
        int firstNameComparison = contacto1.getFirstName().compareTo(contacto2.getFirstName());
        
        if (firstNameComparison == 0) {
            return contacto1.getSecondName().compareTo(contacto2.getSecondName());
        }
        
        return firstNameComparison;
    }
}
