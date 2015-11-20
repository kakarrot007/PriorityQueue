package qcollection;

import java.util.AbstractCollection;
import java.util.Iterator;

public class HiLoPriorityQueue<E extends BinaryPrioritizable> extends AbstractCollection{

	private int count;
	private int lcount;
	private int hcount;
	private Object[] elements;
	private Object[] helements;
	private Object[] lelements;
	private int hhead;
	private int lhead;
	private int htail,head,tail;
	private int ltail;
	HiLoPriorityQueue<Customer>  hq,lq; 
	
	public HiLoPriorityQueue(int high_capacity, int low_capacity){
		helements = new Object[high_capacity];
		lelements = new Object[low_capacity];
		hq = new HiLoPriorityQueue<Customer>(high_capacity);
		lq = new HiLoPriorityQueue<Customer>(low_capacity);
		count = lcount = 0;
		hcount = 0;
		hhead = 0;
		htail = 0;
		ltail = 0;
		lhead = 0;
	}
	
	public HiLoPriorityQueue(int capacity)
	{
		elements = new Object[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}
	
	
	
	@Override
	public Iterator<E> iterator(){
		 	return new Iterator<E>()
			 {
			 public boolean hasNext()
			 {	
				 if(hvisited < hcount)
					 return hvisited < hcount;
				 else
					 return lvisited < lcount;
			 }

			 public E next()
			 {
				 if(hvisited < hcount){
					 int index = (hhead + hvisited) % helements.length;
					 E r = (E) helements[index];
					 hvisited++;
					 return r;
				 }
				 else{
					 int index = (lhead + lvisited) % lelements.length;
					 E r = (E) lelements[index];
					 lvisited++;
					 return r;
				 }
				 
			 }

			 public void remove()
			 {
				 throw new UnsupportedOperationException();
			 }

			 private int hvisited = 0;
			 private int lvisited = 0;
			 };
	}
	
	 public boolean add(E anObject)
	 {
		 System.out.println("Customer with details :: "+anObject.toString()+ " is added to the queue");
		 System.out.println("His priority is :: "+anObject.getPriority());
		    if(anObject.getPriority() == 1){
		    	if(hq.size() < 5 ){
		    		helements[htail] = anObject;
				 	htail = (htail + 1) % helements.length;
				 	hcount = hcount + 1;
		    	}
		    	else{
		    		if(hq.size() >= helements.length ){	
		    			lelements[ltail] = anObject;
		    			ltail = (ltail + 1) % lelements.length;
		    			lcount = lcount + 1;
		    			if(lcount >= lelements.length){
		    				//Removing an element from low priority queue when it is full
		    				E lqlastElement = (E) lelements[lcount-1];
		    				lcount--;
		    			}
		    		}
		    	}
		    }
		    else{
		    	if(lq.size() < lelements.length ){
		    		lelements[ltail] = anObject;
				 	ltail = (ltail + 1) % lelements.length;
				 	lcount++;
		    	}
		    }

		 return true;
	 }

	 public E remove()
	 {
		 E r = null;
		 if(hcount > 0){
			 r = (E) helements[hhead];
			 hhead = (hhead + 1) % helements.length;
			 hcount = hcount - 1;
		 }
		 else if(hcount == 0 && lcount > 0){
			 r = (E) lelements[lhead];
			 lhead = (lhead + 1) % lelements.length;
			 lcount = lcount - 1;
		 }
		 return r;
	 } 
	 
	@Override
	 public int size()
	 {
		return count;
	 }
	
	

}
