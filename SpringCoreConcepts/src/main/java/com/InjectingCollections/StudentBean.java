package com.InjectingCollections;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentBean {
    private List<String> subjects;

    // Setter for dependency injection
    @org.springframework.beans.factory.annotation.Autowired
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void displaySubjects() {
        System.out.println("Subjects:");
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }
    }
}