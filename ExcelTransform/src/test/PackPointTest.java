package test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import entity.MemberPoint;
import entity.PackPointInfo;
import mainfuntion.HibernateUtil;

public class PackPointTest {
	@Test
	public void haveATry() {
	int i=0;
	Session session = HibernateUtil.openSession();
	Transaction tx = session.beginTransaction();
	Criteria criteria = session.createCriteria(MemberPoint.class);
	List<MemberPoint> list = criteria.list();
	for(MemberPoint point:list) {
		i++;
	}
	tx.commit();
	session.close();
	System.out.println(i);
	}

}
