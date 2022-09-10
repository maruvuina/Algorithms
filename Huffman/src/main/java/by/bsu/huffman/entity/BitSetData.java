package by.bsu.huffman.entity;

import java.util.BitSet;
import java.util.Map;

public class BitSetData {

    private String text;

    public BitSetData(String text) {
        this.text = text;
    }

    public BitSet convertStringToBitset(String stringOfWordCodes) {
        BitSet bitset = new BitSet(stringOfWordCodes.length());
        for (int i = 0; i < stringOfWordCodes.length(); i++) {
            if (stringOfWordCodes.charAt(i) == '1') {
                bitset.set(i);
            }
        }
        return bitset;
    }

    public String convertBitsetToString(BitSet bitSet) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= bitSet.length() + 1; i++) {
            if (bitSet.get(i)) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    public BitSet getBinaryData(Map<Character, String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : text.toCharArray()) {
            String charCode = huffmanCode.get(ch);
            stringBuilder.append(charCode);
        }
        return convertStringToBitset(stringBuilder.toString());
    }
}
