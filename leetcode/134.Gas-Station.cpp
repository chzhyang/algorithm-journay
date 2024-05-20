class Solution {
public:
    int ringAdd(int r, int n){
            if(r==n-1) return 0;
            else return r+1;
    }
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        // 车辆尝试从0~n-1出发，看能不能走一圈，l
		// r : 窗口即将进来的下标
		// len : 窗口大小
		// sum : 窗口累加和
        for(int l=0, r=0, sum=0, len=0; l<n; l++){
            while(sum >= 0){
                if(len==n) return l;
                len++;
                sum += gas[r]-cost[r];
                // r=ringAdd(r, n);
                r = (l+len) % n;
            }
            // sum <0，此时 l 为起点无法完成一圈，l 出窗口，起点变为 l+1
            len--;
            sum -= gas[l]-cost[l];
        }
        return -1;
    }
};