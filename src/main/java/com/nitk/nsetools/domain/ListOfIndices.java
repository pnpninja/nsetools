package com.nitk.nsetools.domain;

import java.util.List;

public class ListOfIndices {
    private Integer preOpen;
    private String time;
    private Integer corrOpen;
    private String status;
    private String haltedStatus;
    private Integer mktOpen;
    private List<Indices> data;

    public Integer getPreOpen() {
        return preOpen;
    }

    public ListOfIndices setPreOpen(Integer preOpen) {
        this.preOpen = preOpen;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ListOfIndices setTime(String time) {
        this.time = time;
        return this;
    }

    public Integer getCorrOpen() {
        return corrOpen;
    }

    public ListOfIndices setCorrOpen(Integer corrOpen) {
        this.corrOpen = corrOpen;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ListOfIndices setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getHaltedStatus() {
        return haltedStatus;
    }

    public ListOfIndices setHaltedStatus(String haltedStatus) {
        this.haltedStatus = haltedStatus;
        return this;
    }

    public Integer getMktOpen() {
        return mktOpen;
    }

    public ListOfIndices setMktOpen(Integer mktOpen) {
        this.mktOpen = mktOpen;
        return this;
    }

    public List<Indices> getData() {
        return data;
    }

    public ListOfIndices setData(List<Indices> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ListOfIndices{" +
                "preOpen=" + preOpen +
                ", time='" + time + '\'' +
                ", corrOpen=" + corrOpen +
                ", status='" + status + '\'' +
                ", haltedStatus='" + haltedStatus + '\'' +
                ", mktOpen=" + mktOpen +
                ", data=" + data +
                '}';
    }
}
