package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,IntWritable,IntWritable>{

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		  
		String n=context.getConfiguration().get("Year");
		String record=value.toString();
		String recordparts[]=record.split(",");
		String age=recordparts[0];
		
		
		int a=Integer.parseInt(n);
		int b=Integer.parseInt(age);
		
		context.write(new IntWritable(a), new IntWritable(b));
		
		
	}

}
