public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                res[i] =res[i] | (1 << words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if ((res[i] & res[j]) == 0) {
                    max = Math.max(words[i].length()*words[j].length(),max);
                    //System.out.println(words[i] +"+"+words[j]);
                }
                    
            }
        }
        return max;
    }
}