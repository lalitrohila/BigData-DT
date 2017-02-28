package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{

	//13, Children, Never married, Male, Nonfiler,61.23, Mother only present, United-States, Native- Born in the United States,0

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		  
	    
		String data[]=value.toString().split(",");
		String mykey=data[3];
		context.write(new Text(mykey), value);
	    
		
		
	}

}
