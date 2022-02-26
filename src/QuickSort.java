import javax.swing.SwingWorker;

public class QuickSort extends SortingAlgorithm {	//O(n log n), worst O(n^2);
	
	Bar[] ar = getArray();

	
	QuickSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				quickSort(ar, 0, ar.length-1, so);	
				return null;
			}
      };
      Worker.execute();
	}

	void quickSort(Bar[] ar, int start, int end, SortingOrder so) throws Exception{
		if(end <= start) return; 
		
		int pivot = partition(ar, start, end, so);
		quickSort(ar, start, pivot -1, so);
		quickSort(ar, pivot +1, end, so);
	}
	
	int partition(Bar[] ar, int start, int end, SortingOrder so) throws Exception{
		int pivot = ar[end].value;
		int i = start -1;
		
		for(int j = start; j < end; j++) {
			if(so == SortingOrder.LtoH) {
				if(ar[j].value < pivot) {
					i++;
					swapBars(Main.bars[i], Main.bars[j]);
					Thread.sleep(Settings.sortingDelay);
				}				
			} else {
				if(ar[j].value > pivot) {
					i++;
					swapBars(Main.bars[i], Main.bars[j]);
					Thread.sleep(Settings.sortingDelay);
				}
			}
		}
		i++;
		swapBars(Main.bars[i], Main.bars[end]);
		Thread.sleep(Settings.sortingDelay);
		return i;
	}
}
