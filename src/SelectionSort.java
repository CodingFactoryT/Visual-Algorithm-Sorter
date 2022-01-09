
public class SelectionSort extends SortingAlgorithm {		//O(n^2)
	
	Bar[] ar = getArray();
	
	SelectionSort(Bar[] in) {
		super(in);
	}

	@Override
	void sort(SortingOrder so) {
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
			swapBars(Main.bars[i], Main.bars[min]);
		}
	}
}
