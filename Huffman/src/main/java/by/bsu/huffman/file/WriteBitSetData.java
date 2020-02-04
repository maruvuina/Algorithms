package by.bsu.huffman.file;

import by.bsu.huffman.entity.Node;

import java.io.*;
import java.util.BitSet;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WriteBitSetData {
    private static final Logger logger = LogManager.getLogger(WriteBitSetData.class);

    private String path;

    public WriteBitSetData(String path) {
        this.path = path;
    }

    public void writeDataAsBin(Node root, BitSet bitSet) {
        try(FileOutputStream bw = new FileOutputStream(new File(path));
                ObjectOutputStream object = new ObjectOutputStream(bw)) {
            object.writeObject(root);
            object.writeObject(bitSet);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while write data as binary output: ", e);
        }
    }
}
