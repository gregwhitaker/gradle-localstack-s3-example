package example;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;

/**
 * Simple example that loads files into the S3 buckets created by the Gradle LocalStack Plugin and then
 * downloads and prints their contents.
 */
public class S3ExampleApplication {
    private static final Logger LOG = LoggerFactory.getLogger(S3ExampleApplication.class);

    public static void main(String... args) throws Exception {
        final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-1"))
                .withPathStyleAccessEnabled(true)
                .build();

        final File file1 = Paths.get(S3ExampleApplication.class.getClassLoader().getResource("file1.txt").toURI()).toFile();
        final File file2 = Paths.get(S3ExampleApplication.class.getClassLoader().getResource("file2.json").toURI()).toFile();

        LOG.info("Uploading file1.txt to bucket1...");
        s3Client.putObject("bucket1", "file1.txt", file1);

        LOG.info("Uploading file2.json to bucket2...");
        s3Client.putObject("bucket2", "file2.json", file2);

        LOG.info("Downloading file1.txt from bucket1...");
        LOG.info(s3Client.getObjectAsString("bucket1", "file1.txt"));

        LOG.info("Downloading file2.json from bucket2...");
        LOG.info(s3Client.getObjectAsString("bucket2", "file2.json"));
    }
}
