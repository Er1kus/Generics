package ru.netology.domain;

import java.util.Objects;

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


    public int getDuration() {
        return duration;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && duration == ticket.duration && Objects.equals(departure, ticket.departure) && Objects.equals(arrival, ticket.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departure, arrival, duration);
    }
}
