
public class BubbleSort extends SortingAlgorithm {		//O(n^2)

	Bar[] ar = getArray();
	
	BubbleSort(Bar[] in) {
		super(in);	
	}

	@Override
	void sort(SortingOrder so) {
		for(int i = 0; i < ar.length -1; i++) {
			for(int j = 0; j < ar.length -i -1; j++) {
				if(so == SortingOrder.LtoH) {
					if(ar[j].value > ar[j+1].value) {
						swapBars(Main.bars[j], Main.bars[j+1]);
					}	
				} else if(so == SortingOrder.HtoL) {
					if(ar[j].value < ar[j+1].value) {
						swapBars(Main.bars[j], Main.bars[j+1]);
					}	
				}
			}
			
			
		}
		
	}

}
