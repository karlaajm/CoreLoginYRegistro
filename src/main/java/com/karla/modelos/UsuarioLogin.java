package com.karla.modelos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioLogin {
	@NotBlank(message = "Por favor proporciona el nombre de usuario.")
    @Size(min = 3, max = 15, message = "El nombre de usuario debe de contener entre 3 y 15 caracteres.")
    private String nombreUsuarioLogin;

    @NotBlank(message = "Por favor proporciona una contraseña.")
    private String contraseniaLogin;
    
    public UsuarioLogin() {}

	public String getNombreUsuarioLogin() {
		return nombreUsuarioLogin;
	}

	public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
		this.nombreUsuarioLogin = nombreUsuarioLogin;
	}

	public String getContraseniaLogin() {
		return contraseniaLogin;
	}

	public void setContraseniaLogin(String contraseniaLogin) {
		this.contraseniaLogin = contraseniaLogin;
	}

	
}