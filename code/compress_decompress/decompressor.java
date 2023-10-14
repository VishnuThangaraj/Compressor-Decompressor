package compress_decompress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        // Get Abstract Path of the File, To save output file in same location in storage
        String fileDirectory = file.getParent();

        FileInputStream fileInput = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fileInput);

        FileOutputStream fileOutput = new FileOutputStream(fileDirectory + "/DecompressedFile.txt");

        byte[] buffer = new byte[1024]; // max-write size as 1GB
        int length;

        while ((length = gzip.read(buffer)) != -1) {
            // data, offset-value, length(Number of bytes to write)
            fileOutput.write(buffer, 0, length);
        }

        gzip.close();
        fileOutput.close();
        fileInput.close();

    }
}
