package br.inatel.DAO;

import br.inatel.Model.Inscricoes;

import java.sql.SQLException;
import java.util.ArrayList;

public class InscricoesDAO extends ConnectionDAO {

    // Inserir uma inscrição
    public boolean insertInscricao(Inscricoes inscricao) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Inscricoes (id_inscricao, Eventos_id_eventos, Participantes_id_participante, data_inscricao, status) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, inscricao.getId_inscricao());
            pst.setInt(2, inscricao.getEventos_id_eventos());
            pst.setInt(3, inscricao.getParticipantes_id_participante());
            pst.setString(4, inscricao.getData_inscricao());
            pst.setInt(5, inscricao.getStatus());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir inscrição: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // Atualizar uma inscrição
    public boolean updateInscricao(int id, Inscricoes inscricao) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Inscricoes SET Eventos_id_eventos = ?, Participantes_id_participante = ?, data_inscricao = ?, status = ? WHERE id_inscricao = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, inscricao.getEventos_id_eventos());
            pst.setInt(2, inscricao.getParticipantes_id_participante());
            pst.setString(3, inscricao.getData_inscricao());
            pst.setInt(4, inscricao.getStatus());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar inscrição: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // Excluir uma inscrição
    public boolean deleteInscricao(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Inscricoes WHERE id_inscricao = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao excluir inscrição: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // Selecionar todas as inscrições
    public ArrayList<Inscricoes> selectInscricoes() {
        connectToDb();

        ArrayList<Inscricoes> inscricoes = new ArrayList<>();
        String sql = "SELECT * FROM Inscricoes";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de inscrições:");
            while (rs.next()) {
                Inscricoes inscricaoAux = new Inscricoes(
                        rs.getInt("id_inscricao"),
                        rs.getInt("Eventos_id_eventos"),
                        rs.getInt("Participantes_id_participante"),
                        rs.getString("data_inscricao"),
                        rs.getInt("status")
                );
                System.out.println("Id: " + inscricaoAux.getId_inscricao() +
                        " Evento ID: " + inscricaoAux.getEventos_id_eventos() +
                        " Participante ID: " + inscricaoAux.getParticipantes_id_participante() +
                        " Data: " + inscricaoAux.getData_inscricao() +
                        " Status: " + inscricaoAux.getStatus());
                System.out.println("--------------------");
                inscricoes.add(inscricaoAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar inscrições: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return inscricoes;
    }
}
