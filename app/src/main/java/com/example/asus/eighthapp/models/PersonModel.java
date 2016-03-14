package com.example.asus.eighthapp.models;

import java.io.Serializable;

public class PersonModel implements Serializable {
    private String firstName = "";
    private String lastName = "";
    private String gender = "";
    private String age = "";
    private String phoneNumber = "";

    public PersonModel(){
    }

    public PersonModel (String firstName, String phoneNumber){
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    //getters
    public String getFirstName (){
        return firstName;
    }

    public String getLastName (){
        return lastName;
    }

    public String getGender () {
        return gender;
    }

    public String getAge (){
        return age;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    //setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setGender (String gender){
        this.gender = gender;
    }

    public void setAge (String age){
        this.age = age;
    }

    public void setPhoneNumber (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name" + firstName + "Number" + phoneNumber;
    }

    public boolean hasEmptyFields (){
        return firstName.equals("") || lastName.equals("") || gender.equals("")
                ||age.equals("") || phoneNumber.equals("");
    }

}
