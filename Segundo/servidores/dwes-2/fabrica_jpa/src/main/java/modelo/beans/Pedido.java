package modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PEDIDOS database table.
 * 
 */
@Entity
@Table(name="PEDIDOS")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")
	private int idPedido;

	@Column(name="DOMICILIO_ENTREGA")
	private String domicilioEntrega;

	@Column(name="ESTADO")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Usuario usuario;

	//bi-directional many-to-one association to ProductosEnPedido
	@OneToMany(mappedBy="pedido", cascade={CascadeType.PERSIST})
	private List<ProductosEnPedido> productosEnPedidos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getDomicilioEntrega() {
		return this.domicilioEntrega;
	}

	public void setDomicilioEntrega(String domicilioEntrega) {
		this.domicilioEntrega = domicilioEntrega;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductosEnPedido> getProductosEnPedidos() {
		return this.productosEnPedidos;
	}

	public void setProductosEnPedidos(List<ProductosEnPedido> productosEnPedidos) {
		this.productosEnPedidos = productosEnPedidos;
	}

	public ProductosEnPedido addProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().add(productosEnPedido);
		productosEnPedido.setPedido(this);

		return productosEnPedido;
	}

	public ProductosEnPedido removeProductosEnPedido(ProductosEnPedido productosEnPedido) {
		getProductosEnPedidos().remove(productosEnPedido);
		productosEnPedido.setPedido(null);

		return productosEnPedido;
	}

}