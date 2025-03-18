package com.InjectingCollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring application context using the configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Student bean
        StudentBean student = context.getBean(StudentBean.class);

        // Display the subjects
        student.displaySubjects();
    }
}