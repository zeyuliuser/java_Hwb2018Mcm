package mainfuntion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;

	static {
		Configuration conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
	}

	public static Session openSession() {
		Session session = sf.openSession();
		return session;
	}

	public static Session getCurrentSession() {
		Session session = sf.getCurrentSession();
		return session;
	}


}
