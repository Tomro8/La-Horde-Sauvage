
From : https://github.com/Tomro8/La-Horde-Sauvage

# 1. Project Description - Kafka Architecture
Our company is in charge of a fleet - or rather a swarm - of drones patrolling France. Their mission is to detect moskitoes and kill them with the use of an embeded laser.

Our swarm is composed of a thousand of drones. We decided to use Kafka in order to store communication between drones and our control center in charge of flight regulation and statistic analysis.

The drones will communicate their state and performance over time to the control center through 2 topics partitionned over 2 brokers each, in a cluster of 3 brokers in total. 
The first topic is the state topic. It will store the drone state related data such as :
 - drone id
 - drone speed
 - drone location (longitude, latitude, height)
 - drone battery

The second topic is the performance topic. It will store the drone performances related data such as:
 - drone id
 - drone quantity of ammo
 - drone moskitoe kill counter
 - drone efficacity (rate representing drone productivity per day)

# 2. Project Structure
Our project structure is composed of model classes, serializer and deserializer classes, producer and consumer classes.
We have two producer, one for each topic, and two consumers, one for each topic as well.


The model instances are given as parameter to the producer instance that use the serializer to format the data to JSON and send them to the topics.
Then when we wish to consume data, the consumer instances will use the deserializer instances to retrieve data from topics and write them into two separate text files. We can then perform statistics operations on those data.

# 3. Difficulties met and missing functionalities

Unfortunately, we were not able to make work the Spark part. After countless hours of straining efforts tweaking dependencies, we were not able to successfuly build our project with Spark. Therefore our project only consists of the producing and consuming parts, without the analitics.

# 4. Set up your environment for testing

As said before, we use 2 topics on a cluster of 3 brokers. In order to test our program, you need to set up this configuration on your machine. Please follow this steps by steps explanation bellow:

##### 4.1. First you need to delete any previous data generated by another Kafka use
Delete those folders if they exist:

- /tmp/zookeeper 
- /tmp/logs 
- /tmp/kafka-logs

For the rest of the tutorial, go into your ***kafka folder***.

##### 4.2. Then we need to create a configuration file for each of our brokers:
    $ ./config/server-0.properties
    $ ./config/server-1.properties
    $ ./config/server-2.properties

For convenience, we provided you those files in our project file structure in /config folder. But feel free to generate them by yourself.

We can now start zookeeper server and then create our three brokers based on the three files we created:

##### 4.3. Starting Zookeeper

     $ ./bin/zookeeper-server-start.sh config/zookeeper.properties &

##### 4.4. Creating the three brokers
    $ ./bin/kafka-server-start.sh config/server-0.properties &
    $ ./bin/kafka-server-start.sh config/server-1.properties &
    $ ./bin/kafka-server-start.sh config/server-2.properties &

##### 4.5. Now as a last step you need to create our 2 topics:

    $ ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic state_topic
    $ ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic perform_topic

# 5. Test our program
The main.scala file contains the code to test both producing and consuming functionalities.
In a real context, producers and consumers would be separate programs running independantly and at the same time. They would interact with the topics simultaneously ; in a Real-time manner. However, since we are not in a real context, and that we work on sloppy virtual environments, we took the decision not to make two programs run at the same time. Neither did we made the producers and consumers run concurrently on separate thread. For the sake of the simplicity of the demonstration, we just made the test follow these sequential steps:
1. The state producer produces data in the State topic
2. The perform producer produces data in the Perform topic
3. The state consumer consumes from State topic and stores data into a text file named "state_logs.txt"
4. The perform consumer consumes from Perform topic and stores data into a text file named "perform_logs.txt"
