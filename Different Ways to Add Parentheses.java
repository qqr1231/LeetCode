public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0) return res;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String s1 = input.substring(0,i);
                String s2 = input.substring(i+1);
                List<Integer> l1 = diffWaysToCompute(s1);
                List<Integer> l2 = diffWaysToCompute(s2);
                
                for (int a:l1) {
                    for (int b:l2){
                        if (c == '+') {
                            res.add(a+b);
                        }
                        if (c == '-') {
                            res.add(a-b);
                        }
                        if (c == '*') {
                            res.add(a*b);
                        }
                    }
                }
            }else{
                continue;
            }
        }
        if (res.size() == 0){
            res.add(Integer.valueOf(input));
        } 
        return res;
    }
}