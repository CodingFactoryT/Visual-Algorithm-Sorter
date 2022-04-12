package main.java.Algorithms;

import javax.swing.SwingWorker;
import main.java.Bar;
import main.java.Settings;
import main.java.SortingAlgorithm;
import main.java.SortingOrder;
import main.java.FrameComponents.ViewPort;

public class SelectionSort extends SortingAlgorithm {		//O(n^2)
	
	Bar[] ar = getArray();
	
	public SelectionSort(Bar[] in) {
		super(in);
	}

	@Override
	public void sort(SortingOrder so) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				for(int i = 0; i < ar.length -1; i++) {
					int min = i;
					for(int j = i + 1; j < ar.length; j++) {
						if(so == SortingOrder.LtoH) {
							if(ar[min].value > ar[j].value) 
								min = j;					
						} else if(so == SortingOrder.HtoL) {
								if(ar[min].value < ar[j].value) 
									min = j;			
						}
					}
					swapBars(ViewPort.bars[i], ViewPort.bars[min]);
					Thread.sleep(Settings.sortingDelay);
				}
				return null;
			}
      };
      Worker.execute();
		
	}			
}
