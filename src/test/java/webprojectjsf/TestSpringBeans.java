package webprojectjsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.webprojectjsf.dao.UsuarioDAO;
import br.com.webprojectjsf.entidades.Usuario;

public class TestSpringBeans {
	
	@Test 
	public void testContextSpring() {
		//Criando o Contexto do Spring para carregar os Beans
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
				
		EntityManagerFactory emf = (EntityManagerFactory)ctx.getBean("entityMF");
		//Declarando o Gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
	
		System.out.println(usuarioDAO.buscarPorId(5));
		
		ctx.close();
	}

}
