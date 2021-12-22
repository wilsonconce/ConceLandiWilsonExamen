package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.entidad.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private LibroFacade ejbLibroFacade;
	
	private List<Libro> list;
	private String nombre;
	private int isbn;
	private int paginas;

	public LibroBean() {
	}

	@PostConstruct
	public void init() {
		list = ejbLibroFacade.findAll();
	}

	public Libro[] getList() {
		// TODO Auto-generated method stub
		return list.toArray(new Libro[0]);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public void setList(List<Libro> list) {
		this.list = list;
	}
	
	public String add() {
		ejbLibroFacade.create(new Libro(this.nombre, this.isbn, this.paginas));
		return null;
	}

	public String delete(Libro l) {
		ejbLibroFacade.remove(l);
		list= ejbLibroFacade.findAll();
		return null;
	}
	public String edit(Libro l) {
		ejbLibroFacade.edit(l);
		l.setEditable(false);
		return null;
	}
}
