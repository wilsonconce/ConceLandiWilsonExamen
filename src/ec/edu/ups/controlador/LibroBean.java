package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.entidad.Autor;
import ec.edu.ups.entidad.Capitulo;
import ec.edu.ups.entidad.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private LibroFacade ejbLibroFacade;
	@EJB
	private CapituloFacade ejbCapituloFacade;
	@EJB
	private AutorFacade ejbAutorFacade;
	
	private List<Libro> list;
	private String nombre;
	private int isbn;
	private int paginas;
	
	private Capitulo capitulo;
	private List<Capitulo> listcap;
	private int numero;
	private String titulo;
	
	private List<Autor> listAutor;
	private Autor autor;
	private String nombreAutor;

	public LibroBean() {
	}

	@PostConstruct
	public void init() {
		list = ejbLibroFacade.findAll();
		listAutor = ejbAutorFacade.findAll();
		listcap = ejbCapituloFacade.findAll();
		
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
	
	public LibroFacade getEjbLibroFacade() {
		return ejbLibroFacade;
	}

	public void setEjbLibroFacade(LibroFacade ejbLibroFacade) {
		this.ejbLibroFacade = ejbLibroFacade;
	}

	public CapituloFacade getEjbCapituloFacade() {
		return ejbCapituloFacade;
	}

	public void setEjbCapituloFacade(CapituloFacade ejbCapituloFacade) {
		this.ejbCapituloFacade = ejbCapituloFacade;
	}

	public AutorFacade getEjbAutorFacade() {
		return ejbAutorFacade;
	}

	public void setEjbAutorFacade(AutorFacade ejbAutorFacade) {
		this.ejbAutorFacade = ejbAutorFacade;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public List<Capitulo> getListcap() {
		return listcap;
	}

	public void setListcap(List<Capitulo> listcap) {
		this.listcap = listcap;
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

	public List<Autor> getListAutor() {
		return listAutor;
	}

	public void setListAutor(List<Autor> listAutor) {
		this.listAutor = listAutor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	

	public String add() {
		
		try {
			Autor autor = ejbAutorFacade.buscarNombre(this.nombreAutor);
			ejbCapituloFacade.create(new Capitulo(this.numero, this.titulo, autor));
			listcap = ejbCapituloFacade.findAll();
			Capitulo capitulo = ejbCapituloFacade.buscarTitulo(this.titulo);
			ejbLibroFacade.create(new Libro(this.nombre, this.isbn, this.paginas, capitulo));
			list = ejbLibroFacade.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "te falta aqui";
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
