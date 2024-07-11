package hibernate.getOrload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.savingImage.Student;

public class GetOrLoadApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
		
//		Student student=session.get(Student.class, 1);
//		System.out.println("====================================");
//		System.out.println("Id of student\t:"+student.getId());
//		System.out.println("Name of student\t:"+student.getName());
		
		Student student2 = session.load(Student.class, 1);
		System.out.println("Id of student\t:"+student2.getId());
		System.out.println("=======================================");
		System.out.println("Name of student\t:"+student2.getName());
		System.out.println("Image of student\t:"+student2.getImage());
		
//		tx.commit();
		session.close();

	}

}
