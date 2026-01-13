package OnlineVotingSystem;

public class ElectionServiceImpl implements ElectionService {

    private Voter[] voters = new Voter[10];
    private Candidate[] candidates = new Candidate[5];

    private int voterCount = 0;
    private int candidateCount = 0;

    @Override
    public void registerVoter(Voter voter) {
        voters[voterCount++] = voter;
        System.out.println("Voter registered successfully!");
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates[candidateCount++] = candidate;
        System.out.println("Candidate added successfully!");
    }

    @Override
    public void castVote(int voterId, int candidateId)
            throws DuplicateVoteException {

        Voter voter = null;
        Candidate candidate = null;

        for (int i = 0; i < voterCount; i++) {
            if (voters[i].getVoterId() == voterId) {
                voter = voters[i];
                break;
            }
        }

        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].getCandidateId() == candidateId) {
                candidate = candidates[i];
                break;
            }
        }

        if (voter == null || candidate == null) {
            System.out.println("Invalid voter or candidate ID!");
            return;
        }

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already voted!");
        }

        Vote vote = new Vote(voter, candidate);
        candidate.addVote();
        voter.markVoted();

        System.out.println("Vote cast successfully for " + vote.getCandidate().getName());
    }

    @Override
    public void showResults() {
        System.out.println("\n---- ELECTION RESULTS ----");
        for (int i = 0; i < candidateCount; i++) {
            System.out.println(candidates[i].getName() +
                    " : " + candidates[i].getVoteCount() + " votes");
        }
    }
}

