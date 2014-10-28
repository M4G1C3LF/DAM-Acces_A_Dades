import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FitxersBinaris {

		public static String imprimirFitxer(String ruta)
		{
			FileInputStream f = null;
			DataInputStream dataIS = null;
			try 
			{
				f = new FileInputStream(ruta);
				dataIS = new DataInputStream(f);
				
				int i 		= dataIS.readInt();
				boolean b	= dataIS.readBoolean();
				String str 	= dataIS.readUTF();
				
				return new String(i+" "+b+" "+str);
			
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
			return null;
		}
		public static void grabarEnFitxer(String ruta)
		{
			FileOutputStream f = null;
			DataOutputStream dataOS = null;
			try 
			{
				f=new FileOutputStream(ruta,false);
				dataOS = new DataOutputStream(f);
				
				dataOS.writeInt(10);
				dataOS.writeBoolean(false);
				dataOS.writeUTF("Esto es una prueba.");
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
			
			String ruta = "C:\\archivosJava\\fichericoBinario.dat";
			grabarEnFitxer(ruta);
			System.out.println("Contenido del fichero binario\n"+imprimirFitxer(ruta));
		}
	
}
