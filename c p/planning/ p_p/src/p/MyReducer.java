package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,Text,Text,IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			 
			throws IOException, InterruptedException {
		  
		 int count=0;
		 
		 for(Text value:values)
		 {
			
				 count++;
				 
			 }
	context.write(key, new IntWritable(count));
	
	
	}


}
