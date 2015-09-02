package powxn;

public class Solution {
    public double pow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n<0){
            return 1/x*1/pow(x,-(n+1));
        }
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        if(n%2==0){
            double r=pow(x,n/2);
            return r*r;
        }
        else{
            double r=pow(x,(n-1)/2);
            return x*r*r;
        }
    }
}