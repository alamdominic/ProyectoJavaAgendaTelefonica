package src;

/**
 * Clase que representa un contacto en la agenda telefónica.
 * Contiene el nombre, apellido y número telefónico del contacto.
 */
public class Contacto {
    private String firstName;   // Nombre del contacto
    private String secondName;  // Apellido del contacto
    private String number;      // Número telefónico del contacto

    /**
     * Constructor que inicializa un nuevo contacto con nombre, apellido y número.
     *
     * @param firstName  Nombre del contacto
     * @param secondName Apellido del contacto
     * @param number     Número telefónico del contacto
     */
    public Contacto(String firstName, String secondName, String number) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.number = number;
    }

    /**
     * Devuelve el nombre del contacto.
     *
     * @return Nombre del contacto
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Devuelve el apellido del contacto.
     *
     * @return Apellido del contacto
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Devuelve el número telefónico del contacto.
     *
     * @return Número telefónico del contacto
     */
    public String getNumber() {
        return number;
    }

    /**
     * Devuelve una representación en forma de cadena del contacto.
     *
     * @return Cadena con el formato "Nombre Apellido - Número"
     */
    @Override
    public String toString() {
        return firstName + " " + secondName + " - " + number;
    }

    /**
     * Compara este contacto con otro para verificar si son el mismo,
     * considerando que un contacto es igual si tiene el mismo nombre y apellido,
     * ignorando mayúsculas y minúsculas.
     *
     * @param obj Objeto con el que se compara
     * @return true si son el mismo contacto, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto otro = (Contacto) obj;
            return this.firstName.equalsIgnoreCase(otro.getFirstName()) &&
                   this.secondName.equalsIgnoreCase(otro.getSecondName());
        }
        return false;
    }
}
