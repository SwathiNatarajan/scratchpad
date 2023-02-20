package sort;

/**
 * Created by thotap on 4/21/2017.
 */
public class MergeSort {
  private int[] ary1;
  private int[] ary2;
  private int[] sorted;
  private int[] temp;

  public MergeSort(int[] ary1, int[] ary2) {
    this.ary1 = ary1;
    this.ary2 = ary2;
    sorted =  new int[ary1.length+ary2.length];
    System.arraycopy(ary1, 0, sorted, 0, ary1.length);
    for(int i: sorted){
      System.out.print(i + " ");
    }
    System.out.println();
    System.arraycopy(ary2, 0, sorted, ary1.length, ary2.length);
    for(int i: sorted){
      System.out.print(i + " ");
    }
    System.out.println();
    temp = new int[sorted.length];
  }

  public static void main(String[] args) {
    int[] ary1 = {20, 10, 40, 50, 70};
    int[] ary2 = {60, 30, 80, 90};
    MergeSort sorter = new MergeSort(ary1, ary2);
    sorter.mergeSort();
    int[] sortedAry = sorter.getSortedAry();

    for(int i: sortedAry) {
      System.out.print(i + " ");
    }
  }

  private void mergeSort() {
    mergeSort(0, sorted.length-1);
  }

  private void mergeSort(int start, int end) {
    if(start < end){
      int mid = start + (end -start)/2;
      mergeSort(start, mid);
      mergeSort(mid+1, end);
      merge(start, mid,end);
    }
  }

  private void merge(int start, int mid, int end) {

    for (int i = start; i <= end; i++) {
      temp[i] = sorted[i];
    }
    int i = start;
    int j = mid+1;
    int k = start;
   while (i<=mid && j<=end){
     if(temp[i] <= temp[j]){
       sorted[k++] = temp[i++];
     }else {
       sorted[k++] = temp[j++];
     }
   }
   while (i<=mid){
     sorted[k++]= temp[i++];
   }

  }


  public int[] getSortedAry() {
    return sorted;
  }
}
