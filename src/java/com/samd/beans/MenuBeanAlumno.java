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
public class MenuBeanAlumno {

    private MenuModel menuAlumno;

    public MenuModel getMenuAlumno() {
        return menuAlumno;
    }
    private final Fachada fachada;

    public MenuBeanAlumno() throws PersistenciaExcepcion {

        fachada = Fachada.getInstancia();
        menuAlumno = new DefaultMenuModel();

        //Menu Teórico
        DefaultSubMenu menuTeorico = new DefaultSubMenu("Teórico");

        for (Tema t : fachada.listarTemas()) {
            DefaultSubMenu item = new DefaultSubMenu(t.getNombre());
            item.setIcon("ui-icon-home");
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

        for (Tema t : fachada.listarTemas()) {
            DefaultMenuItem itemPractico = new DefaultMenuItem(t.getNombre());
            itemPractico.setIcon("ui-icon-home");
            menuPractico.addElement(itemPractico);
        }

        menuAlumno.addElement(menuPractico);

    }

}
