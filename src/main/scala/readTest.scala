

import org.apache.spark.sql.SparkSession

object readTest extends App {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("Spark SQL basic example")
    .getOrCreate()

  import spark.implicits._

  val file = spark.read.json("state_logs.json")

}
