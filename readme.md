
Example of a WebSocket echo on Jetty using the Native WebSocket API.

This project uses maven.
This checkout is a valid ${jetty.base} directory too.

To build:

    $ mvn clean install

  This should have created a webapps/root.war file for you
  
To run using jetty home:
  
    $ java -jar /path/to/jetty-home/start.jar

To test:

  1) Open [http://localhost:8080/demo](http://localhost:8080/demo) in your websocket capable web browser


