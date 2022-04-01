package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FAMILIAS database table.
 * 
 */
@Entity
@Table(name="FAMILIAS")
@NamedQuery(name="Familia.findAll", query="SELECT f FROM Familia f")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FAMILIA")
	private int idFamilia;

	@Column(name="DESCRIPCION")
	private String descripcion;

	public Familia() {
	}

	public int getIdFamilia() {
		return this.idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}