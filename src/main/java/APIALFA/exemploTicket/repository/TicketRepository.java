package APIALFA.exemploTicket.repository;

import APIALFA.exemploTicket.model.Ticket;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findBycodCliente(String codcliente);

    List<Ticket> findBycodModulo(String codmodulo);

    List<Ticket> findBydataAberturaBetween(Date dataAbertura, Date dataFim, Sort sort);
}
