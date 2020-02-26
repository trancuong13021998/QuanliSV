package com.example.quanlisv.model;

public class SubFuntion {
   private int img1,img2;
   private String noidung;

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public SubFuntion(int img1, int img2, String noidung) {
        this.img1 = img1;
        this.img2 = img2;
        this.noidung = noidung;
    }
}
