# receipt-processor-


Clone the repo: <br />

cd receipt-processor- <br />
cd receipt-processor(The Dockerfile is in this folder) <br />
****Run with Docker**
# Build Docker image
docker build -t receipt-processor .
# Run Docker container
docker run -p 8080:8080 receipt-processor


as per the Requirement:

Endpoint: Process Receipts
Path: /receipts/process
Method: POST
Payload: Receipt JSON
Response: JSON containing an id for the receipt.

Test API URL - http://localhost:8080/receipts/process


Endpoint: Get Points
Path: /receipts/{id}/points
Method: GET
Response: A JSON object containing the number of points awarded.

Test API URL - http://localhost:8080/receipts/{id}/points
NOTE:Replace the id with the response from the process receipts endpoint it will give the id generated.

I am including my test Screenshots

![id return](https://github.com/user-attachments/assets/b1b02331-a8cd-4caf-833d-caa0aba51bf7)

![points return](https://github.com/user-attachments/assets/8aaa6db3-6656-4fea-941e-fed433e81966)
