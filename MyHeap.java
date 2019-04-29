import java.util.*;

public class MyHeap{
  public static void main(String[] args){
    int[] a = {1,7,5,3};
    pushDown(a, 4,0);
    System.out.println( Arrays.toString(a));
  }
  /*
     - size  is the number of elements in the data array.
     - push the element at index i downward into the correct position.
       This will swap with the larger of the child nodes provided that child is larger.
       This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive.
*/
  private static void pushDown(int[]data,int size,int index){
    // indices of children
    int child1 = 2*index + 1;
    int child2 = 2*index + 2;
    // while indices are valid and children are larger than element at given index
    while (child1 < size && data[child1] > data[index]
        || child2 < size && data[child2] > data[index]){
     //  System.out.println("Inside while statement");
     // if there is only one child, which is larger
      if (child2 >= size && data[child1] > data[index]){
      //  System.out.println("There is only 1 child, "+data[child1] );
        int temp = data[child1];
        data[child1] = data[index];
        data[index] = temp;
        index = child1;
      }
     // if there are two children
     else if (child1 < size && child2 < size){
      // System.out.println("There are 2 children, "+data[child1]+", "+data[child2] );
       if (data[child1] >= data[child2]){
      //    System.out.println("Child 1 is larger, "+data[child1]+" >= "+data[child2] );
         int temp = data[child1];
         data[child1] = data[index];
         data[index] = temp;
         index = child1;
       }
       else{
        //   System.out.println("Child 2 is larger, "+data[child2]+" > "+data[child1] );
         int temp = data[child2];
         data[child2] = data[index];
         data[index] = temp;
         index = child2;
       }
     }
     // update children indices
     child1 = 2*index + 1;
     child2 = child1 + 1;
    // System.out.println("New children indices: "+child1+", "+child2);
    }
  }
/*
- push the element at index i up into the correct position.
 This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
- precondition: index is between 0 and data.length-1 inclusive.
*/
private static void pushUp(int[]data,int index){
  int parent = (index - 1) / 2;
  while (parent >= 0 && data[parent] < data[index]){
    int temp = data[parent];
    data[parent] = data[index];
    data[index] = temp;
    index = parent;
  }
  parent = (index - 1) / 2;
}


/*
    - convert the array into a valid heap. [ should be O(n) ]
    */
public static void heapify(int[]data){

}

/*
- sort the array [ should be O(nlogn) ] :
 converting it into a heap
 removing the largest value n-1 times (remove places at end of the sub-array).
 */
public static void heapsort(int[]data){

}

}
