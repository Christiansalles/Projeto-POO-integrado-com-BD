package br.inatel.Model;

public class Inscricoes {
    private int id_inscricao;
    private int Eventos_id_eventos;
    private int Participantes_id_participante;
    private String data_inscricao;
    private int status;

    public Inscricoes(int id_inscricao, int eventos_id_eventos, int participantes_id_participante, String data_inscricao, int status) {
        this.id_inscricao = id_inscricao;
        Eventos_id_eventos = eventos_id_eventos;
        Participantes_id_participante = participantes_id_participante;
        this.data_inscricao = data_inscricao;
        this.status = status;
    }

    public int getId_inscricao() {
        return id_inscricao;
    }

    public void setId_inscricao(int id_inscricao) {
        this.id_inscricao = id_inscricao;
    }

    public int getEventos_id_eventos() {
        return Eventos_id_eventos;
    }

    public void setEventos_id_eventos(int eventos_id_eventos) {
        Eventos_id_eventos = eventos_id_eventos;
    }

    public int getParticipantes_id_participante() {
        return Participantes_id_participante;
    }

    public void setParticipantes_id_participante(int participantes_id_participante) {
        Participantes_id_participante = participantes_id_participante;
    }

    public String getData_inscricao() {
        return data_inscricao;
    }

    public void setData_inscricao(String data_inscricao) {
        this.data_inscricao = data_inscricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}