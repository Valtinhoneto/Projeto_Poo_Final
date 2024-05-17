package org.example;

interface Autenticavel {
    boolean login(String login, String senha);
    void cadastrar(String nome, String login, String senha, String documento);
}

