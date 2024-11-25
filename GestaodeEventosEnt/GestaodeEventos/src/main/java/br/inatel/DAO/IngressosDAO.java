package br.inatel.DAO;

import br.inatel.Model.Ingressos;

import java.sql.SQLException;
import java.util.ArrayList;

public class IngressosDAO extends ConnectionDAO {

    // Inserir um ingresso
    public boolean insertIngresso(Ingressos ingresso) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Ingressos (id_ingresso, tipo_ingresso, preco, quantidade, Inscricoes_id_inscricao) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, ingresso.getId_ingresso());
            pst.setString(2, ingresso.getTipo_ingresso());
            pst.setFloat(3, ingresso.getPreco());
            pst.setInt(4, ingresso.getQuantidade());
            pst.setInt(5, ingresso.getInsricoes_id_inscricao());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao inserir ingresso: " + exc.getMessage());
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

    // Atualizar um ingresso
    public boolean updateIngresso(int id, Ingressos ingresso) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Ingressos SET tipo_ingresso = ?, preco = ?, quantidade = ?, Inscricoes_id_inscricao = ? WHERE id_ingresso = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, ingresso.getTipo_ingresso());
            pst.setFloat(2, ingresso.getPreco());
            pst.setInt(3, ingresso.getQuantidade());
            pst.setInt(4, ingresso.getInsricoes_id_inscricao());
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao atualizar ingresso: " + exc.getMessage());
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

    // Excluir um ingresso
    public boolean deleteIngresso(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Ingressos WHERE id_ingresso = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro ao excluir ingresso: " + exc.getMessage());
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

    // Selecionar todos os ingressos
    public ArrayList<Ingressos> selectIngressos() {
        connectToDb();

        ArrayList<Ingressos> ingressos = new ArrayList<>();
        String sql = "SELECT * FROM Ingressos";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de ingressos:");
            while (rs.next()) {
                Ingressos ingressoAux = new Ingressos(
                        rs.getInt("id_ingresso"),
                        rs.getString("tipo_ingresso"),
                        rs.getFloat("preco"),
                        rs.getInt("quantidade"),
                        rs.getInt("Inscricoes_id_inscricao")
                );
                System.out.println("Id: " + ingressoAux.getId_ingresso() +
                        " Tipo: " + ingressoAux.getTipo_ingresso() +
                        " Preço: " + ingressoAux.getPreco() +
                        " Quantidade: " + ingressoAux.getQuantidade() +
                        " Inscrição ID: " + ingressoAux.getInsricoes_id_inscricao());
                System.out.println("--------------------");
                ingressos.add(ingressoAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao listar ingressos: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro ao fechar conexão: " + exc.getMessage());
            }
        }
        return ingressos;
    }
}
