

  //Name:Amina Kanamatova
  //Email: ak9936@bard.edu
  //Collaboration Statement: I worked on the code myself and read a few articles like https://www.w3schools.com/dsa/dsa_ref_traveling_salesman.php
 //and practiced linkedlists on online coding webites to familiarize myself more with the topic. 

*/
import edu.princeton.cs.algs4.*;

    /*
      Tour()                      // create an empty tour
      void show()                 // print the tour to standard output
      void draw()                 // draw the tour to standard draw
      int size()                  // number of points on tour
      double distance()           // return the total distance of the tour
      void insertNearest(Point p) // insert p using nearest neighbor heuristic
      void insertSmallest(Point p)// insert p using smallest increase heuristic

      Compile: javac -cp .:algs4.jar NearestInsertion.java 
      Run:     java  -cp .:algs4.jar NearestInsertion < tsp1000.txt 

    */


public class Tour {
    // inner class for one node
    private class Node {
      private Point p;
	   private Node next;

      private Node() {
	    this(null,null);
	}

	private Node(Point thepoint, Node thenext) {
	    p = thepoint;
	    next = thenext;
	}
}

    private Node path; // head of path
    private int len; //number of nodes

    //create empty tour, constructor
    public Tour(){ 
      path = null; 
      len = 0;
    }


    public int size() {
      return len; //returns number of nodes
    }

      public double distance() {
      if(path == null) return 0.0; //if empty

      double total = 0.0; 
      Node curr = path; //start at the head

      do{
         total += curr.p.distanceTo(curr.next.p); //distance between current and next points
         curr = curr.next; 

      } while (curr != path); //stop when loops back to start
      return total;
    }

    /**
       TODO: Write appropriate comment!
    */
    public void show() {
      if(path == null){
         System.out.println("Tour is empty");
         return; 
      }
      Node curr = path; 

      do{
         System.out.println(curr.p); //current point
         curr = curr.next; //move to the next node 
      } while(curr != path); 

    }


   
    public void draw() {
      if(path == null) return; //if empty

      Node curr = path;

      do{
         curr.p.drawTo(curr.next.p); //draw line from current to next point
         curr = curr.next; 
      } while (curr != path); 
    }

    /**
       Inserts p using nearest neighbor heuristic.
       @param p The starting point.
    */
    void insertNearest(Point p) {
      if(path == null){
         path = new Node(p, null); //node points to itself
         path.next = path; 
         len++;
         return; 
      }
      Node node = path; 
      double minDist = path.p.distanceTo(p);
      Node curr = path.next;
      //find the neaarest point
      do{ 
         double dist = curr.p.distanceTo(p);
         if(dist < minDist){
            minDist = dist; 
            node = curr; 
         }
         curr = curr.next; 
      } while(curr != path); 
      //insert the new point
      Node newNode = new Node(p, node.next); 
      node.next = newNode; 
      len++; 
    }
    
    /**
       Inserts p using smallest increase heuristic.
       @param p The starting point.
    */
    void insertSmallest(Point p) {
      if(path == null){
         path = new Node(p, null); 
         path.next = path; 
         len++; 
         return; 
      }
      Node node = path; 
      Node curr = path; 

      double min = Double.POSITIVE_INFINITY; 
      //find point with the smallest increase
      do{
         double currDist = curr.p.distanceTo(curr.next.p);
         double newDist = curr.p.distanceTo(p) + p.distanceTo(curr.next.p); 
         double incr = newDist - currDist; 

         if(incr < min){ 
            min = incr; 
            node = curr; 
         }
         curr = curr.next; 
      }while(curr != path); 
      Node newNode = new Node(p, node.next); 
      node.next = newNode; 
      len++;

    }
    
} // end Tour
