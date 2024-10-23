package pe.com.cibertec.mode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEntity {

	@Id
	@Column(name = "correo", nullable = false, length = 60)
	private String correo;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "fecha_nacimiento", nullable = false)
	private String fechaNacimiento;

	@Column(name = "url_imagen")
	private String urlImagen;
}