package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Autor;

@Stateless
public class AutorFacade extends AbstractFacade<Autor>{
	@PersistenceContext(unitName = "ConceLandiWilsonExamen")
	private EntityManager em;
	
	public AutorFacade() {
        super(Autor.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
