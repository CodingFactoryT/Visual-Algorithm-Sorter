package main.java;

public abstract class SortingAlgorithm {

	public Bar[] in;
	
	public SortingAlgorithm(Bar[] in){
		this.in = in;
	} 
	
	public abstract void sort(SortingOrder so);

	public void swapBars(Bar bar1, Bar bar2) { 
		int temp = bar1.value;
		bar1.value = bar2.value;
		bar2.value = temp;	
		bar1.panel.setBounds(0,Settings.allBarsPanelHeigth-bar1.value,1000,bar1.value);
		bar2.panel.setBounds(0,Settings.allBarsPanelHeigth-bar2.value,1000,bar2.value);
	}
		
	public Bar[] getArray() {
		return this.in;
	}
	
	public void printArray() {	//only for debugging purposes
		String output = "";
		output += "[";
		for(Bar i : this.in) {
			output +=  i.value + ", ";
		}
		output = output.substring(0, output.length()-2);
		output += "]";
		System.out.println(output);
	}
}
