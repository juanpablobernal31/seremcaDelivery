package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.uniquindio.proyecto.servicios.personaServicio;



import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import java.io.Serializable;

@Component
@ViewScoped
public class loginBean implements Serializable {

    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Autowired
    private final personaServicio personaServicio;
    public loginBean(personaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    private int idPersona;
    private String clave;


    public void login() {
        try {
            Persona buscado = personaServicio.login(clave, idPersona);
            if (buscado.getContrasena().equals(clave)) {
                // Inicio de sesión exitoso
                System.out.println(buscado);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Login Exitoso!");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/index.html");


            } else {
                // Credenciales incorrectas
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos incorrectos!");
                FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeBean", fm);
        }
    }


    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
