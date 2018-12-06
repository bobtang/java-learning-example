package myiodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends FilterInputStream{

	protected UpperCaseInputStream(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public int read() throws IOException
	{
		int c=super.read();
		return c==-1?c:Character.toUpperCase((char)(c));
	}
	public int read(byte[] b,int offset,int len) throws IOException
	{
		int result=super.read(b,offset,len);
		for(int i=0;i<result;i++)
		{
			b[i]=(byte)Character.toUpperCase((char)(b[i]));
		}
		
		return result;
	}
}
