package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.Municipio;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class municipioConverte implements Converter<Municipio> {

    @Autowired
    private adminServicio adminServicio;


    @Override
    public Municipio getAsObject(FacesContext context, UIComponent component, String value) {
        Municipio municipio = null;
        try {
            municipio = adminServicio.obtenerMunicipio(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException();
        }

        return municipio;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Municipio value) {
        if(value!=null){
            return ""+value.getIdMunicipio();
        }

        return "";
    }
}
