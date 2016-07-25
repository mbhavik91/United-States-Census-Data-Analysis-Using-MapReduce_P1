/**
 * 
 */
package cs455.gigasort.hadoop;
//import


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author mbhavik
 *
 */
public class MainJob {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

            Configuration conf = new Configuration();
            // Give the MapRed job a name. You'll see this name in the Yarn webapp.
            Job job = Job.getInstance(conf, "GigaSort");
            // Current class.
            job.setJarByClass(MainJob.class);
            // Mapper
            job.setMapperClass(GigaSortMap.class);
            // Combiner. We use the reducer as the combiner in this case.
            job.setCombinerClass(GigaSortCombiner.class);
            job.setPartitionerClass(GigaSortPartitioner.class);
            // Reducer
            job.setReducerClass(GigaSortReducer.class);
            job.setNumReduceTasks(16);
            // Outputs from the Mapper.
            job.setMapOutputKeyClass(LongWritable.class);
            job.setMapOutputValueClass(NullWritable.class);
            // Outputs from Reducer. It is sufficient to set only the following two properties
            // if the Mapper and Reducer has same key and value types. It is set separately for
            // elaboration.
            job.setOutputKeyClass(LongWritable.class);
            job.setOutputValueClass(NullWritable.class);
            // path to input in HDFS
            FileInputFormat.addInputPath(job, new Path(args[0]));
            // path to output in HDFS
            FileSystem fs1 = FileSystem.get(conf);
    		
    		String outputPath = args[1] + "";
    	
    		if(fs1.exists(new Path(outputPath)))
    			fs1.delete(new Path(outputPath), true);

    		FileOutputFormat.setOutputPath( job ,new Path(args[1]+""));
            //FileOutputFormat.setOutputPath(job, new Path(args[1]));
            // Block until the job is completed.
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
