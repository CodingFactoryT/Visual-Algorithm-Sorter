import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class MergeSort extends SortingAlgorithm{		//O(n log n), but more space
	
	Bar[] ar = getArray();
	MergeSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so, int delay) {
		SwingWorker<Void, String> Worker = new SwingWorker<Void, String>(){

			@Override
			protected Void doInBackground() throws Exception {
				mergeSort(ar, so, delay);
				return null;
			}
      };
      Worker.execute();
	}
	
	void mergeSort(Bar[] ar, SortingOrder so, int delay) throws Exception{

		int length = ar.length;
		if(length <= 1) return;	//base case
		
		int middle = length / 2;
		Bar[] leftArray = new Bar[middle];
		for(int i = 0; i<leftArray.length; i++) {
			leftArray[i] = new Bar(new JPanel(), 10);		
		}
		
		Bar[] rightArray = new Bar[length - middle];
		for(int i = 0; i<rightArray.length; i++) {
			rightArray[i] = new Bar(new JPanel(), 10);		
		}
		
		int j = 0;	//for rightArray
		
		for(int l = 0;l < length; l++) {
			if(l < middle) {
				leftArray[l].value = ar[l].value;
			} else {
				rightArray[j].value = ar[l].value;
				j++;
			} 
		}
		mergeSort(leftArray, so, delay);
		mergeSort(rightArray, so, delay);
		merge(leftArray, rightArray, ar, so, delay);
	}
	
	void merge(Bar[] leftArray, Bar[] rightArray, Bar[] ar, SortingOrder so, int delay) throws Exception{
		int leftSize = ar.length / 2;
		int rightSize = ar.length - leftSize;
		int i = 0, l = 0, r = 0; 	//indices
		
		while(l < leftSize && r < rightSize) {
			if(so==SortingOrder.LtoH) {
				if(leftArray[l].value < rightArray[r].value) {
					ar[i].value = leftArray[l].value;
					Main.bars[i].value = leftArray[l].value;
					Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
					Thread.sleep(delay);
					i++;
					l++;
				} else {
					ar[i].value = rightArray[r].value;
					Main.bars[i].value = rightArray[r].value;
					Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
					Thread.sleep(delay);
					i++;
					r++;
				}			
			} else {
				if(leftArray[l].value > rightArray[r].value) {
					ar[i].value = leftArray[l].value;
					Main.bars[i].value = leftArray[l].value;
					Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
					Thread.sleep(delay);
					i++;
					l++;
				} else {
					ar[i].value = rightArray[r].value;
					Main.bars[i].value = rightArray[r].value;
					Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
					Thread.sleep(delay);
					i++;
					r++;
				}			
			}
		}
		
		while(l < leftSize) {
			ar[i].value = leftArray[l].value;
			Main.bars[i].value = leftArray[l].value;
			Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
			Thread.sleep(delay);
			i++;
			l++;
		}
		while(r < rightSize) {
			ar[i].value = rightArray[r].value;
			Main.bars[i].value = rightArray[r].value;
			Main.bars[i].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[i].value,1000,Main.bars[i].value);
			Thread.sleep(delay);
			i++;
			r++;
		}
	}
}
