public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length < 4)  return false;
        int t1 = 0;
        int t2 = x[0];
        int t3 = x[1];
        int t4 = x[2];
        int t5;
        boolean flag = (t4 > t2) ? false:true;
        for (int i = 3; i < x.length; i++){
            t5 = x[i];
            if(flag && t5 >= t3)    return true;
            else if(!flag && t5 <= t3){
                if(i+1 < x.length && x[i+1] + t2 < t4 || t5 + t1 < t3){
                    flag = true;
                }else if(i+1 < x.length)   return true;
            }
            t1 = t2;
            t2 = t3;
            t3 = t4;
            t4 = t5;
        }
       return false; 
    }
}