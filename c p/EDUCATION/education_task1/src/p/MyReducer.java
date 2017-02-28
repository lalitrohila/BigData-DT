package p;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,Text,Text,Text>{

	//13, Children, Never married, Male, Nonfiler,61.23, Mother only present, United-States, Native- Born in the United States,0

	@Override
	protected void reduce(Text key, Iterable<Text> values,Context context)
			 
			throws IOException, InterruptedException {
		 
				int male=0;
				int female=0;
				for(Text value:values)
				{
					String gender=value.toString();
					if(gender.equals(" Male"))
					{
						male++;
					}
					else
					{
						female++;
					}
				}
	
				String stringmale=String.valueOf(male);
				String stringfemale=String.valueOf(female);
				String myvalue="Male: "+stringmale+"\t"+"Female: "+stringfemale+"\n";
				context.write(key, new Text(myvalue));
				
	}


}
