package br.inatel.DAO;

import br.inatel.Model.Eventos;

import java.sql.*;

import java.util.ArrayList;

public class EventosDAO extends ConnectionDAO {

    public void conectar() {
        connectToDb();
    }

    public boolean insertEvento(Eventos evento, int idOrg) {
        connectToDb();

        boolean sucesso;
        String sql = "INSERT INTO Eventos (id_evento, nome, data, local, capacidade, ingressos_disponiveis, ingressos_vendidos, organizadores_id_organizador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, evento.getId_evento());
            pst.setString(2, evento.getNome());
            pst.setString(3, evento.getData());
            pst.setString(4, evento.getLocal());
            pst.setInt(5, evento.getCapacidade());
            pst.setInt(6, evento.getIngressos_disponiveis());
            pst.setInt(7, evento.getIngressos_vendidos());
            pst.setInt(8, idOrg);
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

    public boolean updateEvento(int id, Eventos evento , int idOrg) {
        connectToDb();

        boolean sucesso;
        String sql = "UPDATE Eventos SET nome = ?, data = ?, local = ?, capacidade = ?, ingressos_disponiveis = ?, ingressos_vendidos = ?, organizadores_id_organizador = ? WHERE id_eventos = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getData());
            pst.setString(3, evento.getLocal());
            pst.setInt(4, evento.getCapacidade());
            pst.setInt(5, evento.getIngressos_disponiveis());
            pst.setInt(6, evento.getIngressos_vendidos());
            pst.setInt(7, idOrg);
            pst.setInt(8, id); // Índice ajustado
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

    public boolean deleteEvento(int id) {
        connectToDb();

        boolean sucesso;
        String sql = "DELETE FROM Eventos WHERE id_eventos = ?";
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

    /*
    public ArrayList<Eventos> selectEvento() {
        connectToDb();

        ArrayList<Eventos> eventos = new ArrayList<>();
        String sql = "SELECT * FROM Eventos";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de eventos:");
            while (rs.next()) {
                Eventos eventoAux = new Eventos(rs.getInt("id_eventos"), rs.getString("nome"), rs.getString("data"), rs.getString("local"), rs.getInt("capacidade"), rs.getInt("ingressos_disponiveis"), rs.getInt("ingressos_vendidos"), rs.getInt("Organizadores_id_organizador"));
                System.out.println("Id: "+ eventoAux.getId_evento()+" Nome: " + eventoAux.getNome() + " Data: " + eventoAux.getData()+ " Local: "+eventoAux.getLocal()+" Capacidade: "+ eventoAux.getCapacidade()+" Ingressos Disponíveis: "+eventoAux.getIngressos_disponiveis()+" Ingressos Vendidos: "+eventoAux.getIngressos_vendidos());
                System.out.println("--------------------");
                eventos.add(eventoAux);
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
        return eventos;
    }
     */
}
