package crud;

import java.io.Serializable;

public class Gafas implements Serializable {
    private int id;
    private String tipo;
    private double precio;
    private String marca;

    public Gafas(int id, String tipo, double precio, String marca) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Gafas(double precio, String tipo, int id, String marca) {
        this.precio = precio;
        this.tipo = tipo;
        this.id = id;
        this.marca = marca;
    }
}
