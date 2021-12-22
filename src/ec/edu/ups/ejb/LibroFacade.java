package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Libro;

@Stateless
public class LibroFacade extends AbstractFacade<Libro> {
	@PersistenceContext(unitName = "ConceLandiWilsonExamen")
	private EntityManager em;

	public LibroFacade() {
		// TODO Auto-generated constructor stub
		super(Libro.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
