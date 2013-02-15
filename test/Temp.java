package test;
import java.util.ArrayList;

public class Temp {
	public static void main(String args[]){
		ArrayList<Double> myList = new ArrayList<Double>(2);
		myList.add(0.0);
		myList.add(1.1);
		myList.set(0, myList.set(1, myList.get(0)));
		for(int ii=0;ii<myList.size();ii++)
			System.out.println(myList.get(ii));
	}
}
