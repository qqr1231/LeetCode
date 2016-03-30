/*  38. Count and Say
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
*/
public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if(n <= 0)  return null;
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < res.length(); j++){
                int count = 0;
                char c = res.charAt(j);
                count++;
                while(j+1 < res.length() && res.charAt(j+1) == c){
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(c);
            }
            res = sb.toString();
        }
       return res; 
    }
}