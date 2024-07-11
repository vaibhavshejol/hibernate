package hibernate.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyMappingApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Company company = new Company();
		List<Employee> employeeList = new ArrayList<Employee>();
//		Employee emp1 = new Employee();
//		Employee emp2 = new Employee();
//		
//		company.setId(1001);
//		company.setName("Virus Company");
//		company.setEmployeeList(employeeList);
//		
//		emp1.setId(1);
//		emp1.setName("ABC PQR XYZ");
//		emp1.setSalary(10000);
//		emp1.setCompany(company);
//		
//		emp2.setId(2);
//		emp2.setName("MNO SUV WSX");
//		emp2.setSalary(20000);
//		emp2.setCompany(company);
//		
//		session.save(company);
//		session.save(emp1);
//		session.save(emp2);
		
		company = session.get(Company.class, 1001);
		employeeList= company.getEmployeeList();

		System.out.println(company.getName());
		for(Employee emp:employeeList) {
			System.out.println(emp.toString());
		}
		
		tx.commit();
		System.out.println("Data saved successfully.....");
		session.close();

	}

}
