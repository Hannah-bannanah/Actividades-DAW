package com.itt.maquinaexpendedora;

public class Bebida {

    private String bebida;

    private float precio;

    public Bebida(String bebida, float precio) {

                  this.bebida = bebida;

                  this.precio = precio;

    }

    public float getPrecio() {

                  return this.precio;

    }

    public String getBebida() {

                  return this.bebida;

    }

    @Override

    public String toString() {

          return "Servicio [bebida=" + bebida + ", precio=" + precio + "]";

    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bebida == null) ? 0 : bebida.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
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
		Bebida other = (Bebida) obj;
		if (bebida == null) {
			if (other.bebida != null)
				return false;
		} else if (!bebida.equals(other.bebida))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}
    
    

}