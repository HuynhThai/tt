package com.example.tt.model;

public class ItemType {
    public int Id;
    public String itemtypename;
    public  String itemtypeimage;

    public ItemType(int id, String itemtypename, String itemtypeimage) {
        Id = id;
        this.itemtypename = itemtypename;
        this.itemtypeimage = itemtypeimage;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getItemtypename() {
        return itemtypename;
    }

    public void setItemtypename(String itemtypename) {
        this.itemtypename = itemtypename;
    }

    public String getItemtypeimage() {
        return itemtypeimage;
    }

    public void setItemtypeimage(String itemtypeimage) {
        this.itemtypeimage = itemtypeimage;
    }
}
