package scenario.ResumeShortlistingSystem;

import java.util.*;

public class Resume {
    private String candidateName;
    private Set<String> skills;

    public Resume(String candidateName, Set<String> skills) throws InvalidResumeException {
        if (skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume must have at least one skill.");
        }
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public String getCandidateName() { return candidateName; }
    public Set<String> getSkills() { return skills; }

    public int matchingSkillCount(Set<String> requiredSkills) {
        Set<String> intersection = new HashSet<>(skills);
        intersection.retainAll(requiredSkills);
        return intersection.size();
    }

    @Override
    public String toString() {
        return candidateName + " | Skills: " + skills;
    }
}