package com.example.project;

public class itemData {
    String itemName;
    String itemType;
    String itemCost;


    public itemData(){

    }

    public itemData(String itemName, String itemType, String itemCost) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }
}
