package com.example.aarmnotification;

public class model {
    String name,deptclass,date,totalstudent,classtime,topic,comment;

    public model() {
    }

    public model(String name, String deptclass, String date, String totalstudent, String classtime, String topic, String comment) {
        this.name = name;
        this.deptclass = deptclass;
        this.date = date;
        this.totalstudent = totalstudent;
        this.classtime = classtime;
        this.topic = topic;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptclass() {
        return deptclass;
    }

    public void setDeptclass(String deptclass) {
        this.deptclass = deptclass;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalstudent() {
        return totalstudent;
    }

    public void setTotalstudent(String totalstudent) {
        this.totalstudent = totalstudent;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
