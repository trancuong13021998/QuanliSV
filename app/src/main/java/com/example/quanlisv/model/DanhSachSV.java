package com.example.quanlisv.model;

public class DanhSachSV {
    private int masv;
    private String tensv,anhsv,lopsv,khoasv,sodutaikoan;
    private int pass;

    public DanhSachSV() {
    }

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

    public String getSodutaikoan() {
        return sodutaikoan;
    }

    public void setSodutaikoan(String sodutaikoan) {
        this.sodutaikoan = sodutaikoan;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public DanhSachSV(int masv, String tensv, String anhsv, String lopsv, String khoasv, String sodutaikoan, int pass) {
        this.masv = masv;
        this.tensv = tensv;
        this.anhsv = anhsv;
        this.lopsv = lopsv;
        this.khoasv = khoasv;
        this.sodutaikoan = sodutaikoan;
        this.pass = pass;
    }
}
