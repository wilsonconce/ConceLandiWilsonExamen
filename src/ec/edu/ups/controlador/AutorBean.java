package ec.edu.ups.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.entidad.Autor;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean {

    private static final long serialVersionUID = 1L;

    @EJB
    private AutorFacade ejbAutorFacade;
    
    private List<Autor> list;
    private String nombre;
    private String nacionalidad;
    
	public AutorBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		list=ejbAutorFacade.findAll();
	}

	public List<Autor> getList() {
		return list;
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String add() {
		ejbAutorFacade.create(new Autor(this.nombre, this.nacionalidad));
		list = ejbAutorFacade.findAll();
		return null;
	}

}
