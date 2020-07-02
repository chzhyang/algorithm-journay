
//快速排序
//挖坑填数法，第一个数做基准
void quick_sort(int s[], int l, int r)
{
    if (l < r)
    {
		//Swap(s[l], s[(l + r) / 2]); //如果是中间的数做基准，则将中间的这个数和第一个数交换
        int i = l, j = r, x = s[l];//第一个数做基准
        while (i < j)
        {
            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
				j--;  
            if(i < j) 
				s[i++] = s[j];
			
            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
				i++;  
            if(i < j) 
				s[j--] = s[i];
        }
        s[i] = x;//本趟基准放入最终位置
        quick_sort(s, l, i - 1); // 递归调用左侧
        quick_sort(s, i + 1, r);//右侧
    }
}
