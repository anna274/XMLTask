package main.entity;

import java.util.ArrayList;

public class Department {
    private String name;
    private String phone;
    private ArrayList<Ward> wards = new ArrayList<>();

    public Department(){}

    public Department(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Ward> getWards() {
        return wards;
    }

    public void setWards(ArrayList<Ward> wards) {
        this.wards = wards;
    }

    public void addWard(Ward ward) {
        wards.add(ward);
    }
}
