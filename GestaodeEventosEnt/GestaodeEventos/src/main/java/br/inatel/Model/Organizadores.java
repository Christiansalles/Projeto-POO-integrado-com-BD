package br.inatel.Model;

public class Organizadores {
    private int id_organizador;
    private String nome;
    private String contato;

    public Organizadores(int id_organizador, String nome, String contato) {
        this.id_organizador = id_organizador;
        this.nome = nome;
        this.contato = contato;
    }

    public int getId_organizador() {
        return id_organizador;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}
