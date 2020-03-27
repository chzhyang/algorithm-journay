package greedy;

import java.util.*;
import java.lang.Math;
public class CatEat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int h = Integer.parseInt(sc.nextLine());
        int[] data = new int[s.length];
        int max = 0;//上限
        int min = 0;//下限
        int mid = 0;
        int sum = 0;
        for(int i = 0; i < s.length; i++){
            data[i] = Integer.parseInt(s[i]);
            max = Math.max(max, data[i]);
            sum += data[i];
        }
        min = (sum%h == 0)? sum/h:sum/h+1;
        //System.out.println("min="+min);
        //二分查找
        while(min < max){
            mid = (max + min )/2;
            //验证
            //如在左边，max变成res
            if(verify(data, s.length, mid, h)){
                max = mid;
            }else{//如果在右边，min变成res
                min = mid + 1;
            }
            //如果下限满足条件，则成功退出 ???
            if(verify(data, s.length, min, h))
            {
                System.out.println(min);
                break;
            }
        }
    }
    public static boolean verify(int[] data, int n, int k, int h){
        int res = 0;
        for(int i = 0; i<n; i++){
            res += (data[i]%k == 0)?data[i]/k:data[i]/k+1;
        }
        return res <= h;//总时间小于h，说明速度还可以再增大，二分法变到右侧
    }
}