package com.asurion.bo.sb.customermanagement.log;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/*
 * I am not using this class anywhere
 */

public class Log {

	public void log(String logMessage) {
		try {
			logS3(logMessage);
			logSQS(logMessage);

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which means your request made it "
					+ "to Amazon AWS, but was rejected with an error response for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with AWS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void logS3(String logMessage) {

		String bucketName = "my-first-s3-bucket";
		String key = "MyObjectKey";

		AWSCredentials credentials = getAWSCredentials();

		if (credentials == null)
			return;

		AmazonS3 s3 = new AmazonS3Client(credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		s3.setRegion(usWest2);

		System.out.println("Creating Message on S3");
		s3.putObject(new PutObjectRequest(bucketName, key, logMessage));

	}

	public void logSQS(String logMessage) {

		String queueName = "my-queue";

		AWSCredentials credentials = getAWSCredentials();

		if (credentials == null)
			return;

		AmazonSQS sqs = new AmazonSQSClient(credentials);
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		sqs.setRegion(usWest2);

		SendMessageRequest message = new SendMessageRequest(queueName, logMessage);

		System.out.println("Sending message to SQS");
		sqs.sendMessage(message);

	}

	public AWSCredentials getAWSCredentials() {
		try {
			System.out.println("Getting AWS credentials");
			AWSCredentials credentials = new ProfileCredentialsProvider("default").getCredentials();
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
