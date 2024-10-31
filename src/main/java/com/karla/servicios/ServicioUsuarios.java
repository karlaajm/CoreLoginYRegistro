package com.karla.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.karla.modelos.Usuario;
import com.karla.modelos.UsuarioLogin;
import com.karla.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	@Autowired
	private final RepositorioUsuarios repositorioUsuario;

	public ServicioUsuarios(RepositorioUsuarios repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
	
	public List<Usuario> obtenerTodosLosUsuarios(){
		return this.repositorioUsuario.findAll();
	}
	
	public Usuario obtenerUsuarioPorId(Long idUsuario) {
		return this.repositorioUsuario.findById(idUsuario).orElse(null);
	}
	
	public Usuario insertarUsuario(Usuario nuevoUsuario) {
		String contraseniaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasenia(), BCrypt.gensalt());
		nuevoUsuario.setContrasenia(contraseniaEncriptada);
		return this.repositorioUsuario.save(nuevoUsuario);
	}
	
	public Usuario obtenerUsuarioParaLogin(String nombreUsuario) {
		return this.repositorioUsuario.findByNombreUsuario(nombreUsuario);
	}
	
	public BindingResult validarRegistro(BindingResult validation, Usuario usuario) {
		if(! usuario.getContrasenia().equals(usuario.getConfirmacionContrasenia())) {
			validation.rejectValue("confirmacionContrasenia", "contraseniasNoCoincide", "Las contraseñas deben de ser iguales.");
		}
		return validation;
	}
	
	public BindingResult validarLogin(BindingResult resultado, UsuarioLogin usuarioLogin) {
		Usuario usuarioExistente = this.repositorioUsuario.findByNombreUsuario(usuarioLogin.getNombreUsuarioLogin());
		if(usuarioExistente == null) {
			resultado.rejectValue("nombreUsuarioLogin", "Missing", "Credenciales incorrectas!");
		}
		else {
			if(! BCrypt.checkpw(usuarioLogin.getContraseniaLogin(), usuarioExistente.getContrasenia())) {
				resultado.rejectValue("contraseniaLogin", "Matches", "Credenciales incorrectas!");
			}
		}
		return resultado;
	}
}