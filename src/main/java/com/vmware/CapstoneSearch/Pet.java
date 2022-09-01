package com.vmware.CapstoneSearch;

import javax.persistence.*;

@Entity
@Table(name="pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String zip;
    private String type;
    private String breed;
    private int age;
    private String gender;

    public Pet() {
    }

    public Pet(String type, String name, String zip) {
        this.name = name;
        this.zip = zip;
        this.type = type;
        this.breed = "test";
        this.age = 0;
        this.gender = "test";
    }

    public Pet(String name, String zip, String type, String breed, int age, String gender) {
        this.name = name;
        this.zip = zip;
        this.type = type;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
