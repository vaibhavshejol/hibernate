package hibernate.embedding;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddingApplication {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Question question = new Question();
		Answer answer =new Answer();
		
		question.setId(1);
		question.setQuestion("What is Hibernate?");
		question.setAnswer(answer);
		
		answer.setId(1);
		answer.setAnswer("Hibernate is a ORM tool.");
		
		session.save(question);
		
		tx.commit();
		session.close();

	}

}
