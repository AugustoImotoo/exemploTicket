package APIALFA.exemploTicket.controller;

import APIALFA.exemploTicket.model.Ticket;
import APIALFA.exemploTicket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public List<Ticket> buscarTodosTickets(){
        Sort sort = Sort.by("codCliente", "codModulo");
        return ticketRepository.findAll(sort);
    }

    @GetMapping("/cliente/{codcliente}")
    public ResponseEntity<List<Ticket>> buscarTicketsPorCliente(@PathVariable ("codcliente") String codCliente){
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

    @GetMapping("/modulo/{codmodulo}")
    public ResponseEntity<List<Ticket>> buscarTicketsPorModulo(@PathVariable ("codmodulo") String codModulo){
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
    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket (@RequestBody Ticket ticket) {
        try {
            Ticket novoTicket  = ticketRepository
                    .save(new Ticket(ticket.getTitulo(), ticket.getCodCliente(), ticket.getCodModulo(), ticket.getDataabertura(), ticket.getDataencerramento()));
            return new ResponseEntity<>(novoTicket, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
