package pe.com.cibertec.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.cibertec.mode.entity.CategoriaProductoEntity;
import pe.com.cibertec.mode.entity.ProductoEntity;
import pe.com.cibertec.mode.entity.UsuarioEntity;
import pe.com.cibertec.reposity.CategoriaProductoRepository;
import pe.com.cibertec.reposity.ProductoRepository;
import pe.com.cibertec.reposity.UsuarioRepository;
import pe.com.cibertec.utils.Utilitarios;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void run(String... args) throws Exception {
		insertarDatosIniciales();

	}

	private void insertarDatosIniciales() {

		UsuarioEntity user1 = new UsuarioEntity();
		user1.setCorreo("mau@gmail.com");
		user1.setPassword(Utilitarios.extraerHash("12345")); // Hashear la contraseña
		user1.setNombre("Mauricio");
		user1.setApellido("Ramirez");
		user1.setFechaNacimiento("02/07/2003");
		user1.setUrlImagen("https://mx.pinterest.com/pin/632474341424086584/");

		UsuarioEntity user2 = new UsuarioEntity();
		user2.setCorreo("user@gmail.com");
		user2.setPassword(Utilitarios.extraerHash("12345")); // Hashear la contraseña
		user2.setNombre("Alexa");
		user2.setApellido("Diaz");
		user2.setFechaNacimiento("02/07/2003");
		user2.setUrlImagen("https://mx.pinterest.com/pin/31666003621401263/");

		usuarioRepository.save(user1);
		usuarioRepository.save(user2);

		CategoriaProductoEntity cat1 = new CategoriaProductoEntity();
		cat1.setNombre("MEDICINA");
		CategoriaProductoEntity cat2 = new CategoriaProductoEntity();
		cat2.setNombre("LACTEOS");
		CategoriaProductoEntity cat3 = new CategoriaProductoEntity();
		cat3.setNombre("ENLATADO");
		CategoriaProductoEntity cat4 = new CategoriaProductoEntity();
		cat4.setNombre("GOLOSINA");

		categoriaProductoRepository.save(cat1);
		categoriaProductoRepository.save(cat2);
		categoriaProductoRepository.save(cat3);
		categoriaProductoRepository.save(cat4);

		ProductoEntity prod1 = new ProductoEntity();
		prod1.setNombre("LECHE GLORIA");
		prod1.setPrecio(23.50);
		prod1.setStock(40);
		prod1.setCategoriaProducto(cat2);

		ProductoEntity prod2 = new ProductoEntity();
		prod2.setNombre("ATÚN FLORIDA");
		prod2.setPrecio(7.50);
		prod2.setStock(60);
		prod2.setCategoriaProducto(cat3);

		ProductoEntity prod3 = new ProductoEntity();
		prod3.setNombre("CHOCOLATE");
		prod3.setPrecio(20.30);
		prod3.setStock(12);
		prod3.setCategoriaProducto(cat4);

		ProductoEntity prod4 = new ProductoEntity();
		prod4.setNombre("PARACETAMOL");
		prod4.setPrecio(12.30);
		prod4.setStock(100);
		prod4.setCategoriaProducto(cat1);

		productoRepository.save(prod1);
		productoRepository.save(prod2);
		productoRepository.save(prod3);
		productoRepository.save(prod4);
	}

}
