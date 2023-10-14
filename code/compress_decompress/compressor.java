package compress_decompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method(File file) throws IOException {
        // Get Abstract Path of the File, To save output file in same location in storage
        String fileDirectory = file.getParent();

        FileInputStream fileInput = new FileInputStream(file);
        FileOutputStream fileOutput = new FileOutputStream(fileDirectory+"CompressedFile.gzip");

        GZIPOutputStream gzip = new GZIPOutputStream(fileOutput);

        byte[] buffer = new byte[1024]; // max-Read size as 1GB
        int length;

        while((length = fileInput.read(buffer)) != -1){
            // data, offset-value, length(Number of bytes to write)
            gzip.write(buffer,0,length);
        }

        gzip.close();
        fileInput.close();
        fileOutput.close();
    }
}
