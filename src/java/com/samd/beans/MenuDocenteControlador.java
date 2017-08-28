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
        cerrarSesion.setCommand("#{inicioSesionBean.cerrarSesion()}");

        menuUsuario.addElement(cambiarClave);
        menuUsuario.addElement(cerrarSesion);

        menuDocente.addElement(menuUsuario);

        //*******************************************************************************************************        
        //Menu Principal Gestion de Tema
        DefaultSubMenu menuAdministracionTemas = new DefaultSubMenu("Administracion de Contenido");
        menuAdministracionTemas.setIcon("ui-icon-document");

        // Menu de Tema
        DefaultSubMenu item = new DefaultSubMenu("Tema");
        item.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(item);

        // Sub Menu Ingresar Tema 
        DefaultMenuItem itemTema = new DefaultMenuItem("Ingresar Tema");
        itemTema.setIcon("ui-icon-plus");
        itemTema.setUrl("/Views/docente/ingresarTema.xhtml");
        item.addElement(itemTema);

        //Sub Menu Buscar Temas
        DefaultMenuItem itemBuscoTema = new DefaultMenuItem("Gestionar Temas");
        itemBuscoTema.setIcon("ui-icon-plus");
        itemBuscoTema.setUrl("/Views/docente/gestionarTemas.xhtml");
        item.addElement(itemBuscoTema);

        //*********************************************************************************************************
        //Menu de Teoricos
        DefaultSubMenu itemTeorico = new DefaultSubMenu("Teorico");
        itemTeorico.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(itemTeorico);

        // Sub Menu Ingresar Contenidos Teoricos de Temas 
        DefaultMenuItem itemTeoricos = new DefaultMenuItem("Ingresar Teoricos");
        itemTeoricos.setIcon("ui-icon-plus");
        itemTeoricos.setUrl("/Views/docente/ingresarTeorico.xhtml");
        itemTeorico.addElement(itemTeoricos);

        //Sub Menu Gestionar Teoricos Ingresados
        DefaultMenuItem itemBuscoTeorico = new DefaultMenuItem("Gestionar Teoricos");
        itemBuscoTeorico.setIcon("ui-icon-plus");
        itemBuscoTeorico.setUrl("/Views/docente/gestionarTeorico.xhtml");
        itemTeorico.addElement(itemBuscoTeorico);

        //*************************************************************************************************************
        //Menu de Preguntas
        DefaultSubMenu itemPregunta = new DefaultSubMenu("Preguntas");
        itemPregunta.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(itemPregunta);

        // Sub Menu Ingresar Preguntas 
        DefaultMenuItem itemPreguntas = new DefaultMenuItem("Ingresar Preguntas");
        itemPreguntas.setIcon("ui-icon-plus");
        itemPreguntas.setUrl("/Views/docente/ingresarPregunta.xhtml");
        itemPregunta.addElement(itemPreguntas);

        //Sub Menu Gestionar Preguntas
        DefaultMenuItem itemBuscoPreguntas = new DefaultMenuItem("Gestionar Pregunta");
        itemBuscoPreguntas.setIcon("ui-icon-plus");
        itemBuscoPreguntas.setUrl("/Views/docente/gestionarPregunta.xhtml");
        itemPregunta.addElement(itemBuscoPreguntas);

        //Menu Evaluacion **********************************************************************************************
        //Menu de Evaluacion
        DefaultSubMenu itemEvaluacion = new DefaultSubMenu("Evaluacion");
        itemEvaluacion.setIcon("ui-icon-document-b");
        menuAdministracionTemas.addElement(itemEvaluacion);

        //Sub Menu Nueva Evaluacion 
        DefaultMenuItem itemEvaluaciones = new DefaultMenuItem("Nueva Evaluacion");
        itemEvaluaciones.setIcon("ui-icon-plus");
        itemEvaluaciones.setUrl("/Views/docente/ingresarPregunta.xhtml");
        itemEvaluacion.addElement(itemEvaluaciones);

        //Sub Menu Gestionar Evaluaciones
        DefaultMenuItem itemGestionarEvaluaciones = new DefaultMenuItem("Gestionar Evaluaciones");
        itemGestionarEvaluaciones.setIcon("ui-icon-plus");
        itemGestionarEvaluaciones.setUrl("/Views/docente/gestionarPregunta.xhtml");
        itemEvaluacion.addElement(itemGestionarEvaluaciones);

        menuDocente.addElement(menuAdministracionTemas);

    }

}
