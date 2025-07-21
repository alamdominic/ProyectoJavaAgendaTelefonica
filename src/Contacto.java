package src;

public class Contacto {
    private String firstName;
    private String secondName;
    private String number;

    public Contacto(String firstName, String secondName, String number) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " - " + number;
    }

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
