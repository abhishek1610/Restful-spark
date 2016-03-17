

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;


@Path("/entry-point")
public class EntryPoint {

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Test";
    }
//BaseService implementation on spark...future plan to add elasticsearch
    @GET
    @Path("query")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryspark() {
        String [] samp  = {"test" ,"over" } ;
        Basefunction s = new SparkServiceimpl();
        String testname = s.query("input.txt");

        return  testname;
    }

//Hbase
    @GET
    @Path("queryhbase")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryhbase() {

        Basefunction s = new Hbaseimpl();
        String testname = s.query("my-table");

        return  testname;
    }
}