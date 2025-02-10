package Dao;

import Interfaces.IProveedor;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.TblProveedor;

public class ClassProveedorImp implements IProveedor{
	
	 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("T2_Coila");

	public void RegistrarProveedor(TblProveedor tblproveedor) {
		EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tblproveedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
		
	}

	public void ActualizarProveedor(TblProveedor tblproveedor) {
		EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tblproveedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
		
	}

	public void EliminarProveedor(TblProveedor tblproveedor) {
		EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TblProveedor proveedor = em.find(TblProveedor.class, tblproveedor.getIdproveedor());
            if (proveedor != null) {
                em.remove(proveedor);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
		
	}

	public List<TblProveedor> ListadoProveedor() {
		EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM TblProveedor t", TblProveedor.class).getResultList();
        } finally {
            em.close();
        }
	}

	public TblProveedor BuscarProveedor(TblProveedor tblproveedor) {
		EntityManager em = emf.createEntityManager();
        try {
            return em.find(TblProveedor.class, tblproveedor.getIdproveedor());
        } finally {
            em.close();
        }
	}

}
