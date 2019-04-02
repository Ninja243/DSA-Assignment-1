/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

/**
 *
 * @author mweya
 */
import java.lang.Math;
public class Searching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int Needle = 8;
        int[] Haystack = {35,23,567,34,23,78,23,13,56,7,23};
        System.out.println("Linear Search:\n"+linearSearch(Haystack, Needle)+"\n");
        int[] HayStackSorted = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("Binary Search (Unsorted Array):\n"+binarySearch(Haystack, Needle)+"\n");
        System.out.println("Binary Search (Sorted Array):\n"+binarySearch(HayStackSorted, Needle)+"\n");
   
    }
    
    public static int linearSearch(int[] arr, int key) {
        int index = -1;
        int j = 0;
        
        while (j<arr.length) {
            if (arr[j] == key) {
                index = j;
                break;
            }
            j = j+1;
        }
        
        return index;
    }
    
    public static int binarySearch(int[] arr, int key) {
        int index = -1;
        // Check if sorted
        int j = 1;
        while(j < arr.length) {
            if (arr[j]<arr[j-1]) {
                System.out.println("Array not sorted!");
                return index;
            }
            j = j+1;
        }
        j = 0;
        
        int L = 0;
        int R = arr.length-1;
        int position = 0;
        while (L<=R) {
              position =(int) Math.floor((L+R)/2);
              if (arr[position] < key) {
                  L = position+1;
              } else if (arr[position] > key) {
                  R = position-1;
              } else {
                  index = position;
                  break;
              }
              //System.out.println(L+"<>"+R);
        }
        return index;
    }
}
