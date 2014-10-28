import java.io.*;

public class CopiaFichero
{
	public static void main(String[] args)
	{
		
		FileInputStream f1=null;
		FileOutputStream f2=null;
		
		char c;
		try
		{
			String entrada = (args[0]);
			String salida = (args[1]);
			f1=new FileInputStream(entrada);
			f2=new FileOutputStream(salida);
			int size = f1.available();
			
			for (int i=0; i<size;i++)
			{
				c= (char)f1.read();
				f2.write((byte)c);				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				f1.close();
				f2.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
