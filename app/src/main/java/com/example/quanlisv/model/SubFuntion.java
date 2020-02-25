package com.example.quanlisv.model;

public class SubFuntion {
    private String img1="";
    private String img2="";
    private String noidung="";

    public SubFuntion(String img1, String img2, String noidung) {
        this.img1 = img1;
        this.img2 = img2;
        this.noidung = noidung;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
