package io.hungry.models;


public class FoodRequest {
    private String name;
    private String zip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString(){
        return this.name + " " + this.zip;
    }
}
