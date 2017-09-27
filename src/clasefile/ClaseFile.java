
package clasefile;

import java.io.File;
import java.util.Date;

public class ClaseFile {

    public static void main(String[] args) 
    {	
	try
	{
	    File archivo = new File(args[0]);
	    ComprobarArbol(archivo);
	}
	catch(ArrayIndexOutOfBoundsException e)
	{	    
	    System.out.println("Error, no se han pasado suficientes argumentos");
	}
	catch(NullPointerException e)
	{
	    System.out.println("Error, la ruta especificada no es válida");
	}
    }       
    
    public static void ComprobarArbol (File archivo)
    {
	InformacionArchivo(archivo);
	if (archivo.isDirectory())
	{	    	  	    	    
	    File [] listaDirectorio = archivo.listFiles();	    
	    for (File a : listaDirectorio)
	    {
		ComprobarArbol(a);
	    }
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
