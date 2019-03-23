package mainfuntion;

import entity.MemberPoint;
import entity.Point;

public class PackageMethod {

	public static void main(String[] args) {
		int i;
		MemberPoint memberPoint = new MemberPoint();
		Point point0 = new Point();
		Point point1 = new Point();
		String clustername;
		PackagedPoint packagedPoint = new PackagedPoint();
		//初始化
		packagedPoint.inital();
		/*System.out.println(packagedPoint.getMemberPointNum());
		System.out.println(packagedPoint.getMethodPointNum());*/
	/*	if(packagedPoint.getMemberPointNum()<=packagedPoint.getMethodPointNum())*/
		while(packagedPoint.getMemberPointNum()>0)
		{
			memberPoint = packagedPoint.getPoint();
			System.out.println(memberPoint.getMemname());
			//point0 = packagedPoint.changePointFormat(memberPoint);
			point0.setName(memberPoint.getMemname());
			point0.setGpsx(memberPoint.getMgpsx());
			point0.setGpsy(memberPoint.getMgpsy());
			System.out.println(point0.getName());
			clustername = point0.getName();
			for(i=1;i<=Integer.parseInt(memberPoint.getWeight());i++) {
			point1 = packagedPoint.cheakForMinDisPoint(point0);
			if (point1!=null) {
				PackagedPoint.saveInfo(point1,point0,clustername);
				point0 = point1;
				System.out.println(point0.getName());
				System.out.println(clustername);
			}
						 
			}
			packagedPoint.deleteMember(clustername);
		}
	}
}
