package br.inatel.Model;

public class Eventos {
    int id_evento;
    String nome;
    String data;
    String local;
    int capacidade;
    int ingressos_disponiveis;
    int ingressos_vendidos;

    public Eventos(int id_evento, String nome, String data, String local, int capacidade, int ingressos_disponiveis, int ingressos_vendidos) {
        this.id_evento = id_evento;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.ingressos_disponiveis = ingressos_disponiveis;
        this.ingressos_vendidos = ingressos_vendidos;
    }

    public int getId_evento() {
        return id_evento;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getIngressos_disponiveis() {
        return ingressos_disponiveis;
    }

    public int getIngressos_vendidos() {
        return ingressos_vendidos;
    }
}
