package com.example.project;

public class itemData {
    String itemname;
    String itemtype;
    String itemcost;

    public itemData(){

    }

    public itemData(String itemname, String itemtype, String itemcost) {
        this.itemname = itemname;
        this.itemtype = itemtype;
        this.itemcost = itemcost;
    }




    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getItemcost() {
        return itemcost;
    }

    public void setItemcost(String itemcost) {
        this.itemcost = itemcost;
    }


}
