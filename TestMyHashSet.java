/* 
 * TestMyHashSet.java 
 * 
 * Version: 
 *       2 
 * 
 * Revisions: 
 *       1
 */

/**
 * This class has various methods which are used
 * to test the methods in MyHashSet.java
 *
 * @author      Soniya Rode
 * @author      Aishwarya Sontakke
 */

public class TestMyHashSet{ 

public static void main(String args[] )      {
        SetI<String> aSet = new MyHashSet<String>();
        SetI<String> bSet = new MyHashSet<String>();
        SetI<String> cSet = new MyHashSet<String>();
        
        aSet.makeBuckets();    
        aSet.add("a");
        aSet.add("b");
        aSet.add("c");
        aSet.add("d");
        aSet.add("e"); 
        aSet.add("k"); 
        aSet.add("l");
        aSet.add("m");
        
        System.out.println("aSet");            
        aSet.print();

        System.out.println("\nSize :"+aSet.size());
        System.out.println("Is the aSet empty? " + aSet.isEmpty());

        System.out.println("Implemeting toArray method:");
        aSet.printArray(aSet.toArray());
        System.out.println("Does aSet contain a? "+aSet.contains("a"));
        System.out.println("Does aSet contain z? "+aSet.contains("z"));

        bSet.makeBuckets();    
        bSet.add("a");
        bSet.add("b");
        bSet.add("c");
        bSet.add("d");
        bSet.add("e"); 
        bSet.add("k");  
        bSet.add("l");
        bSet.add("m");

        System.out.println("\nbSet"); 
        bSet.print(); 
        System.out.println("aSet.equals(bSet): "+aSet.equals(bSet));

        System.out.println("\nRemoving l from bSet:");
        bSet.remove("l");
        System.out.println("bSet:");
        bSet.print();
        System.out.println("\naSet.equals(bSet): "+aSet.equals(bSet));
        System.out.println("aSet.containsAll(bSet): "+aSet.containsAll(bSet));


        aSet.remove("b");
        aSet.remove("k");
        aSet.remove("c");
        System.out.println("\nAfter removing b, k and c from aSet \naSet:");
        aSet.print();

        System.out.println("\nRemove x from aSet: "+aSet.remove("x"));

        cSet.makeBuckets();  
        cSet.add("d");  
        cSet.add("z");
        cSet.add("q");
        cSet.add("y");
        cSet.add("r"); 
        System.out.println("\ncSet:");
        cSet.print();

        System.out.println("\nInserting null in cSet:");
        System.out.println("cSet.add(null) :"+cSet.add(null));
        System.out.println("cSet");
        cSet.print();

        System.out.println("\nRemoving null from cSet:");        
        System.out.println("cSet.remove(null) :"+cSet.remove(null));
        System.out.println("cSet");
        cSet.print(); 

        System.out.println("\nAdding cSet to aSet:");        
        aSet.addAll(cSet);
        aSet.print();

        System.out.println("\nRemoving cSet from aSet:"); 
        aSet.removeAll(cSet);
        aSet.print();

        System.out.println("\nClearing aSet:");
        aSet.clear();
        System.out.println("Size :"+aSet.size());
        System.out.println("aSet");
        aSet.print();
        System.out.println("aSet.isEmpty() : "+aSet.isEmpty());       

/*   
    
        System.out.println("contains all  "+aSet.containsAll(bSet));
        bSet.add("c");
        System.out.println("contains all  "+aSet.containsAll(bSet));

    increasing the size of hashmap

    }
    */
    }
}