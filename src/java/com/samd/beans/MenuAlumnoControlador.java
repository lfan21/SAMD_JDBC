package com.samd.beans;

import com.samd.excepciones.PersistenciaExcepcion;
import com.samd.fachada.Fachada;
import com.samd.modelo.Tema;
import com.samd.modelo.Teorico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@RequestScoped
public class MenuAlumnoControlador {

    private MenuModel menuAlumno;

    public MenuModel getMenuAlumno() {
        return menuAlumno;
    }
    private final Fachada fachada;

    public MenuAlumnoControlador() throws PersistenciaExcepcion {

        fachada = Fachada.getInstancia();
        menuAlumno = new DefaultMenuModel();

    //Menu Usuario
     DefaultSubMenu menuUsuario = new DefaultSubMenu("Usuario"); 
     menuUsuario.setIcon("ui-icon-person");
     
     DefaultMenuItem cambiarClave = new DefaultMenuItem("Cambiar Contraseña");
     cambiarClave.setIcon("ui-icon-key");
     cambiarClave.setUrl("/Views/cambiarContrasenia.xhtml");
     
     DefaultMenuItem cerrarSesion = new DefaultMenuItem("Cerrar Sesión");
     cerrarSesion.setIcon("ui-icon-circlesmall-close");
     cerrarSesion.setCommand("#{inicioSesionBean.cerrarSesion()}");
     
     
     menuUsuario.addElement(cambiarClave);
     menuUsuario.addElement(cerrarSesion);
             
     
     menuAlumno.addElement(menuUsuario);
   
          
//*******************************************************************************************************        
        
        //Menu Teórico
        DefaultSubMenu menuTeorico = new DefaultSubMenu("Teórico");
        menuTeorico.setIcon("ui-icon-document");

        for (Tema t : fachada.listarTemas()) {
            DefaultSubMenu item = new DefaultSubMenu(t.getNombre());
            item.setIcon("ui-icon-document-b");
            menuTeorico.addElement(item);

            for (Teorico teo : fachada.listarTeoricos()) {

                if (teo.getIdTema() == t.getIdTema()) {
                    DefaultMenuItem itemTeorico = new DefaultMenuItem(teo.getTitulo());
                    item.addElement(itemTeorico);
                }

            }

        }

        menuAlumno.addElement(menuTeorico);
        
        
 //*****************************************************************************************************       

        //Menu Práctico
        DefaultSubMenu menuPractico = new DefaultSubMenu("Práctico");
        menuPractico.setIcon("ui-icon-document");

        for (Tema t : fachada.listarTemas()) {
            DefaultMenuItem itemPractico = new DefaultMenuItem(t.getNombre());
            itemPractico.setIcon("ui-icon-document-b");
            menuPractico.addElement(itemPractico);
        }

        menuAlumno.addElement(menuPractico);    
        
 //*****************************************************************************************************   
    
    //Menu Calificaciones
    

     DefaultSubMenu menuCalificaciones = new DefaultSubMenu("Calificaciones"); 
     menuCalificaciones.setIcon("ui-icon-person");
     
     DefaultMenuItem verPromedio = new DefaultMenuItem("Ver Promedio Calificaciones");
     verPromedio.setIcon("ui-icon-pencil");
     verPromedio.setUrl("#");
     
     DefaultMenuItem verPorTema = new DefaultMenuItem("Ver Calificaciones Por Tema");
     verPorTema.setIcon("ui-icon-pencil");
     verPorTema.setCommand("#");
     
     menuCalificaciones.addElement(verPromedio);
     menuCalificaciones.addElement(verPorTema);
     
     
     
     menuAlumno.addElement(menuCalificaciones);
     
     
     
     

    }
    
             
     
    

}
