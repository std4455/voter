import java.util.List;

public class Candidate {
    private Long order;
    private String firstName;
    private String lastName;
    private String about;
    private Long numOfVotes;
    private List<Voter> voters;

    public Candidate(){

    }
    public Candidate(String firstName, String surname, String about, Long numOfVotes, List<Voter> voters) {
        super();
        this.firstName = firstName;
        lastName = surname;
        this.about = about;
        this.numOfVotes = numOfVotes;
        this.voters = voters;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(Long numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return order + ". {" +
                "firstName='" + firstName + '\'' +
                ", Surname='" + lastName + '\'' +
                ", about='" + about + '\'' +
                ", numOfVotes=" + numOfVotes + '}';
    }
}
