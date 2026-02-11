package scenario.ResumeShortlistingSystem;

import java.util.*;

public class JobPortal {
    private List<Resume> resumes = new ArrayList<>();

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public void shortlistResumes(Set<String> requiredSkills) {
        resumes.sort((r1, r2) -> r2.matchingSkillCount(requiredSkills) - r1.matchingSkillCount(requiredSkills));
        System.out.println("Shortlisted Resumes:");
        for (Resume r : resumes) {
            System.out.println(r.getCandidateName() + " | Matching Skills: " + r.matchingSkillCount(requiredSkills));
        }
    }
} 