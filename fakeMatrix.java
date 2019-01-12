
public class fakeMatrix {
	
	private static int[] row0 = {4, 4, 2, 2};
	
	static void printRow(int[] row) {
		for(int i : row) {
			System.out.print(i);
		}
	}
	
	static void pushLeft(int[] Row_Column) {
		int count = 0;
		for (int i = 0; i<=3; i++) {
			if(Row_Column[i] != 0) {
				Row_Column[count] = Row_Column[i];
				count++;
			}
		}
		while(4-count>0) {
			Row_Column[count] = 0;
			count++;
		}

	}
	
	static void toTheLeft(int[] Row_Column) {
		//Push
		pushLeft(Row_Column);
		//Add
		for (int i = 0; i<3; i++) {
			if(Row_Column[i] == Row_Column[i+1]) { 
				Row_Column[i]=Row_Column[i]+Row_Column[i+1];
				Row_Column[i+1]=0;
			}
		}
		//Push again
		pushLeft(Row_Column);
	}
	
	
	static void toTheRight1(int[] Row_Column) {
		//Push
		pushRight1(Row_Column);
		//Add
		for (int i=3; i>0; i--) {
			if(Row_Column[i] == Row_Column[i-1]) {
				Row_Column[i]=Row_Column[i]+Row_Column[i-1];	
				Row_Column[i-1] = 0;
			}
		}
		//Push again
		pushRight1(Row_Column);
	}
	
	static void pushRight1(int[] Row_Column) {
		int count = 3;
		for (int i=3; i>=0; i--) {
			if(Row_Column[i] != 0) {
				Row_Column[count]=Row_Column[i];
				count--;
			}
		}
		while(count>=0) {
			Row_Column[count]=0;
			count--;
		}
	}
	
	static void toTheRight(Entry[] Row_Column) {
		//Push
		pushRight(Row_Column);
		//Add
		for (int i=3; i>0; i--) {
			if(Row_Column[i].data() == Row_Column[i-1].data()) { 
				Row_Column[i].setData(Row_Column[i].data()+Row_Column[i-1].data());
				Row_Column[i-1].setData(0);
			}
		}
		//Push again
		pushRight(Row_Column);
	}
	
	static void pushRight(Entry[] Row_Column) {
		int count = 3;
		for (int i=3; i>=0; i--) {
			if(Row_Column[i].data() != 0) {
				Row_Column[count].setData(Row_Column[i].data());
				count--;
			}	
		}
		while(count>=0) {
			Row_Column[count].setData(0);;
			count--;
		}
	}
	public static void main (String[] args) {
		toTheRight1(row0);
		printRow(row0);
//		System.out.println();
//		toTheLeft(row0);
//		printRow(row0);
//		System.out.println();
		
	}
}