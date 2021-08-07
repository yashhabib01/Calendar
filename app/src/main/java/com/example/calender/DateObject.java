package com.example.calender;

public class DateObject {
    private String Date;
    private String event;
    private boolean isSunday;
    private boolean isEvent;

    public DateObject(String date, String event,boolean isEvent ,boolean isSunday) {
        this.Date = date;
        this.event = event;
        this.isEvent = isEvent;
        this.isSunday = isSunday;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public boolean isSunday() {
        return isSunday;
    }

    public void setSunday(boolean sunday) {
        isSunday = sunday;
    }

    public boolean isEvent() {
        return isEvent;
    }

    public void setEvent(boolean event) {
        isEvent = event;
    }
}
