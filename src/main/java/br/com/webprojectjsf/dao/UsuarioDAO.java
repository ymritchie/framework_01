package br.com.webprojectjsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.webprojectjsf.entidades.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAO(EntityManager em){
		this.em = em;
	}
	
	public Usuario salvar(Usuario usuario){
		em.getTransaction().begin();
		Usuario u = em.merge(usuario);
		em.getTransaction().commit();
		return u;
	}
	
	public void excluir(Usuario usuario){
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarTodos(){
		Query q = em.createQuery("select u from Usuario u");
		return q.getResultList();
	}
}
