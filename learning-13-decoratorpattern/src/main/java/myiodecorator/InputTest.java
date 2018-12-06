package myiodecorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	public static void main(String[] args) {
		int c;
		try {
			InputStream in1 =  new BufferedInputStream(
					new FileInputStream("F:\\test.txt"));
			while((c=in1.read())>=0)
			{
				System.out.print((char)c);
				
			}
			System.out.println();
			System.out.println("***********************");
			InputStream in2 = new UpperCaseInputStream(new BufferedInputStream(
					new FileInputStream("F:\\test.txt")));
			while((c=in2.read())>=0)
			{
				System.out.print((char)c);

			}
			System.out.println();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
