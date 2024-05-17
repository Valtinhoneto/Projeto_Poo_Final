package org.example;

import java.util.Scanner;

public class MetodoPagamento {

    private Integer id;
    private String nome;
    private String pix;
    private Double cartão;
    private Double dinheiro;

    // criar metodo que pergunta qual a opção de pagamento: cartão, dinheiro, pix

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public Double getCartão() {
        return cartão;
    }

    public void setCartão(Double cartão) {
        this.cartão = cartão;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void selecionarOpcaoPagamento() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a opção de pagamento:");
        System.out.println("1. Cartão");
        System.out.println("2. Dinheiro");
        System.out.println("3. PIX");

        try {
            if (scanner.hasNextInt()) {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Pagamento selecionado: Cartão");
                        break;
                    case 2:
                        System.out.println("Pagamento selecionado: Dinheiro");
                        break;
                    case 3:
                        System.out.println("Pagamento selecionado: PIX");
                        break;
                    default:
                        System.out.println("Opção de pagamento inválida!");
                }
            } else {
                System.out.println("Entrada inválida. Certifique-se de inserir um número inteiro.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número inteiro.");
        } finally {
            scanner.close(); // fechar o scanner após o uso
        }
    }
}


