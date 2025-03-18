package entidades.DAO;

import entidades.Cliente;
import dataBase.DataBaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public static boolean insertCLiente(Cliente cliente){
        try(Connection con = DataBaseConnect.getConnection()){
            String query = "insert into clientes (nome, email, telefone, cpf, endereco) value (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getEndereco());

            stmt.execute();
            return true;

        }catch (SQLException e){
            System.out.print("Erro: ");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static Cliente selectClientByCPF(String cpf){
        try(Connection connection = DataBaseConnect.getConnection()){
            String query = "call selectClienteByCPF(?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, cpf);

            ResultSet result = stmt.executeQuery();
            while(result.next()){
                return new Cliente(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("telefone"),
                        result.getString("email"),
                        result.getString("endereco"),
                        result.getString("cpf")
                );
            }


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
