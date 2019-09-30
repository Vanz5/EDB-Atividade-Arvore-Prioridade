package br.com.waldson.aula11;

import java.util.*;

public class Pessoa {
    private String nome;
    private int idade;

    private final List<Event> aux = new ArrayList<>();

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        int idadeAntiga = this.getIdade();
        this.idade = idade;
        for(Event x: aux){
            x.notifyEvent(this,idadeAntiga);
        }
    }

    public void inserirOutro(FilaBanco fila){
        aux.add(fila);
    }

    public void removerOutro(FilaBanco fila){
        aux.remove(fila);
    }
}
