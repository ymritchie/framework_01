package webprojectjsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.webprojectjsf.dao.DAOException;
import br.com.webprojectjsf.dao.UsuarioDAO;
import br.com.webprojectjsf.entidades.Usuario;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class) //informa quem vai executar
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager")

public class TestUsuarioDAO2 {
	@Autowired
	UsuarioDAO dao;

	
	@Before
	public void init(){
		
	}
	@After
	public void finalizar(){
		
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
	
	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void testExcluir() throws DAOException {
		Usuario usu = new Usuario();
		
		usu.setLogin("test");
		usu.setNome("Usuario de test");
		usu.setSenha("12345");
		
		Usuario usuSalvo = dao.salvar(usu);
		
		//Usuario novoUsu = dao.buscarPorId(usuSalvo.getId());
		
		dao.excluir(usuSalvo);
		
		Usuario usuExclu = dao.buscarPorId(usuSalvo.getId());
		
		Assert.assertEquals(usuExclu, null);
	}
}
