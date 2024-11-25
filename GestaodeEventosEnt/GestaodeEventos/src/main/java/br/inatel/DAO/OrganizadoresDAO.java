package br.inatel.DAO;

import java.sql.*;

import br.inatel.Model.Organizadores;

import java.sql.SQLException;
import java.util.ArrayList;


public class OrganizadoresDAO extends ConnectionDAO {

    public void conectar(){
        connectToDb();
    }

    public boolean insertOrganizadores(Organizadores organizador) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Organizadores (id_organizador, nome, contato) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, organizador.getId_organizador());
            pst.setString(2, organizador.getNome());
            pst.setString(3, organizador.getContato());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean updateOrganizadores(int id, Organizadores organizador) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Organizadores SET nome = ?, contato = ? WHERE id_organizador = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, organizador.getNome());
            pst.setString(2, organizador.getContato());
            pst.setInt(3, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        }
        finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteOrganizadores(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Organizadores WHERE id_organizador = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Organizadores> selectOrganizadores() {
        connectToDb();

        ArrayList<Organizadores> organizadores = new ArrayList<>();
        String sql = "SELECT * FROM Organizadores";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de eventos:");
            while (rs.next()) {
                Organizadores organizadorAux = new Organizadores(rs.getInt("id_organizador"), rs.getString("nome"), rs.getString("contato"));
                System.out.println("Id: " + organizadorAux.getId_organizador()+ " Nome: " + organizadorAux.getNome()+ " Contato: "+ organizadorAux.getContato());
                System.out.println("--------------------");
                organizadores.add(organizadorAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return organizadores;
    }
}

