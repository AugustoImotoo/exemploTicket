package APIALFA.exemploTicket.Service;

import APIALFA.exemploTicket.model.Ticket;
import APIALFA.exemploTicket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public ResponseEntity<List<Ticket>> findByDataAbertura(String dataAbertura, String dataFim) throws ParseException {
        //Filtrando pela data de abertura (Inicial/Final)
        Sort sort = Sort.by("codCliente", "codModulo");
        List<Ticket> ticketsPorData = ticketRepository.findBydataAberturaBetween(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(dataAbertura)), new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(dataFim)), sort);
        return new ResponseEntity<>(ticketsPorData, HttpStatus.OK);
    }

    public ResponseEntity<List<Ticket>> buscarTicketsPorCliente(String codCliente) {
        //Filtrando apenas por cliente, então usando /cliente/1, trará as informações cadastradas com o Cliente 1.
        try {
            List<Ticket> ticketsPorCliente = ticketRepository.findBycodCliente(codCliente);
            if (ticketsPorCliente.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ticketsPorCliente, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Ticket>> buscarTicketsPorModulo(String codModulo) {
        //Filtrando apenas por modulo, então usando /modulo/1, trará as informações cadastradas com o Modulo 1.
        try {
            List<Ticket> ticketsPorModulo = ticketRepository.findBycodModulo(codModulo);
            if (ticketsPorModulo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ticketsPorModulo, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Ticket> createTicket (Ticket ticket) {
        // Método criado para lançamento de um novo Ticket.
        try {
            Ticket novoTicket  = ticketRepository
                    .save(new Ticket(ticket.getTitulo(), ticket.getCodCliente(), ticket.getCodModulo(), ticket.getDataAbertura(), ticket.getDataEncerramento()));
            return new ResponseEntity<>(novoTicket, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
