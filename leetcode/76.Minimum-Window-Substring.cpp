class Solution {
public:
    string minWindow(string s, string t) {
        // 滑动窗口[l...r]
        // debt = t.size() 总欠债，正数表示欠债
        // count[256] 下标是t的int(字符)，数值是该字符的欠债，负数表示欠债
        // 满足的条件：debt==0
        vector<int> count(256,0);
        //init count[]欠债
        for(int i=0; i<t.size(); i++){
            count[int(t[i])]--;
        }
        //子串长度
        int len = INT_MAX;
        //子串的初始坐标
        int start = 0;
        for(int l=0, r=0, debt=-(t.size()); r<s.size(); r++){
            //r进入窗口，如果该字符有欠债，则该欠债（负数）减少，同时总负债（正数）减少
            if(count[int(s[r])] < 0){
                debt++;
            }
            count[int(s[r])]++;
            if(debt==0){
                //如果总负债归零了，看看窗口左侧能不能右移
                while(count[int(s[l])] > 0){
                    //l出窗口
                    count[int(s[l])]--;
                    l++;
                }
                //更新最短串的起始位置和长度
                if(r-l+1 < len){
                    len = r-l+1;
                    start = l;
                }
            }
        }
        return len == INT_MAX ? string() : s.substr(start, len);
    }
};
