package OnlineVotingSystem;

public interface ElectionService {

    void registerVoter(Voter voter);

    void addCandidate(Candidate candidate);

    void castVote(int voterId, int candidateId) throws DuplicateVoteException;

    void showResults();
}

