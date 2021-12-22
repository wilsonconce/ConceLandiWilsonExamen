package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.entidad.Capitulo;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class CapituloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CapituloFacade ejbCapituloFacade;

	private List<Capitulo> list;
	private int numero;
	private String titulo;

	public CapituloBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		list = ejbCapituloFacade.findAll();
	}

	public List<Capitulo> getList() {
		return list;
	}

	public void setList(List<Capitulo> list) {
		this.list = list;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String add() {
		ejbCapituloFacade.create(new Capitulo(this.numero, this.titulo));
		list = ejbCapituloFacade.findAll();
		return null;
	}
	
	public String delete(Capitulo c) {
		ejbCapituloFacade.remove(c);
		list = ejbCapituloFacade.findAll();
		return null;
	}

	public String edit(Capitulo c) {
		c.setEditable(true);
		return null;
	}
	
	public String save(Capitulo c) {
		ejbCapituloFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
}
