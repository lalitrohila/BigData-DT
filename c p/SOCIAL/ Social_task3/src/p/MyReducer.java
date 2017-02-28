package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,Text,Text,IntWritable>{

	//46, High school graduate, Divorced, Female, Single,978.16, Not in universe, Columbia, Foreign born- Not a citizen of U S ,52
    @Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			 
			throws IOException, InterruptedException {
		int count=0;
    	for(Text value:values)
    	{
    		String s[]=value.toString().split(",");
    		String gender=s[3];
    		String ww=s[9];
    		int n=Integer.parseInt(ww);
    		if(gender.equals(" Female")&& n>0)
    		{
    			count++;
    		}
    	}
    	
				
	
				context.write(key, new IntWritable(count));
				
	}


}
