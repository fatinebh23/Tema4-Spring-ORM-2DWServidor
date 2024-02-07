package ejercicio7;

import java.sql.*;

public class OperacionesCRUDPilotos {
    String endpoint = "ejercicio7.cle2gkk2csmp.us-east-1.rds.amazonaws.com";
    String port = "5432";
    String usuario = "postgres";
    String password = "12345678";
    String urlConexion = "jdbc:postgresql://" + endpoint + ":" + port + "/f12006";
    PreparedStatement consulta;
    public void crearPiloto(Piloto p) {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String insert = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorid) VALUES (?, ?, ?, ?, ?, ?)";
            consulta = con.prepareStatement(insert);
            consulta.setString(1, p.getCode());
            consulta.setString(2, p.getForename());
            consulta.setString(3, p.getSurname());
            consulta.setDate(4, Date.valueOf(String.valueOf(p.getDob())));
            consulta.setString(5, p.getNationality());
            consulta.setInt(6, p.getConstructorid());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void crearEscuderia(Constructor c) {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String insert = "INSERT INTO constructors (constructorref, name, nationality, url) VALUES (?, ?, ?, ?)";
            consulta = con.prepareStatement(insert);
            consulta.setString(1, c.getConstructorref());
            consulta.setString(2, c.getName());
            consulta.setString(3, c.getNationality());
            consulta.setString(4, c.getUrl());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void leerPiloto(int id) {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String select = "SELECT driverid, code, forename, surname, dob AS formatted_dob, nationality " +
                    "FROM drivers " +
                    "WHERE driverid = ? ";
            consulta = con.prepareStatement(select);
            consulta.setInt(1, id);
            ResultSet res = consulta.executeQuery();
            System.out.format("\n%3s%5s%25s%16s%20s\n", "Id", "Cod", "Nombre", "Fecha Nac", "Nacionalidad");
            System.out.println("********************************************************************");
            while (res.next()) {
                System.out.format("%3d%5s%25s%16s%20s\n",
                        res.getInt("driverid"),
                        res.getString("code"),
                        res.getString("forename") + " " + res.getString("surname"),
                        res.getString("formatted_dob"),
                        res.getString("nationality"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void leerPilotos() {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String select = "SELECT driverid, code, forename, surname, dob AS formatted_dob, nationality, constructorid " +
                    "FROM drivers";
            consulta = con.prepareStatement(select);
            ResultSet res = consulta.executeQuery();
            System.out.format("\n%3s%5s%25s%16s%20s%10s\n", "Id", "Cod", "Nombre", "Fecha Nac", "Nacionalidad", "Constructorid");
            System.out.println("********************************************************************");
            while (res.next()) {
                System.out.format("%3d%5s%25s%16s%20s%10s\n",
                        res.getInt("driverid"),
                        res.getString("code"),
                        res.getString("forename") + " " + res.getString("surname"),
                        res.getString("formatted_dob"),
                        res.getString("nationality"),
                        res.getInt("constructorid"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void leerEscuderias() {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String select = "SELECT constructorid, constructorref, name, nationality " +
                    "FROM constructors";
            consulta = con.prepareStatement(select);
            ResultSet res = consulta.executeQuery();
            System.out.format("\n%-15s%-15s%-15s%-15s%n\n", "Id", "Ref", "Nombre", "Nacionalidad");
            System.out.println("********************************************************************");
            while (res.next()) {
                System.out.format("%-15s%-15s%-15s%-15s%n\n",
                        res.getInt("constructorid"),
                        res.getString("constructorref"),
                        res.getString("name"),
                        res.getString("nationality"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void actualizarPiloto(int id, Piloto p) {

        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String update = "UPDATE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ?  WHERE driverid = ?";
            consulta = con.prepareStatement(update);
            consulta.setString(1, p.getCode());
            consulta.setString(2, p.getForename());
            consulta.setString(3, p.getSurname());
            consulta.setDate(4, Date.valueOf(String.valueOf(p.getDob())));
            consulta.setString(5, p.getNationality());
            consulta.setInt(6, id);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void borrarPiloto(int id) {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String update = "DELETE FROM drivers WHERE driverid = ?";
            consulta = con.prepareStatement(update);
            consulta.setInt(1, id);
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void mostrarClasificacionPiloto() {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String mostrarPilotos = "SELECT d.code, SUM(r.points) AS points " +
                    "FROM drivers d " +
                    "INNER JOIN results r " +
                    "ON d.driverid = r.driverid " +
                    "GROUP BY d.driverid " +
                    "ORDER BY SUM(r.points) DESC ";
            consulta = con.prepareStatement(mostrarPilotos);
            ResultSet res = consulta.executeQuery();
            System.out.format("%-15s%-15s%n", "code", "points");
            System.out.println("*********************");
            while (res.next()) {
                System.out.format("%-15s%-15s%n",
                        res.getString("code"),
                        res.getInt("points"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public void mostrarClasificacionConstructores() {
        try (Connection con = DriverManager.getConnection(urlConexion, usuario, password)){
            String mostrarConstrucotres = "SELECT co.name, SUM(r.points) AS points\n" +
                    "FROM constructors co \n" +
                    "INNER JOIN drivers d\n" +
                    "ON co.constructorid = d.constructorid\n" +
                    "INNER JOIN results r\n" +
                    "ON d.driverid = r.driverid\n" +
                    "GROUP BY co.constructorid\n" +
                    "ORDER BY SUM(r.points) DESC";
            consulta = con.prepareStatement(mostrarConstrucotres);
            ResultSet res = consulta.executeQuery();
            System.out.format("%-15s%-15s%n", "name", "points");
            System.out.println("*********************");
            while (res.next()) {
                System.out.format("%-15s%-15s%n",
                        res.getString("name"),
                        res.getInt("points"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
