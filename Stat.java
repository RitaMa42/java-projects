/*
 * Stat.java
 * Author: Yueyue(Rita) Ma
 */

public class Stat {
	
	private double[] data;
	
	//declare all the methods from UML
	
	public Stat() {	
		data = new double[1]; //create an array
		data[0] = 0.0;
	}
	
	
	public Stat(double[] d) {
		setData(d);
	}
	
	//get data
	public double [] getData() {
		double[]copy = new double[data.length];
		for (int i =0; i <data.length; i++) {
			copy[i] = data[i];
		}
	        return copy;
	}
	
	//setData
	public void setData(double[] d) {
		if (d == null) {
			data = new double[0];
			return;
		}
		
		data = new double[d.length];
		for (int i = 0; i < d.length; i++) {
            data[i] = d[i];
		}
	}
	
	//equals
	public boolean equals(Stat s) {
		if (s == null) return false;              // cannot equal a null object
		double[] other = s.getData();             // get a safe copy of the other's data
		if (data.length != other.length) return false;  // different sizes → not equal
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] != other[i]) return false; // mismatch found
			}
		return true; // all elements matched
	    }
		
	//toString
	public String toString() {
		String result = "[";  // opening bracket
		for (int i = 0; i < data.length; i++) {
	            result += data[i];             // add current number
	            if (i < data.length - 1) {     // add comma + space between values
	                result += ", ";
	            }
	        }

	        result += "]"; // closing bracket
	        return result;
	    }

	//minimum
	public double min() {
        double m = data[0]; // start with the first element
        for (int i = 1; i < data.length; i++) {
            if (data[i] < m) {
                m = data[i]; // update m when a smaller value is found
            }
        }
        return m;
    }
	
	//maximum
	public double max() {
        double m = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > m) {
                m = data[i];
            }
        }
        return m;
    }
	
	//average
	public double average() {
        double sum = 0.0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / data.length;
    }
	
	//mode(value that occurs most frequently)
	public double mode() {
        double bestValue = Double.NaN;  // will hold the most frequent value
        int bestCount = 0;              // how many times that value appeared
        boolean unique = false;         // true = only one value has that count

        // Outer loop: pick one element
        for (int i = 0; i < data.length; i++) {
            int count = 0;

            // Inner loop: count how many times it appears in the entire array
            for (int j = 0; j < data.length; j++) {
                if (data[j] == data[i]) {
                    count++;
                }
            }

            // If we found a new higher frequency
            if (count > bestCount) {
                bestCount = count;
                bestValue = data[i];
                unique = true;   
            }
            // If another different value appears the same number of times,
            // that means we have a tie
            else if (count == bestCount && data[i] != bestValue) {
                unique = false;
            }
        }

        // If there was a single unique most frequent value, return it.
        // Otherwise, return NaN to indicate no unique mode.
        if (unique) {
            return bestValue;
        } else {
            return Double.NaN;
        }
    }
}
	
	
	
	
