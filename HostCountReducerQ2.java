// reducer function for application to calculate total number of bytes and find min, max timestamp
import java.util.*;
import java.io.*;
import java.net.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.mapreduce.Reducer;

public class HostCountReducer extends Reducer<Text, Text, LongWritable, DoubleWritable> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        double max = -1;
        double min = -1;
        int i = 0;
        String strKey = key.toString();
        Long bytes = Long.parseLong(strKey);
        double timeStamp = 0;      
         for (Text value : values) {
          String val = value.toString();
          timeStamp = Double.parseDouble(val);
         }        
        context.write(new LongWritable(bytes), new DoubleWritable(timeStamp));
    }
}
