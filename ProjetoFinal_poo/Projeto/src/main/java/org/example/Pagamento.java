package org.example;

public class Pagamento {
    
    private Integer id;
    private Double valor;
    private Boolean StatusPago;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {

        if (valor >= 0){
            this.valor = valor;
        } else {
            System.out.println("Valor invalido");
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        if (id >= 0){
            this.id = id;
        }else{
            System.out.println("Id invalido");
        }

    }


    public Boolean getStatusPago() {
        return StatusPago;
    }

    public void setStatusPago(Boolean statusPago) {
        if (statusPago != null && statusPago) {
            this.StatusPago = true;
        } else {
            System.out.println("Status pago inválido. Deve ser verdadeiro.");
        }
    }



    public void ValidarPagamento(){



        if (id ==null || valor == null || StatusPago == null){
            System.out.println("Valor invalido");
            return;
        }


    }
    
    
}
