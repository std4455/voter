import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class ElectionHandler {
    public ElectionHandler() {
    }

    public void start() {
        String answer;
        Scanner sc = new Scanner(System.in);
        do {
            List<Voter> voterList = readVoterFromFile();
            List<Candidate> canList = readCandidatesFromFile();
            System.out.println("Welcome to Epic Presidential Election of DuckLand");
            System.out.println("1. Are you an existing voter?");
            System.out.println("2. Or create a new voter?");
            answer = sc.nextLine();
            int ans = parseInt(answer);
            if (ans == 1) {
                do {
                    System.out.println("Scan your right index finger");
                    answer = sc.nextLine();
                    String v = findVoterByFingerPrint(voterList, answer);
                    if (v == null) {
                        System.out.println("You are not in the voters list. Try again? (yes/no)");
                        answer = sc.nextLine();
                    } else {
                        System.out.println("You're voting as " + v);
                    }
                } while (answer.equalsIgnoreCase("yes"));
            } if(ans == 2 || answer.equalsIgnoreCase("no")) {
                Voter newVoter = new Voter();
                System.out.println("Creating a new voter\n Your Id: ");
                newVoter.setId(sc.nextLine());
                System.out.println("Your first name: ");
                newVoter.setFirstName(sc.nextLine());
                System.out.println("Your last name: ");
                newVoter.setLastName(sc.nextLine());
                System.out.println("Scan your right index finger: ");
                newVoter.setFingerPrint(sc.nextLine());
                saveNewVoter(newVoter);
            }
            System.out.println("Choose your candidate: ");
            canList.forEach(System.out::println);
            System.out.println("Choose your candidate: ");
            answer = sc.nextLine();
            long canNumber = parseLong(answer);
            canList.forEach(c -> {
                if(c.getOrder() == canNumber)
                    c.setNumOfVotes(c.getNumOfVotes() + 1);
            });
            System.out.println("Thank you for your vote. Vote again? (yes/no)");
            saveResults(canList);
            answer = sc.nextLine();
        } while (answer.equalsIgnoreCase("yes"));
    }


    private List<Voter> readVoterFromFile() {
        List<Voter> voterList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("voter.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Voter voter = new Voter();
                voter.setId(values[0]);
                voter.setFirstName(values[1]);
                voter.setLastName(values[2]);
                voter.setFingerPrint(values[3]);
                voterList.add(voter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return voterList;
    }

    private List<Candidate> readCandidatesFromFile() {
        List<Candidate> canList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("can.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Candidate can = new Candidate();
                can.setOrder(parseLong(values[0]));
                can.setFirstName(values[1]);
                can.setLastName(values[2]);
                can.setAbout(values[3]);
                can.setNumOfVotes(parseLong(values[4]));
                canList.add(can);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return canList;
    }

    private void saveNewVoter(Voter voter) {
        try (FileWriter pw = new FileWriter("voter.csv", true)) {
            pw.append("\n").append(voter.getId()).append(",").append(voter.getFirstName()).append(",").append(voter.getLastName()).append(",").append(voter.getFingerPrint());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveResults(List<Candidate> canList) {
        try (FileWriter pw = new FileWriter("can.csv")) {
            for (Candidate c : canList) {
                pw.append(String.valueOf(c.getOrder())).append(",").append(c.getFirstName()).append(",").append(c.getLastName()).append(",").append(c.getAbout()).append(",").append(String.valueOf(c.getNumOfVotes())).append("\n");
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String findVoterByFingerPrint(List<Voter> voterList, String s) {
        for (Voter v : voterList) {
            if (v.getFingerPrint().equalsIgnoreCase(s))
                return v.getFirstName() + " " + v.getLastName();
        }
        return null;
    }
}
