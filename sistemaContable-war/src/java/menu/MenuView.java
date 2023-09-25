/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import com.sistema.general.entity.Menu;
import com.sistema.general.entity.Smenu;
import com.sistema.general.negocio.MenuFacadeLocal;
import com.sistema.general.negocio.SmenuFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

/**
 *
 * @author UES_BRYAN
 */
@Named(value = "menuView")
@SessionScoped
public class MenuView implements Serializable {

    @EJB
    private SmenuFacadeLocal smenuFacade;

    

    @EJB
    private MenuFacadeLocal menuFacade;
    private List<Menu> menus = new ArrayList();
    private List<Smenu> smenus = new ArrayList();

    private MenuModel model;
    private String currentPage = "bienvenido.xhtml"; // Página predeterminada

    @PostConstruct
    public void init() {
        menus = menuFacade.findAll();
        model = new DefaultMenuModel();
        this.uno();
    }

    public void uno() {
        try {

            for (Menu m : menus) {
                DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label(m.getNombre()).build();
                for (Smenu sm : m.getSmenuList()) {
                    DefaultMenuItem item = DefaultMenuItem.builder().value(sm.getNombre()).command(sm.getInicio()+sm.getUrl()+sm.getFinal1()).update("includePanel").build();
                    secondSubmenu.getElements().add(item);
                }
                model.getElements().add(secondSubmenu);
            }
        } catch (Exception e) {
        }

    }

    public void unos() {
        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Personas").build();

        DefaultMenuItem item = DefaultMenuItem.builder().value("Listar").command("#{menuView.navigate('general/personas/listar.xhtml')}").update("includePanel").build();
        secondSubmenu.getElements().add(item);

        item = DefaultMenuItem.builder().value("Agregar").command("#{menuView.navigate('general/personas/agregar.xhtml')}").update("includePanel").build();
        secondSubmenu.getElements().add(item);
        model.getElements().add(secondSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void navigate(String outcome) {
        // Realiza alguna lógica aquí si es necesario antes de cambiar de página
        // Puedes agregar condicionales u otra lógica según tus necesidades

        // Cambia la página actual
        currentPage = outcome;
    }

}
