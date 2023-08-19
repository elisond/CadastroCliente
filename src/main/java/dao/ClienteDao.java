package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO tabelaclientes VALUES (null, ?, ?, ?, ?)";
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNomeCliente());
			 preparedStatement.setString(2, cliente.getEnderecoCliente());
			 preparedStatement.setString(3, cliente.getModalidadeCliente());
			 preparedStatement.setString(4, cliente.getSituacaoCliente());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct insert on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect insert on database. " + e.getMessage());
		 }
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM tabelaclientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on cliente. " + e.getMessage());
		}
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE tabelaclientes SET nomeCliente=?, enderecoCliente=?, modalidadeCliente=?, situacaoCliente=? WHERE id=?";
		 
		 try {
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 
			 preparedStatement.setString(1, cliente.getNomeCliente());
			 preparedStatement.setString(2, cliente.getEnderecoCliente());
			 preparedStatement.setString(3, cliente.getModalidadeCliente());
			 preparedStatement.setString(4, cliente.getSituacaoCliente());
			 preparedStatement.setInt(5, cliente.getId());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("--correct update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("--incorrect update on database. " + e.getMessage());
		 }
	}
	public static Cliente findByPk(int clienteId) {
		sql = String.format("SELECT * FROM tabelaclientes WHERE id = %d ", clienteId);
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNomeCliente(resultSet.getString("nomeCliente"));
				cliente.setEnderecoCliente(resultSet.getString("enderecoCliente"));
				cliente.setModalidadeCliente(resultSet.getString("modalidadeCliente"));
				cliente.setSituacaoCliente(resultSet.getString("situacaoCliente"));
			}
			
			System.out.println("--correct find by pk clientes");
			return cliente;
			
	} catch(SQLException e) {
		
			System.out.println("--incorrect find by pk clientes. " + e.getMessage());
			return null;
		}
	}
	
public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM tabelaclientes WHERE nomeCliente like '%s%%' ", pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			java.sql.Statement statement = connection.createStatement();
			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNomeCliente(resultSet.getString("nomeCliente"));
				cliente.setEnderecoCliente(resultSet.getString("enderecoCliente"));
				cliente.setModalidadeCliente(resultSet.getString("modalidadeCliente"));
				cliente.setSituacaoCliente(resultSet.getString("situacaoCliente"));
				
				clientes.add(cliente);
				
			}
			
			System.out.println("--correct find clientes");
			return clientes;
			
		} catch(SQLException e) {
			System.out.println("--incorrect find clientes. " + e.getMessage());
			return null;
		}
	
	}
}
