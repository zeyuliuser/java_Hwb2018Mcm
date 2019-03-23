package mainfuntion;

import java.util.List;

import org.apache.poi.hslf.record.TxInteractiveInfoAtom;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mysql.fabric.xmlrpc.base.Value;

import entity.MemberPoint;
import entity.MethodPoint;
import entity.PackPointInfo;
import entity.Point;

public class PackagedPoint {

	public int getMethodPointNum() {
		int i=0;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(MethodPoint.class);
		//区域改动***************************************************************
		criteria.add(Restrictions.eq("clusterid", "3"));
		//区域改动***************************************************************
		List<MethodPoint> list = criteria.list();		
		for(MethodPoint methodPoint:list) {
			i++;
		}
		tx.commit();
		session.close();
		return i;
	}

	public int getMemberPointNum() {
		int i=0;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(MemberPoint.class);
		List<MemberPoint> list = criteria.list();		
		for(MemberPoint memberPoint:list) {
			i++;
		}
		tx.commit();
		session.close();
		return i;
	}

	public MemberPoint getPoint() {
		PackagedPoint pt = new PackagedPoint();
		MemberPoint mt = pt.searchForMaxScore();
		return mt;
	}


	private MemberPoint searchForMaxScore() {	
		MemberPoint mt = new MemberPoint();
		double honour = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(MemberPoint.class);
		List<MemberPoint> list = criteria.list();
		for(MemberPoint mp:list) {
			if(mp.getHonour()>honour) {
				honour = mp.getHonour();
				mt = mp;
			}else if (mp.getHonour()==honour) {
				if (mp.getOrder()>mt.getOrder()) {
					mt=mp;
				}else if (mp.getOrder()==mt.getOrder()) {
					if(mp.getTime()<mt.getTime()) {
						mt = mp;
					}
				}				
			}else {				
			}
		}
		tx.commit();
		session.close();
		return mt;
	}

	public Point cheakForMinDisPoint(Point point0) {
		Point point = new Point();
		String name=null;
		double gpsx=0;
		double gpsy=0;
		double f;
		double d=1;
		double distance = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(MethodPoint.class);
		//区域改动***************************************************************
		criteria.add(Restrictions.eq("clusterid", "3"));
		//区域改动***************************************************************
		List<MethodPoint> list = criteria.list();
		//System.out.println(point0.getGpsx());
		for(MethodPoint mt:list) {		
			//System.out.println(mt.getMgpsx());
			f =(Double.parseDouble(mt.getMgpsx())-point0.getGpsy())*(Double.parseDouble(mt.getMgpsx())-point0.getGpsy())+(Double.parseDouble(mt.getMgpsy())-point0.getGpsx())*(Double.parseDouble(mt.getMgpsy())-point0.getGpsx());
			if(f<d) {
				d = f;
				name = mt.getMname();
				gpsx = Double.parseDouble(mt.getMgpsy());
				gpsy = Double.parseDouble(mt.getMgpsx());
				distance = d;
			}else {
				
			}			
		}	
		tx.commit();
		session.close();
		/*System.out.println(name);
		System.out.println(gpsx);*/
		//区域改动***************************************************************
		//一区接受距离0.0103012437254907
		//二区接受距离0.184229808
		//三区接受距离0.086126741
		if(d<0.086126741) {
		point.setName(name);
		point.setGpsx(gpsx);
		point.setGpsy(gpsy);
		point.setDistance(distance);
		}else{
			point = null;
		}
		//区域改动***************************************************************
		return point;
	}

	public static void saveInfo(Point point1, Point point0, String clustername) {
		PackPointInfo pt = new PackPointInfo();
		
		
		pt.setPointname1(point0.getName());
		pt.setPointname2(point1.getName());
		pt.setDistance(String.valueOf(point1.getDistance()));
		pt.setClusterid(clustername);
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.save(pt);
		session.delete(session.get(MethodPoint.class, point1.getName()));
		
		tx.commit();
		session.close();
	}

	/*public Point changePointFormat(MemberPoint memberPoint) {
		Point point = new Point();
		point.setName(memberPoint.getMemname());
		System.out.println(point.getName());
		point.setGpsx(memberPoint.getMgpsx());
		point.setGpsy(memberPoint.getMgpsy());
		return point;
	}*/

	public void deleteMember(String clustername) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.get(MemberPoint.class, clustername));
		tx.commit();
		session.close();
	}

	public void inital() {		
		int weight;
		double sum =0.0;
		double score;
		Session session =HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(MemberPoint.class);
		List<MemberPoint> list = criteria.list();
		for(MemberPoint memberPoint:list) {
			score = (0.0783*(0.708333333-memberPoint.getTime())+0.7049*memberPoint.getHonour()/100+0.7049*memberPoint.getOrder());
			memberPoint.setScore(String.valueOf(score));
			session.save(memberPoint);
			sum = score + sum;
		}
		Criteria criteria1 = session.createCriteria(MemberPoint.class);
		List<MemberPoint> list1 = criteria1.list();
		//System.out.println(getMethodPointNum());
		for(MemberPoint memberPoint:list1) {
			weight = (int)(Double.parseDouble(memberPoint.getScore())*getMemberPointNum()/sum);
			memberPoint.setWeight(String.valueOf(weight));
			session.save(memberPoint);
		}			
		tx.commit();
		session.close();
	}	
}
