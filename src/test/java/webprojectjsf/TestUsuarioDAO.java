package webprojectjsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.webprojectjsf.dao.UsuarioDAO;
import br.com.webprojectjsf.entidades.Usuario;

public class TestUsuarioDAO {
	EntityManager em;
	ClassPathXmlApplicationContext ctx;
	UsuarioDAO dao;

	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory)ctx.getBean("entityMF");
		//Declarando o Gerenciador de entidades
		em = emf.createEntityManager();
		dao = new UsuarioDAO(em);
	}
	@After
	public void finalizar(){
		ctx.close();
	}
	
	@Test
	public void testSalvar(){
		Usuario usu = new Usuario();
		
		usu.setLogin("milder");
		usu.setNome("Milder Mora Ritchie");
		usu.setSenha("12345");
		
		Usuario usuRetorno = dao.salvar(usu);
		
		System.out.println(dao.buscarPorId(usuRetorno.getId()));
		
	}
}
