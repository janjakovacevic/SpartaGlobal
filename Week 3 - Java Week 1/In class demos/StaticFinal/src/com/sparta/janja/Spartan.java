package com.sparta.janja;

public final class Spartan {
    // instance variables
    private String spartanName;
    private int age;
    private String gender;

    // static variable - class level
    // if not static, no one sees it - whenever object created == 1
    private static int spartanCount;
    // compile time constant -- constant variable
    private static final int SPARTAN_ONSITE_COUNT = 150;

    private final int spartanId;

    static{
        // static block
        // first thing executed/loaded when class loads
        // class level
        // e.g. browser/database loading
        System.out.println("Static block 1");
    }
    static{
        System.out.println("Static block 2");
    }

    public final void aboutSpartan(){
        // as FINAL cannot be overriden
        System.out.println("This Spartan belongs to the London academy");
    }

    // instance initializer block
    // at the object level
    {
        spartanCount++;
        final int IdGenerator = 1000;
        //instance level - only recognized when run: runtime constant (final)
        spartanId = IdGenerator + spartanCount + SPARTAN_ONSITE_COUNT;
        System.out.println("SpartanId is:: " + spartanId);
        System.out.println("Initializer 1");
    }
    {
        System.out.println("Initializer 2");
    }

    // default constructor
    public Spartan(){
    }

    // parameterized constructor
    public Spartan(String spartanName, int age, String gender) {
        this.spartanName = spartanName;
        this.age = age;
        this.gender = gender;
    }

    public static int totalSpartanCount() {
        return spartanCount + SPARTAN_ONSITE_COUNT;
    }

    public String getSpartanName() {
        return spartanName;
    }

    public void setSpartanName(String spartanName) {
        this.spartanName = spartanName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSpartanCount() {
        return spartanCount;
    }

}
