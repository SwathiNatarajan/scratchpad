package misc;

/**
 * Created by thotap on 5/25/2017.
 */
public class TowerOfHanoi {
  public void moveDisks(int numOfDisks, String start, String aux, String end){
    if(numOfDisks == 1){
      System.out.println(start + " --> " + end);
    }else{
      moveDisks(numOfDisks-1, start, end, aux);
      System.out.println(start + " --> " + end);
      moveDisks(numOfDisks-1, aux, start,end);
    }
  }

  public static void main(String[] args) {
    TowerOfHanoi towerOfHanoi =  new TowerOfHanoi();
    towerOfHanoi.moveDisks(3, "start", "aux", "end");
      }

}
