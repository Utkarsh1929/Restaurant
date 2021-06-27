package com.example.project;

public class itemss {
    String name,type;
    String cost;

    public itemss(){

    }
    public itemss(String name, String type, String cost){

        this.name=name;
        this.type=type;
        this.cost=cost;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getCost(){
        return cost;
    }

    public void setCost(String cost){
        this.cost=cost;
    }
}
