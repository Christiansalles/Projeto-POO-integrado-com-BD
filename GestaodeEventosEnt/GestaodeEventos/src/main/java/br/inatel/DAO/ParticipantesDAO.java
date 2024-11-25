package br.inatel.DAO;

import br.inatel.Model.Participantes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParticipantesDAO extends ConnectionDAO {

    // Inserir um participante
    public boolean insertParticipante(Participantes participante) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Participantes (id_participante, nome, email, telefone) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, participante.getId_participante());
            pst.setString(2, participante.getNome());
            pst.setString(3, participante.getEmail());
            pst.setString(4, participante.getTelefone());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir participante: " + exc.getMessage());
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

    // Atualizar um participante
    public boolean updateParticipante(int id, Participantes participante) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Participantes SET nome = ?, email = ?, telefone = ? WHERE id_participante = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, participante.getNome());
            pst.setString(2, participante.getEmail());
            pst.setString(3, participante.getTelefone());
            pst.setInt(4, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar participante: " + exc.getMessage());
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

    // Excluir um participante
    public boolean deleteParticipante(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Participantes WHERE id_participante = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao excluir participante: " + exc.getMessage());
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

    // Selecionar todos os participantes
    public ArrayList<Participantes> selectParticipantes() {
        connectToDb();

        ArrayList<Participantes> participantes = new ArrayList<>();
        String sql = "SELECT * FROM Participantes";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de participantes:");
            while (rs.next()) {
                Participantes participanteAux = new Participantes(
                        rs.getInt("id_participante"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
                System.out.println("Id: " + participanteAux.getId_participante() +
                        " Nome: " + participanteAux.getNome() +
                        " Email: " + participanteAux.getEmail() +
                        " Telefone: " + participanteAux.getTelefone());
                System.out.println("--------------------");
                participantes.add(participanteAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar participantes: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return participantes;
    }
}
