package Model;

import patterns.observer.Observer;

public class User implements Observer {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.printf("Notification pour %s (%s): %s%n", name, email, message);
    }
}
