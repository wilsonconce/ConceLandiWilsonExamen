package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Libro
 *
 */
@Entity
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private int isbn;
	private int paginas;
	@Transient
	private boolean editable;

	public Libro() {
	}

	public Libro(String nombre, int isbn, int paginas) {
		this.nombre = nombre;
		this.isbn = isbn;
		this.paginas = paginas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + isbn;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + paginas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (codigo != other.codigo)
			return false;
		if (isbn != other.isbn)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (paginas != other.paginas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", isbn=" + isbn + ", paginas=" + paginas + "]";
	}

}
