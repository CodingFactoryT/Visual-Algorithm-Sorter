import javax.swing.SwingWorker;

public class InsertionSort extends SortingAlgorithm {		//O(n^2), best case O(n)
	
	Bar[] ar = getArray();
	
	InsertionSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so, int delay) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				for(int i = 1; i < ar.length; i++) {
					int temp = Main.bars[i].value;
					int j = i - 1;
					
					if(so == SortingOrder.LtoH) {
						while(j >= 0 && ar[j].value > temp) {
							Main.bars[j+1].value = Main.bars[j].value;
							Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
							Thread.sleep(delay);
							j--;
						}		
					} else if(so == SortingOrder.HtoL) {
						while(j >= 0 && ar[j].value < temp) {
							Main.bars[j+1].value = Main.bars[j].value;
							Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
							Thread.sleep(delay);
							j--;
						}	
					}
					
					ar[j+1].value = temp;
					Main.bars[j+1].value = temp;
					Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
					Thread.sleep(delay);
				}
				return null;
			}
      };
      Worker.execute();	
		
	}


}
