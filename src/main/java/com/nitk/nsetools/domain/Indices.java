package com.nitk.nsetools.domain;

public class Indices {
    private String name;
    private String lastPrice;
    private String change;
    private String pChange;
    private String imgFileName;

    public String getName() {
        return name;
    }

    public Indices setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public Indices setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    public String getChange() {
        return change;
    }

    public Indices setChange(String change) {
        this.change = change;
        return this;
    }

    public String getpChange() {
        return pChange;
    }

    public Indices setpChange(String pChange) {
        this.pChange = pChange;
        return this;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public Indices setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
        return this;
    }

    @Override
    public String toString() {
        return "Indices{" +
                "name='" + name + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                ", change='" + change + '\'' +
                ", pChange='" + pChange + '\'' +
                ", imgFileName='" + imgFileName + '\'' +
                '}';
    }
}
