package hibernate.savingImage;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ImageSavingApplication {

	public static void main(String[] args) throws IOException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		FileInputStream fis = new FileInputStream("src/main/java/Photo.jpg");
		byte[] image = new byte[fis.available()];
		fis.read(image);
		
		Student student = new Student();
		student.setId(1);
		student.setName("ABC PQR MNO");
		student.setImage(image);
		
		session.save(student);
		
		tx.commit();
		session.close();

	}

}
