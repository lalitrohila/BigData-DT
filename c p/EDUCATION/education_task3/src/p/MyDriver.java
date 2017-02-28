package p;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {

	 
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// user/cloudera/rohit/census
		
		 Configuration conf=new Configuration();
		
		 Job job=new Job(conf,"my first job of Education Task 3:");
		 job.setJarByClass(MyDriver.class);
		 job.setMapperClass(MyMapper.class);
		 job.setReducerClass(MyReducer.class);
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(Text.class);
		 
		 
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 
		 
		 System.exit(job.waitForCompletion(true)  ?  0 :1);
		 
	}

}
