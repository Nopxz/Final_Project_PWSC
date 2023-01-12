/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.uaspwsfinalproject;

import finalproject.uaspwsfinalproject.exceptions.NonexistentEntityException;
import finalproject.uaspwsfinalproject.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ASUS
 */
public class B2020wsJpaController implements Serializable {

    public B2020wsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("finalproject_uaspwsfinalproject_jar_0.0.1-SNAPSHOTPU");

    public B2020wsJpaController() {}
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(B2020ws b2020ws) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(b2020ws);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findB2020ws(b2020ws.getId()) != null) {
                throw new PreexistingEntityException("B2020ws " + b2020ws + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(B2020ws b2020ws) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            b2020ws = em.merge(b2020ws);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = b2020ws.getId();
                if (findB2020ws(id) == null) {
                    throw new NonexistentEntityException("The b2020ws with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            B2020ws b2020ws;
            try {
                b2020ws = em.getReference(B2020ws.class, id);
                b2020ws.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The b2020ws with id " + id + " no longer exists.", enfe);
            }
            em.remove(b2020ws);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<B2020ws> findB2020wsEntities() {
        return findB2020wsEntities(true, -1, -1);
    }

    public List<B2020ws> findB2020wsEntities(int maxResults, int firstResult) {
        return findB2020wsEntities(false, maxResults, firstResult);
    }

    private List<B2020ws> findB2020wsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(B2020ws.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public B2020ws findB2020ws(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(B2020ws.class, id);
        } finally {
            em.close();
        }
    }

    public int getB2020wsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<B2020ws> rt = cq.from(B2020ws.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
