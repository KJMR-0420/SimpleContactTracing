package com.example.finalcontacttracing;

public class basicinfohelperclass {
    String name,age,gender,address,contact;
    String q1,q2,q3;
    String transpo,route;
    String location,duration,position;
    public basicinfohelperclass() {
    }

    public basicinfohelperclass(String name, String age, String gender, String address, String contact, String q1, String q2, String q3, String transpo, String route, String location, String duration, String position) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.transpo = transpo;
        this.route = route;
        this.location = location;
        this.duration = duration;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getTranspo() {
        return transpo;
    }

    public void setTranspo(String transpo) {
        this.transpo = transpo;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
