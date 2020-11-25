package com.sparta.janja;

public abstract class Teacher {

    private String name;
    private String subject;
    private int age;
    private boolean currentlyTeaching;

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, String subject, int age, boolean currentlyTeaching) {
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.currentlyTeaching = currentlyTeaching;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCurrentlyTeaching() {
        return currentlyTeaching;
    }

    public void setCurrentlyTeaching(boolean currentlyTeaching) {
        this.currentlyTeaching = currentlyTeaching;
    }

    public abstract void favoritePhrase();

    public abstract char grade();
}
