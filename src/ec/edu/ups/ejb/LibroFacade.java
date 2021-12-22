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

	public Libro buscarTitulo(String valor) {
		try {
			String jpql = "SELECT lib FROM Libro lib, Autor au, Capitulo cap WHERE lib.capitulo.titulo='"+valor+"'";
			Libro libro = (Libro) em.createQuery(jpql).getSingleResult();
			return libro;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
