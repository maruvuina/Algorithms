package by.bsu.huffman.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WriteTextData {

    private static final Logger logger = LogManager.getLogger(WriteTextData.class);

    private String path;

    public WriteTextData(String path) {
        this.path = path;
    }

    public void writeTextData(String dataForWrite) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(dataForWrite);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while write text data: ", e);
        }
    }
}
