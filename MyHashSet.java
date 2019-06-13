/* 
 * MyHashSet.java 
 * 
 * Version: 
 *       2 
 * 
 * Revisions: 
 *       1
 */

/**
 * This class has various methods for implementing HashSet which are 
 * implemented using generics.
 *
 * @author      Soniya Rode
 * @author      Aishwarya Sontakke
 */
 
import java.util.Scanner;

public class MyHashSet<E> implements SetI<E>{

	// Value to be stored in the list. Can be of any type.
	E value;

	// next points to the next element in the linked list for chaining.
    MyHashSet next;
	int size=10;

    //counter2 specifies the number of elements in the list. 	
    int counter2=0;
    
    //Constructor for MyHashSet class
    MyHashSet(){
        this.value = null;
        this.next=null;    
    }
	
	MyHashSet[] buckets=new MyHashSet[size];

	/**
     * This method is used to initialize the buckets for corresponding set.
     *     
     * @param   -		- 
     * @return 	void 	This method does not return any type.
     *					   
     */
	public void makeBuckets(){
		for(int i =0;i<size;i++){
			MyHashSet current=new MyHashSet();
			buckets[i]=current;
		}
	}
	/**
     * This method is used to generate new  buckets whenever the size of hashmap 
     * has to be increased.
     *     
     * @param   -		- 
     * @return 	MyHashSet[] 	This method creates new buckets and adds the existing
     * buckets to it.
     *					   
     */
	public MyHashSet[] newBuckets(){
		size*=2;
		System.out.println("Size Increased to "+size);
		MyHashSet[] buckets2=new MyHashSet[size];
		for(int i=0;i<buckets.length;i++){
			buckets2[i]=buckets[i];
		}
		return buckets2;



	}

	
	/**
     * This method is used to print for corresponding set.
     *     
     * @param   -		- 
     * @return 	void 	This method does not return any type.
     *					   
     */
	public void print(){
		for(int i=0;i<size;i++){

			//c gives the length of chain
			int c=0;
			if(buckets[i]!=null){
				System.out.println(i+": 0/ "+buckets[i].value);

				//For printing the chain of the ith bucket.
				MyHashSet stemp=buckets[i].next;
				while(stemp!=null){
					c++;
					System.out.println("\t"+c+"/"+stemp.value);
					stemp=stemp.next;
				}
			}
			else{
				System.out.println(i+": 0/ "+buckets[i]);
			}
		}
	}

	/**
      * Checks whether the passed object is present in the hash set.
      *
      * @param   Object o		The object that is to be checked.
      *
      * @return  boolean 		The method returns true when the element is
      *							found else false
      */
	public boolean contains(Object o){
		Object e=(E)o;

		//Convert it to the array and then check.
		Object[] array1=this.toArray();
		for(int i=0;i<array1.length;i++){
			if(array1[i]==e){
				return true;
			}
		}
		return false;	
	}

	/**
     * Removes the passed object from this list.
     *
     * @param   Object o 	Object to be removed
     *    
     * @return  boolean		Returns true on successful removal of the object
     *       				else returns false.
     */
	public boolean remove(Object o){
		Object e=(E)o;
		for(int i=0;i<size;i++){

			//condition to check the element if it is not null
			if(buckets[i]!=null){

				//when the element is found
				if(buckets[i].value==e){

					//decrement the counter for number of elements in the set.
					counter2--;

					//updation of the list after removing the element.
					if(buckets[i].next!=null)
						buckets[i]=buckets[i].next;
					else
						buckets[i]=null;
				return true;
				}

				//checking the elements inside the chain 
				else{
					MyHashSet stemp=buckets[i].next;
					MyHashSet temp=buckets[i];
				
					while(stemp!=null){

						//when the element is found
						if(stemp.value==e){
							counter2--;
							temp.next=stemp.next;
							return true;
						}
						temp=stemp;
						stemp=stemp.next;
					}
				}
			}	
		}	
		return false;
	}

	/**
     * Checks whether the sets are equal.
     *
     * @param   Object o 	Object to that is to be compared.
     *    
     * @return  boolean		Returns true if the sets are equal else false.
     */
	public boolean equals(Object o){
		MyHashSet e=(MyHashSet)o;
		Object[] array1=this.toArray();
		Object[] array2=e.toArray();

		//Checking the length of both the sets.
		if(array1.length!=array2.length){
			return false;
		}
		for(int i=0;i<array1.length;i++){
			if(array1[i]!=array2[i]){
				return false;
			}
		}
		return true;	
	}

	/**
     * This method checks whether all elements of the passed set are present
     * in the set on which the method is called.
     *
     * @param   SetI<?> c 	Collection that is to be checked.
     *    
     * @return  boolean		Returns true if the condition is satisfied else
     *						false.
     */
	public boolean containsAll(SetI<?> c){

		//flag to check whether all elements are present.
		boolean flag=false;
		int count=0;
		Object[] array1=this.toArray();
		Object[] array2=c.toArray();
		for(int i=0;i<array2.length;i++){
			for(int j=0;j<array1.length;j++){
				if(array1[j]==array2[i]){
					flag=true;
				}
			}
			if(flag==true){
 
				//Incresing the counter to verify if 'all' elements of the
				//passed set are present.
				count++;
			}
		}	
		if(count==array2.length){
			return true;	
		}
		else{
			return false;
		}
	}

	/**
      * Add all the elements of the passed collection to the set on which the
      * method was called.
      *
      * @param   SetI<? extends E> c	Collection that is to be added.								 
      *
      * @return  boolean 				The method returns true for successful
      *									addition of all elements else false.    
      */
	public boolean addAll(SetI<? extends E> c){
		Object[] array2;
    	array2=c.toArray();
	
		for(int i=0;i<array2.length;i++){
			if((E)array2[i]!=null){

				//Calling the add method on every element of the collection.
				this.add((E)array2[i]);
			}
		}
		return true;	
	}

	/**
      * Removes all the elements of the passed collection.
      *
      * @param   SetI<?> c		The collection whose elements are to 
      *							be removed. 
      * @return  boolean		The method returns true for successful
      *							removal of all the elements else false. 
      */
	public boolean removeAll(SetI<?> c){
		Object[] array2;
    	array2=c.toArray();
	
		for(int i=0;i<array2.length;i++){
			if((E)array2[i]!=null){

				//Calling remove method on all the elements of the collection.
				this.remove((E)array2[i]);
			}
		}
		return true;	
	}

	/**
      * This method returns the hashcode of the object on which it is called.
      *
      * @param   - 		-							 
      *
      * @return  int	Haschcode of the object.   
      * 
      */
	public int hashcode(){
		int ans;
		if(this.value==null){
			return 0;
		}
		else{
			ans=this.value.hashCode()%size;
			return ans;
		}
	}

	/**
     *  This method adds the element to the HashSet.
     *     
     * @param   e   		Element to be added to the set.  
     *  
     * @return boolean 		Return true if element is successfully added to
     *						set else false.   
     */
	public boolean add(E e){

		//Check whether the element is already present in the set.
		if(this.contains(e)){
			System.out.println(e+" Element already present");
			return false;
		}
		int index;
		MyHashSet n=new MyHashSet();
		n.value=e;
		index=n.hashcode();

		//Cehcking the load factor for the hashmap
		if(counter2<(int)size*0.75){

			//if the size is less, insert the elements in the available hashset
			if(buckets[index].value==null){
				buckets[index].value=e;
				counter2++;
				return true;
			}
			else{
				MyHashSet stemp=buckets[index];

				//Travese through the list till null is found.
				while(stemp.next!=null){
					stemp=stemp.next;
				}

				// s object to be added to the list
				MyHashSet s=new MyHashSet();

				//Store the reference of index+1 in new element's next
				s.next=stemp.next;

				//Store the reference for new element 
				stemp.next=s;
				s.value=e;
				counter2++;
				return true;
			}
		}
		else{
			System.out.println("Capacity full.Increasing the hashmap capacity.");
			this.buckets=newBuckets();
		this.add(e);

		}
		return true;
	}


	/**
      * Converts the set on which the method is called to an array.
      *
      * @param   -			-
      *
      * @return  Object[]	Returns the object array.
      */
	public Object[] toArray(){
		Object array[]= new Object[counter2];
		int j=0;
		for(int i=0;i<size;i++){

			//for the elements in the bucket.
			if(buckets[i]!=null){
				if(buckets[i].value!=null){
					array[j]=buckets[i].value;
					j++;
				}
				MyHashSet stemp=buckets[i];

				//for the elements in the chain.
				while(stemp.next!=null){
					stemp=stemp.next;
					if(stemp.value!=null){
						array[j]=stemp.value;				
						j++;
					}
				}		
			}
		}
		return array;
	}
	
	/**
     *  Removes all of the elements from this set.
     *
     * @param   -           
     * @return  - 	The method does not return any type.  
     * 
     */
	public void clear(){
		counter2=0;
		for(int i=0;i<buckets.length;i++){
				buckets[i]=null;
		}
	}

	/**
     *  Prints the elements of the array
     *
     * @param   Object[] array 		The array that is to be printed.
     *          
     * @return  void 				The method does not return any type.  
     * 
     */	
	public void printArray(Object[] array){
		for(int j=0;j<array.length;j++){
			System.out.print(array[j]+ "  ");
		}
		System.out.println("");
	}

	/**
     *  Returns the number of elements in this set.
     *
     * @param       -      
     * @return      int 	The number of elements in the set.
     */
	public int size(){
		return this.counter2;
	}

	/**
     *  Checks whether the set on which the method is called is empty.
     *
     * @param       -      
     * @return      boolean 	Returns true if the condition is satisfied
     *							else false.
     */
	public boolean isEmpty(){
		if(this.counter2==0){
			return true;
		}
		else{
			return false;
		}
	}
}