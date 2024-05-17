package org.example;

public class Viagem {
    private Motorista motorista;
    private Passageiro passageiro;
    private Localizacao origem;
    private Localizacao destino;
    private String status;
    private int id;

    public void FazerViagem(int id, Motorista motorista, Passageiro passageiro, Localizacao origem, Localizacao destino, String status) {
        this.id = id;
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Localizacao getOrigem() {
        return origem;
    }

    public void setOrigem(Localizacao origem) {
        this.origem = origem;
    }

    public Localizacao getDestino() {
        return destino;
    }

    public void setDestino(Localizacao destino) {
        this.destino = destino;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



