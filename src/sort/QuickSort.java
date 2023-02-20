package sort;

import java.util.Arrays;

/**
 * Created by thotap on 4/21/2017.
 */
public class QuickSort {
  private int[] numbers;

  public QuickSort(int[] numbers) {
    this.numbers = numbers;
  }

  public void sort(){
    quickSort(0, numbers.length-1);
  }

  public void quickSort(int low, int high){
    int i= low;
    int j = high;
    int pivotPosition = low + (high-low)/2;
    int pivot = numbers[pivotPosition];
    while(i<=j){
      while (numbers[i] < pivot){
        i++;
      }
      while (numbers[j] > pivot){
        j--;
      }
      if(i<=j){
        swap(i,j);
        i++;
        j--;
      }
    }
    if(low<j){
      quickSort(low, j);
    }
    if(i<high){
      quickSort(i,high);
    }
  }

  private void swap(int i, int j) {
    int number = numbers[j];
    numbers[j] = numbers[i];
    numbers[i] = number;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public static void main(String[] args) {
    int[] ary = {20, 10 ,40, 50, 70, 60, 30, 80, 90};
    QuickSort sort =  new QuickSort(ary);
    sort.sort();
    for(int i : sort.getNumbers()){
      System.out.print(i+" ");
    }
  }
}
