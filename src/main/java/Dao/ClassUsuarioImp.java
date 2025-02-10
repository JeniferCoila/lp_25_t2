package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblUsuario;

public class ClassUsuarioImp {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("T2_Coila");

	public TblUsuario validarUsuario(String usuario, String password) {
		EntityManager em = emf.createEntityManager();
		try {
			TblUsuario user = em
					.createQuery("SELECT u FROM TblUsuario u WHERE u.usuario = :usuario AND u.password = :password",
							TblUsuario.class)
					.setParameter("usuario", usuario).setParameter("password", password).getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

}
