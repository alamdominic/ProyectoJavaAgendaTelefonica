public class main {
    private String Name;
    private Long Number;

    // Constructor
    public main(String Name, Long Number) {
        this.Name = Name;
        this.Number = Number;
    }

    // Getter y Setter para Name
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
                "Name='" + Name + '\'' +
                ", Number=" + Number +
                '}';
    }
}
