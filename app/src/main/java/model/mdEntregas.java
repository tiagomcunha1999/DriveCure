package model;

public class mdEntregas {

    private Long id;
    private String nomeCliente;
    private String numeroCliente;
    private String moradaCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getMoradaCliente() {
        return moradaCliente;
    }

    public void setMoradaCliente(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    public String getDescricaoEntrega() {
        return descricaoEntrega;
    }

    public void setDescricaoEntrega(String descricaoEntrega) {
        this.descricaoEntrega = descricaoEntrega;
    }

    private String descricaoEntrega;
}
