package phoneBook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Fin {
	 public static void main(String[] args) throws IOException{
		 File file = new File("PhoneHome.dat");
		 System.out.println("We got a file: "+file);
		 
		 System.out.println("Does it exist? "+file.exists());
		 System.out.println("If file does exist..: "+file.isDirectory());
		 
		 
		/* String contentsToWrite = "Detroit";
		 OutputStream outStream = new FileOutputStream(file);
		 outStream.write(contentsToWrite.getBytes());
		 outStream.close();*/

}
}