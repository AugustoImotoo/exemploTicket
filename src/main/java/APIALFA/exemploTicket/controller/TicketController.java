package APIALFA.exemploTicket.controller;

import APIALFA.exemploTicket.Service.TicketService;
import APIALFA.exemploTicket.model.Ticket;
import APIALFA.exemploTicket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/ticket/{dataabertura}/{datafim}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> findByDataAbertura(@PathVariable ("dataabertura") String dataAbertura, @PathVariable ("datafim") String dataFim) throws ParseException {
        return ticketService.findByDataAbertura(dataAbertura, dataFim);
    }

    @GetMapping("/cliente/{codcliente}")
    public ResponseEntity<List<Ticket>> buscarTicketsPorCliente(@PathVariable ("codcliente") String codCliente){
        return ticketService.buscarTicketsPorCliente(codCliente);
    }

    @GetMapping("/modulo/{codmodulo}")
    public ResponseEntity<List<Ticket>> buscarTicketsPorModulo(@PathVariable ("codmodulo") String codModulo){
        return ticketService.buscarTicketsPorModulo(codModulo);
    }
    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket (@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }
}
