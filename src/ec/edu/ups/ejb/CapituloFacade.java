package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Capitulo;

@Stateless
public class CapituloFacade extends AbstractFacade<Capitulo> {

	@PersistenceContext(unitName = "examen")
	private EntityManager em;

	public CapituloFacade() {
		super(Capitulo.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Capitulo buscarTitulo(String nombre) {
		try {
			String jpql = "SELECT cap FROM Capitulo cap WHERE cao.titulo= '"+nombre+"'";
			Capitulo capitulo = (Capitulo) em.createQuery(jpql).getSingleResult();
			return capitulo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
