package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Autor;
import ec.edu.ups.entidad.Libro;

@Stateless
public class AutorFacade extends AbstractFacade<Autor>{
	@PersistenceContext(unitName = "examen")
	private EntityManager em;
	
	public AutorFacade() {
        super(Autor.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Libro buscarNombre(String valor) {
		try {
			String jpql = "";
			Libro libro = (Libro) em.createQuery(jpql).getSingleResult();
			return libro;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	

}
