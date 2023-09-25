/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genenral;

//<editor-fold defaultstate="collapsed" desc="Imports">
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
//</editor-fold>

/**
 *
 * @author resolutions
 */
public class Tiempo {

    public static Date getFecha(final String strFecha, final String format)
            throws Exception {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
        Date fecha = formatoDelTexto.parse(strFecha);
        return fecha;
    }

    /**
     * Método que retorna el nombre del mes ".
     *
     * @param fecha Fecha a formatear;
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     * @throws java.lang.Exception Error genérico.
     */
    public static String getStringMes(BigInteger mes) {
        switch (new Integer(mes.toString())) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Desconocido";
        }
    }

    /**
     * Método que retorna el nombre del mes ".
     *
     * @param fecha Fecha a formatear;
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     * @throws java.lang.Exception Error genérico.
     */
    public static String getStringMes(String mes) {
        switch (new Integer(mes)) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Desconocido";
        }
    }

    /**
     * Método que permite formatear la fecha bajo el patrón: "dd/MM/yyyy
     * HH:mm:ss".
     *
     * @param fecha Fecha a formatear;
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     * @throws java.lang.Exception Error genérico.
     */
    public static Date getFechaFormateada(final Date fecha, final int modo)
            throws Exception {
        if (fecha == null) {
            return fecha;
        }
        SimpleDateFormat sdf = null;
        if (modo < 0 || modo > 2) {
            sdf = new SimpleDateFormat("DD/MM/YYY");
        } else {
            sdf = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS");
        }
        Calendar c = new GregorianCalendar();
        String f = "";
        c.setTime(fecha);
        f = c.get(Calendar.DATE)
                + "/"
                + (c.get(Calendar.MONTH) + 1)
                + "/"
                + c.get(Calendar.YEAR);
        if (modo == 0) {
            f += " 00:00:00";
        } else if (modo == 1) {
            f += " 23:59:59";
        }
        return sdf.parse(f);
    }

    /**
     * suma meses a una fecha predeterminada
     *
     * @param fecha <code>date<code>
     * @param meses <code>int<code>
     * @return fecha
     */
    public static Date sumarMes(Date fecha, int meses) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.MONTH, meses);
        return calendar.getTime();
    }

    /**
     * resta fecha 1 menos fecha 2.
     *
     * @param fecha1 fecha uno.
     * @param fecha2 fecha dos.
     * @return el numero de dias de restar fecha1 - menos fecha2.
     */
    public String restaFechas(Date fecha2, Date fecha1) {

        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(fecha1); //dateIni es el objeto Date

        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(fecha2);

        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
            return String.valueOf(date2.get(Calendar.DAY_OF_YEAR)
                    - date1.get(Calendar.DAY_OF_YEAR));
        } else {
            /* SI ESTAMOS EN DISTINTO ANYO COMPROBAMOS QUE EL ANYO DEL DATEINI
             * NO SEA BISIESTO
             * SI ES BISIESTO SON 366 DIAS EL ANYO
             * SI NO, SON 365
             */
            int diasAnyo = date1
                    .isLeapYear(date1.get(Calendar.YEAR)) ? 366 : 365;
            /* CALCULAMOS EL RANGO DE ANYOS */
            int rangoAnyos = date2.get(Calendar.YEAR)
                    - date1.get(Calendar.YEAR);
            /* CALCULAMOS EL RANGO DE DIAS QUE HAY */
            int rango = (rangoAnyos * diasAnyo)
                    + (date2.get(Calendar.DAY_OF_YEAR)
                    - date1.get(Calendar.DAY_OF_YEAR));
            return String.valueOf(rango);
        }
    }

    /**
     * resta fecha 2 menos fecha 1 y devuelve la cantidad de meses.
     *
     * @param fecha1 fecha uno.
     * @param fecha2 fecha dos.
     * @return el numero de dias de restar fecha1 - menos fecha2.
     */
    public int restaFechasMeses(Date fecha2, Date fecha1) {
        float nDias = 0;
        int nMeses = 0;
        nDias = Float.parseFloat(restaFechas(fecha2, fecha1));
        nDias = nDias / 30;
        String strmeses = String.valueOf(nDias);
        if (strmeses.indexOf('.') != -1) {
            nMeses = (int) nDias + 1;
        } else {
            nMeses = (int) nDias;
        }
        return nMeses;
    }

    /**
     * resta fecha 2 menos fecha 1 y devuelve la cantidad de meses.
     *
     * @param fecha1 fecha uno.
     * @param fecha2 fecha dos.
     * @return numero de meses
     */
    public int MesesTranscurridos(Date fecha2, Date fecha1) {
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(fecha2);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(fecha1);
        int startMes = (startCalendar.get(Calendar.YEAR) * 12) + startCalendar.get(Calendar.MONTH);
        int endMes = (endCalendar.get(Calendar.YEAR) * 12) + endCalendar.get(Calendar.MONTH);
        int diffMonth = endMes - startMes;
        return diffMonth;
    }

    /**
     * Redondea un timestamp a la hora mas cercana segun el parametro m.
     *
     * @param fecha La fecha (timestamp) a redondear.
     * @param m la cantidad de minutos a la que se quiere redondear (p. ej. 15
     * min. o 30 min.).
     * @return La fecha (timestamp) redondeada.
     */
    public Date redondearMinutos(Date fecha, int m) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        int minutos = cal.get(Calendar.MINUTE);
        int mode = minutos % m;
        if (mode > (m / 2)) {
            minutos = m - mode;
        } else {
            minutos = 0 - mode;
        }
        cal.add(Calendar.MINUTE, minutos);
        return cal.getTime();
    }

    /**
     * Valida dos fechas (si una es mayor a otra).
     *
     * @param f1 fecha 1.
     * @param f2 fecha 2.
     * @return numero entero q especifica si f1 = f2 retorna 0 si f1>f2 retorna
     * 1 si f1&lt;f2 retorna -1
     */
    public int compararFecha(Date f1, Date f2) {
        int var = f1.compareTo(f2);
        if (var == 0) {
            return 0;
        }
        if (var > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Valida dos fechas (si una es mayor a otra).
     *
     * @param f1 fecha 1.
     * @param f2 fecha 2.
     * @return numero entero q especifica si f1 = f2 retorna 0 si f1>f2 retorna
     * 1 si f1&lt;f2 retorna -1
     */
    public static int compararFechasTruncadas(Date f1, Date f2) throws Exception {
        int var = getFechaFormateada(f1, 0).compareTo(getFechaFormateada(f2, 0));
        if (var == 0) {
            return 0;
        }
        if (var > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Compara 2 fechas sin hora ni minuto para saber si fecha 1 es mayor o
     * igual que fecha 2.
     *
     * @param f1 fecha uno de referencia.
     * @param f2 fecha dos de referencia.
     * @return fecha
     * @throws Exception error generico.
     */
    public boolean esFechaMayorIgual(Date f1, Date f2) throws Exception {
        boolean esVenc = false;
        Calendar choy = Calendar.getInstance();
        choy.setTime(Tiempo.getFechaFormateada(f2, 0));
        choy.set(Calendar.HOUR, 0);
        choy.set(Calendar.MINUTE, 0);
        choy.set(Calendar.MILLISECOND, 0);
        Calendar cven = Calendar.getInstance();
        cven.setTime(Tiempo.getFechaFormateada(f1, 0));
        cven.set(Calendar.HOUR, 0);
        cven.set(Calendar.MINUTE, 0);
        cven.set(Calendar.MILLISECOND, 0);

        if (cven.before(choy) || cven.equals(choy)) {
            esVenc = true;
        }
        return esVenc;
    }

    /**
     * Sumar n dias a la fecha actual.
     *
     * @param n numero de dias q se tiene q sumar.
     * @return Un objeto de tipo date.
     */
    public static Date SumarDias(int n) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        //Obtiene la fecha del sistema
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, n); //le suma la cantidad de días
        String f = formato.format(c1.getTime());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date fecha = df.parse(f);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Sumar n dias a la fecha actual.
     *
     * @param n numero de dias q se tiene q sumar.
     * @param fecha a la que se van a sumar los dias
     * @return Un objeto de tipo date.
     */
    public static Date sumarDias(final Date fecha, final int n) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar c1 = new GregorianCalendar();
        c1.setTime(fecha); //dateIni es el objeto Date

        //Obtiene la fecha del sistema
        c1.add(Calendar.DATE, n); //le suma la cantidad de días
        String f = formato.format(c1.getTime());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha2 = df.parse(f);
            return fecha2;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo q aplica formato de hora al formato de tiempo
     *
     * @param tiempo String al q se le va aplicar formato.
     * @return String con formato de hora:minutos:segundo.
     */
    public static String FormatoTiempo(String tiempo) {
        String hora = "";
        int n = tiempo.length();
        try {
            hora = tiempo.substring(0, n - 4)
                    + ":" + tiempo.substring(n - 4, n - 2)
                    + ":" + tiempo.substring(n - 2, n);
        } catch (Exception e) {
            hora = tiempo;
            e.printStackTrace();
        }
        return hora;
    }

    /**
     * Metodo q devuelve una fecha a partir de un String segun el formato.
     *
     * @param strFecha Fecha en String. Ej: "12/12/2010"
     * @param patron Patron el q se desea convertir la fecha. Ej: 'dd/MM/yyyy'.
     * @return fecha Date con formato definido.
     */
    public Date convFecha(String strFecha, String patron) {
        //DD/MM/yyyy
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(patron);
        //String strFecha = "12/12/2010";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
            return fecha;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Metodo que retorna una fecha en String con un formato.
     *
     * @param Date Fecha
     * @param patron Patron Ej: 'DD/MM/yyyy'.
     * @return fechaFormato String
     */
    public String formatoFecha(String patron, Date fecha) {
        String fechaFormato = "";
        //DD/MM/yyyy
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(patron);
        fechaFormato = formatoDelTexto.format(fecha);
        return fechaFormato;


    }

    /**
     * Método que convierte una fecha de tipo java.util.date a
     * XMLGregorianCalendar.
     *
     * @param fecha fecha q se va a convertir a formato XMLGregorianCalendar.
     * @return dateXML fecha en formato XMLGregorianCalendar.
     */
    public static XMLGregorianCalendar ConvDateXmlCal(Date fecha)
            throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fecha);
        try {
            XMLGregorianCalendar dateXML = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(c);
            return dateXML;
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Tiempo.class.getName())
                    .log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Método que convierte una fecha de tipo java.util.date a
     * XMLGregorianCalendar.
     *
     * @param strFecha String q contiene la fecha q se va a convertir.
     * @param patron de formato de la fecha.
     * @return dateXML fecha en formato XMLGregorianCalendar.
     */
    public static XMLGregorianCalendar ConvStrDateXmlCal(String strFecha,
            String patron) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(patron);
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(fecha);
            XMLGregorianCalendar dateXML = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(c);
            return dateXML;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Tiempo.class.getName())
                    .log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Método que convierte una fecha de tipo java.util.date a
     * XMLGregorianCalendar sin tomar en cuenta el tiempo.
     *
     * @param fecha fecha q se va a convertir a formato XMLGregorianCalendar.
     * @return dateXML fecha en formato XMLGregorianCalendar.
     */
    public static XMLGregorianCalendar ConvXmlCal(final Date fecha) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fecha);

        DatatypeFactory factory = null;
        try {
            factory = DatatypeFactory.newInstance();
            XMLGregorianCalendar calendar = factory.newXMLGregorianCalendar();
            calendar.setYear(c.get(GregorianCalendar.YEAR));
            calendar.setMonth(c.get(GregorianCalendar.MONTH) + 1);
            calendar.setDay(c.get(GregorianCalendar.DAY_OF_MONTH));
            calendar.setHour(0);
            calendar.setMinute(0);
            calendar.setSecond(0);
            XMLGregorianCalendar fechaXml = factory
                    .newXMLGregorianCalendar(calendar.toXMLFormat());
            return fechaXml;
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Tiempo.class.getName())
                    .log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene la hora del sistema en formato HoraMinutoSegundo.
     *
     * @throws Escribe en el log y lanza errores a seguiente capa.
     */
    public static BigInteger horaSistema(boolean pmilisegs) throws Exception {
        Calendar cl = Calendar.getInstance();
        Integer horas = Integer.valueOf(cl.get(Calendar.HOUR_OF_DAY));
        Integer minutos = Integer.valueOf(cl.get(Calendar.MINUTE));
        Integer segundos = Integer.valueOf(cl.get(Calendar.SECOND));
        Integer milisegs = 0;
        if (pmilisegs) {
            milisegs = Integer.valueOf(cl.get(Calendar.MILLISECOND));
        }
        StringBuilder hora = new StringBuilder();
        hora.append(horas.toString());
        hora.append(String.format("%02d", minutos));
        hora.append(String.format("%02d", segundos));
        if (pmilisegs) {
            hora.append(String.format("%02d", milisegs));
        }
        return new BigInteger(hora.toString());
    }
    
    
      /**
     * Obtiene la hora del sistema en formato HoraMinutoSegundo.
     *
     * @throws Escribe en el log y lanza errores a seguiente capa.
     */
    public static String horaSistemaString(boolean pmilisegs) throws Exception {
        Calendar cl = Calendar.getInstance();
        Integer horas = Integer.valueOf(cl.get(Calendar.HOUR_OF_DAY));
        Integer minutos = Integer.valueOf(cl.get(Calendar.MINUTE));
        Integer segundos = Integer.valueOf(cl.get(Calendar.SECOND));
        Integer milisegs = 0;
        if (pmilisegs) {
            milisegs = Integer.valueOf(cl.get(Calendar.MILLISECOND));
        }
        StringBuilder hora = new StringBuilder();
        hora.append(horas.toString()).append(":");
        hora.append(String.format("%02d", minutos)).append(":");
        hora.append(String.format("%02d", segundos)).append(" - ");
        if (pmilisegs) {
            hora.append(String.format("%02d", milisegs));
        }
        return (hora.toString());
    }

    /**
     * Busca la cantidad de días transcurridos desde una fecha inicio a una
     * fecha actual
     *
     * @param fechaInicial la fecha inicio
     * @param fechaFinal la fecha actual
     * @return la cantidad de días
     */
    public int calcularDiasTrancurridos(Date fechaInicial, Date fechaFinal) throws Exception {
        Calendar c = Calendar.getInstance();
        Calendar fechaInicio = new GregorianCalendar();
        fechaInicio.setTime(getFechaFormateada(fechaInicial, 3));
        Calendar fechaFin = new GregorianCalendar();
        fechaFin.setTime(getFechaFormateada(fechaFinal, 3));
        long milseg = fechaFin.getTime().getTime()
                - fechaInicio.getTime().getTime();
        return this.convertirMilisegADias(milseg);
    }

    /**
     * Obtiene el año de una fecha.
     *
     * @param fecha a obtener la fecha.
     * @return valor obtenido.
     */
    public static BigInteger getAnio(Date fecha) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        return new BigInteger(String.valueOf(c.get(Calendar.YEAR)));
    }

    /**
     * Obtiene el mes de una fecha base uno.
     *
     * @param fecha a obtener la fecha.
     * @return valor obtenido.
     */
    public static BigInteger getMes(Date fecha) throws Exception {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        return new BigInteger(String.valueOf(c.get(Calendar.MONTH)))
                .add(BigInteger.ONE);
    }

    /**
     * Metodo que devuelve una fecha.
     *
     * @param mes codigo de el anio.
     * @param anio codigode el anio.
     * @param dia codigo del del dia.
     * @return fecha.
     */
    public static Date getFecha(final BigInteger mes,
            final BigInteger anio, final BigInteger dia) {
        if (mes == null || anio == null) {
            return null;
        }
        Calendar c = new GregorianCalendar();
        c.set(anio.intValue(), mes.intValue() - 1, dia.intValue());
        return c.getTime();

    }

    /**
     * Método que te permite obtener la fecha inicial de la fecha enviada de
     * parámetro.
     *
     * @param fecha Fecha
     * @return Fecha inicial
     */
    public static Date getFechaInicial(final Date fecha) {
        if (fecha == null) {
            return fecha;
        }
        Calendar c = new GregorianCalendar();
        c.setTime(fecha);
        c.set(c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.getActualMinimum(Calendar.DAY_OF_MONTH),
                c.getMinimum(Calendar.HOUR_OF_DAY),
                c.getMinimum(Calendar.MINUTE),
                c.getMinimum(Calendar.SECOND));
        return c.getTime();
    }

    /**
     * Método que te permite obtener la fecha final de la fecha enviada de
     * parámetro.
     *
     * @param fecha Fecha.
     * @return Fecha final
     */
    public static Date getFechaFinal(final Date fecha) {
        if (fecha == null) {
            return fecha;
        }
        Calendar c = new GregorianCalendar();
        c.setTime(fecha);
        c.set(c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.getActualMaximum(Calendar.DAY_OF_MONTH),
                c.getMaximum(Calendar.HOUR_OF_DAY),
                c.getMaximum(Calendar.MINUTE),
                c.getMaximum(Calendar.SECOND));
        return c.getTime();
    }

    /**
     * Convertir milisegundos a Días.
     *
     * @param miliseg cantidad de milisegundos convertir a días.
     * @return
     */
    public int convertirMilisegADias(long miliseg) throws Exception {
        BigDecimal divisor = new BigDecimal("3600")
                .multiply(new BigDecimal("24"))
                .multiply(new BigDecimal("1000"));
        BigDecimal dividendo = new BigDecimal(miliseg);
        return dividendo.divide(divisor, RoundingMode.DOWN).intValue();
    }

    /**
     * Sumar meses a una fecha
     *
     * @param fecha fecha a sumar meses
     * @param nmeses numero de meses a sumar
     * @return
     */
    public Date sumarMeses(Date fecha, int nmeses) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(fecha);
        cal1.add(Calendar.MONTH, nmeses);
        if (getUltimoDiaDelMes(fecha).compareTo(fecha) == 0) {
            System.out.println("Es ultimo dia del mes");
            return getUltimoDiaDelMes(cal1.getTime());
        }
        return cal1.getTime();
    }

    public static Date getPrimerDiaDelMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static int getDiaFecha(Date fecha) {
        int dia = -1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        getDiaSemana();
        return dia;
    }

    public static Date getUltimoDiaDelMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getPrimerDiaDelAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(cal.get(Calendar.YEAR),
                0,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getUltimoDiaDelAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(cal.get(Calendar.YEAR),
                11,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    /**
     * Método retorno el último día del mes bajo el patrón: "dd/MM/yyyy
     * HH:mm:ss".
     *
     * @param anio año
     * @param mes mes
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     *
     */
    public static Date getUltimoDiaDelMes(BigInteger anio, BigInteger mes, int modo)
            throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio.intValue());
        cal.set(Calendar.MONTH, mes.intValue() - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int dia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        return getFechaFormateada(cal.getTime(), modo);
    }

    /**
     * Método retorno el primer día del mes bajo el patrón: "dd/MM/yyyy
     * HH:mm:ss".
     *
     * @param anio año
     * @param mes mes
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     *
     */
    public static Date getPrimerDiaDelMes(BigInteger anio, BigInteger mes, int modo)
            throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio.intValue());
        cal.set(Calendar.MONTH, mes.intValue() - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getFechaFormateada(cal.getTime(), modo);
    }

    /**
     * Obtener String de fecha formateada dd/MM/yyyy en Cadena de Texto.
     *
     * @param fecha a obtener String de Fecha
     * @return
     */
    public static String getCadenaFecha(Date fecha, String formato) {
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            return sdf.format(fecha).toUpperCase();
        } else {
            return "";
        }



    }

    /**
     * Método retorno una fecha bajo el patrón: "dd/MM/yyyy HH:mm:ss".
     *
     * @param anio año
     * @param mes mes
     * @param dia dia
     * @param modo 0 = Retornará dd/MM/yyyy 00:00:00, 1 = Retornará dd/MM/yyyy
     * 23:59:59, 2 = Retornará dd/MM/yyyy HH:mm:ss, n = Retornará dd/MM/yyyy
     * @return Date
     *
     */
    public static Date getDia(int anio, int mes, int dia, int modo)
            throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, anio);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1); // trick
        cal.set(Calendar.DAY_OF_MONTH, dia);
        return getFechaFormateada(cal.getTime(), modo);
    }

    /**
     *
     * @param fecha1 fecha uno.
     * @param fecha2 fecha dos.
     * @return el numero de años de restar fecha1 - menos fecha2.
     */
    public int aniosTranscurridos(Date fecha2, Date fecha1) {
        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(fecha1); //dateIni es el objeto Date
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(fecha2);

        int diff_year = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
        int diff_month = date2.get(Calendar.MONTH) - date1.get(Calendar.MONTH);
        int diff_day = date2.get(Calendar.DAY_OF_MONTH) - date1.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        return diff_year;
    }

    /**
     *
     * @param fecha1 fecha uno.
     * @param fecha2 fecha dos.
     * @return el numero de años de restar fecha1 - menos fecha2.
     */
    public int mesesTranscurridos(Date fecha2, Date fecha1) {
        GregorianCalendar date1 = new GregorianCalendar();
        date1.setTime(fecha1); //dateIni es el objeto Date
        GregorianCalendar date2 = new GregorianCalendar();
        date2.setTime(fecha2);

        int diff_year = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
        int diff_month = date2.get(Calendar.MONTH) - date1.get(Calendar.MONTH);
        int diff_day = date2.get(Calendar.DAY_OF_MONTH) - date1.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        return diff_year;
    }

    /**
     * Sumar anios a una fecha
     *
     * @param fecha fecha a sumar anios
     * @param anios numero de anios a sumar
     * @return ultimo dia del mes
     */
    public Date sumarAnios(Date fecha, int anios) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(fecha);
        cal1.add(Calendar.YEAR, anios);
        return getUltimoDiaDelMes(cal1.getTime());
    }

    /**
     * Sumar anios a una fecha
     *
     * @param fecha fecha a sumar anios
     * @param anios numero de anios a sumar
     * @return
     */
    public Date sumarAniosA(Date fecha, int anios) {
        Calendar cal1 = GregorianCalendar.getInstance();
        cal1.setTime(fecha);
        cal1.add(Calendar.YEAR, anios);
        return cal1.getTime();
    }

    /**
     * Obtiene el número correspondiente al dia de la semana.
     *
     * @return int del dia de la semana.
     */
    public static int getDiaSemana() {
        Calendar cal = GregorianCalendar.getInstance();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Obtiene el número correspondiente al dia de la semana.
     *
     * @return int del dia de la semana.
     */
    public static int getDiaSemana(Date fecha) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int getAM_PM() {
        Calendar cal = GregorianCalendar.getInstance();
        return cal.get(Calendar.AM_PM);
    }

    public static String getDiaStr(Date fecha) {
        int dia = getDiaSemana(fecha);
        String diaSrt = "Otro";
        switch (dia) {
            case 1:
                diaSrt = "Domingo";
                break;
            case 2:
                diaSrt = "Lunes";
                break;
            case 3:
                diaSrt = "Martes";
                break;
            case 4:
                diaSrt = "Miercoles";
                break;
            case 5:
                diaSrt = "Jueves";
                break;
            case 6:
                diaSrt = "Viernes";
                break;
            case 7:
                diaSrt = "Sabado";
                break;
        }
        return diaSrt;
    }
}