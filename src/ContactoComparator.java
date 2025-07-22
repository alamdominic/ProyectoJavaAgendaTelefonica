package src;

import java.util.Comparator;

/**
 * Clase que implementa la interfaz Comparator para comparar objetos de tipo Contacto.
 * Permite ordenar contactos alfabéticamente primero por nombre y, en caso de empate, por apellido.
 * También maneja casos en los que alguno de los contactos es null.
 */
public class ContactoComparator implements Comparator<Contacto> {
    
    /**
     * Compara dos objetos Contacto para definir su orden.
     * - Si ambos son null, se consideran iguales.
     * - Si uno es null, se considera menor que el otro.
     * - Si ambos son válidos, se comparan por nombre y luego por apellido.
     *
     * @param contacto1 Primer contacto a comparar
     * @param contacto2 Segundo contacto a comparar
     * @return Un número negativo si contacto1 < contacto2, 
     *         cero si son iguales, 
     *         o un número positivo si contacto1 > contacto2.
     */
    @Override
    public int compare(Contacto contacto1, Contacto contacto2) {
        // Manejo de casos null
        if (contacto1 == null && contacto2 == null) {
            return 0; // Ambos contactos son null, se consideran iguales
        }
        if (contacto1 == null) {
            return -1; // contacto1 es null, se coloca antes
        }
        if (contacto2 == null) {
            return 1; // contacto2 es null, se coloca antes
        }

        // Comparar por el nombre (firstName)
        int firstNameComparison = contacto1.getFirstName().compareTo(contacto2.getFirstName());
        
        // Si los nombres son iguales, comparar por apellido (secondName)
        if (firstNameComparison == 0) {
            return contacto1.getSecondName().compareTo(contacto2.getSecondName());
        }

        // Devolver el resultado de la comparación por nombre
        return firstNameComparison;
    }
}
