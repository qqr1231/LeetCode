public class NumArray {
    // create binary indexed tree
    int[] num;
    int[] tree;
    int size;
    
    public NumArray(int[] nums) {
        this.size = nums.length;
        this.num = new int[nums.length];
        this.tree = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
            updateTree(i, nums[i]);
        }
    }
    
    void updateTree(int i, int val) {
        i++;
        while (i <= size) {
            tree[i] = tree[i] + val;
            i += i&(-i);
        }
    }
    
    void update(int i, int val) {
        updateTree(i, val - num[i]);
        num[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        j++;
        while (j > 0) {
            int t = j&(-j);
            sum += tree[j];
            j -= t;
            
        }
        while (i > 0) {
            int t = i&(-i);
            sum -= tree[i];
            i -= t;
        }
        
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);