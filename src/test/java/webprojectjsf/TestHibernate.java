package webprojectjsf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.webprojectjsf.dao.UsuarioDAO;
import br.com.webprojectjsf.entidades.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		//Declarando a Fabrica de entidades
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("webprojectjsf");
		
		//Criando o Contexto do Spring para carregar os Beans
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		
		EntityManagerFactory emf = (EntityManagerFactory)ctx.getBean("entityMF");
		//Declarando o Gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		Usuario usu = new Usuario();
		
		usu.setNome("Nicholas Mora Saldanha");
		usu.setLogin("nicholas");
		usu.setSenha("123");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		
			
		usuarioDAO.salvar(usu);
		
		//Usuario usuRetorno = usuarioDAO.buscarPorId(5);
		
		//System.out.println(usuRetorno.toString());
		//usuRetorno.setNome("Samara Saldanha Silva");
		//usuarioDAO.salvar(usuRetorno);
		ctx.close();
	}

}
