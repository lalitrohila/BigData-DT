package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<IntWritable,IntWritable,Text,IntWritable>{

	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values,Context context)
			 
			throws IOException, InterruptedException {
		 int targetage=18;
		 int mykey=Integer.parseInt(String.valueOf(key));
		 
		 int reqage=targetage-mykey;
		 int count=0;
		 
		 for(IntWritable value:values)
		 {
			 int m=Integer.parseInt(String.valueOf(value));
			 if(m==reqage)
			 {
				 count++;
				 
			 }
		 }
	context.write(new Text("Total voter:"),new IntWritable(count));
	
	
	}


}
