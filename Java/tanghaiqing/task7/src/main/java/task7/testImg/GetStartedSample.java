    package task7.testImg;

    import com.aliyun.oss.OSS;
    import com.aliyun.oss.OSSClient;
    import com.aliyun.oss.model.*;

    import java.io.*;

    public class GetStartedSample {
        private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        private static String accessKeyId = "LTAIYJkbrR5aHKIX";
        private static String accessKeySecret = "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut";
        private static String bucketName = "tas7haiqing";
        private static String key = "<key>";

        public static void main(String[] args) {
            OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            System.out.println("Getting Started with OSS SDK for Java\n");
            try {
                /*
                 * Determine whether the bucket exists
                 */
                if(!ossClient.doesBucketExist(bucketName)){
                    System.out.println("Creating bucket " + bucketName + "\n");
                    ossClient.createBucket(bucketName);
                    CreateBucketRequest createBucketRequest=new CreateBucketRequest(bucketName);
                    createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                    ossClient.createBucket(createBucketRequest);
                }
                /*
                 * List the buckets in your account
                 */
                System.out.println("Listing buckets");
                ListBucketsRequest listBucketsRequest =new ListBucketsRequest();
                listBucketsRequest.setMaxKeys(500);
                for (Bucket bucket : ossClient.listBuckets()) {
                    System.out.println(" - " + bucket.getName());
                }
                System.out.println();
                /*
                 * Upload an object to your bucket
                 */
                System.out.println("Uploading a new object to OSS from a file\n");
                ossClient.putObject(new PutObjectRequest(bucketName,key,createSampleFile()));
                /*
                 * Determine whether an object residents in your bucket
                 */
                boolean exists =ossClient.doesObjectExist(bucketName,key);
                System.out.println("Does object " + bucketName + " exist? " + exists + "\n");
                ossClient.setObjectAcl(bucketName,key,CannedAccessControlList.PublicRead);
                ossClient.setObjectAcl(bucketName,key,CannedAccessControlList.Default);

                ObjectAcl objectAcl =ossClient.getObjectAcl(bucketName,key);
                System.out.println("ACL:" + objectAcl.getPermission().toString());
                /*
                 * Download an object from your bucket
                 */
                System.out.println("Downloading an object");
                OSSObject ossObject =ossClient.getObject(bucketName,key);
                System.out.println("Content-Type: "  +ossObject.getObjectMetadata().getContentType());
                displayTextInputStream(ossObject.getObjectContent());

            } catch (IOException e) {
                e.printStackTrace();
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

                System.out.println("    " + line);
            }
            System.out.println();

            reader.close();
        }
    }
