import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class GuardarArrayEnFitxer {

	public static void imprimirFitxer(String ruta)
	{
		FileInputStream f = null;
		try 
		{
			f =new FileInputStream(ruta);
			int size = f.available();
			
			for (int i=0; i<size;i++)
			{
				System.out.print((char)f.read());
							
			}
			
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
	public static void grabarArrayEnFitxer(String[] paraules, String ruta)
	{
		FileOutputStream f = null;
		try 
		{
			f=new FileOutputStream(ruta,false);
			for(String paraula : paraules)
			{
				f.write(paraula.getBytes());
				f.write(10);	//EL CÓDIGO ASCII 10 ES EL \n
			}
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
	public static void main (String[] args)
	{
		
		String paraules[] = {"Ordinador","Classe","Lavabo","Teclat","Llibreta","Cable"};
		String ruta = "C:\\archivosJava\\paraulesArray.txt";
		grabarArrayEnFitxer(paraules,ruta);
		imprimirFitxer(ruta);
	}
}
