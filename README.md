# Detecting duplicate files in a given path

In this homework, you will recursively traverse all the regular files in a given path. You can do so with the [SimpleFileVisitor](https://docs.oracle.com/javase/8/docs/api/java/nio/file/SimpleFileVisitor.html) interface.
You can start with the [Walking the File Tree](http://docs.oracle.com/javase/tutorial/essential/io/walk.html) example and iterate on it.

Instead of comparing two files byte by byte, you will compare their checksum values. You will calculate a checksum for each file using an algorithm of your choice. 
I used [cyclic redundancy check](https://en.wikipedia.org/wiki/Cyclic_redundancy_check) (`java.util.zip.CRC32`), but feel free to choose another one. If computed checksum values are equal, then we can assume that files are duplicates of each other.

Use an appropriate data structure to group files under the same checksum. **Hint: Map<Long,List\<Path\>>**

Your program will sort the duplicate lists by the number of files in each list.
For example, if four duplicates of a file is detected, then this four files will be printed before a duplicate list of size two.

You can test your program easily by downloading a [solr-6.4.1](http://www-eu.apache.org/dist/lucene/solr/6.4.1/solr-6.4.1.tgz) distribution.
Extract it into some location and use this path as starting directory of your program.

* java -jar target/HW1-1.0.jar /Users/iorixxx/Desktop/solr-6.4.1

and the program will print out something like:

```
...
licenses/httpclient-NOTICE.txt licenses/httpcore-NOTICE.txt licenses/httpmime-NOTICE.txt  
...
server/solr-webapp/webapp/js/lib/highlight.js server/solr-webapp/webapp/libs/highlight.js  
... 
server/solr-webapp/webapp/WEB-INF/lib/httpmime-4.4.1.jar dist/solrj-lib/httpmime-4.4.1.jar 
...
docs/images/solr.svg server/solr-webapp/webapp/img/solr.svg  
...
```


* Print relative paths between the file and the starting directory (`java.nio.file.Path.relativize`).
* Files in each row will be sorted by last modified time (`Files.getLastModifiedTime`): newest will come first.
* Skip hidden (`Files.isHidden`) files and folders altogether and only work with regular files as measured by the `BasicFileAttributes.isRegularFile` method.
* Your project must a valid maven project and `mvn clean package` command should produce an executable jar file named `target/HW1-1.0.jar`.