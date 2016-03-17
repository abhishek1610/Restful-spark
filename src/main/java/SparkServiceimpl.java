import com.codahale.metrics.MetricRegistryListener;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.api.java.function.Function;

import java.util.List;
import org.apache.spark.sql.Row;
import java.io.Serializable;
/**
 * Created by root on 13/03/16.
 */

public class SparkServiceimpl  implements Basefunction{

    private static JavaSparkContext jc ;
    @Override
    public String query (String inpfile) {
        //val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[2]"))
      if (jc == null) {
           jc = new JavaSparkContext(new SparkConf().setAppName("Spark Count").setMaster("local[2]"));
      }
        SQLContext sqlContext1 = new org.apache.spark.sql.SQLContext(jc);
        JavaRDD<Person> people = jc.textFile(inpfile).map(
                new Function<String, Person>() {
                    public Person call(String line) throws Exception {
                        String[] parts = line.split(",");

                        Person person = new Person();
                        person.setId(Integer.parseInt(parts[0])) ;
                        person.setPayroleid(Integer.parseInt(parts[1]));
                        person.setName(parts[2]);
                        person.setSurname(parts[3]);


                        person.setAge(Integer.parseInt(parts[4].trim()));
                        person.setCompany(parts[5]);
                        person.setDept(parts[6]);

                        return person;
                    }
                });
        DataFrame schemaPeople = sqlContext1.createDataFrame(people, Person.class);
        DataFrame filpeop=schemaPeople.filter(schemaPeople.col("age").gt(30)) ;
        filpeop.show();
        //Person [] p = filpeop.collect();
        //String nam = p.getName();
        //System.out.println(nam) ;

      List<String> name = filpeop.javaRDD().map(new Function<Row, String>() {
            public String call(Row row) {
                return "Name: " + row.getString(4);
            }
        }).collect();

        String testname=name.toString() ;
        return testname;
        //System.out.println(testname) ;
    }
}
