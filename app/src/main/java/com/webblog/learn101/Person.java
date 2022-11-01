package com.webblog.learn101;

public class Person {
    private String name;
    private String details;
    private int age;
    private String spfor;
    private String type;
    private int id;

    public Person(String name, String details, int age, String spfor,String t) {
        this.name = name;
        this.details = details;
        this.age = age;
        this.spfor = spfor;
        this.type=t.replace("Add","");
        this.id=0;
    }
    public Person(String name, String details, int age, String spfor){
        this.name = name;
        this.details = details;
        this.age = age;
        this.spfor = spfor;
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return this.details;
    }

    public int getAge() {
        return this.age;
    }

    public String getSpfor() {
        return this.spfor;
    }

    public String getType() {
        return this.type;
    }

    public int getID(){
        return  this.id;
    }

    public void setType(String t){
        this.type=t;
    }
    public void setId(int id){
        this.id=id;
    }
}
