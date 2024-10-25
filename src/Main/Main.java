package Main;

import java.sql.SQLException;

import dao.ContatoDAO;
import model.Contato;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ContatoDAO contatoDao = new ContatoDAO(); 
		
		   
		  Contato contato = new Contato();
		  
		  contato.setNome("Carlos Neto");
		  contato.setIdade(1); 
		  contato.setTelefone("99996666");
		  contatoDao.save(contato);
		 
		//LEITURA DOS CONTATOS
//		for (Contato c: contatoDao.read() ) {
//			System.out.println(c.toString());
//		}
		  
//		  #####Atualizando o cadastro
//		  contato.setNome("ARTHUR Luiz dos Anjos");
//		  contato.setIdade(4); 
//		  contato.setTelefone("99997777");
//		  contato.setId(2);
//		  
//		  contatoDao.update(contato);
		  
//		  ##### Deletando o cadastro
//		  contato.setNome("ARTHUR Luiz dos Anjos");
//		  contato.setIdade(4); 
//		  contato.setTelefone("99997777");
//		  contato.setId(2);
//		  
//		  contatoDao.delete(contato);
		  
	}

}
