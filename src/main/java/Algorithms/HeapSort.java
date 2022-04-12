package main.java.Algorithms;

import javax.swing.SwingWorker;
import main.java.Bar;
import main.java.Settings;
import main.java.SortingAlgorithm;
import main.java.SortingOrder;

public class HeapSort extends SortingAlgorithm{
	
	Bar[] ar = getArray();

	public HeapSort(Bar[] in) {
		super(in);
	}
	
	@Override
	public void sort(SortingOrder so) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				int size = ar.length;
				
				for(int i = size/2-1; i>=0; i--) {
					heapify(so, ar, size, i);
				}
				
				for(int i=size-1; i>=0; i--) {
					swapBars(ar[0], ar[i]);
					Thread.sleep(Settings.sortingDelay);
					heapify(so, ar, i, 0);
				}	
				return null;
			}
      };
      Worker.execute();
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
