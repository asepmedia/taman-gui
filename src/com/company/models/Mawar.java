package com.company.models;

public class Mawar extends Plant {
    @Override
    public String getJenis() {
        return "Mawar";
    }

    @Override
    public String getImagePath() {
        if(this.statusTumbuh == 5) {
            return "img/roses.png";
        }
        return super.getImagePath();
    }
}
