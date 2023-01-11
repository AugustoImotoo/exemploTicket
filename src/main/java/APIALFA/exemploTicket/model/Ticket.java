package APIALFA.exemploTicket.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name="ticket_seq", sequenceName="ticket_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ticket_seq")
    private long id;
    private String Titulo;
    @Column(name = "codcliente")
    private Integer codCliente;
    @Column(name = "codmodulo")
    private Integer codModulo;
    @Column(name = "dataabertura")
    private LocalDate dataAbertura;
    @Column(name = "dataencerramento")
    private LocalDate dataEncerramento;

    public Ticket(String titulo, Integer codCliente, Integer codModulo, LocalDate dataabertura, LocalDate dataencerramento) {
        Titulo = titulo;
        this.codCliente = codCliente;
        this.codModulo = codModulo;
        this.dataAbertura = dataabertura;
        this.dataEncerramento = dataencerramento;
    }

    public Ticket() {

    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Integer codModulo) {
        this.codModulo = codModulo;
    }

    public LocalDate getDataabertura() {
        return dataAbertura;
    }

    public void setDataabertura(LocalDate dataabertura) {
        this.dataAbertura = dataabertura;
    }

    public LocalDate getDataencerramento() {
        return dataEncerramento;
    }

    public void setDataencerramento(LocalDate dataencerramento) {
        this.dataEncerramento = dataencerramento;
    }
}
