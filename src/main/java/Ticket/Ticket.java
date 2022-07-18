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
        return "Ticket{" +
                "code='" + code + '\'' +
                ", bicycle=" + bicycle +
                ", user=" + user +
                ", date=" + date +
                ", initialHour=" + initialHour +
                ", finishHour=" + finishHour +
                ", hasHelmet=" + hasHelmet +
                ", hasDamage=" + hasDamage +
                ", toPay=" + toPay +
                ", status='" + status + '\'' +
                '}';
    }
    public void generateTicket(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("tickets.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

