package qcollection;

import java.util.*;
//import java.util.PriorityQueue;

public class PQTest {

	public static void main(String[] args) {

		HiLoPriorityQueue<Customer>  prq = new HiLoPriorityQueue<Customer>(10); 
		HiLoPriorityQueue<Customer>  hlq = new HiLoPriorityQueue<Customer>(10,5);
		
		Customer c1 = new Customer("Rock",999);
		Customer c2 = new Customer("Brock",1);
		Customer c3 = new Customer("UnderTaker",1000);		

		
		
		// insert values in the queue
		hlq.add(c1);
		hlq.add(c2);
		hlq.add(c3);
	    
		Customer c = hlq.remove();      
	    System.out.println("Customer removed from queue information :: "+c.toString());
	    
	    Iterator<Customer> itr = hlq.iterator();
	    System.out.println("Looping through all the current elements of the queue :: ");
	    while(itr.hasNext()) {
	         Customer element = itr.next();
	         System.out.println("Details :: " + element.toString());
	      }
		
	}

}
