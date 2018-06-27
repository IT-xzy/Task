package com.Utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.exceptions.ClientException;

import java.io.*;

/**
 * @author: 曹樾
 * @program: task7
 * @description: exam
 * @create: 2018/5/29 下午7:49
 */

public class exam {
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAINW6xnz0Qw2Og";
    private static String accessKeySecret = "HLnU0Varkd6kqjppUFKm3owkyOHKK8";
    
    private static String bucketName = "caoyue1-2-3-4";
    private static String key = "aaa/";
    
    public static void main(String[] args) throws IOException {
        /*
         * Constructs a client instance with your account for accessing OSS
         */
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        
        try {
            
            /**
             * Note that there are two ways of uploading an object to your bucket, the one
             * by specifying an input stream as content source, the other by specifying a file.
             */
            
            /*
             * Upload an object to your bucket from an input stream
             */
            System.out.println("Uploading a new object to OSS from an input stream\n");
            
            String content = "Thank you for using Aliyun Object Storage Service";
            System.out.println(content.getBytes());
            client.putObject(bucketName, key, new ByteArrayInputStream(content.getBytes()));
            
            /*
             * Upload an object to your bucket from a file
             */
            System.out.println("Uploading a new object to OSS from a file\n");
            client.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));
            
            /*
             * Download an object from your bucket
             */
            System.out.println("Downloading an object");
            OSSObject object = client.getObject(new GetObjectRequest(bucketName, key));
            System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
            displayTextInputStream(object.getObjectContent());
            
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } finally {
            /*
             * Do not forget to shut down the client finally to release all allocated resources.
             */
            client.shutdown();
        }
    }
    
    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("oss-java-sdk-", ".txt");
        file.deleteOnExit();
        
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();
        
        return file;
    }
    
    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            
            System.out.println("\t" + line);
        }
        System.out.println();
        
        reader.close();
    }
}
