package divideTwoIntegers;

public class Solution {
	int abs(int a) {
		if(a<0) {
			return -a;
		}
		else {
			return a;
		}
	}
	public int divide(int dividend, int divisor) {
		if(divisor==0) {
        	return Integer.MAX_VALUE;
        }
        if(divisor == dividend) {
        	return 1;
        }
        if(divisor+dividend == 0) {
        	return -1;
        }
        if(dividend==0) {
        	return 0;
        }
        if(divisor == Integer.MIN_VALUE) {
        	return 0;
        }
        if(divisor == Integer.MAX_VALUE) {
        	if(dividend == Integer.MAX_VALUE) {
        		return 1;
        	}
        	else if(dividend == Integer.MIN_VALUE) {
        		return -1;
        	}
        	else {
        		return 0;
        	}
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1) {
        	return Integer.MIN_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
        	return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE) {
        	if(divisor>0) {
        		return -1+divide(dividend+divisor, divisor);
        	}
        	else {
        		return 1+divide(dividend-divisor, divisor);
        	}        	
        }
        int a = abs(dividend), b = abs(divisor);
        if(a<b) {
        	return 0;
        }
        int tmp1 = b, i=0;
        int result = 0, tmp2 = a, tmp3;
        while(tmp2>=tmp1) {
        	result += (1<<i);
        	tmp2 -= tmp1;
        	tmp3 = (tmp1<<1);
        	if(tmp3>0)
        	{tmp1 = tmp3;i++;}
        	System.out.println(tmp1+" "+tmp2+" "+tmp3+" "+result+" "+" "+i);
        }
        for(int j=i; j>=0; j--) {
        	if(tmp2>=tmp1) {
        		tmp2 -= tmp1;
        		result += (1<<j);
        	}
        	tmp1 = (tmp1>>1);
        }
        if((dividend>0 && divisor>0)||(dividend<0 && divisor<0)) {
        	return result;
        }
        else {
        	return -result;
        }      
    }
}
