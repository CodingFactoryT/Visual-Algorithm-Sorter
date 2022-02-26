import javax.swing.SwingWorker;

public class HeapSort extends SortingAlgorithm{
	
	Bar[] ar = getArray();

	HeapSort(Bar[] in) {
		super(in);
	}
	
	@Override
	void sort(SortingOrder so) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				heapSort(so, ar);
				return null;
			}
      };
      Worker.execute();
	}
	
	void heapSort(SortingOrder so, Bar[] array) throws Exception {
		int size = array.length;
		
		for(int i = size/2-1; i>=0; i--) {
			heapify(so, array, size, i);
		}
		
		for(int i=size-1; i>=0; i--) {
			swapBars(array[0], array[i]);
			Thread.sleep(Settings.sortingDelay);
			heapify(so, array, i, 0);
		}		
	}
	
	void heapify(SortingOrder so, Bar array[], int size, int i) throws Exception{
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
			Thread.sleep(Settings.sortingDelay);
			heapify(so, array, size, largest);
		}
		
	}

}
