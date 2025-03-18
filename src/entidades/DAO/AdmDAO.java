package entidades.DAO;

import dataBase.DataBaseConnect;
import entidades.Adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmDAO {
    public static void insertAdm(Adm adm) {
        try (Connection con = DataBaseConnect.getConnection()) {
            String query = "INSERT INTO adm (email, senha, nome, telefone, login) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, adm.getEmail());
            stmt.setString(2, adm.getSenha());
            stmt.setString(3, adm.getNome());
            stmt.setString(4, adm.getTelefone());
            stmt.setString(5, adm.getLogin());

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir administrador");
            System.out.println(e.getMessage());
        }
    }

    public static Adm selectAdmByLogin(String login){
        try(Connection con = DataBaseConnect.getConnection()){
            String query = "call selectAdmByLogin(?);";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, login);
            ResultSet resultQuery = stmt.executeQuery();
            while(resultQuery.next()){
                Adm adm = new Adm(
                        resultQuery.getString("email"),
                        resultQuery.getString("senha"),
                        resultQuery.getString("nome"),
                        resultQuery.getString("telefone"),
                        resultQuery.getString("adm_login")
                );
                adm.setId(resultQuery.getInt("id"));
                return adm;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
