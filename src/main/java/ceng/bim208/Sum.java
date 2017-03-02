package ceng.bim208;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;

class Sum {

    // Compute a checksum for the given path

    static long sum(Path p) {

        if (!Files.isRegularFile(p)) return -1;
        java.util.zip.CRC32 crc32 = new CRC32();
       
        // your codes goes here ...

        return crc32.getValue();
    }
}