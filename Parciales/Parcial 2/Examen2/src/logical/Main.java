package logical;

public class Main {

	public static void main(String[] args) {
		
		Productos p =new ProductoNorm();
		p.setCodigo("1");
		p.setDias(4);
		p.setIndice(2);
		p.setNombre("Queso");
		p.setPcompra(50);
		p.setPventa(Centro.getCentro().precioVenta());
		Centro.getCentro().registrarProducto(p);
		
		Productos p1 =new ProductosEsc();
		p1.setCodigo("2");
		p1.setDias(12);
		p1.setIndice(2);
		p1.setNombre("Jamon");
		p1.setPcompra(85);
		p1.setPventa(Centro.getCentro().precioVenta());
		Centro.getCentro().registrarProducto(p1);
		
		Productos p2 =new ProductosEsc();
		p2.setCodigo("3");
		p2.setDias(10);
		p2.setIndice(3);
		p2.setNombre("Cloro");
		p2.setPcompra(90);
		p2.setPventa(Centro.getCentro().precioVenta());
		Centro.getCentro().registrarProducto(p2);
		
		for(int i =0; i < Centro.getCentro().getListaproductos().size();i++)
		{
			System.out.println("Nombre: "+Centro.getCentro().getListaproductos().get(i).getNombre() );
			System.out.println("Precio compra: " + Centro.getCentro().getListaproductos().get(i).getPcompra());
			System.out.println("Precio venta " + Centro.getCentro().getListaproductos().get(i).getPventa());
			System.out.println("Dias en oferta: " + Centro.getCentro().getListaproductos().get(i).getDias());
			System.out.println("  " );
			;
		} 
		
		System.out.println("Cantidad de productos escasos: " + Centro.getCentro().cantEsc());

	}

}
