package hibernate.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneMappingApplication {

	public static void main(String[] args) {
		System.out.println("Application started successfully...");
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		
		Question question=new Question();
		Answer answer=new Answer();
		
		question.setId(1);
		question.setQuestion("What is Java?");
		question.setAnswer(answer);
		
		answer.setId(1);
		answer.setAnswer("Java is a programming language and it is platform independent.");
		answer.setQuestion(question);
		
		session.save(question);
		session.save(answer);
		
		tx.commit();
		System.out.println("Data saved succefully...");
		session.close();
		

	}

}
