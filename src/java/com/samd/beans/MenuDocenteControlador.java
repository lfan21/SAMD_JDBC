package com.samd.beans;

import com.samd.fachada.Fachada;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@RequestScoped
public class MenuDocenteControlador {

    private MenuModel menuDocente;

    public MenuModel getMenuDocente() {
        return menuDocente;
    }
    private Fachada fachada;

    public MenuDocenteControlador() {
        fachada = Fachada.getInstancia();
        menuDocente = new DefaultMenuModel();

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

        menuDocente.addElement(menuUsuario);

        //*******************************************************************************************************        
        //Menu Principal Gestion de Tema
        DefaultSubMenu menuAdministracionTemas = new DefaultSubMenu("Administracion de Contenido");
        menuAdministracionTemas.setIcon("ui-icon-document");

        // Menu de Tema
        DefaultSubMenu menuTema = new DefaultSubMenu("Tema");
        menuTema.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(menuTema);

        // Sub Menu Ingresar Tema 
        DefaultMenuItem menuItemIngresartemas = new DefaultMenuItem("Ingresar Tema");
        menuItemIngresartemas.setIcon("ui-icon-plus");
        menuItemIngresartemas.setUrl("/Views/docente/ingresarTemas.xhtml");
        menuTema.addElement(menuItemIngresartemas);

        //Sub Menu Buscar Temas
        DefaultMenuItem menuItemGestionarTemas = new DefaultMenuItem("Gestionar Temas");
        menuItemGestionarTemas.setIcon("ui-icon-plus");
        menuItemGestionarTemas.setUrl("/Views/docente/gestionarTemas.xhtml");
        menuTema.addElement(menuItemGestionarTemas);

        menuDocente.addElement(menuAdministracionTemas);

//        //*********************************************************************************************************
//        //Menu de Teoricos
        DefaultSubMenu menuAdministracionTeorico = new DefaultSubMenu("Teorico");
        menuAdministracionTeorico.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(menuAdministracionTeorico);

        // Sub Menu Ingresar Contenidos Teoricos de Temas 
        DefaultMenuItem menuIngresarTeoricos = new DefaultMenuItem("Ingresar Teoricos");
        menuIngresarTeoricos.setIcon("ui-icon-plus");
        menuIngresarTeoricos.setUrl("/Views/docente/ingresarTeoricos.xhtml");
        menuAdministracionTeorico.addElement(menuIngresarTeoricos);

        //Sub Menu Gestionar Teoricos Ingresados
        DefaultMenuItem menuGestionarTeoricos = new DefaultMenuItem("Gestionar Teoricos");
        menuGestionarTeoricos.setIcon("ui-icon-plus");
        menuGestionarTeoricos.setUrl("/Views/docente/gestionarTeoricos.xhtml");
        menuAdministracionTeorico.addElement(menuGestionarTeoricos);

        menuDocente.addElement(menuAdministracionTeorico);

//        //*************************************************************************************************************
//        //Menu de Preguntas
        DefaultSubMenu menuAdministracionPreguntas = new DefaultSubMenu("Preguntas");
        menuAdministracionPreguntas.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(menuAdministracionPreguntas);

        // Sub Menu Ingresar Preguntas 
        DefaultMenuItem menuIngresarPreguntas = new DefaultMenuItem("Ingresar Preguntas");
        menuIngresarPreguntas.setIcon("ui-icon-plus");
        menuIngresarPreguntas.setUrl("/Views/docente/ingresarPreguntas.xhtml");

        menuAdministracionPreguntas.addElement(menuIngresarPreguntas);

        //Sub Menu Gestionar Preguntas
        DefaultMenuItem menuGestionarPreguntas = new DefaultMenuItem("Gestionar Preguntas");
        menuGestionarPreguntas.setIcon("ui-icon-plus");
        menuGestionarPreguntas.setUrl("/Views/docente/gestionarPreguntas.xhtml");

        menuAdministracionPreguntas.addElement(menuIngresarPreguntas);

        menuDocente.addElement(menuAdministracionPreguntas);
//                
//
//        //   Menu Evaluacion **********************************************************************************************

        DefaultSubMenu menuEvaluaciones = new DefaultSubMenu("Evaluaciones");
        menuEvaluaciones.setIcon("ui-icon-document");

        DefaultMenuItem menuIngresarEvalucion = new DefaultMenuItem("Nueva Evaluacion");
        menuIngresarEvalucion.setIcon("ui-icon-plus");
        menuIngresarEvalucion.setUrl("/Views/docente/ingresarPreguntas.xhtml");
        menuEvaluaciones.addElement(menuIngresarEvalucion);

        DefaultMenuItem menuGestionaEvalucion = new DefaultMenuItem("Gestionar Evaluaciones");
        menuGestionaEvalucion.setIcon("ui-icon-plus");
        menuGestionaEvalucion.setUrl("/Views/docente/gestionarPreguntas.xhtml");
        menuEvaluaciones.addElement(menuGestionaEvalucion);

        menuDocente.addElement(menuEvaluaciones);

    }

}
