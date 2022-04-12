package main.java.Algorithms;

import javax.swing.SwingWorker;
import main.java.Bar;
import main.java.Settings;
import main.java.SortingAlgorithm;
import main.java.SortingOrder;
import main.java.FrameComponents.ViewPort;

public class InsertionSort extends SortingAlgorithm {		//O(n^2), best case O(n)
	
	Bar[] ar = getArray();
	
	public InsertionSort(Bar[] in) {
		super(in);
	}

	@Override
	public void sort(SortingOrder so) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				for(int i = 1; i < ar.length; i++) {
					int temp = ViewPort.bars[i].value;
					int j = i - 1;
					
					if(so == SortingOrder.LtoH) {
						while(j >= 0 && ar[j].value > temp) {
							ViewPort.bars[j+1].value = ViewPort.bars[j].value;
							ViewPort.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-ViewPort.bars[j+1].value,1000,ViewPort.bars[j+1].value);
							Thread.sleep(Settings.sortingDelay);
							j--;
						}		
					} else if(so == SortingOrder.HtoL) {
						while(j >= 0 && ar[j].value < temp) {
							ViewPort.bars[j+1].value = ViewPort.bars[j].value;
							ViewPort.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-ViewPort.bars[j+1].value,1000,ViewPort.bars[j+1].value);
							Thread.sleep(Settings.sortingDelay);
							j--;
						}	
					}
					
					ar[j+1].value = temp;
					ViewPort.bars[j+1].value = temp;
					ViewPort.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-ViewPort.bars[j+1].value,1000,ViewPort.bars[j+1].value);
					Thread.sleep(Settings.sortingDelay);
				}
				return null;
			}
      };
      Worker.execute();	
		
	}


}
