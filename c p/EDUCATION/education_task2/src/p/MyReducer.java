package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,Text,Text,IntWritable>{

	//13, Children, Never married, Male, Nonfiler,61.23, Mother only present, United-States, Native- Born in the United States,0

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
