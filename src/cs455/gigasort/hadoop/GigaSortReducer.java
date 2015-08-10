/**
 * 
 */
package cs455.gigasort.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

/**
 * @author mbhavik
 *
 */
public class GigaSortReducer extends Reducer<LongWritable, NullWritable, LongWritable, NullWritable> {

public static int counter = 1;
	
	NullWritable nullWritable = NullWritable.get();
    @Override
    protected void reduce(LongWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //int count = 0;
        // calculate the total count
        /*for(IntWritable val : values){
            count += val.get();
            
        }*/
    	for(NullWritable val : values){
    		if(counter % 1000 == 0){
    			context.write(key, nullWritable);
    		}
    		else if (counter == 1) {
    			context.write(key, nullWritable);
			}
    		counter++;
        }
    }
}
