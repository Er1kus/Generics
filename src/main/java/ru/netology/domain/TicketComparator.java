package ru.netology.domain;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket ticket1, Ticket ticket2) {
        return ticket1.getDuration() - ticket2.getDuration();
    }
}
