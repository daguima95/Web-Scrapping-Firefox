package application;

public class Cafetera {
	public String nombre;
	public String precio;
	public Cafetera(String nombre, String precio){
		this.nombre = nombre;
		this.precio = precio;
	}
	public Cafetera(){
		
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getPrecio(){
		return this.precio;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setPrecio(String precio){
		this.precio = precio;
	}
}
