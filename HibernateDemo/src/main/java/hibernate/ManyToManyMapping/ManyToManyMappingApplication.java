package hibernate.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMappingApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Project project1 = new Project();
		Project project2 = new Project();
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		List<Project> projectList1 = new ArrayList<Project>();
		List<Project> projectList2 = new ArrayList<Project>();
		
		
		project1.setId(101);
		project1.setName("Project1");
		
		project2.setId(102);
		project2.setName("Project2");
		
		
		employee1.setId(1);
		employee1.setName("ABC ABC ABC");
		employee1.setProjectList(projectList1);
		
		employee2.setId(2);
		employee2.setName("XYZ XYZ XYZ");
		employee2.setProjectList(projectList2);
		
		projectList1.add(project1);
		
		projectList2.add(project1);
		projectList2.add(project2);

		session.save(project1);
		session.save(project2);
		session.save(employee1);
		session.save(employee2);
		
		tx.commit();
		session.close();

	}

}
