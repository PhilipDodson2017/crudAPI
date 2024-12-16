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

Run the docker image with
`docker run -p 8080:8080 demo-app
`

### Kubernetes: Run with MiniCube

Kubernetes setup is not currently working.  I have documented my steps so far here.

With Minicube installed, run

`minikube start
`

Once it has finished starting, you can check status with 

`minikube status
`

Verify kubectl can connect to Minikube

`kubectl get nodes
`

Start MiniKube tunnel to simulate load balancer.

`minikube tunnel`

Ideally, we could deploy by applying the YAML Files but this did not work for me:

`kubectl apply -f kubernetes/deployment.yml`

`kubectl apply -f kubernetes/service.yml`

`kubectl apply -f kubernetes/ingress.yml  # Optional`

Instead of deploying with yaml files, run the image via command line:

`kubectl run hello-demo-app --image=demo-app --image-pull-policy=Never`

Create service 

 `kubectl expose pod hello-demo-app --type=NodePort --port=8080 --target-port=8080`

 Get minikube ip

 `minikube ip`

Get Node Port from this command

`kubectl get svc`

Go to this URL to view app

`http://<minikube-ip>:<node-port>`