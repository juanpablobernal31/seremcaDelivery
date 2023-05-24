package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.adminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class productoConvert implements Converter<Producto> {

    @Autowired
    private adminServicio adminServicio;

    @Override
    public Producto getAsObject(FacesContext context, UIComponent component, String value) {
        Producto producto = null;
        try {
            producto = adminServicio.obtenerProducto(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException();
        }

        return  producto;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Producto value) {
       if(value!=null){
           return ""+value.getIdProducto();
       }
       return null;
    }
}
