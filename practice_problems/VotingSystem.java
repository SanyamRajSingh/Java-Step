package week9.practice_problems;

public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            boolean validate(String id) {
                return id != null && id.length() == 10;
            }
        }
        VoteValidator validator = new VoteValidator();
        if (validator.validate(voterId)) {
            System.out.println("Vote casted for " + candidate + " by " + voterId);
        } else {
            System.out.println("Invalid voter ID: " + voterId);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("VOTER1234", "Alice");
        vs.processVote("BADID", "Bob");
    }
}
