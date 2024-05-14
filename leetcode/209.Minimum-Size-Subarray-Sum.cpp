ass Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        // 滑动窗口[l...r]，
        // sum：累加和
        // 循环：r向后走，nums[r]累加到sum
        //      当sum-nums[l]>=target时，l从窗口里出去
        //      如果sum>=target，更新当前的子数组长度
        // 如果没找到符合条件的子数组，返回0
        int ans = INT_MAX;
        for(int l=0, r=0, sum=0; r<nums.size(); r++){
            sum += nums[r];
            while(sum - nums[l] >= target){
                sum -= nums[l++];
            }
            if(sum >= target){
                ans = min(ans, r-l+1);
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};
