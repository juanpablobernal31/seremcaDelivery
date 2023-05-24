package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.Persona;
import co.edu.uniquindio.proyecto.servicios.personaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class personaConver implements Converter<Persona> {

    @Autowired
    private personaServicio personaServicio;

    @Override
    public Persona getAsObject(FacesContext context, UIComponent component, String value) {
        Persona persona = null;
        try{
            persona= personaServicio.obtenerPersona(Integer.parseInt(value));

        }catch (Exception e){
            throw new RuntimeException();
        }
        return persona;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Persona value) {
        if (value!=null){
            return ""+value.getIdPersona();
        }
        return "";
    }
}
