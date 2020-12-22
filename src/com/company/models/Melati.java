package com.company.models;

public class Melati extends Plant {
    @Override
    public String getJenis() {
        return "Melati";
    }

    @Override
    public String getImagePath() {
        if(this.statusTumbuh == 5) {
            return "img/jasmine.png";
        }
        return super.getImagePath();
    }
}
