package com.example.project;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Cartgetset {

    private String name;
    private String type;
    private String cost;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    String documentId;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @ServerTimestamp
    Date timestamp;

    public Cartgetset(){

    }

    public Cartgetset(String name, String type, String cost,Date timestamp,String documentId) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.timestamp = timestamp;
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }




}

