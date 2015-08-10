/**
 * 
 */
package cs455.gigasort.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author mbhavik
 *
 */
public class GigaSortPartitioner extends Partitioner<LongWritable, NullWritable> {

	Long part1 = (long) Math.pow(2, 59);
    Long part2 = 2 * part1;
    Long part3 = 3 * part1;
    Long part4 = 4 * part1;
    Long part5 = 5 * part1;
    Long part6 = 6 * part1;
    Long part7 = 7 * part1;
    Long part8 = 8 * part1;
    Long part9 = 9 * part1;
    Long part10 = 10 * part1;
    Long part11 = 11 * part1;
    Long part12 = 12 * part1;
    Long part13 = 13 * part1;
    Long part14 = 14 * part1;
    Long part15 = 15 * part1;
	@Override
	public int getPartition(LongWritable arg0, NullWritable arg1, int arg2) {
		// TODO Auto-generated method stub
		Long range = arg0.get();
        
        if(range >=0 && range < part1){
            return 0;
        }
        else if(range >=part1 && range < part2){
            return 1;
        }
        else if(range >=part2 && range < part3){
            return 2;
        }
        else if(range >=part3 && range < part4){
            return 3;
        }
        else if(range >=part4 && range < part5){
            return 4;
        }
        else if(range >=part5 && range < part6){
            return 5;
        }
        else if(range >=part6 && range < part7){
            return 6;
        }
        else if(range >=part7 && range < part8){
            return 7;
        }
        else if(range >=part8 && range < part9){
            return 8;
        }
        else if(range >=part9 && range < part10){
            return 9;
        }
        else if(range >=part10 && range < part11){
            return 10;
        }
        else if(range >=part11 && range < part12){
            return 11;
        }
        else if(range >=part12 && range < part13){
            return 12;
        }
        else if(range >=part13 && range < part14){
            return 13;
        }
        else if(range >=part14 && range < part15){
            return 14;
        }
        else if(range >=part15 ){
            return 15;
        }
        else {
			return 0;
		}
		
	}
}