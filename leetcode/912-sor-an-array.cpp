class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        if(nums.size()>1){
            quickSort2(nums, 0, nums.size()-1);
        }
        return nums;
    }
    //经典随机快排，超时
    void quickSort1(vector<int>& nums, int l, int r){
        if(l>=r) return;
        //随机取数
        int i = rand() % (r - l + 1) + l;
        int mid = partition1(nums, l, r, nums[i]);//随机数x=nums[i]
        quickSort1(nums,l,mid-1);
        quickSort1(nums,mid+1,r);
    }
    //划分数组，a代表x的index，<=x放左边区域，nums[0...a-1]，>x放右边区域nums[a+1...r]
    int partition1(vector<int> &nums, int l, int r, int x){
        int a=l;
        int xIndex=0;//x的index
        for(int i=l; i<=r; i++){
            if(nums[i]<=x){//放到a左侧
                swap(nums, i, a);
                if(nums[a]==x) xIndex=a;//记录x的index
                a++;
            }
        }
        swap(nums, xIndex, a-1);
        return a-1;
    }
    void swap(vector<int> &nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    //优化后的随机快排
    //荷兰国旗问题，partition2会将数组划分成<x, =x, >x三个区域，=x区域是nums[a...b]
    int first, last;//记录partition后的=x的区域的左右边界，防止被递归sort中被改变
    void quickSort2(vector<int>& nums, int l, int r){
        if(l>=r) return;
        //随机取数
        int i = rand() % (r - l + 1) + l;
        partition2(nums, l, r, nums[i]);//随机数x=nums[i]
        int left = first, right=last;
        quickSort2(nums,l,left-1);
        quickSort2(nums,right+1,r);
    }
    //不再记录xIndex
    void partition2(vector<int> &nums, int l, int r, int x){
        first=l;
        last=r;
        for(int i=l; i<=last;){
            if(nums[i]==x){
                i++;
            }else if(nums[i]<x){
                //放左侧
                swap(nums, first++, i++);
            }else{
                //放右侧, i不动是因为i换成了新的数值，要跟a的数值做比较
                swap(nums, last--, i);
            }
        }
    }
};