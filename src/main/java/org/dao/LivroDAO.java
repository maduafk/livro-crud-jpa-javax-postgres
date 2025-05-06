package org.dao;

import javax.persistence.EntityManager;
import org.model.Livro;
import org.principal.JPAUtil;

import java.util.List;

public class LivroDAO {

    private EntityManager em = JPAUtil.getEntityManager();

    public void salvar(Livro livro) {
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
    }

    public Livro buscarPorId(Long id) {
        return em.find(Livro.class, id);
    }

    public List<Livro> listarTodos() {
        return em.createQuery("FROM Livro", Livro.class).getResultList();
    }

    public void atualizar(Livro livro) {
        em.getTransaction().begin();
        em.merge(livro);
        em.getTransaction().commit();
    }

    public void remover(Long id) {
        Livro livro = em.find(Livro.class, id);
        if (livro != null) {
            em.getTransaction().begin();
            em.remove(livro);
            em.getTransaction().commit();
        }
    }
}