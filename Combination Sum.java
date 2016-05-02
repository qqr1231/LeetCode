public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tep = new ArrayList<Integer>();
        if (candidates.length == 0 || candidates == null) return res;
        
        Arrays.sort(candidates);
        helper(res,tep,candidates,target,0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> tep,int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tep));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            
            tep.add(candidates[i]);
            int newTarget = target - candidates[i];
            helper(res,tep,candidates,newTarget,i);
            
            tep.remove(tep.size()-1);
        }
    }
}P