### Building and Running the Application

Build and run unit tests with 

`mvn clean install
`

Run with 

`mvn spring-boot:run
`

Hello world API call

http://127.0.0.1:8080/customers/hello

### Acceptance Testing

Acceptance tests are not currently working due to import issues.  However, once this is resolved, you can run them
by configuring a run configuration in your IDE of choice to run CucumberTestRunner.java.  Additionally, these can
be run with a maven command, and integrated into CI/CD pipelines using that maven command.

### Instrumentation/Observability/Logging

-Logging library for this repo is log4j.  
-These logs should be forwarded to a logging tool such as Splunk, ELK or Cloudwatch.  
-Splunk has a better UI than Cloudwatch which
makes analysis quicker and easier, so this would be my preferred option.
However, Cloudwatch in my experience can be faster than Splunk
for large amounts of log data.
-I would recommend a dashboard and some alerts to track important metrics

### Containerization

After building the application, a jar file is generated. Use this command to build docker image from the jar file.

`docker build -t demo-app .
`