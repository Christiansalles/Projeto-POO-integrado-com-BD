package br.inatel.Model;


import br.inatel.DAO.OrganizadoresDAO;

import java.util.ArrayList;
import java.util.List;

public class Eventos {
    private int id_evento;
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private int ingressos_disponiveis;
    private int ingressos_vendidos;
    private List<Organizadores> organizadoresList;

    public Eventos(int id_evento, String nome, String data, String local, int capacidade, int ingressos_disponiveis) {
        this.id_evento = id_evento;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.ingressos_disponiveis = ingressos_disponiveis;
        this.ingressos_vendidos = capacidade - ingressos_disponiveis;
        //this.organizadoresList = organizadoresList;
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

    public List<Organizadores> getOrganizadoresList() {
        return organizadoresList;
    }

    public void setOrganizadoresList(List<Organizadores> organizadoresList) {
        this.organizadoresList = organizadoresList;
    }
}
