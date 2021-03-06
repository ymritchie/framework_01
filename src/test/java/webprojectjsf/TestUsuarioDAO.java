package webprojectjsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.webprojectjsf.dao.UsuarioDAO;
import br.com.webprojectjsf.entidades.Usuario;
import junit.framework.Assert;

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
	
	@Test
	public void testExcluir() {
		Usuario usu = new Usuario();
		
		usu.setLogin("test");
		usu.setNome("Usuario de test");
		usu.setSenha("12345");
		
		Usuario usuSalvo = dao.salvar(usu);
		
		dao.excluir(usuSalvo);
		
		Usuario usuExclu = dao.buscarPorId(usuSalvo.getId());
		
		Assert.assertEquals(usuExclu, null);
	}
}
