# receipt-processor-


****Run with Docker**
**Since the project requirement is aplliaction must be Dockerized**

# Build Docker image
docker build -t receipt-processor .

# Run Docker container
docker run -p 8080:8080 receipt-processor


***************************************************************************************************************************


**Build Instructions (Using Maven)**

To run the application manually:

# first navigate to the project folder
cd receipt-processor

# Build the application
mvn clean package

# Run the application
java -jar target/receipt-processor-0.0.1-SNAPSHOT.jar

or open in IntelliJ and just click run application



