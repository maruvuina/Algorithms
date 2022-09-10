package by.bsu.huffman.main;

import by.bsu.huffman.entity.BitSetData;
import by.bsu.huffman.entity.DecodedData;
import by.bsu.huffman.entity.Huffman;
import by.bsu.huffman.entity.Node;
import by.bsu.huffman.file.ReadBitSetData;
import by.bsu.huffman.file.ReadTextData;
import by.bsu.huffman.file.WriteBitSetData;
import by.bsu.huffman.file.WriteTextData;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ReadTextData inputData = new ReadTextData("data", "input");
        String text = inputData.readFromFile();
        Huffman huffman = new Huffman();
        Node tree = huffman.getTree(text);
        String code = "";
        Map<Character, String> huffmanCode = new HashMap<>();
        huffman.encode(tree, code, huffmanCode);
        BitSetData bitSetData = new BitSetData(text);
        BitSet bitSet = bitSetData.getBinaryData(huffmanCode);
        String encodeDataPath = "src/main/resources/data/encodeData.txt";
        WriteBitSetData writeBitSetData = new WriteBitSetData(encodeDataPath);
        writeBitSetData.writeDataAsBin(tree, bitSet);
        ReadBitSetData readBitSetData = new ReadBitSetData(encodeDataPath);
        DecodedData decodedData = readBitSetData.getDecodedData();
        String convertedData = bitSetData.convertBitsetToString(decodedData.getBitSet());
        String decodedText = huffman.decode(decodedData.getTree(), convertedData);
        String pathToDecodedData = "src/main/resources/data/decodeData.txt";
        WriteTextData writeTextData = new WriteTextData(pathToDecodedData);
        writeTextData.writeTextData(decodedText);
    }
}
