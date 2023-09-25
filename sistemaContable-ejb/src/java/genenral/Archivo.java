/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genenral;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;


//import org.apache.commons.vfs.FileObject;
//import org.apache.commons.vfs.FileSystemOptions;
//import org.apache.commons.vfs.Selectors;
//import org.apache.commons.vfs.UserAuthenticator;
//import org.apache.commons.vfs.VFS;
//import org.apache.commons.vfs.auth.StaticUserAuthenticator;
//import org.apache.commons.vfs.impl.DefaultFileSystemConfigBuilder;

/**
 *
 * @author resolutions
 */
public class Archivo {

    /**
     * Devuelve un array de bytes que corresponde al archivo leido desde la
     * <code>ruta</code> enviada.
     *
     * @param ruta la ruta del archivo a obtener.
     * @return el archivo en un array de bytes.
     * @throws java.io.IOException error de lectura/escritura.
     */
    public final byte[] openFile(final String ruta) throws IOException {
        File f = new File(ruta);
        try {
            //lo abrimos. Lo importante es que sea un InputStream
            InputStream is = new FileInputStream(f);
            //creamos el buffer
            byte[] buffer = new byte[(int) f.length()];
            //leemos el archivo al buffer
            is.read(buffer);
            return buffer;
        } catch (FileNotFoundException ex) {
           
            return null;
        } catch (IOException e) {
           
            throw e;
        }
    }

    /**
     * Método que permite verificar si el archivo existe.
     *
     * @param archivo Nombre del Archivo.
     * @return boolean.
     * @throws java.lang.Exception Error genérico.
     */
    public final boolean existeArchivo(final String archivo) throws Exception {
        File file = new File(archivo);
        if (file != null) {
            return file.exists();
        } else {
            return false;
        }
    }

    /**
     * Método que permite eliminar un archivo.
     *
     * @param archivo Nombre del archivo.
     * @return boolean
     * @throws java.lang.Exception Error genérico.
     */
    public final boolean eliminarArchivo(final String archivo)
            throws Exception {
        File file = new File(archivo);
        if (file != null) {
            return file.delete();
        } else {
            return false;
        }
    }

    /**
     * Convierte el contenido del archivo en filas de tipo String.
     *
     * @param ruta ruta del archivo q se desea leer
     * @return Una lista de string correspondiente a cada linea del archivo
     */
    public List< String> DatosFiles(String ruta) {
        File archivo = null;
        FileReader fr = null;
        List< String> lineas = new ArrayList();
        String linea = "";
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE,
                    "Error en lectura de archivo. " + e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE,
                        "Error cerrando archivo. " + e);
            }
        }
        archivo.delete();
        return lineas;
    }

    /**
     * Imprime la salida de procesos asincronos cuando el log es muy grande. El
     * archivo se escribe en la ruta de los logs de la instancia. Dentro de una
     * carpeta integrity. Ej.
     * c:\rutadelglassfish\domains\domain1\logs\coopOne\idproceso.txt.
     *
     * @param idproc codigo de proceso.
     * @param charset codigo de juego de caracteres.
     * @param salida texto de salida de archivo.
     * @return String ruta de archivo.
     * @throws java.lang.Exception error generico.
     */
    public String imprimirSalidaProc(final String idproc, final String salida,
            final String charset) throws Exception {
        StringBuilder outputpath = new StringBuilder(
                System.getProperty("com.sun.aas.instanceRoot"));
        outputpath.append(File.separatorChar);
        outputpath.append("logs");
        outputpath.append(File.separatorChar);
        outputpath.append("coopOne");
        outputpath.append(File.separatorChar);
        File crearuta = new File(outputpath.toString());
        crearuta.mkdir();
        outputpath.append(idproc);
        outputpath.append(".txt");
        this.crearArchivo(outputpath.toString(),
                salida, charset);
        return outputpath.toString();
    }

    /**
     * Método que permite generar un archivo en la ubicación especificada. en el
     * parametro nomarch, nomarch puede contener solo el nombre del archivo o la
     * ruta completa + el nombre del archivo.
     *
     * @param nomarch Nombre o ruta completa con nombre del archivo.
     * @param contenido Contenido del archivo.
     * @param charset Formato de caracteres UTF8, ISO-8859-1, etc.
     * @return true en caso de exito, false caso contrario.
     * @throws java.lang.Exception Excepción genérica.
     */
    public final boolean crearArchivo(final String nomarch,
            final String contenido, final String charset) throws Exception {
        StringBuffer err = null;
        try {
            FileOutputStream fos = new FileOutputStream(nomarch);
            Writer out = new OutputStreamWriter(fos, charset);
            out.append(contenido);
            out.flush();
            out.close();
            return true;
        } catch (NullPointerException e) {
            err = new StringBuffer();
            err.append("Error en el método crearArchivo. ");
            err.append("Detalle [");
            err.append(e.getMessage());
            err.append("]");
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    err.toString());
            throw e;
        } catch (Exception e) {
            err = new StringBuffer();
            err.append("Error en el método crearArchivo. ");
            err.append("Detalle [");
            err.append(e.getMessage());
            err.append("]");
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                    err.toString());
            throw e;
        }

    }

//    public void moverFileSystem(String rutaLocal) throws IOException {
//        String domain = "COOP1\\all";
//        String userName = "carlos.flores";
//        String password = "Coop1234#";
//        String remoteFilePath = "\\\\192.168.10.12\\Equifax";
//
//
//        File f = new File(rutaLocal); //Takes the default path, else, you can specify the required path
//        if (f.exists()) {
//            f.delete();
//        }
//        f.createNewFile();
//        FileObject destn = (FileObject) VFS.getManager().resolveFile(f.getAbsolutePath());
//
//        //domain, username, password
//        UserAuthenticator auth = new StaticUserAuthenticator(domain, userName, password);
//        FileSystemOptions opts = new FileSystemOptions();
//        DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
//
//
//        FileObject destnRemoto = (FileObject) VFS.getManager().resolveFile(remoteFilePath);
//
//        System.out.println("RUTA LOCAL" + rutaLocal);
//
//        System.out.println("RUTA REMOTA" + remoteFilePath);
//
//        FileObject archivoLocal = (FileObject) VFS.getManager().resolveFile(rutaLocal, opts);
//
//        System.out.println("Existe o no" + archivoLocal.exists());
//        destnRemoto.copyFrom(archivoLocal, Selectors.SELECT_SELF);
//        destnRemoto.close();
//
//        //InputStream is = new FileInputStream(f);
//
//        InputStream is = new FileInputStream(f);
//
//
//    }

//    public static void smbPut(String remoteUrl, String localFilePath) {
//        InputStream in = null;
//        OutputStream out = null;
//        try {
//            File localFile = new File(localFilePath);
//            String fileName = localFile.getName();
//            SmbFile remoteFile = new SmbFile(remoteUrl + "/" + fileName);
//            in = new BufferedInputStream(new FileInputStream(localFile));
//            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
//            byte[] buffer = new byte[1024];
//            while (in.read(buffer) != -1) {
//                out.write(buffer);
//                buffer = new byte[1024];
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public void testArchivo() throws IOException {
        StringBuilder outputpath = new StringBuilder(
                System.getProperty("user.home"));
        outputpath.append(File.separatorChar);
        outputpath.append("ArchivoPRUEBA.xls");
        Workbook workbook = new XSSFWorkbook();
        String rutaArchivo = outputpath.toString();
        Sheet datosSheet = workbook.createSheet("Datos");
        try {
            FileOutputStream fos = new FileOutputStream(rutaArchivo);
            workbook.write(fos);
            fos.close();
            System.out.println(" is successfully written");

//            moverFileSystem(rutaArchivo);


//            String localPath = "E:\\FinalJar\\commons-io-2.4-bin\\commons-io-2.4\\commons-io-2.4-tests.jar";
//            String netUrl = "smb://carlos.flores:Coop1234#@192.168.10.12/Equifax";
//            smbPut(netUrl, rutaArchivo);
        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private static class XSSFWorkbook implements Workbook {

        public XSSFWorkbook() {
        }

        @Override
        public int getActiveSheetIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setActiveSheet(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getFirstVisibleTab() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setFirstVisibleTab(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setSheetOrder(String string, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setSelectedTab(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setSheetName(int i, String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getSheetName(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getSheetIndex(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getSheetIndex(Sheet sheet) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet createSheet() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet createSheet(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet cloneSheet(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getNumberOfSheets() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet getSheetAt(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Sheet getSheet(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeSheetAt(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setRepeatingRowsAndColumns(int i, int i1, int i2, int i3, int i4) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Font createFont() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Font findFont(short s, short s1, short s2, String string, boolean bln, boolean bln1, short s3, byte b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public short getNumberOfFonts() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Font getFontAt(short s) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CellStyle createCellStyle() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public short getNumCellStyles() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CellStyle getCellStyleAt(short s) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void write(OutputStream out) throws IOException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getNumberOfNames() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Name getName(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Name getNameAt(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Name createName() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getNameIndex(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeName(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeName(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setPrintArea(int i, String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setPrintArea(int i, int i1, int i2, int i3, int i4) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getPrintArea(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removePrintArea(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Row.MissingCellPolicy getMissingCellPolicy() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setMissingCellPolicy(Row.MissingCellPolicy mcp) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DataFormat createDataFormat() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int addPicture(byte[] bytes, int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<? extends PictureData> getAllPictures() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CreationHelper getCreationHelper() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isHidden() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setHidden(boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isSheetHidden(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isSheetVeryHidden(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setSheetHidden(int i, boolean bln) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setSheetHidden(int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
