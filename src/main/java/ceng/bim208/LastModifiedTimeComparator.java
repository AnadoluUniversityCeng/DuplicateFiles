package ceng.bim208;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * Compare the last modified date/time of two paths
 */
class LastModifiedTimeComparator implements Comparator<Path> {
    @Override
    public int compare(Path p1, Path p2) {
        return -1; // your code goes here ...
    }
}
