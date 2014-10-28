import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import classes.Alumne;

public class ObjectesSeriats {

	public static ArrayList<Object> llegirFitxer(String ruta)
	{
		FileInputStream f = null;
		ObjectInputStream objectIS = null;
		try 
		{
			f = new FileInputStream(ruta);
			objectIS = new ObjectInputStream(f);
			
			ArrayList<Object> objects = new ArrayList<Object>();
			
			//HEM DE COMPROBAR EL TAMANY DEL BUFFER DESDE FileInputStream, NO DESDE ObjectInputStream
			while (f.available() > 0)
			{
				objects.add(objectIS.readObject());
				
			}
			return objects;
		
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				f.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void grabarEnFitxer(ArrayList<Object> alo,String ruta)
	{
		FileOutputStream f = null;
		ObjectOutputStream objectOS = null;
		try 
		{
			//NO ES POT AFEGIR RES QUAN TANQUEM EL BUFFER, SINÓ NO EL PODRÉM TORNAR A LLEGIR
			f=new FileOutputStream(ruta,false);	
			objectOS = new ObjectOutputStream(f);
			
			for(Object obj : alo)
				objectOS.writeObject(obj);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				f.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args)
	{
		String ruta = "C:\\archivosJava\\objetosGuardados.dat";

		String[] noms = {"Ana", "Alba", "Jana", "Jordi", "Pau", "Jonh"};
		int[] edats = {13,14,15,21,14,14};
		
		ArrayList<Object> alo = new ArrayList<Object>();
		
		for (int i=0;i<noms.length;i++)
		{
			alo.add(new Alumne(noms[i],edats[i]));
		}
		
		grabarEnFitxer(alo,ruta);
		
		
		ArrayList<Object> objects =  llegirFitxer(ruta);
		for (Object obj : objects )
		{
			System.out.println("Nom: "+((Alumne) obj).getNom()+"\tEdat: "+((Alumne) obj).getEdat());
		}
	}
}
