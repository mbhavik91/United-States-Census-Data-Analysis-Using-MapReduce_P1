/**
 * 
 */
package cs455.gigasort.hadoop;
//import
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author mbhavik
 *
 */
public class GigaSortMap extends Mapper<LongWritable, Text, LongWritable, NullWritable> {

	NullWritable nullWritable = NullWritable.get();
	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // tokenize into words.
        StringTokenizer itr = new StringTokenizer(value.toString());
        // emit word, count pairs.
            
        while (itr.hasMoreTokens()) {
            context.write(new LongWritable(Long.parseLong(itr.nextToken())), nullWritable);
        }
    }
}
