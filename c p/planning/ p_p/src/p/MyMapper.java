package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		  
		 
		String record=value.toString();
		String recordparts[]=record.split(",");
		String mykey=recordparts[8];
		
		
		 context.write(new Text(mykey), value);
	}

}
