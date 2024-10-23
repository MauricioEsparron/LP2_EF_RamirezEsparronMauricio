package pe.com.cibertec.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productoId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "stock")
	private Integer stock;

	@ManyToOne
	@JoinColumn(name = "categoria_producto", nullable = false)
	private CategoriaProductoEntity categoriaProducto;
}
