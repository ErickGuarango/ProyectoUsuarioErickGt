package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//ListarUsuarios
	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}
	
    //BUSCAR POR ID
	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario usuarioExiste = usuarioRepository.findById(id).orElseGet(null);
		 
		usuarioExiste.setNombre(usuario.getNombre());
		usuarioExiste.setClave(usuario.getClave());
		usuarioExiste.setEmail(usuario.getEmail());
		usuarioExiste.setEstado(usuario.getEstado());
		
		return usuarioRepository.save(usuarioExiste);
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		
		usuarioRepository.delete(usuario);
	}
	

}
