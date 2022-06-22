package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repositiry.TicketRepository;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class TicketManager {
    private TicketRepository repository;

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] searchBy(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.findAll()) {
            if (item.matches(text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                System.arraycopy(ans, 0, tmp, 0, ans.length);
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}


