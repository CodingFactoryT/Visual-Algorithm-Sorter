
public class QuickSort extends SortingAlgorithm {	//O(n log n), worst O(n^2);
	
	Bar[] ar = getArray();

	
	QuickSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so) {
		quickSort(ar, 0, ar.length-1, so);	
	}

	void quickSort(Bar[] ar, int start, int end, SortingOrder so) {
		if(end <= start) return; 
		
		int pivot = partition(ar, start, end, so);
		quickSort(ar, start, pivot -1, so);
		quickSort(ar, pivot +1, end, so);
	}
	
	int partition(Bar[] ar, int start, int end, SortingOrder so) {
		int pivot = ar[end].value;
		int i = start -1;
		
		for(int j = start; j < end; j++) {
			if(so == SortingOrder.LtoH) {
				if(ar[j].value < pivot) {
					i++;
					swapBars(Main.bars[i], Main.bars[j]);
				}				
			} else {
				if(ar[j].value > pivot) {
					i++;
					swapBars(Main.bars[i], Main.bars[j]);
				}
			}
		}
		i++;
		swapBars(Main.bars[i], Main.bars[end]);
		return i;
	}
}
