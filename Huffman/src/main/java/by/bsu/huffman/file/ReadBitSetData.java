package by.bsu.huffman.file;

import by.bsu.huffman.entity.DecodedData;
import by.bsu.huffman.entity.Node;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.BitSet;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadBitSetData {

    private static final Logger logger = LogManager.getLogger(ReadBitSetData.class);

    private String path;

    public ReadBitSetData(String path) {
        this.path = path;
    }

    public DecodedData getDecodedData() {
        Node decodeNode = null;
        BitSet bitSet = null;
        try(FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream)) {
            decodeNode = (Node) objectOutputStream.readObject();
            bitSet = (BitSet) objectOutputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.ERROR, "Error while get decoded data: ", e);
        }
        return new DecodedData(decodeNode, bitSet);
    }
}
