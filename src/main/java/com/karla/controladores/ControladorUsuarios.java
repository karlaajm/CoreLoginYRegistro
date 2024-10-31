package com.karla.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.karla.modelos.Usuario;
import com.karla.modelos.UsuarioLogin;
import com.karla.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	@Autowired
	private final ServicioUsuarios servicioUsuarios;
	
	public ControladorUsuarios(ServicioUsuarios servicioUsuarios) {
		this.servicioUsuarios = servicioUsuarios;
	}
	
	@ModelAttribute
    public void addAttributes(@ModelAttribute Usuario usuario, @ModelAttribute UsuarioLogin usuarioLogin, Model model) {
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", usuario);
        }
        if (!model.containsAttribute("usuarioLogin")) {
            model.addAttribute("usuarioLogin", usuarioLogin);
        }
    }
	
	@GetMapping("/")
    public String mostrarFormulario(Model model) {
       return "index.jsp";
    }
	
	@GetMapping("/inicio")
    public String inicio(HttpSession session) {
		if(session.getAttribute("id") == null) {
			return "redirect:/";
		}
        return "inicio.jsp";
    }
	
	@PostMapping("/procesa/registro")
    public String registrarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult validation, HttpSession session) {
		validation = this.servicioUsuarios.validarRegistro(validation, usuario);
		if (validation.hasErrors()) {
            return "index.jsp";
        }
        servicioUsuarios.insertarUsuario(usuario);
        session.setAttribute("id", usuario.getId());
        session.setAttribute("correo", usuario.getCorreo());
        session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
        session.setAttribute("fechaDeNacimiento", usuario.getFechaDeNacimiento());
        session.setAttribute("nombreYApellido", usuario.getNombre() + " " + usuario.getApellido());
        return "redirect:/inicio";
    }
	
    
    @PostMapping("/procesa/login")
    public String loginUsuario(@Valid @ModelAttribute UsuarioLogin usuarioLogin, BindingResult validation, HttpSession session, Model model) {
        validation = this.servicioUsuarios.validarLogin(validation, usuarioLogin);
        if(validation.hasErrors()) {
            return "index.jsp";
        }
        Usuario usuario = this.servicioUsuarios.obtenerUsuarioParaLogin(usuarioLogin.getNombreUsuarioLogin());
        session.setAttribute("id", usuario.getId());
        session.setAttribute("correo", usuario.getCorreo());
        session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
        session.setAttribute("fechaDeNacimiento", usuario.getFechaDeNacimiento());
        session.setAttribute("nombreYApellido", usuario.getNombre() + " " + usuario.getApellido());
        return "redirect:/inicio";
    }
    
    @PostMapping("/procesa/logout")
    public String logout(HttpSession sesion) {
    	sesion.invalidate();
    	return "redirect:/";
    }
}
