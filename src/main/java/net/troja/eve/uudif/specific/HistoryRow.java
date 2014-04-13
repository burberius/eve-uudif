package net.troja.eve.uudif.specific;

import java.util.Date;

public class HistoryRow {
    private Date date;
    private int orders;
    private double low;
    private double high;
    private double average;
    private int quantity;

    public HistoryRow() {
	super();
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public int getOrders() {
	return orders;
    }

    public void setOrders(int orders) {
	this.orders = orders;
    }

    public double getLow() {
	return low;
    }

    public void setLow(double low) {
	this.low = low;
    }

    public double getHigh() {
	return high;
    }

    public void setHigh(double high) {
	this.high = high;
    }

    public double getAverage() {
	return average;
    }

    public void setAverage(double average) {
	this.average = average;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    @Override
    public String toString() {
	return "HistoryRow [date=" + date + ", orders=" + orders + ", low="
		+ low + ", high=" + high + ", average=" + average
		+ ", quantity=" + quantity + "]";
    }

}
