package pe.com.cibertec.mode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	private Integer productoId;
	private Integer cantidad;
}