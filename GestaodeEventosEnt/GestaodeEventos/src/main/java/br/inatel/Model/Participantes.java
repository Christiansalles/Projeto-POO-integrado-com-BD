package br.inatel.Model;

public class Participantes {
    private int id_participante ;
    private String nome;
    private String email;
    private String telefone;

    public Participantes(int id_participante, String nome, String email, String telefone) {
        this.id_participante = id_participante;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId_participante() {
        return id_participante;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


    public String getTelefone() {
        return telefone;
    }
}
