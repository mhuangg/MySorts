import java.util.ArrayList;

public class MySorts {
     public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

     // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	int length = data.size();
	for (int i = 0; i < length; i++) {
	    int minPos = i;
	    for (int j = i + 1; j < length; j++) {
		if (data.get(minPos).compareTo(data.get(j)) > 0) {
		    int swap = (int)data.get(minPos);
		    data.set(minPos, data.get(j));
		    data.set(j, swap);
		}
	    }
	}		    	 
    }//end selectionSort -- O(?)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.

     public static ArrayList<Comparable>
	 selectionSort( ArrayList<Comparable> input ) {
	 ArrayList <Comparable> output = new ArrayList <Comparable>();
	 for (int i = 0; i < input.size(); i++) {
	     output.add(input.get(i));
	 }
	 selectionSortV(output);
	 return output;
      
     } //end selectionSort -- O(?)

     // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	int length = data.size()-1; 
	for (int pass = 1; pass < length ; pass++) {
	    for (int i = length; i > 0; i--) { 
	    if (data.get(i).compareTo(data.get(i-1)) < 0) {
		int swap = (int)data.get(i);
		data.set(i,data.get(i-1));
		data.set(i-1,swap);
	    }
	}
    }
    }


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.

public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
    ArrayList output = new ArrayList <Comparable>();
    for (int i = 0; i < input.size(); i++) {
	output.add(input.get(i));
    }
    bubbleSortV(output); 
	return output; 
    
	 
    }//end bubbleSort -- O(?)

    public static boolean isSorted(ArrayList<Comparable> data) {
        int length = data.size()-1;
	for (int pass = 1; pass < length; pass++) {
	    for (int i = length; i > 0; i--) {
		if (data.get(i).compareTo(data.get(i-1)) < 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static ArrayList<Comparable> bogoSort(ArrayList<Comparable> x) {
	int n = 0;
	while (!isSorted(x)) {
	    shuffle(x);
	    n++;
	}
	return x;
    }
    
    public static void main (String [] args) {
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bogoSort(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	
	ArrayList glen2 = new ArrayList<Integer>();
	glen2.add(7);
	glen2.add(1);
	glen2.add(5);
	glen2.add(12);
	glen2.add(3);
	System.out.println( "ArrayList glen2 before sorting:\n" + glen2 );
	ArrayList glenSorted2 = bubbleSort( glen2 );
	System.out.println( "sorted version of ArrayList glen2:\n" 
			    + glenSorted2 );
	
	ArrayList glen3 = new ArrayList<Integer>();
	glen3.add(7);
	glen3.add(1);
	glen3.add(5);
	glen3.add(12);
	glen3.add(3);
	System.out.println( "ArrayList glen3 after sorting:\n" + glen3 );
	System.out.println( "ArrayList glen3 before sorting:\n" + glen3 );
	ArrayList glenSorted3 = selectionSort( glen3 );
	System.out.println( "sorted version of ArrayList glen3:\n" 
        + glenSorted3 );
        System.out.println( "ArrayList glen3 after sorting:\n" + glen3 );

	  
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bogoSort(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	
	ArrayList coco2 = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
	ArrayList cocoSorted2 = bubbleSort( coco2 );
	System.out.println( "sorted version of ArrayList coco2:\n" 
			    + cocoSorted2 );
	System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
	
	 ArrayList coco3 = populate( 10, 1, 1000 );
	 ArrayList cocoSorted3 = selectionSort( coco3 );
	  System.out.println( "sorted version of ArrayList coco3:\n" 
	  + cocoSorted3 );
	  System.out.println( "ArrayList coco3 after sorting:\n" + coco3 );
    }
}
    
