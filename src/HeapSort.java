
public class HeapSort extends SortingAlgorithm{
	
	Bar[] ar = getArray();
//	int[] ar = new int[] {234,654,7,412,412,5,63,6,43,6,72,1464,523,643};
	HeapSort(Bar[] in) {
		super(in);
	}
	
	@Override
	void sort(SortingOrder so) {
		heapSort(so, ar);
	}
	
	void heapSort(SortingOrder so, Bar[] array) {
		int size = array.length;
		
		for(int i = size/2-1; i>=0; i--) {
			heapify(so, array, size, i);
		}
		
		for(int i=size-1; i>=0; i--) {
			swapBars(array[0], array[i]);		
			heapify(so, array, i, 0);
		}
	}
	
	void heapify(SortingOrder so, Bar array[], int size, int i) {
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		if(so == SortingOrder.LtoH) {
			if(l<size && array[l].value > array[largest].value) {
				largest = l;
			}
			
			if(r<size && array[r].value > array[largest].value) {
				largest = r;
			}			
		} else if(so == SortingOrder.HtoL){
			if(l<size && array[l].value < array[largest].value) {
				largest = l;
			}
			
			if(r<size && array[r].value < array[largest].value) {
				largest = r;
			}
		}
		
		if(largest != i) {
			swapBars(array[i], array[largest]);
			heapify(so, array, size, largest);
		}
		
	}

}
