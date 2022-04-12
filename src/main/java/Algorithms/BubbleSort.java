package main.java.Algorithms;

import javax.swing.SwingWorker;
import main.java.Bar;
import main.java.Settings;
import main.java.SortingAlgorithm;
import main.java.SortingOrder;
import main.java.FrameComponents.ViewPort;

public class BubbleSort extends SortingAlgorithm{		//O(n^2)

	Bar[] ar = getArray();

	public BubbleSort(Bar[] in) {
		super(in);	
	}

	@Override
	public void sort(SortingOrder so) {	
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				for(int i = 0; i < ar.length -1; i++) {
					for(int j = 0; j < ar.length -i -1; j++) {
						if(so == SortingOrder.LtoH) {
							if(ar[j].value > ar[j+1].value) {
								swapBars(ViewPort.bars[j], ViewPort.bars[j+1]);
								Thread.sleep(Settings.sortingDelay);
							}	
						} else if(so == SortingOrder.HtoL) {
							if(ar[j].value < ar[j+1].value) {
								swapBars(ViewPort.bars[j], ViewPort.bars[j+1]);
								Thread.sleep(Settings.sortingDelay);
							}	
						}
					}
				}
				return null;
			}
      };
      Worker.execute();
	}

}
