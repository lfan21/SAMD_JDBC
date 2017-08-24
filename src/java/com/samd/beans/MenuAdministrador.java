
package com.samd.beans;

import com.samd.fachada.Fachada;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.MenuModel;


@ManagedBean
@RequestScoped
public class MenuAdministrador {
    
    private MenuModel menuAdminstrador;
    private  Fachada fachada;

 
    public MenuAdministrador() {
        fachada = Fachada.getInstancia();
        
    }
    
}
