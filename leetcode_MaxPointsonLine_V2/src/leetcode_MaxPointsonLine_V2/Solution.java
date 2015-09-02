package leetcode_MaxPointsonLine_V2;
public class Solution {
	double[] a;
	double[] b;
	boolean [] normal;//the state of line, false vertical line slope infinity, true normal line
	int[] count;
	int[] weight;//number of some specific point
	int use;
	int NUniPoint;//number of unique points
	double eps = 0.001;
	public int maxPoints(Point[] points)
	{
		if(points.length<=2)
		{
			return points.length;
		}
		else
		{
			Point[] points3 = PreProcess2(points);
			Point[] points2 = new Point[NUniPoint];
			for(int i=0; i<NUniPoint;i++)
			{
				points2[i] = points3[i];
			}
			int n = points2.length;
			if(n==1)
			{
				return weight[0];
			}
			else if(n==2)
			{
				return weight[0]+weight[1];
			}
			else
			{
				a = new double[n*(n-1)/2];
				b = new double[n*(n-1)/2];
				normal = new boolean[n*(n-1)/2];
				count = new int[n*(n-1)/2];
				Init(points2[0], points2[1]);
				for(int i=2;i<n;i++)
				{
					CheckOnLine(points2[i], weight[i]);
					UpdateLineData(points2, points2[i], i);
				}
				//PrintResult();
				//PrintWeight();
				//PrintLine();
				return MaxInArray(count);
			}
		}		
    }
	public Point[] PreProcess2(Point[] points)//faster than PreProcess() delete same points, change weights accordingly
	{
		int n = points.length;
		Point[] points2 = new Point[n];//allocate array of size n, but we do not use all of them
		points2[0] = points[0];
		weight = new int[n];
		weight[0] = 1;
		NUniPoint = 1;
		int[] result;
		for(int i=1; i<n; i++)
		{
			result = Contain2(points2, points[i]);
			if(result[0]>0)//if points[i] is already in points2, same point
			{
				weight[result[1]]++;
			}
			else//new unique point, new to points2
			{
				points2[NUniPoint] = points[i];
				weight[NUniPoint] = 1;
				NUniPoint++;
			}
		}
		return points2;
	}
	public int[] Contain2(Point[] points2, Point p)//contain used in PreProcess2()
	{
		int[] result = new int[2];
		for(int i=0;i<NUniPoint;i++)
		{
			if(p.x==points2[i].x && p.y==points2[i].y)
			{
				result[0] = 1; // yes contains
				result[1] = i; // position in points2
				return result;
			}
		}
		result[0] = 0;// no not contains
		result[1] = -1;//no position
		return result;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//begin main methods
	public double[] CalcLine(Point p1, Point p2)
	{
		double[] result = new double[3];
		if(p1.x==p2.x)//not normal line i.e. vertical line
		{
			result[0] = p1.x; // x-axis position
			result[1] = p1.x; // this does not matter 
			result[2] = -1;// indicator that this line is not a line, two or more dots at one position
		}
		else
		{
			double k = (p1.y-p2.y+0.0)/(p1.x-p2.x+0.0);
			double c = (p1.x*p2.y-p2.x*p1.y+0.0)/(p1.x-p2.x+0.0);
			result[0] = k;
			result[1] = c;
			result[2] = 1;//this line is normal
		}
		return result;
	}
	public void Init(Point p1, Point p2)
	{
		double[] result = new double[3];
		result = CalcLine(p1, p2);
		a[0] = result[0];
		b[0] = result[1];
		normal[0] = (result[2]>0)? true:false;
		count[0] = weight[0] + weight[1];
		use = 1;
	}
	public void CheckOnLine(Point p, int w)//w is the weight of point p
	{
		int n = a.length;
		for(int i=0; i<n; i++)
		{
			if(normal[i])
			{
				if(Math.abs(p.y-a[i]*p.x-b[i])<eps)
				{
					count[i] += w;
				}
			}
			else
			{
				if(Math.abs(p.x-a[i])<eps)
				{
					count[i] += w;
				}
			}
		}
	}
	public void UpdateLineData(Point[] points, Point p, int index)
	{
		double[] result = new double[3];
		int TmpUse = use;
		for(int i=0; i<index; i++)
		{
			result = CalcLine(points[i],p);
			a[TmpUse+i] = result[0];
			b[TmpUse+i] = result[1];
			count[TmpUse+i] = weight[i] + weight[index];
			normal[TmpUse+i] = (result[2]>0)? true:false;
			use++;
		}
	}
	public int MaxInArray(int[] a)
	{
		int tmp = 0;
		for(int i=0; i<a.length; i++)
		{
			if(tmp<a[i])
			{
				tmp = a[i];
			}
		}
		return tmp;
	}
	public void PrintResult()
	{
		System.out.println(a.length+"	"+use);
	}
	public void PrintWeight()
	{
		System.out.print("weight:     ");
		for(int i=0;i<weight.length;i++)
		{
			System.out.print(weight[i]+"    ");
		}
		System.out.println();
	}
	public void PrintLine()
	{
		System.out.print("line:     ");
		for(int i=0;i<a.length;i++)
		{
			System.out.print("("+a[i]+", "+b[i]+")	");
		}
		System.out.println();
	}
}

