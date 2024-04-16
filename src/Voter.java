public class Voter {
    private String id;
    private String firstName;
    private String lastName;
    private String fingerPrint;

    public Voter(){

    }

    public Voter(String id, String firstName, String lastName, String signature) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fingerPrint = signature;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", signature='" + fingerPrint + '}';
    }
}
