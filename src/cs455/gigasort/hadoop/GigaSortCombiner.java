/**
 * 
 */
package cs455.gigasort.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author mbhavik
 *
 */
public class GigaSortCombiner extends Reducer<LongWritable, NullWritable, LongWritable, NullWritable> {
	
	public static int counter = 1;
	NullWritable nullWritable = NullWritable.get();
    @Override
    protected void reduce(LongWritable key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
 	
    	for(NullWritable val : values){
    		context.write(key, nullWritable);
        }
    }
}