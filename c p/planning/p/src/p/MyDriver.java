package p;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {

	 
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		 Configuration conf=new Configuration();
		 Scanner sc=new Scanner(System.in);
		 String n;
		 System.out.println("Enter Year after that we expect how many new voter will come:");
		 
		 n=sc.nextLine();
		 
		 
		 conf.set("Year", n);
		 
		 Job job=new Job(conf,"my first job of voter:");
		 job.setJarByClass(MyDriver.class);
		 job.setMapperClass(MyMapper.class);
		 job.setReducerClass(MyReducer.class);
		 job.setNumReduceTasks(1);
		 job.setMapOutputKeyClass(IntWritable.class);
		 job.setMapOutputValueClass(IntWritable.class);
		 
		 
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 
		 
		 System.exit(job.waitForCompletion(true)  ?  0 :1);
		 
	}

}
