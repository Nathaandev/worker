package entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(Date date, Integer hours, double valuePerHour) {
        this.date = date;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }
    public double totalValue(){
        return valuePerHour * hours;
    }
}
