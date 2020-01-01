# Calculating Simple Moving Average of given last N numbers

## Description

A simple Java application that implements the data structure DataEntry, which is used to calculate and return Simple Moving Average 
for last N number of entries in a data set. Where, N is the user given value or limit or window which is used as the divisor for 
calculating average. N can be any positive non-zero integer.

```
Example :   
 N : 4 
 Dataset : { 1, 3, 5, 6, 8, 10, 1 }
 Moving Average : {1, 2, 3, 3.75, 5.5, 7.25, 6.25}
```
N has to be specified while initialing the class dataEntryImpl. And values in this data set is specified by the user as well.

## Pre-requisites
To run this project - 
    **Java 8** or higher version and
    **Maven** version 3.6.x is needed.


## Execution steps

This project can be cloned from [github](https://github.com/baisalilaha/sde_coding_challenge) location.
It can be imported as a Maven project in any IDE.
Below command can be used to create .jar file from root directory of the project folders or Terminal window of the  IDE.

     mvn package

Above command will execute all associated test cases as well. And MovingAverage-1.0-SNAPSHOT.jar will be available inside
**{path_to_project_dir}/MovingAverage/target/**



## Implementation

MovingAverage-1.0-SNAPSHOT.jar can be added as an dependency with any Java application.

In order to get moving average of last N numbers, DataEntryImpl class has to be instantiated- providing the value N, as a variable
```java
DataEntryImpl data = new DataEntryImpl(3);
```
In this above example N = 3.

To add new values in this data structure, we have to use DataEntryImpl.put method, example: 
```java
DataEntryImpl data = new DataEntryImpl(3);
data.put( 6.79);
```   
getMovingAverage method can be used to view moving average of these inserted values:
```java
DataEntryImpl data = new DataEntryImpl(3);
data.getMovingAverage();
``` 

Log level has been set to DEBUG right now, which can be modified in   ../src/resources/log4j.properties file

