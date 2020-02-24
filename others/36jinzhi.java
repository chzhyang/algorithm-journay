//0-z分别表示36进制中的0-35，求两个36进制数的假加法
class Solution{
	String nums = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public String add(String s1, String s2){
		String res = new String();
		int i = s1.length()-1;
		int j = s2.length()-1;
		int sum  = 0;
		int tmp = 0 //进位符
		int index1 = 0;
		int index2 = 0;
		//加
		while(i >=0 && j>= 0){
			index1 = nums.indexOf(s1[i]);
			index2 = nums.indexOf(s2[j]);
			sum = index1 + index2 + tmp;
			if(sum >= 36){
				tmp = 1;
				sum = sum%36;
			}
			else{
				tmp = 0;
			}
			//拼接结果
			res += nums[sum];
			i--;
			j--;
		}
		//s1还有余位
		while(i>=0){
			sum = nums.indexOf(s1[i]) + tmp;
			if(sum >= 36){
				tmp = 1;
				sum = sum%36;
			}
			else{
				tmp = 0;
			}
			//拼接结果
			res += nums[sum];
			i--;
		}
		//s2
		while(j>=0){
			sum = nums.indexOf(s2[j]) + tmp;
			if(sum >= 36){
				tmp = 1;
				sum = sum%36;
			}
			else{
				tmp = 0;
			}
			//拼接结果
			res += nums[sum];
			j--;
		}
		//最后有进位
		if(tmp == 1){
			res += '1';
		}
		//反转res
		return new StringBuffer(res).reverse().toString();
		
	}
	
}

