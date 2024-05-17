package org.example;

import java.util.Scanner;

public class SignIn {

    private String senha;
    private String nome;


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {

        this.nome = nome;

    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void ValidaLogin(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu login: ");
        this.nome = scanner.nextLine();

        if (nome == null || nome.isEmpty()){
            System.out.println("Invalid Login");
        }


        String [] loginsValidos = {"a","b","c","d","e","f","g","h"};

        boolean loginsEncontrado=false;

        for (String loginsValid : loginsValidos){
            if (nome.equals(loginsValid)){
                loginsEncontrado = true;
                break;
            }

        }

        if (loginsEncontrado){
            System.out.println("login efetuado com sucesso");
        }else {
            System.out.println("Logins inválido");
        }
    }

    public void ValidaSenha(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu senha:");
        this.senha = scanner.nextLine();

        if (nome == null || nome.isEmpty() || senha == null || senha.isEmpty()){
            System.out.println("Invalid Login");
            }


        String [] loginsValidos = {"senha1", "senha2", "senha3", "senha4"};

        boolean loginsEncontrado=false;

        for (String loginsValid : loginsValidos){
            if (senha.equals(loginsValid)){
                loginsEncontrado = true;
                break;
            }

        }

        if (loginsEncontrado){
            System.out.println("login efetuado com sucesso");
        }else {
            System.out.println("Logins inválido");



        }

    }
}
