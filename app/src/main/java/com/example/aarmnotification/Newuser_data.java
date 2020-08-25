package com.example.aarmnotification;

import android.widget.EditText;

public class Newuser_data {
    String name,emailid,employid,depertment;

    public Newuser_data() {
    }

    public Newuser_data(String name, String emailid, String employid, String depertment) {
        this.name = name;
        this.emailid = emailid;
        this.employid = employid;
        this.depertment = depertment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getEmployid() {
        return employid;
    }

    public void setEmployid(String employid) {
        this.employid = employid;
    }

    public String getDepertment() {
        return depertment;
    }

    public void setDepertment(String depertment) {
        this.depertment = depertment;
    }
}
