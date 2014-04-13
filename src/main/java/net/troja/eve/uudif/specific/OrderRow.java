package net.troja.eve.uudif.specific;

import java.util.Date;

public class OrderRow {
    private double price;
    private int volRemaining;
    private int range;
    private long orderId;
    private int volEntered;
    private int minVolume;
    private boolean bid;
    private Date issueDate;
    private int duration;
    private long stationId;
    private Long solarSystemId;

    public OrderRow() {
	super();
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public int getVolRemaining() {
	return volRemaining;
    }

    public void setVolRemaining(int volRemaining) {
	this.volRemaining = volRemaining;
    }

    public int getRange() {
	return range;
    }

    public void setRange(int range) {
	this.range = range;
    }

    public long getOrderId() {
	return orderId;
    }

    public void setOrderId(long orderId) {
	this.orderId = orderId;
    }

    public int getVolEntered() {
	return volEntered;
    }

    public void setVolEntered(int volEntered) {
	this.volEntered = volEntered;
    }

    public int getMinVolume() {
	return minVolume;
    }

    public void setMinVolume(int minVolume) {
	this.minVolume = minVolume;
    }

    public boolean isBid() {
	return bid;
    }

    public void setBid(boolean bid) {
	this.bid = bid;
    }

    public Date getIssueDate() {
	return issueDate;
    }

    public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
    }

    public int getDuration() {
	return duration;
    }

    public void setDuration(int duration) {
	this.duration = duration;
    }

    public long getStationId() {
	return stationId;
    }

    public void setStationId(long stationId) {
	this.stationId = stationId;
    }

    public Long getSolarSystemId() {
	return solarSystemId;
    }

    public void setSolarSystemId(Long solarSystemId) {
	this.solarSystemId = solarSystemId;
    }

    @Override
    public String toString() {
	return "OrderRow [price=" + price + ", volRemaining=" + volRemaining
		+ ", range=" + range + ", orderId=" + orderId + ", volEntered="
		+ volEntered + ", minVolume=" + minVolume + ", bid=" + bid
		+ ", issueDate=" + issueDate + ", duration=" + duration
		+ ", stationId=" + stationId + ", solarSystemId="
		+ solarSystemId + "]";
    }
}
