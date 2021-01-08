# gradle-localstack-s3-example
![Build](https://github.com/gregwhitaker/gradle-localstack-s3-example/workflows/Build/badge.svg)

An example of working with mock AWS S3 endpoints using [LocalStack](https://github.com/localstack/localstack) and the [Gradle LocalStack Plugin](https://github.com/Nike-Inc/gradle-localstack).

## Building the Example
Run the following command to build the example:

    ./gradlew clean build

## Running the Example
Follow the steps below to run the example application:

1. Run the following command to setup the LocalStack environment:

        ./gradlew startLocalStack

    If successful, you will see that the S3 buckets were created in the console:

         > Task :setupS3Buckets
         Creating S3 bucket: bucket1
         Created S3 bucket: bucket1
         Creating S3 bucket: bucket2
         Created S3 bucket: bucket2
         
         > Task :startLocalStack
         LocalStack Started

2. Run the following command to list the S3 buckets in LocalStack:
   
         ./gradlew listS3buckets

   If successful, you will see something similar to the following in the console:

         > Task :listS3Buckets
         ┌───────────────────────────────────────┬──────────────────────────────────────┐
         │BucketName                             │CreationDate                          │
         ├───────────────────────────────────────┼──────────────────────────────────────┤
         │bucket1                                │Thu Jan 07 15:51:37 PST 2021          │
         ├───────────────────────────────────────┼──────────────────────────────────────┤
         │bucket2                                │Thu Jan 07 15:51:37 PST 2021          │
         └───────────────────────────────────────┴──────────────────────────────────────┘

3. Run the following command to execute the application:

         ./gradlew run

   If successful, you will see the following in the console:

         > Task :run
         [main] INFO example.S3ExampleApplication - Uploading file1.txt to bucket1...
         [main] INFO example.S3ExampleApplication - Uploading file2.json to bucket2...
         [main] INFO example.S3ExampleApplication - Downloading file1.txt from bucket1...
         [main] INFO example.S3ExampleApplication - This is a test file.
         [main] INFO example.S3ExampleApplication - Downloading file2.json from bucket2...
         [main] INFO example.S3ExampleApplication - {
         "message": "This is a test file."
         }

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/gradle-localstack-s3-example/issues).
         
## License
MIT License

Copyright (c) 2021 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.