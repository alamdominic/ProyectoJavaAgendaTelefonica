public class main {
    private String FirstName;
    private String SecondName;
    private Long Number;

    // Constructor
    public main(String FirstName, String SecondName, Long Number) {
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.Number = Number;
    }

    // Getter y Setter para FirstName
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    // Getter y Setter para SecondName
    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    // Getter y Setter para Number
    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long Number) {
        this.Number = Number;
    }

    @Override
    public String toString() {
        return "main{" +
                "FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", Number=" + Number +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contacto) {
            Contacto otro = (Contacto) obj;
            return this.nombre.equalsIgnoreCase(otro.getNombre());
        }
        return false;
    }

}