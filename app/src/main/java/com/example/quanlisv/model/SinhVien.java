package com.example.quanlisv.model;

public class SinhVien {
    private int masv;
    private String tensv = "";
    private String anhsv = "";
    private String lopsv = "";
    private String sodutaikhoansv = "";
    private String khoasv = "";
    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getAnhsv() {
        return anhsv;
    }

    public void setAnhsv(String anhsv) {
        this.anhsv = anhsv;
    }

    public String getLopsv() {
        return lopsv;
    }

    public void setLopsv(String lopsv) {
        this.lopsv = lopsv;
    }

    public String getKhoasv() {
        return khoasv;
    }

    public void setKhoasv(String khoasv) {
        this.khoasv = khoasv;
    }

    public String getSodutaikhoansv() {
        return sodutaikhoansv;
    }

    public void setSodutaikhoansv(String sodutaikhoansv) {
        this.sodutaikhoansv = sodutaikhoansv;
    }



    public SinhVien(int masv, String anhsv, String lopsv, String khoasv, String sodutaikhoansv) {
        this.masv = masv;
        this.anhsv = anhsv;
        this.lopsv = lopsv;
        this.khoasv = khoasv;
        this.sodutaikhoansv = sodutaikhoansv;
    }


    public SinhVien(int masv, String tensv, String anhsv, String lopsv, String khoasv, String sodutaikhoansv) {
        this.masv = masv;
        this.tensv = tensv;
        this.anhsv = anhsv;
        this.lopsv = lopsv;
        this.khoasv = khoasv;
        this.sodutaikhoansv = sodutaikhoansv;
    }


}
