package com.ite.fabricaSpring.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * The persistent class for the PRODUCTOS_EN_PEDIDO database table.
 * 
 */
@Entity
@Table(name="PRODUCTOS_EN_PEDIDO")
@NamedQuery(name="ProductosEnPedido.findAll", query="SELECT p FROM ProductosEnPedido p")
public class ProductosEnPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUM_ORDEN")
	private int numOrden;

	@Column(name="CANTIDAD")
	private int cantidad;

	@Column(name="PRECIO_VENTA")
	private BigDecimal precioVenta;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="ID_PEDIDO")
	private Pedido pedido;

	//uni-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	public ProductosEnPedido() {
	}

	public int getNumOrden() {
		return this.numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProductosEnPedido))
			return false;
		ProductosEnPedido other = (ProductosEnPedido) obj;
		return numOrden == other.numOrden;
	}

	@Override
	public String toString() {
		return "ProductosEnPedido [numOrden=" + numOrden + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta
				+ ", pedido=" + pedido + ", producto=" + producto + "]";
	}

}