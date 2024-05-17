package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Motorista, Passageiro e Veículo");
            System.out.println("2 - Validar Login");
            System.out.println("3 - Iniciar Viagem");
            System.out.println("4 - Método de Pagamento");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarPessoa(scanner, pessoas);
                    break;
                case 2:
                    validarLogin(scanner, pessoas);
                    break;
                case 3:
                    iniciarViagem(scanner, pessoas);
                    break;
                case 4:
                    metodoPagamento(scanner, pessoas);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarPessoa(Scanner scanner, List<Pessoa> pessoas) {
        System.out.println("Cadastro:");
        System.out.println("1 - Cadastrar Passageiro");
        System.out.println("2 - Cadastrar Motorista");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                cadastrarPassageiro(scanner, pessoas);
                break;
            case 2:
                cadastrarMotorista(scanner, pessoas);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarPassageiro(Scanner scanner, List<Pessoa> pessoas) {
        Passageiro passageiro = new Passageiro();
        System.out.println("Cadastro de Passageiro:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        passageiro.setNome(nome);
        System.out.print("Login: ");
        String login = scanner.nextLine();
        passageiro.setLogin(login);
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        passageiro.setSenha(senha);
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        passageiro.setDocumento(cpf);
        pessoas.add(passageiro);
        System.out.println("Passageiro cadastrado com sucesso!");
    }

    private static void cadastrarMotorista(Scanner scanner, List<Pessoa> pessoas) {
        Motorista motorista = new Motorista();
        System.out.println("Cadastro de Motorista:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        motorista.setNome(nome);
        System.out.print("Login: ");
        String login = scanner.nextLine();
        motorista.setLogin(login);
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        motorista.setSenha(senha);
        System.out.print("CNH: ");
        String cnh = scanner.nextLine();
        motorista.setDocumento(cnh);

        System.out.println("Cadastro de Veículo:");
        System.out.print("Tipo de Veículo (1 - Carro, 2 - Moto): ");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo;
        if (tipoVeiculo == 1) {
            veiculo = new Carro();
            System.out.print("Número de Portas: ");
            int numeroPortas = scanner.nextInt();
            ((Carro) veiculo).setNumeroPortas(numeroPortas);
        } else if (tipoVeiculo == 2) {
            veiculo = new Moto();
            System.out.print("Tem Bagageiro? (true/false): ");
            boolean temBagageiro = scanner.nextBoolean();
            ((Moto) veiculo).setTemBagageiro(temBagageiro);
        } else {
            System.out.println("Tipo de veículo inválido!");
            return;
        }

        scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        veiculo.setPlaca(placa);
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        veiculo.setModelo(modelo);
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        veiculo.setCor(cor);
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        veiculo.setAno(ano);
        motorista.setVeiculo(veiculo);

        pessoas.add(motorista);
        System.out.println("Motorista cadastrado com sucesso!");
    }


    private static void validarLogin(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getLogin().equals(login) && pessoa.getSenha().equals(senha)) {
                System.out.println("Login efetuado com sucesso!");

                if (pessoa instanceof Passageiro) {
                    System.out.println("Deseja iniciar uma viagem? (1-Sim, 2-Não)");
                    int iniciarViagem = scanner.nextInt();
                    if (iniciarViagem == 1) {
                        // Código para iniciar uma viagem
                        System.out.println("Iniciando viagem...");
                    }
                } else if (pessoa instanceof Motorista) {
                    System.out.println("Deseja aceitar uma viagem? (1-Sim, 2-Não)");
                    int aceitarViagem = scanner.nextInt();
                    if (aceitarViagem == 1) {
                        // Código para aceitar uma viagem
                        System.out.println("Viagem aceita!");
                    }
                }
                return;
            }
        }
        System.out.println("Login inválido!");
    }

    private static void iniciarViagem(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o login do passageiro: ");
        String loginPassageiro = scanner.nextLine();

        Passageiro passageiro = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Passageiro && pessoa.getLogin().equals(loginPassageiro)) {
                passageiro = (Passageiro) pessoa;
                break;
            }
        }

        if (passageiro == null) {
            System.out.println("Passageiro não encontrado!");
            return;
        }

        System.out.print("Digite a localização atual (latitude): ");
        double latitudeAtual = scanner.nextDouble();
        System.out.print("Digite a localização atual (longitude): ");
        double longitudeAtual = scanner.nextDouble();
        Localizacao localizacaoAtual = new Localizacao(latitudeAtual, longitudeAtual);
        passageiro.setLocalizacaoAtual(localizacaoAtual);

        System.out.print("Digite a localização de destino (latitude): ");
        double latitudeDestino = scanner.nextDouble();
        System.out.print("Digite a localização de destino (longitude): ");
        double longitudeDestino = scanner.nextDouble();
        Localizacao localizacaoDestino = new Localizacao(latitudeDestino, longitudeDestino);

        System.out.println("Viagem iniciada do ponto " + localizacaoAtual + " ao ponto " + localizacaoDestino + ".");
    }

    private static void metodoPagamento(Scanner scanner, List<Pessoa> pessoas) {
        System.out.print("Digite o login do passageiro: ");
        String loginPassageiro = scanner.nextLine();

        Passageiro passageiro = null;
        for (Pessoa pessoa : pessoas)
            if (pessoa instanceof Passageiro && pessoa.getLogin().equals(loginPassageiro)) {
                passageiro = (Passageiro) pessoa;
                break;
            }

        if (passageiro == null) {
            System.out.println("Passageiro não encontrado!");
            return;
        }

            System.out.println("Selecione o método de pagamento:");
            System.out.println("1 - Cartão");
            System.out.println("2 - Dinheiro");
            System.out.println("3 - Pix");
            System.out.print("Escolha uma opção: ");
            int opcaoPagamento = scanner.nextInt();

            switch (opcaoPagamento) {
                case 1:
                    System.out.println("Pagamento realizado com Cartão.");
                    break;
                case 2:
                    System.out.println("Pagamento realizado com Dinheiro.");
                    break;
                case 3:
                    System.out.println("Pagamento realizado com Pix.");
                    break;
                default:
                    System.out.println("Opção de pagamento inválida!");
            }
        }
    }
