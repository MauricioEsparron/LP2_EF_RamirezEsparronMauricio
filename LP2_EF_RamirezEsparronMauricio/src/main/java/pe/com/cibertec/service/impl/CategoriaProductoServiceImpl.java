package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.cibertec.controller.CategoriaProductoEntity;
import pe.com.cibertec.reposity.CategoriaProductoRepository;
import pe.com.cibertec.service.CategoriaProductoService;

public class CategoriaProductoServiceImpl implements CategoriaProductoService {

	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;

	@Override
	public List<CategoriaProductoEntity> buscarCategoriaProductos() {
		return categoriaProductoRepository.findAll();
	}

	@Override
	public void crearCategoriaProducto(CategoriaProductoEntity categoriaProducto) {
		categoriaProductoRepository.save(categoriaProducto);
	}

	@Override
	public CategoriaProductoEntity buscarCategoriaProductoPorId(Integer id) {
		return categoriaProductoRepository.findById(id).get();

	}

	@Override
	public void actualizarCategoriaProducto(Integer id, CategoriaProductoEntity categoriaActualizada) {
		CategoriaProductoEntity categoriaProductoEncontrado = buscarCategoriaProductoPorId(id);
		if (categoriaProductoEncontrado == null) {
			throw new RuntimeException("categoria no encontrada");
		}
		try {
			categoriaProductoEncontrado.setNombre(categoriaActualizada.getNombre());
		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar", e);
		}
	}

	@Override
	public void eliminarCategoriaProducto(Integer id) {
		CategoriaProductoEntity categoriaProductoEncontrado = buscarCategoriaProductoPorId(id);
		if (categoriaProductoEncontrado == null) {
			throw new RuntimeException("categoria no encontrada");
		}
		categoriaProductoRepository.delete(categoriaProductoEncontrado);
	}
}
