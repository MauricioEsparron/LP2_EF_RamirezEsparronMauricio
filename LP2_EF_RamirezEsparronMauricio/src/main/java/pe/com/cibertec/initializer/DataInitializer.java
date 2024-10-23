package pe.com.cibertec.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pe.com.cibertec.mode.entity.UsuarioEntity;
import pe.com.cibertec.reposity.UsuarioRepository;
import pe.com.cibertec.utils.Utilitarios;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

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
	}

}
