# Com_Decom Android Appliction

The app compresses large text files into a few KBs which is implemented using Zip Compress Library and then decompresses the file when the
user wants to re-open it. Developed using Java with Android Studio Framework.

The app takes 3 input from user -
  - Path of source file
  - Path of destination file 
  - Action: Compress or decompress

Main Classes -
1. MainActivity - Initialises the user screen and takes input. It then delegates the action to Compress_file or Decompress_file class.
2. Compress_file - Invokes service(MainSErvice) to perform compress job.
3. Decompress_file - Invokes service(SecondWork) to perform decompress job.
1. MainSErvice - This consists of a function YoCompress which compresses the input file.
2. SecondWork - This consists of a function YoDecompress which decompresses the input file.

Output - It then takes the input file, performs the action and stores it back to. the destination file.
