package co.edu.uniquindio.proyecto.converter;


import co.edu.uniquindio.proyecto.entidades.Proveedor;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class proveedorConverte implements Converter<Proveedor> {

    @Autowired
    private adminServicio adminServicio;

    @Override
    public Proveedor getAsObject(FacesContext context, UIComponent component, String value) {
        Proveedor proveedor = null;
        try{

            proveedor= adminServicio.obtenerProveedor(Integer.parseInt(value));

        }catch (Exception e){
            throw new RuntimeException();
        }
        return proveedor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Proveedor value) {
        if (value!=null){
            return ""+value.getIdProveedor();
        }
        return "";
    }
}
