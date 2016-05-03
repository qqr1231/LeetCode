// iteration solution
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) return res;
        ArrayList<Integer> tep = new ArrayList<Integer>();
        res.add(tep);
        
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for (int x = 0;  x < res.size(); x++) {
                List<Integer> l = res.get(x);
                int k = l.size();
                for (int j = 0; j <= k; j++) {
                    List<Integer> t = new ArrayList<Integer>(l);
                    t.add(j, nums[i]);
                    System.out.println(l);
                    cur.add(t);
                }
            }
            res = new ArrayList<List<Integer>>(cur);
        }
        return res;
    }
}

// backtracking solution
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) return res;
        List<Integer> tep = new ArrayList<Integer>();
        helper(res, tep, nums, 0);
        return res;
       
    }
    
    public void helper(List<List<Integer>> res, List<Integer> tep, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(tep));
            return;
        }
        ArrayList<Integer> t = new ArrayList<Integer>(tep);
        for (int i = index; i >= 0; i--) {
            t.add(i,nums[index]);
            helper(res, t, nums, index+1);
            t.remove(i);
        }
    }
}