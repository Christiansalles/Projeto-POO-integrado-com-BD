package br.inatel.Model;

public class Ingressos {
    private int id_ingresso;
    private String tipo_ingresso;
    private float preco;
    private int quantidade;
    private int Insricoes_id_inscricao;

    public Ingressos(int id_ingresso, String tipo_ingresso, float preco, int quantidade, int insricoes_id_inscricao) {
        this.id_ingresso = id_ingresso;
        this.tipo_ingresso = tipo_ingresso;
        this.preco = preco;
        this.quantidade = quantidade;
        Insricoes_id_inscricao = insricoes_id_inscricao;
    }

    public int getId_ingresso() {
        return id_ingresso;
    }

    public void setId_ingresso(int id_ingresso) {
        this.id_ingresso = id_ingresso;
    }

    public String getTipo_ingresso() {
        return tipo_ingresso;
    }

    public void setTipo_ingresso(String tipo_ingresso) {
        this.tipo_ingresso = tipo_ingresso;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getInsricoes_id_inscricao() {
        return Insricoes_id_inscricao;
    }

    public void setInsricoes_id_inscricao(int insricoes_id_inscricao) {
        Insricoes_id_inscricao = insricoes_id_inscricao;
    }
}