package com.samd.beans;

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
public class MenuAdministradorControlador {

    private MenuModel menuAdminstrador;
    private Fachada fachada;

    public MenuModel getMenuAdminstrador() {
        return menuAdminstrador;
    }

    public MenuAdministradorControlador() {
        fachada = Fachada.getInstancia();
        menuAdminstrador = new DefaultMenuModel();

        //Menu Usuario
        DefaultSubMenu menuUsuario = new DefaultSubMenu("Usuario");
        menuUsuario.setIcon("ui-icon-person");

        DefaultMenuItem cambiarClave = new DefaultMenuItem("Cambiar Contraseña");
        cambiarClave.setIcon("ui-icon-key");
        cambiarClave.setUrl("/Views/cambiarContrasenia.xhtml");

        DefaultMenuItem cerrarSesion = new DefaultMenuItem("Cerrar Sesión");
        cerrarSesion.setIcon("ui-icon-circlesmall-close");
        cerrarSesion.setCommand("#{inicioSesionControlador.cerrarSesion()}");

        menuUsuario.addElement(cambiarClave);
        menuUsuario.addElement(cerrarSesion);

        menuAdminstrador.addElement(menuUsuario);

        //**********************************************+++****************************************************
        //Administración de Usuarios
        DefaultSubMenu menuAdministracionDeUsuarios = new DefaultSubMenu("Administración de Usuarios");
        menuAdministracionDeUsuarios.setIcon("ui-icon-person");

        DefaultMenuItem menuIngresarUsuario = new DefaultMenuItem("Ingresar Usuario");
        menuIngresarUsuario.setIcon("ui-icon-plus");
        menuIngresarUsuario.setUrl("/Views/admin/ingresarUsuarios.xhtml");
        menuAdministracionDeUsuarios.addElement(menuIngresarUsuario);

        DefaultMenuItem menuGestionarUsuarios = new DefaultMenuItem("Gestionar Usuarios");
        menuGestionarUsuarios.setIcon("ui-icon-search");
        menuGestionarUsuarios.setUrl("/Views/admin/gestionarUsuarios.xhtml");
        menuAdministracionDeUsuarios.addElement(menuGestionarUsuarios);

        menuAdminstrador.addElement(menuAdministracionDeUsuarios);

        //******************************************************************************
        //Administración de Contenido
        DefaultSubMenu menuAdministracionDeContenido = new DefaultSubMenu("Administración de Contenido");
        menuAdministracionDeContenido.setIcon("ui-icon-document");

        DefaultSubMenu menuTemas = new DefaultSubMenu("Temas");
        menuTemas.setIcon("ui-icon-document-b");

        DefaultMenuItem menuItemIngresarTemas = new DefaultMenuItem("Ingresar Temas");
        menuItemIngresarTemas.setIcon("ui-icon-plus");
        menuItemIngresarTemas.setUrl("/Views/admin/ingresarTemas.xhtml");
        
        menuTemas.addElement(menuItemIngresarTemas);

        DefaultMenuItem menuItemGestionarTemas = new DefaultMenuItem("Gestionar Temas");
        menuItemGestionarTemas.setIcon("ui-icon-search");
        menuItemGestionarTemas.setUrl("/Views/admin/gestionarTemas.xhtml");
        menuTemas.addElement(menuItemGestionarTemas);

        menuAdministracionDeContenido.addElement(menuTemas);

        DefaultSubMenu menuTeorico = new DefaultSubMenu("Teóricos");
        menuTeorico.setIcon("ui-icon-document-b");

        DefaultMenuItem menuItemIngresarTeorico = new DefaultMenuItem("Ingresar Teóricos");
        menuItemIngresarTeorico.setIcon("ui-icon-plus");
        menuItemIngresarTeorico.setUrl("/Views/admin/ingresarTeoricos.xhtml");
        menuTeorico.addElement(menuItemIngresarTeorico);

        DefaultMenuItem menuItemGestionarTeoricos = new DefaultMenuItem("Gestionar Teóricos");
        menuItemGestionarTeoricos.setIcon("ui-icon-search");
        menuItemGestionarTeoricos.setUrl("/Views/admin/gestionarTeoricos.xhtml");
        menuTeorico.addElement(menuItemGestionarTeoricos);

        menuAdministracionDeContenido.addElement(menuTeorico);

        DefaultSubMenu menuPreguntas = new DefaultSubMenu("Preguntas");
        menuPreguntas.setIcon("ui-icon-document-b");

        DefaultMenuItem menuItemIngresarPreguntas = new DefaultMenuItem("Ingresar Preguntas");
        menuItemIngresarPreguntas.setIcon("ui-icon-plus");
        menuItemIngresarPreguntas.setUrl("/Views/admin/ingresarPreguntas.xhtml");
        menuPreguntas.addElement(menuItemIngresarPreguntas);

        DefaultMenuItem menuItemGestionarPreguntas = new DefaultMenuItem("Gestionar Preguntas");
        menuItemGestionarPreguntas.setIcon("ui-icon-search");
        menuItemGestionarPreguntas.setUrl("/Views/admin/gestionarPreguntas.xhtml");
        menuPreguntas.addElement(menuItemGestionarPreguntas);

        menuAdministracionDeContenido.addElement(menuPreguntas);

        DefaultSubMenu menuEvaluacion = new DefaultSubMenu("Evaluación");
        menuEvaluacion.setIcon("ui-icon-document-b");

        DefaultMenuItem menuItemIngresarEvaluacion = new DefaultMenuItem("Ingresar Evaluación");
        menuItemIngresarEvaluacion.setIcon("ui-icon-plus");
        menuItemIngresarEvaluacion.setUrl("/Views/admin/ingresarEvaluacion.xhtml");
        menuEvaluacion.addElement(menuItemIngresarEvaluacion);

        DefaultMenuItem menuItemGestionarEvaluacion = new DefaultMenuItem("Gestionar Evaluación");
        menuItemGestionarEvaluacion.setIcon("ui-icon-search");
        menuItemGestionarEvaluacion.setUrl("/Views/admin/gestionarEvaluacion.xhtml");
        menuEvaluacion.addElement(menuItemGestionarEvaluacion);

        menuAdministracionDeContenido.addElement(menuEvaluacion);

        menuAdminstrador.addElement(menuAdministracionDeContenido);

        //******************************************************************************************
    }

}
