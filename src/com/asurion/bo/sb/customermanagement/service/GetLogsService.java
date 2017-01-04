package com.asurion.bo.sb.customermanagement.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@Service
public class GetLogsService {
	
	public List<String> getS3Logs() {
	
		List<String> s3Messages = new ArrayList<String>();
		
		String bucketName = "customer-management-logs";
		// This is the name of the file that you want to read
		String key = "logs.txt";
		
		try {
			
			AWSCredentials credentials = getAWSCredentials();

			if (credentials == null)
				return null;

			AmazonS3 s3 = new AmazonS3Client(credentials);
			Region usEast1 = Region.getRegion(Regions.US_EAST_1);
			s3.setRegion(usEast1);
			
			// Get message from S3 bucket
			S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
			
			System.out.println("Downloaded the file from S3");
			System.out.println(object);
            
			InputStream input = object.getObjectContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
	        while (true) {
	            String line = reader.readLine();
	            if (line == null) break;

	            s3Messages.add(line);
	        }
			
			return s3Messages;

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon AWS, but was rejected with an error response for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
			
			return null;
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with AWS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			
			return null;
		} catch (Exception e) {
			System.out.println(e);
			
			return null;
		}
		
	}
	
	
	public List<String> getSqsLogs() {
	
		List<String> sqsMessages = new ArrayList<String>();
		String queueName = "customer-management-logs";
		
		try {
			AWSCredentials credentials = getAWSCredentials();

			if (credentials == null)
				return null;

			AmazonSQS sqs = new AmazonSQSClient(credentials);
			Region usEast1 = Region.getRegion(Regions.US_EAST_1);
			sqs.setRegion(usEast1);
			
			
			// Get messages from SQS
			ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueName);
            List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
            System.out.println(messages);
            
            for (Message message : messages) {
            	System.out.println(message.getBody());
            	sqsMessages.add(message.getBody());
            	
            	// Delete message after reading
            	String messageReceiptHandle = message.getReceiptHandle();
                sqs.deleteMessage(new DeleteMessageRequest(queueName, messageReceiptHandle));
            }
            
            return sqsMessages;
            
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon AWS, but was rejected with an error response for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
			
			return null;
			
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with AWS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
			
			return null;
			
		} catch (Exception e) {
			System.out.println(e);
			
			return null;
		}
		
	}
	
	
	
	public AWSCredentials getAWSCredentials() {
		try {
			System.out.println("Getting AWS credentials");
			AWSCredentials credentials = new ProfileCredentialsProvider("default").getCredentials();
			System.out.println("Got AWS credentials");
			return credentials;
		} catch (Exception e) {
			System.out.println("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (C:\\Users\\vikram.sawant\\.aws\\credentials), and is in valid format.");
			System.out.println(e);
			return null;
		}
	}
	
	

}
