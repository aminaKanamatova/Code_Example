# Code Example
Example of the code I've recently worked on. This is one of the labs we did in the Data Structures class. 
The only part of the code that I worked on and modified is Tour.java. Other classes and text files were provided by the professor. 

The task was on Travelling Salesperson problem, where we developed linked list implementations of the graph tour. 
Specifically, I worked on the class Tour.java, where I wrote the following methods: 
 - public double distance() : calculates and returns the total distance of the tour
 - public int size() : returns the number of nodes
 - public void show() : prints out all the points in the tour
 - public void draw() : draws the tour by connecting points (nodes)
 - void insertNearest() : inserts the new point into the tour using the nearest neighbor heuristic
 - void insertSmallest() : inserts the new point into the tour using the smallest increase heuristic. 

This is the only part of the code I worked on, the rest was provided initially as part of the lab, including the  algs4.jar  that is used for graphics. 

# Instructions(for macOS):
Once all the files are dowloaded, open the terminal and compile all the .java files. 

Run the Nearest Neighbor Heuristic on the points in the tsp1000.txt file by using the following command:java NearestInsertion < tsp1000.txt (or for some other text file provided).

Run the Smallest Insertion Heuristic on the points in the tsp1000.txt file by using the following command:java SmallestInsertion < tsp1000.txt (or some other text file provided). 

These will display the graphical tour and print the tour's length and the number of points.

