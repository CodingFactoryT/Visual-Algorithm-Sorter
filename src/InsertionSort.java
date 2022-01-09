
public class InsertionSort extends SortingAlgorithm {		//O(n^2), best case O(n)
	
	Bar[] ar = getArray();
	
	InsertionSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so) {
		for(int i = 1; i < ar.length; i++) {
			int temp = Main.bars[i].value;
			int j = i - 1;
			
			if(so == SortingOrder.LtoH) {
				while(j >= 0 && ar[j].value > temp) {
					Main.bars[j+1].value = Main.bars[j].value;
					Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
					j--;
				}		
			} else if(so == SortingOrder.HtoL) {
				while(j >= 0 && ar[j].value < temp) {
					Main.bars[j+1].value = Main.bars[j].value;
					Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
					j--;
				}	
			}
			
			ar[j+1].value = temp;
			Main.bars[j+1].value = temp;
			Main.bars[j+1].panel.setBounds(0,Settings.allBarsPanelHeigth-Main.bars[j+1].value,1000,Main.bars[j+1].value);
		}
		
	}


}
