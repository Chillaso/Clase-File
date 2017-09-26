
package clasefile;

import java.io.File;
import java.util.Date;

public class ClaseFile {

    public static void main(String[] args) 
    {	
	try
	{
	    ComprobarDirectorio(args[0]);
	}
	catch(ArrayIndexOutOfBoundsException e)
	{	    
	    System.out.println("Error, no se han pasado suficientes argumentos");
	}
    }
       
    public static void ComprobarDirectorio (String ruta)
    {
	File archivo = new File(ruta);
	//Si la ruta es un directorio cojo todos sus hijos
	if (archivo.isDirectory())
	{
	    File [] lista = archivo.listFiles();
	    //Por cada hijo compruebo si es directorio o no
	    for (File a : lista)
	    {
		ComprobarArbol(a);
	    }
	}
	else
	{
	    InformacionArchivo(archivo);
	}	
    }
    
    //Este metodo se mete dentro de carpetas hasta que encuentra el archivo más profundo
    public static File ComprobarArbol (File archivo)
    {
	//Compruebo si el archivo es un documento
	if (archivo.isFile())
	{
	    InformacionArchivo(archivo);
	    //Termino el bucle
	    return archivo;
	}
	//Si el archivo es un directorio accede a los documentos, imprime y comprueba de nuevo
	else
	{
	    //Imprimo el propio directorio 
	    InformacionArchivo(archivo);
	    
	    //Saco sus hijos
	    File [] listaDirectorio = archivo.listFiles();
	    
	    //Para cada archivo compruebo de nuevo que tiene dentro
	    for (File a : listaDirectorio)
	    {
		ComprobarArbol(a);
	    }
	    return archivo;
	}
    }
    
    //Informacion de los archivos
    public static void InformacionArchivo(File archivo)
    {
	System.out.println("El archivo se llama "+archivo.getName()); //Nombre
	System.out.println("El archivo padre del archivo "+archivo.getName()+" es: "+archivo.getParent()); //Rutas y padre
	
	if (archivo.isDirectory()) System.out.println("El archivo es un directorio"); //Si es direcorio o documento
	else System.out.println("El archivo es un documento");
	
	//Ultima fecha de modificacion
	Date fecha = new Date(archivo.lastModified());		
	System.out.println("La última fecha de modificación del archivo fué: "+fecha.toString()+"\n\n");
    }
}
