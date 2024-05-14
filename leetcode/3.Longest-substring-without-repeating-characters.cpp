ass Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // 滑动窗口[l...r]
        // help[256]存储下标是char的int，数值代表在s中的下标
        // len：子串长度
        // r不断右移，help[int(nums[r])]如果存在,l移动到这个位置+1, len调整;如果不存在，则注入位置，len更新
        vector<int> help(256,-1);
        int ans = 0;
        for(int l=0, r=0, len=0; r<s.size(); r++){
            l = max(l, help[int(s[r])]+1);
            len = r-l+1;
            ans = max(len, ans);
            help[int(s[r])] = r;
        }
        return ans;
    }
};
