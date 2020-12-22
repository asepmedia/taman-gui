package com.company.models;

public class Anggrek extends Plant {
    @Override
    public String getJenis() {
        return "Anggrek";
    }

    @Override
    public String getImagePath() {
        if(this.statusTumbuh == 5) {
            return "img/orchid.png";
        }
        return super.getImagePath();
    }
}
