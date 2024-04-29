class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //随机选择算法来解决第K大的问题
        return randomizedSelect(nums, nums.size()-k);//第k大的下标是nums.size()-k
    }
    //利用荷兰国旗问题和分治思想
    //随机选择x，通过partition划分后，对比first，last和i，i必然在=x区域的左、中、右侧
    //如果i在=x区域，则找到答案，否则在相应区域继续随机partition
    int randomizedSelect(vector<int>& nums, int i){
        int ans = 0;
        for(int l = 0, r=nums.size()-1; l<=r;){
            int index = l + (int)(rand()%(r-l+1));
            int x = nums[index];
            partition(nums, l, r, x);
            if(i<first){
                r = first-1;
            }else if(i>last){
                l = last+1;
            }else{
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
    //荷兰国旗问题，划分三个区域，<x, =x, >x, fisrt和last是=x区域的左右边界
    int first, last;
    void partition(vector<int>& nums, int l, int r, int x){
        first = l;
        last =r;
        int i = l;
        while(i<=last){
            if(nums[i]==x){
                i++;
            }else if(nums[i]<x){
                swap(nums, i++, first++);
            }else{
                swap(nums, i, last--);
            }
        }
    }
    void swap(vector<int>& nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
};