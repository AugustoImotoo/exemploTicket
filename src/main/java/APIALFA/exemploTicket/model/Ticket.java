package APIALFA.exemploTicket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

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
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataAbertura;
    @Column(name = "dataencerramento")
    @JsonFormat (pattern = "dd/MM/yyyy")
    private Date dataEncerramento;


    public Ticket() {

    }

    public Ticket(String titulo, Integer codCliente, Integer codModulo, Date dataAbertura, Date dataEncerramento) {
        Titulo = titulo;
        this.codCliente = codCliente;
        this.codModulo = codModulo;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
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

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
