
import structure5.*;
public class TwoTowers{
  public static void main(String[] args) {
    Vector <Double> set = new Vector<Double>();
    Vector <Double> temp_subset = new Vector<Double>();
    Vector <Double> best_subset = new Vector<Double>();
    double temp_sum=0;
    double total_sum = 0;
    int num_blocks;
    try {
      num_blocks = Integer.parseInt((args[0]));
    }catch (Exception e){
      System.out.println("no integer input");
      num_blocks =5;
    }
    double min_difference; //minimum difference between the subset's height and half of the total height
    SubsetIterator<Double> subsetIt = new SubsetIterator<Double>(set);
    //insert consecutive square roots into the vector, and calculate total
    for(int i = 0; i<num_blocks; i++){
      total_sum += Math.sqrt(i);
      set.add(Math.sqrt(i));
    }
    System.out.println(set.toString());
    System.out.println("total sum: " + total_sum);
    min_difference = total_sum;
    while(subsetIt.hasNext()/*&& temp_sum<total_sum/2*/){
      temp_sum = 0;
      for(int i = 0; i<temp_subset.size(); i++){
        temp_sum+=temp_subset.get(i);
      }
      if(Math.abs(total_sum/2-temp_sum)<min_difference) {
        min_difference = Math.abs(total_sum/2-temp_sum);
        best_subset = temp_subset;
        System.out.println(total_sum/2-min_difference);
      }
      temp_subset = subsetIt.next();
    }
    System.out.println("Closest to " + total_sum/2 + ": " + (total_sum/2-min_difference));
  }
}
