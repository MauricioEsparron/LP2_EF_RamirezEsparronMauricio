package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import pe.com.cibertec.mode.entity.CategoriaProductoEntity;
import pe.com.cibertec.mode.entity.ProductoEntity;
import pe.com.cibertec.service.CategoriaProductoService;
import pe.com.cibertec.service.ProductoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CategoriaProductoService categoriaProductoService;

	@GetMapping("/")
	public String listarProductos(Model model, HttpSession session) {
		String usuarioNombre = (String) session.getAttribute("usuario");
		model.addAttribute("usuario", usuarioNombre); // Pasar al modelo

		List<ProductoEntity> listaProductos = productoService.buscarProductos();
		model.addAttribute("lista_productos", listaProductos);
		return "listar_productos";
	}

	@GetMapping("/registrar_producto")
	public String mostrarRegistrarProducto(Model model) {
		model.addAttribute("producto", new ProductoEntity());
		List<CategoriaProductoEntity> listaCategoriaProductos = categoriaProductoService.buscarCategoriaProductos();
		model.addAttribute("listarCategoriaProducto", listaCategoriaProductos);
		return "registrar_producto";
	}

	@PostMapping("/registrar_producto")
	public String registrarProducto(@ModelAttribute("producto") ProductoEntity productoEntity) {
		productoService.crearProducto(productoEntity);
		return "redirect:/productos/";
	}

	@GetMapping("/detalle_producto/{id}")
	public String verDetalleProducto(Model model, @PathVariable("id") Integer id) {
		ProductoEntity producto = productoService.buscarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "detalle_producto";
	}

	@GetMapping("/editar_producto/{id}")
	public String mostrarActualizarProducto(@PathVariable("id") Integer id, Model model) {
		ProductoEntity producto = productoService.buscarProductoPorId(id);
		List<CategoriaProductoEntity> listaCategoriaProductos = categoriaProductoService.buscarCategoriaProductos();
		model.addAttribute("listarCategoriaProductos", listaCategoriaProductos);
		model.addAttribute("producto", producto);
		return "editar_producto";
	}

	@PostMapping("/editar_producto/{id}")
	public String actualizarProducto(@PathVariable("id") Integer id,
			@ModelAttribute("producto") ProductoEntity producto) {
		productoService.actualizarProducto(id, producto);
		return "redirect:/productos/";
	}

	@GetMapping("/delete/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id) {
		productoService.eliminarProducto(id);
		return "redirect:/productos/";
	}
}
