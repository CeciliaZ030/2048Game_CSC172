import java.awt.event.KeyEvent;
import java.util.Random;

public class Entry {
	
	private int data;
	private final int index;
	
	public Entry(int index) {
		this.data = 0;
		this.index = index;

	}
	
	public int data() {
		return data;
	}
	
	public String dataToString() {
		return String.valueOf(data);
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public int index() {
		return index;
	}

	
}

class Matrix {
	
	static Random r = new Random();
	
	static Entry entry1 = new Entry(1);
	static Entry entry2 = new Entry(2);
	static Entry entry3 = new Entry(3);
	static Entry entry4 = new Entry(4);
	static Entry entry5 = new Entry(5);
	static Entry entry6 = new Entry(6);
	static Entry entry7 = new Entry(7);
	static Entry entry8 = new Entry(8);
	static Entry entry9 = new Entry(9);
	static Entry entry10 = new Entry(10);
	static Entry entry11 = new Entry(11);
	static Entry entry12 = new Entry(12);
	static Entry entry13 = new Entry(13);
	static Entry entry14 = new Entry(14);
	static Entry entry15 = new Entry(15);
	static Entry entry16 = new Entry(16);
	
	static Entry[] row0 = {entry1, entry2, entry3, entry4};
	static Entry[] row1 = {entry5, entry6, entry7, entry8};
	static Entry[] row2 = {entry9, entry10, entry11, entry12};
	static Entry[] row3 = {entry13, entry14, entry15, entry16};
	
	static Entry[] column0 = {entry1, entry5, entry9, entry13};
	static Entry[] column1 = {entry2, entry6, entry10, entry14};
	static Entry[] column2 = {entry3, entry7, entry11, entry15};
	static Entry[] column3 = {entry4, entry8, entry12, entry16};

	static Entry[] all = {entry1, entry2, entry3, entry4, entry5, entry6, entry7, entry8, entry9, entry10, entry11, entry12, entry13, entry14, entry15, entry16};
	
	static void clear() {
		for(Entry entry : all) {
			entry.setData(0);
		}
	}
	
	public static void printRow(Entry[] row0, Entry[] row1, Entry[] row2, Entry[] row3) {
		for(Entry e : row0) {
			System.out.print(" "+e.data());
		}
		System.out.println();
		for(Entry e : row1) {
			System.out.print(" "+e.data());
		}
		System.out.println();
		for(Entry e : row2) {
			System.out.print(" "+e.data());
		}
		System.out.println();
		for(Entry e : row3) {
			System.out.print(" "+e.data());
		}
		System.out.println();
	}
	
	
	static void toTheLeft(Entry[] Row_Column) {
		//Push
		pushLeft(Row_Column);
		//Add
		for (int i = 0; i<3; i++) {
			if(Row_Column[i].data() == Row_Column[i+1].data()) {
				Row_Column[i].setData(Row_Column[i].data()+Row_Column[i+1].data());	
				Row_Column[i+1].setData(0);
			}
		}
		//Push again
		pushLeft(Row_Column);
	}
	

	static void pushLeft(Entry[] Row_Column) {
		int count = 0;
		for (int i = 0; i<=3; i++) {
			if(Row_Column[i].data() != 0) {
				Row_Column[count].setData(Row_Column[i].data());
				count++;
			}
		}
		while(4-count>0) {
			Row_Column[count].setData(0);
			count++;
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
			Row_Column[count].setData(0);
			count--;
		}
	}

	
	static public void popRandom() {
		
		Entry temp;
		int fullTest = 0;
		do {
		int index = r.nextInt(16)+1;
		temp = findEntry(index);
		fullTest++;
		} while(temp.data() != 0 && fullTest<=16);
		
		if(fullTest>=16) {
			System.out.println("Game Over");
			return;
		}
		
		if (r.nextInt(10)<=7)
			temp.setData(2);
		if (r.nextInt(10)>7)
			temp.setData(4);
		
	}
	
	public static Entry findEntry(int index) {
		
		for(Entry entry : all) {
			if (entry.index() == index) 
				return entry;
		}	
		return null;		
	}
	
}
