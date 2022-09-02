package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Casa;
import bean.Condominio;

public class CasaDAO {
	
	private Connection connection;
	
	public CasaDAO() {
		connection = new FabricaConexoes().getConnection();
	}

	public int inserir(Casa c) {
		int inseriu = 0;
		String sql = "INSERT INTO Casa(numeroCasa, proprietario, nomeCondominio) values (?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getNumeroCasa());
			stmt.setString(2, c.getProprietario());
			stmt.setString(3, c.getNomeCondominio());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public int Remover(int numeroCasa) {
        
		String sql = "DELETE FROM Casa WHERE numeroCasa=(?)";
    	PreparedStatement stmt;
    	int removeu = 0;
    	
        try {
        	stmt = (PreparedStatement) connection.prepareStatement(sql);
        	stmt.setInt(1, numeroCasa);
        	removeu = stmt.executeUpdate();
        	stmt.close();
        } catch(SQLException e) {
        	e.printStackTrace();
        }
        return removeu;
	}
	
	public int Alterar(int numeroCasa, String proprietario, String nomeCondominio) {
		int alterou = 0;
		String sql = "UPDATE Casa SET proprietario=?, nomeCondominio=? WHERE numeroCasa=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, proprietario);
			stmt.setString(2, nomeCondominio);
			stmt.setInt(3, numeroCasa);
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public ArrayList<Casa> getLista(){
		String sql = "SELECT * FROM Casa ORDER BY nomeCondominio;";
		PreparedStatement stmt;
		Casa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Casa> casas = new ArrayList<>();
			while(rs.next()) {
				c = new Casa();
				c.setNumeroCasa(rs.getInt("numeroCasa"));
				c.setProprietario(rs.getString("proprietario"));
				c.setNomeCondominio(rs.getString("nomeCondominio"));
				casas.add(c);
			}
			rs.close();
			stmt.close();
			return casas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Casa> getListaCond(String nomeCond){
		String sql = "SELECT * FROM Casa Where nomeCondominio=? ORDER BY nomeCondominio;";
		PreparedStatement stmt;
		Casa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nomeCond);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Casa> casas = new ArrayList<>();
			while(rs.next()) {
				c = new Casa();
				c.setNumeroCasa(rs.getInt("numeroCasa"));
				c.setProprietario(rs.getString("proprietario"));
				c.setNomeCondominio(rs.getString("nomeCondominio"));
				casas.add(c);
			}
			rs.close();
			stmt.close();
			return casas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
