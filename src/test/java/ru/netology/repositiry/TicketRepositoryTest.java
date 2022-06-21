package ru.netology.repositiry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket first = new Ticket(12, 12_999, "BAX", "KRR", 240);
    Ticket second = new Ticket(540, 19_999, "AER", "YKS", 600);
    Ticket third = new Ticket(44, 6_199, "VKO", "TJM", 210);
    Ticket forth = new Ticket(774, 7_499, "OVB", "VVO", 300);
    Ticket fifth = new Ticket(29, 14_399, "KGD", "KHV", 450);
    Ticket sixth = new Ticket(65, 4_999, "LED", "ROV", 180);

    @BeforeEach
    void insertData() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);
        repo.save(fifth);
        repo.save(sixth);
    }

    @Test
    public void saveTicketsTest() {

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {first, second, third, forth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTicketById() {
        repo.removeById(540);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {first, third, forth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }
}
