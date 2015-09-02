package leetcode_MaxPointsonaLine;

public class s {
	public static void main(String[] args)
	{
		int n = 9;
		Point[] points = new Point[n];
		/*for(int i=0;i<n;i++)
		{
			points[i] = new Point((int)Math.round(Math.random()*100),(int)Math.round(Math.random()*100));
		}*/
		points[0] = new Point(84,250);
		points[1] = new Point(0,0);
		points[2] = new Point(1,0);
		points[3] = new Point(0,-70);
		points[4] = new Point(0,-70);
		points[5] = new Point(1,-1);
		points[6] = new Point(21,10);
		points[7] = new Point(42,90);
		points[8] = new Point(-42,-230);
		Solution s = new Solution();
		System.out.println(s.maxPoints(points));
		//System.out.print(s.Contain(points, points[0])[0]+"	"+s.Contain(points, points[0])[1]);
		//s.PrintResult();
	}
}
