package com.nitk.nsetools.domain;

public class Stock {
    public static class Builder{
        private String symbol;
        private String companyName;
        private String series;
        private String dateOfListing;
        private Integer paidUpValue;
        private Integer marketLot;
        private String isinNumber;
        private Integer faceValue;

        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder series(String series) {
            this.series = series;
            return this;
        }

        public Builder dateOfListing(String dateOfListing) {
            this.dateOfListing = dateOfListing;
            return this;
        }

        public Builder paidUpValue(Integer paidUpValue) {
            this.paidUpValue = paidUpValue;
            return this;
        }

        public Builder marketLot(Integer marketLot) {
            this.marketLot = marketLot;
            return this;
        }

        public Builder isinNumber(String isinNumber) {
            this.isinNumber = isinNumber;
            return this;
        }

        public Builder faceValue(Integer faceValue) {
            this.faceValue = faceValue;
            return this;
        }

        public Stock build(){
            Stock stock = new Stock();
            stock.symbol = this.symbol;
            stock.companyName = this.companyName;
            stock.dateOfListing = this.dateOfListing;
            stock.faceValue = this.faceValue;
            stock.isinNumber = this.isinNumber;
            stock.paidUpValue = this.paidUpValue;
            stock.series = this.series;
            stock.marketLot = this.marketLot;
            return stock;
        }
    }
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

    private Stock() {
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