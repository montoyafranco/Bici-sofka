package Ticket;

import Bicycle.Bicycle;
import Menu.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    public String code;
    public Bicycle bicycle;
    public User user;
    public LocalDate date;
    public LocalTime initialHour;
    public LocalTime finishHour;
    public boolean hasHelmet;
    public boolean hasDamage;
    public int toPay;
    public String status;

    public Ticket(String code, Bicycle bicycle,
                  User user, LocalDate date, LocalTime initialHour,
                  LocalTime finishHour, boolean hasHelmet, boolean hasDamage,
                  int toPay,
                  String status) {
        this.code = code;
        this.bicycle = bicycle;
        this.user = user;
        this.date = date;
        this.initialHour = initialHour;
        this.finishHour = finishHour;
        this.hasHelmet = hasHelmet;
        this.hasDamage = hasDamage;
        this.toPay = toPay;
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "Code:" + code + '\'' +
                "Bicycle: " + bicycle +
                "User: " + user +
                "Date:" + date +
                "Start Time: " + initialHour +
                "End Time" + finishHour +
                "Have Helmet:" + hasHelmet +
                "good conditions: " + hasDamage +
                "Amont " + toPay +
                "Status: " + status
                ;
    }


    public void setStatusOk() {
        this.status = "OK";
    }
    public void setStatusPending() {
        this.status = "Pending";
    }

    public void setToPayHelmet() {
        this.toPay = this.toPay + 5 ;
    }
    public void setToPayDamage() {
        this.toPay = this.toPay + 5 ;
    }

    public void setHasNoHelmet() {
        this.hasHelmet = false;
    }

    public void setHasDamage(){
        this.hasDamage = true;
    }
    public void calculateAndAdd() {
        int number1,number2;
        number1 = initialHour.getHour()*60 + initialHour.getMinute();number2=finishHour.getHour()*60 + finishHour.getMinute();
      int minusMinutes = number2 - number1 ;
        if (minusMinutes > 60){
            int resultado = (int) (Math.floor(minusMinutes /30) - 1);
            int finalSum = resultado * 3 ;
            this.toPay = this.toPay + finalSum;
        }

    }

}

