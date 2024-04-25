class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        return reversePairsRecursive(nums, 0, nums.size()-1);
    }
    int reversePairsRecursive(vector<int>& nums, int l, int r){
        if(l==r) return 0;
        int m= (l+r)/2;
        return reversePairsRecursive(nums, l, m)+reversePairsRecursive(nums, m+1, r) + merge(nums, l, m, r);
    }
    int merge(vector<int>& nums, int l, int m, int r){
        int ans = 0;
        //统计跨左右的反转对
        for(int i = l, j=m+1; i <= m; i++){
            while(j<=r && (long long)nums[i] > (long long)nums[j]*2) j++;
            ans += (j-m-1);
        }
        //合并左右的排序数组
        vector<int> help(r-l+1);
        int a = l;
        int b = m+1;
        int i = 0;
        while(a<=m && b<=r){
            help[i++] = nums[a] <= nums[b] ? nums[a++] : nums[b++];
        }
        while(a<=m){
            help[i++]=nums[a++];
        }
        while(b<=r){
            help[i++]=nums[b++];
        }
        for(i=0; i<(r-l+1); i++){
            nums[l+i] = help[i];
        }
        return ans;
    }
};