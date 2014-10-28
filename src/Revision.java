import java.io.*;

import java.util.GregorianCalendar;
public class Revision {
	
		public static void main(String[] args)
		{
			FileInputStream f = null;
			String s = "";
			char ch;
			
			try
			{
				f = new FileInputStream((args[0]));
				int size = f.available();
				
				for (int i =0;i<size;i++)
				{
					ch= (char)f.read();
					s=s+ch;
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				
			
		        File file = new File(args[0]);
		        
				GregorianCalendar c = new GregorianCalendar();
				c.setTimeInMillis(file.lastModified());
				
				System.out.println("La fecha de última modificación del archivo "+file.getName()+" ha sido "
						+c.get(GregorianCalendar.DAY_OF_MONTH)+ "/"
						+c.get(GregorianCalendar.MONTH)+ "/"
						+c.get(GregorianCalendar.YEAR)+ " - "
						+c.get(GregorianCalendar.HOUR_OF_DAY)+ ":"
						+c.get(GregorianCalendar.MINUTE)+ ":"
						+c.get(GregorianCalendar.SECOND));				
				
				try
				{
					f.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}
		


}
