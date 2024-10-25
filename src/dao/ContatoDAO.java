

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import factory.ConnectionFactory;
import model.*;

public class ContatoDAO {

	//CRUD
	
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contato(nome, idade, telefone) VALUES (?, ?, ?)";
		
	    Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = (Connection) ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setString(3, contato.getTelefone());
			
			//executando a query
			
			pstm.execute();
			System.out.println("Contato Salvo");
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			System.out.println("Erro...");
		}finally {
			
			try {
			if(pstm!=null) {
				pstm.close();				
			}
			if(pstm!=null) {
				conn.close();
			}
			}catch (Exception e) {
				
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Contato> read() throws SQLException{
		
		String sql = "SELECT *FROM contato";
		
		List <Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		ResultSet result = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			result = pstm.executeQuery();
			
			while(result.next()) {
				
				Contato contato = new Contato();
				contato.setId(result.getInt("id"));
				contato.setNome(result.getString("nome"));
				contato.setIdade(result.getInt("idade"));
				contato.setTelefone(result.getString("telefone"));
				
				contatos.add(contato);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
			if(result!=null) {
				result.close();
			}
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
			}catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();	
			}
			
			
				
		}
		return contatos;
	}

	public void update(Contato contato) {
		
		String sql = "UPDATE contato SET nome = ?, idade = ?, telefone = ? WHERE id = ?";
				
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setString(3, contato.getTelefone());
			pstm.setInt(4, contato.getId());
			pstm.execute();
			
			System.out.println("Contato atualizado");
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
						
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		
	}

	public void delete(Contato contato) {
		
		String sql = "DELETE FROM contato WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			
			pstm.setInt(1, contato.getId());
			
			pstm.execute();
			
			System.out.println("Contato deletado");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
					
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}

