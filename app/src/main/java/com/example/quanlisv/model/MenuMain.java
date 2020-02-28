package com.example.quanlisv.model;

public class MenuMain {
    public String anhmenu;
    public String tenmenu;

    public MenuMain(String anhmenu, String tenmenu) {
        this.anhmenu = anhmenu;
        this.tenmenu = tenmenu;
    }

    public String getAnhmenu() {
        return anhmenu;
    }

    public void setAnhmenu(String anhmenu) {
        this.anhmenu = anhmenu;
    }

    public String getTenmenu() {
        return tenmenu;
    }

    public void setTenmenu(String tenmenu) {
        this.tenmenu = tenmenu;
    }
}
