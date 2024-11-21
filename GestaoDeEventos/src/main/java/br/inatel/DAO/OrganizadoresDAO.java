package br.inatel.DAO;

import java.sql.*;

import br.inatel.Model.Organizadores;

import java.sql.SQLException;
import java.util.ArrayList;


public class OrganizadoresDAO extends ConnectionDAO {
    public boolean insertEvento(Organizadores organizador) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO evento (id, nome, contato) VALUES (?, ?, ?)";
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

    public boolean updateUser(int id, Organizadores organizador) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE usuario SET nome = ?, cpf = ? WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, organizador.getId_organizador());
            pst.setString(2, organizador.getNome());
            pst.setString(3, organizador.getContato());
            pst.setInt(7, id);
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

    public boolean deleteUser(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM evento WHERE id = ?";
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

    public ArrayList<Organizadores> selectUser() {
        connectToDb();

        ArrayList<Organizadores> organizadores = new ArrayList<>();
        String sql = "SELECT * FROM organizadores";
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

