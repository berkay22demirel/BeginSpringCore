package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceTest {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext();
		
		Resource resourceFile = context.getResource("file:/home/berkay22demirel/Masaüstü/file_resource_example");
		
		try {
			InputStream is = resourceFile.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Resource resourceClasspath = context.getResource("classpath:classpath_resource_example");	
		
		try {
			InputStream is = resourceClasspath.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
