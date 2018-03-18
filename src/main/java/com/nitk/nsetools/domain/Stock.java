package com.nitk.nsetools.domain;

public class Stock {
    private String symbol;
    private String companyName;
    private String series;
    private String dateOfListing;
    private Integer paidUpValue;
    private Integer marketLot;
    private String isinNumber;
    private Integer faceValue;

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSeries() {
        return series;
    }

    public String getDateOfListing() {
        return dateOfListing;
    }

    public Integer getPaidUpValue() {
        return paidUpValue;
    }

    public Integer getMarketLot() {
        return marketLot;
    }

    public String getIsinNumber() {
        return isinNumber;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public Stock(String symbol, String companyName, String series, String dateOfListing, Integer paidUpValue, Integer marketLot, String isinNumber, Integer faceValue) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.series = series;
        this.dateOfListing = dateOfListing;
        this.paidUpValue = paidUpValue;
        this.marketLot = marketLot;
        this.isinNumber = isinNumber;
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", series='" + series + '\'' +
                ", dateOfListing='" + dateOfListing + '\'' +
                ", paidUpValue=" + paidUpValue +
                ", marketLot=" + marketLot +
                ", isinNumber='" + isinNumber + '\'' +
                ", faceValue=" + faceValue +
                '}';
    }
}
