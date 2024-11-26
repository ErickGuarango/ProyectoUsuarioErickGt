package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.example.demo.service.UsuarioService;
import com.example.demo.models.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	
	//inyecciondelservico
	@Autowired
	private UsuarioService usuarioservice;
	
	//Listar 
    @GetMapping
    public List<Usuario> index() {
        return usuarioservice.listaUsuarios();
       
    }
    
    
    @GetMapping("/{id}")
    public Usuario show(@PathVariable Long id) {
        return usuarioservice.obtenerUsuarioPorId(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioservice.crearUsuario(usuario);
    }
    
 // Editar un usuario
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioservice.actualizarUsuario(id, usuario);
    }
    
    // Eliminar un usuario
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioservice.eliminarUsuario(id);
    }
    
    
	

}
