void insertSort(vector<int> &arr){
    if(arr.empty() || arr.size()<2) return;
    for(int end=arr.size()-1; end>0; end--){
        for(int i=end-1; i>0; i--){
	    if(arr[i]>arr[i+1]) swap(arr, i, i+1);
	}
    }
    return;
}
