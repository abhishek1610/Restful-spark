/**
 * Created by root on 17/03/16.
 */
/**
 * Created by root on 15/03/16.
 */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class Hbaseimpl  implements Basefunction {
    public String query (String inptable) throws Exception {
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, inptable);

        Get g = new Get(Bytes.toBytes("row1"));

        // Reading the data
        Result result = table.get(g);

        // Reading values from Result class object
        byte [] value = result.getValue(Bytes.toBytes("colfam1"),Bytes.toBytes("qual1"));

        byte [] value1 = result.getValue(Bytes.toBytes("colfam1"),Bytes.toBytes("qual2"));

        // Printing the values
        String name = Bytes.toString(value);
        String city = Bytes.toString(value1);

        return (name + " "+ city);
      /*  Put put = new Put(Bytes.toBytes("row1"));
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual1"), Bytes.toBytes("value1"));
        put.add(Bytes.toBytes("colfam1"), Bytes.toBytes("qual2"), Bytes.toBytes("value2"));
        put.add(Bytes.toBytes("colfam2"), Bytes.toBytes("qual1"), Bytes.toBytes("value3"));
        table.put(put);
        table.flushCommits();
        table.close(); */
    }
}