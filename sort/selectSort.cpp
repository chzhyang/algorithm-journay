void swap(vector<int> &arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
selectSort(vector<int> &arr){
    if(arr.empty() || arr.size()<2) return;
    for(int i=0; i<arr.size()-1; i++){
        int minIndex = i;
	for(int j=i+1; j<arr.size(); j++){
	    if(arr[j]<arr[minIndex]){
	        minIndex = j;
	    }
	}
	swap(arr, i, minIndex);
    }
    return;
}
