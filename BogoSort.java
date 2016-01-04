//Mei Huang
//APCS1 PD5
//HW 51 Dat Bubbly Tho
//2015 12 22

import java.util.ArrayList;

public class BogoSort {
    
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

    public static void main(String [] args) {
ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bogoSort(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bogoSort(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
    }
}

