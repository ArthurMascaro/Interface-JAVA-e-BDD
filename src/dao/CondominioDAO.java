package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Casa;
import bean.Condominio;

public class CondominioDAO {
	
private Connection connection;
	
	public CondominioDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int Inserir(Condominio c) {
		int inseriu = 0;
		String sql = "INSERT INTO Condominio(nome, qntCasas, cidade) values (?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setInt(2, c.getQntCasas());
			stmt.setString(3, c.getCidade());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int Remover(String nome) {
        
		String sql = "DELETE FROM Condominio WHERE nome=(?)";
    	PreparedStatement stmt;
    	int removeu = 0;
    	
        try {
        	stmt = (PreparedStatement) connection.prepareStatement(sql);
        	stmt.setString(1, nome);
        	removeu = stmt.executeUpdate();
        	stmt.close();
        } catch(SQLException e) {
        	e.printStackTrace();
        }
        return removeu;
	}
	
	public int Alterar(String nome, int qntCasas, String cidade) {
		int alterou = 0;
		String sql = "UPDATE Condominio SET qntCasas=?, cidade=? WHERE nome=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, qntCasas);
			stmt.setString(2, cidade);
			stmt.setString(3, nome);
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Condominio> getLista(){
		String sql = "SELECT * FROM Condominio;";
		PreparedStatement stmt;
		Condominio c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Condominio> condominios = new ArrayList<>();
			while(rs.next()) {
				c = new Condominio();
				c.setNome(rs.getString("Nome"));
				c.setQntCasas(rs.getInt("qntCasas"));
				c.setCidade(rs.getString("cidade"));
				condominios.add(c);
			}
			rs.close();
			stmt.close();
			return condominios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
