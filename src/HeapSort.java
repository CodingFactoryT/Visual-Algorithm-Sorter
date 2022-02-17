import javax.swing.SwingWorker;

public class HeapSort extends SortingAlgorithm{
	
	Bar[] ar = getArray();

	HeapSort(Bar[] in) {
		super(in);
	}
	
	@Override
	void sort(SortingOrder so, int delay) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				heapSort(so, ar, delay);
				return null;
			}
      };
      Worker.execute();
	}
	
	void heapSort(SortingOrder so, Bar[] array, int delay) throws Exception {
		int size = array.length;
		
		for(int i = size/2-1; i>=0; i--) {
			heapify(so, array, size, i, delay);
		}
		
		for(int i=size-1; i>=0; i--) {
			swapBars(array[0], array[i]);
			Thread.sleep(delay);
			heapify(so, array, i, 0, delay);
		}		
	}
	
	void heapify(SortingOrder so, Bar array[], int size, int i, int delay) throws Exception{
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
			Thread.sleep(delay);
			heapify(so, array, size, largest, delay);
		}
		
	}

}
