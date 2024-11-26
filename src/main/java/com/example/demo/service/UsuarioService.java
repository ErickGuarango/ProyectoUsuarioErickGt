package com.example.demo.service;

import java.util.List;

import com.example.demo.models.entity.Usuario;

public interface UsuarioService {
	List<Usuario> listaUsuarios();
	Usuario crearUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorId(Long id);
	Usuario actualizarUsuario(Long id ,Usuario usuario);
	void eliminarUsuario(Long id);
	
	

}
