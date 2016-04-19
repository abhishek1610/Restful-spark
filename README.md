# Restful-spark
Jersey based Spark backend application
Trying to implement a restful architecture with Spark and Hbase as backend

Jersey is used for restful implementation
Jetty is used as embedded mode for server(servlet container)

//To do Add a common query pattern and the correct backen service to be picked using Strategy design pattern

Note- For making it work with Spark downgrade the version of Jersey to 1.9 to avoid conflict with Spark internal dependecies 
