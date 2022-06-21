package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int duration;

    public Ticket(int id, int price, String departure, String arrival, int duration) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }


    public String getDeparture() {
        return departure;
    }


    public String getArrival() {
        return arrival;
    }


    @Override
    public int compareTo(Ticket otherTicket) {
        if (price < otherTicket.price) {
            return -1;
        }
        if (price > otherTicket.price) {
            return 1;
        }
        return 0;
    }

    public boolean matches(String search) {
        if (getDeparture().matches(search)) {
            return true;
        }
        if (getArrival().contains(search)) {
            return true;
        }
        return false;
    }
}