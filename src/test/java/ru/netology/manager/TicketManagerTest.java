package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repositiry.TicketRepository;


public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);

    Ticket first = new Ticket(12, 12_999, "BAX", "KRR", 240);
    Ticket second = new Ticket(540, 19_999, "AER", "YKS", 600);
    Ticket third = new Ticket(5, 2_999, "LED", "DME", 90);
    Ticket forth = new Ticket(774, 7_499, "OVB", "VVO", 300);
    Ticket fifth = new Ticket(29, 14_399, "KGD", "KHV", 450);
    Ticket sixth = new Ticket(65, 4_999, "LED", "ROV", 180);
    Ticket seventh = new Ticket(39, 2_499, "LED", "DME", 90);
    Ticket eighth = new Ticket(71, 6_300, "LED", "KRR", 150);
    Ticket ninth = new Ticket(44, 6_199, "VKO", "TJM", 210);
    Ticket tenth = new Ticket(88, 3_199, "LED", "DME", 100);
    Ticket eleventh = new Ticket(57, 2_499, "LED", "DME", 90);

    @BeforeEach
    void setData() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

    }

    @Test
    public void shouldShowTicket() {

        Ticket[] actual = manager.findAll("LED", "KRR");
        Ticket[] expected = {eighth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNoTickets() {

        Ticket[] actual = manager.findAll("LED", "SVO");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowSeveralTickets() {

        Ticket[] actual = manager.findAll("LED", "DME");
        Ticket[] expected = {seventh, eleventh, third, tenth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByDeparture() {

        Ticket[] actual = manager.searchBy("LED");
        Ticket[] expected = {third, sixth, seventh, eighth, tenth, eleventh};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTickets() {

        Ticket[] actual = manager.searchBy("SVO");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByArrival() {

        Ticket[] actual = manager.searchBy("TJM");
        Ticket[] expected = {ninth};

        Assertions.assertArrayEquals(expected, actual);
    }
}
