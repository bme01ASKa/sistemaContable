/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.general;

import com.sistema.general.entity.Correlativos;
import com.sistema.general.entity.Email;
import com.sistema.general.entity.Genpersonas;
import com.sistema.general.entity.Gentelefonos;
import com.sistema.general.negocio.CorrelativosFacadeLocal;
import com.sistema.general.negocio.GencorrFacadeLocal;
import com.sistema.general.negocio.GenpersonasFacadeLocal;
import genenral.CodCatalagos;
import genenral.CodCorrelativos;
import genenral.CodModulos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UES_BRYAN
 */
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable {

//<editor-fold defaultstate="collapsed" desc="EJB">
    @EJB
    private CorrelativosFacadeLocal correlativosFacade;
    @EJB
    private GencorrFacadeLocal gencorrFacade;
    @EJB
    private GenpersonasFacadeLocal genpersonasFacade;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="VARIABLES DE PER">

    /**
     * Creates a new instance of PersonaBean
     */
    //variables de persona
    private int tabIndex = 0;
    private boolean visible = false;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Integer idPersonas;
    private Genpersonas persona = new Genpersonas();
    private List<Genpersonas> lstPersonas = new ArrayList();
    private Genpersonas selectedPersona = new Genpersonas();
    List<FacesMessage> messages = new ArrayList<>();
    private String busPrimerNombre = null;
    private String busSegundoNombre = null;
    private String busPrimerApellido = null;
    private String busSegundoApellido = null;
    private Date busFechaNacimiento = null;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="VARIABLES DE CORREO">
    //variables de email
    private String Correo;
    private Integer correosId;
    private Email email;
    private List<Email> lstEmail = new ArrayList();
    private List<SelectItem> itemCorreosList = new ArrayList<>();
    private List<Correlativos> lstCorre = new ArrayList<>();
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="VARIABLES DE TELEFONO">
    private String telefono;
    private Integer telefonoId;
    private Gentelefonos telefonoObj;
    private List<Gentelefonos> lstTelefonos = new ArrayList();
    private List<SelectItem> itemTelefonos = new ArrayList<>();
    private List<Correlativos> lstCorreTelefonos = new ArrayList<>();
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="GET AND SET">

//<editor-fold defaultstate="collapsed" desc="PERSONA">
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public Genpersonas getPersona() {
        return persona;
    }

    public void setPersona(Genpersonas persona) {
        this.persona = persona;
    }

    public String getBusPrimerNombre() {
        return busPrimerNombre;
    }

    public void setBusPrimerNombre(String busPrimerNombre) {
        this.busPrimerNombre = busPrimerNombre;
    }

    public String getBusSegundoNombre() {
        return busSegundoNombre;
    }

    public void setBusSegundoNombre(String busSegundoNombre) {
        this.busSegundoNombre = busSegundoNombre;
    }

    public String getBusPrimerApellido() {
        return busPrimerApellido;
    }

    public void setBusPrimerApellido(String busPrimerApellido) {
        this.busPrimerApellido = busPrimerApellido;
    }

    public String getBusSegundoApellido() {
        return busSegundoApellido;
    }

    public void setBusSegundoApellido(String busSegundoApellido) {
        this.busSegundoApellido = busSegundoApellido;
    }

    public Date getBusFechaNacimiento() {
        return busFechaNacimiento;
    }

    public void setBusFechaNacimiento(Date busFechaNacimiento) {
        this.busFechaNacimiento = busFechaNacimiento;
    }

    public Integer getIdPersonas() {
        return idPersonas;
    }

    public Genpersonas getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Genpersonas selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    public void setIdPersonas(Integer idPersonas) {
        this.idPersonas = idPersonas;
    }

    public List<Genpersonas> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Genpersonas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="CORREOS">

    public List<SelectItem> getItemCorreosList() {
        return itemCorreosList;
    }

    public void setItemCorreosList(List<SelectItem> itemCorreosList) {
        this.itemCorreosList = itemCorreosList;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Integer getCorreosId() {
        return correosId;
    }

    public void setCorreosId(Integer correosId) {
        this.correosId = correosId;
    }

    public List<Email> getLstEmail() {
        return lstEmail;
    }

    public void setLstEmail(List<Email> lstEmail) {
        this.lstEmail = lstEmail;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="TELEFONOS">

    public List<Correlativos> getLstCorre() {
        return lstCorre;
    }

    public void setLstCorre(List<Correlativos> lstCorre) {
        this.lstCorre = lstCorre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public Gentelefonos getTelefonoObj() {
        return telefonoObj;
    }

    public void setTelefonoObj(Gentelefonos telefonoObj) {
        this.telefonoObj = telefonoObj;
    }

    public List<Gentelefonos> getLstTelefonos() {
        return lstTelefonos;
    }

    public void setLstTelefonos(List<Gentelefonos> lstTelefonos) {
        this.lstTelefonos = lstTelefonos;
    }

    public List<Correlativos> getLstCorreTelefonos() {
        return lstCorreTelefonos;
    }

    public void setLstCorreTelefonos(List<Correlativos> lstCorreTelefonos) {
        this.lstCorreTelefonos = lstCorreTelefonos;
    }

    public List<SelectItem> getItemTelefonos() {
        return itemTelefonos;
    }

    public void setItemTelefonos(List<SelectItem> itemTelefonos) {
        this.itemTelefonos = itemTelefonos;
    }
//</editor-fold>

//</editor-fold>
    @PostConstruct
    public void init() {
        lstPersonas = genpersonasFacade.findAll();
    }
//<editor-fold defaultstate="collapsed" desc="AGREGAR DATOS DE PERSONA">
//<editor-fold defaultstate="collapsed" desc="OTROS">

    public PersonaBean() {
    }

    public void nuevoRegistro() {
        this.limpiar();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("modulo", CodModulos.GENERAL.getValue());
        parametros.put("catalogo", CodCatalagos.CORREOS.getValue());
        lstCorre = correlativosFacade.buscarCorrelativosLst(parametros);
        itemCorreosList.add(new SelectItem(0, "Seleccione..."));
        for (Correlativos c : lstCorre) {
            itemCorreosList.add(new SelectItem(c.getCorrelativosPK().getCodCor(), c.getDescripcion()));
        }
        this.visible = true;
        persona.setIdPersonas(gencorrFacade.getNextCorrValue("codper"));
    }

    public void listarPersonas() {
        try {
            lstPersonas = genpersonasFacade.getAllGenpersonas();
        } catch (Exception ex) {
            Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelect(SelectEvent<Genpersonas> event) {
        PrimeFaces.current().executeScript("PF('diaogoPersonaas').show();");
        //  FacesMessage msg = new FacesMessage("Car Selected", event.getObject().getPNombre());
        //    FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void mostrar(){
        if(selectedPersona == null){
            agregarMsj(1, "Seleccione un persona");
            mostrarMsj();
        }else{
            PrimeFaces.current().executeScript("PF('diaogoPersonaas').show();");
        }
         
    }

    public int calcularEdad(Date fechaNacimiento) {
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);
        Calendar fechaActual = Calendar.getInstance();

        int edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNac.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="VALIDACIONES">

    public List<String> validaDatos() {
        List<String> msj = new ArrayList<>();
        if (this.getPrimerNombre() == null || this.getPrimerNombre().trim().isEmpty()) {
            msj.add("Ingrese el primer nombre");
        }
        if (this.getSegundoNombre() == null || this.getSegundoNombre().trim().isEmpty()) {
            msj.add("Ingrese el segundo nombre");
        }
        if (this.getPrimerApellido() == null || this.getPrimerApellido().trim().isEmpty()) {
            msj.add("Ingrese el primer apellido");
        }
        if (this.getSegundoApellido() == null || this.getSegundoApellido().trim().isEmpty()) {
            msj.add("Ingrese el segundo apellido");
        }
        if (this.getFechaNacimiento() == null) {
            msj.add("Ingrese la fecha de nacimiento");
        }
        if (lstEmail == null || lstEmail.isEmpty()) {
            msj.add("Ingrese un tipo de correo");
        }
        return msj;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="GUARDAR">

    public void guardarDatos() {
        try {
            if (validaDatos().isEmpty()) {
                persona.setPNombre(primerNombre);
                persona.setSNombre(segundoNombre);
                persona.setPApellido(primerApellido);
                persona.setSApellido(segundoApellido);
                persona.setFchaNac(fechaNacimiento);
                persona.setEmailList(lstEmail);
                genpersonasFacade.agregarpersona(persona);
                lstPersonas = genpersonasFacade.findAll();
                agregarMsj(1, "Persona Agregada");
                mostrarMsj();
            } else {
                validaDatos().forEach((s) -> {
                    agregarMsj(1, s);
                });
                mostrarMsj();
            }
        } catch (Exception e) {
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="BUSQUEDA">

    public void buscarPersona() {
        try {
            Map<String, Object> parametros = new HashMap<>();

            if (busPrimerNombre != null && !busPrimerNombre.isEmpty()) {
                parametros.put("pNombre", busPrimerNombre);
            }
            if (busSegundoNombre != null && !busSegundoNombre.isEmpty()) {
                parametros.put("sNombre", busSegundoNombre);
            }
            if (busPrimerApellido != null && !busPrimerApellido.isEmpty()) {
                parametros.put("pApellido", busPrimerApellido);
            }
            if (busSegundoApellido != null && !busSegundoApellido.isEmpty()) {
                parametros.put("sApellido", busSegundoApellido);
            }
            if (busFechaNacimiento != null) {
                parametros.put("fchaNac", busFechaNacimiento);
            }

            if (parametros.isEmpty()) {
                agregarMsj(1, "Ingrese un parametro de busqueda");
            } else {
                // Llamada al servicio para obtener las personas según los parámetros
                lstPersonas = genpersonasFacade.buscarPersonasPorParametros(parametros);
                if (lstPersonas.isEmpty()) {
                    agregarMsj(1, "No se encontraron registros");
                } else {
                    agregarMsj(1, "Busqueda relizada");
                }
            }

            mostrarMsj();
        } catch (Exception e) {
        }
        // Aquí puedes hacer lo que necesites con la lista de personas encontradas
        // Por ejemplo, actualización de la lista en tu vista o algún otro procesamiento
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="LIMPIEZA">

    public void limpiar() {
        this.visible = false;
        this.itemCorreosList.clear();
        lstEmail.clear();
        persona = new Genpersonas();
        this.primerNombre = "";
        this.segundoNombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.fechaNacimiento = null;
        this.lstCorre.clear();
        messages.clear();
        agregarMsj(1, "Se limpiaron las variables");
        mostrarMsj();
    }

    public void uno() {
        tabIndex = 1;
    }

    public void dos() {
        tabIndex = 2;
    }

    public void tres() {
        tabIndex = 3;
    }

    public void limpiarBusqueda() {
        lstPersonas = genpersonasFacade.findAll();
        busPrimerNombre = null;
        busSegundoNombre = null;
        busPrimerApellido = null;
        busSegundoApellido = null;
        busFechaNacimiento = null;
        agregarMsj(1, "Se limpiaron las variables de busqueda");
        mostrarMsj();
    }
//</editor-fold>

    public void eliminar() {
        if (selectedPersona != null) {
            this.genpersonasFacade.remove(selectedPersona);
            this.selectedPersona = new Genpersonas();
            this.lstPersonas = genpersonasFacade.findAll();
            agregarMsj(1, "Persona eliminada");
            mostrarMsj();
        } else {
            agregarMsj(1, "Seleccione un persona a eliminar");
            mostrarMsj();
        }
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="AGREGAR CORREOS DE PERSONAS">

    public void agregarCorreos() {
        Correlativos correlativo = new Correlativos();
        boolean existe = false;
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("modulo", CodModulos.GENERAL.getValue());
        parametros.put("catalogo", CodCatalagos.CORREOS.getValue());
        parametros.put("correlativo", correosId);
        if (!lstEmail.isEmpty()) {
            for (Email e : lstEmail) {
                if (e.getEmailPK().getCorEmail() == correosId) {
                    existe = true;
                    agregarMsj(1, "Ya existe el tipo correo : " + e.getCorrelativos().getDescripcion());
                }
            }
        }
        if (correosId == 0) {
            agregarMsj(1, "Seleccione un tipo de correo");
        } else {
            if (!existe) {
                email = new Email(persona.getIdPersonas(), CodModulos.GENERAL.getValue(),
                        CodCatalagos.CORREOS.getValue(), correosId);
                correlativo = correlativosFacade.buscarCorrelativos(parametros);
                email.setEmail(Correo);
                email.setCorrelativos(correlativo);
                email.setCorrelativos(correlativo);
                lstEmail.add(email);
                agregarMsj(1, "Correo agregado");
            }
        }
        mostrarMsj();
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="MENSAJES">

    public void mostrarMsj() {
        PrimeFaces.current().executeScript("PF('dlg1').show();");
        FacesContext context = FacesContext.getCurrentInstance();
        for (FacesMessage message : messages) {
            context.addMessage(null, message);
        }
        messages.clear();
    }

    public void agregarMsj(int numero, String msj) {
        switch (numero) {
            case 1:
                messages.add(new FacesMessage(FacesMessage.SEVERITY_INFO, null, msj));
                break;
            case 2:
                messages.add(new FacesMessage(FacesMessage.SEVERITY_WARN, null, msj));
                break;
            case 3:
                messages.add(new FacesMessage(FacesMessage.SEVERITY_FATAL, null, msj));
                break;
            case 4:
                messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, msj));
                break;

        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="REPORTES LLAMADA">
    public void llamar() {
        imprimirReportes("report1", "PDF");
        mostrarMsj();
        agregarMsj(1, "Mostro un reporte");
        mostrarMsj();
    }

    private void imprimirReportes(String reporte, String form) {
        Map parameters = new HashMap();
        parameters.put("user", "user");
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) fc
                    .getExternalContext().getRequest();
            String url = request.getContextPath() + "/ImpRpts";
            request.getSession().setAttribute("ds", "jdbc/sistema_conta");
            request.getSession().setAttribute("url",
                    "/reportes/" + reporte + ".jasper");
            request.getSession().setAttribute("parameters", parameters);
            request.getSession().setAttribute("format", form);

            String javascriptCode = "window.open('" + url + "','Rpt','location=0,menubar=0,"
                    + "resizable=1,status=0,toolbar=0');";
            PrimeFaces.current().executeScript(javascriptCode);
        } catch (Exception ex) {
        }
    }
//</editor-fold>
}//!--java:module/jdbc/sistema
