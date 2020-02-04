package by.bsu.gamewords.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadData {
    private static final Logger logger = LogManager.getLogger(ReadData.class);

    private static final String DIR_NAME = "data";

    private static final String FILE_NAME_WITHOUT_EXTENSION = "Cities";

    private String getFullPathToFile() {
        String FILE_EXTENSION = ".txt";
        return DIR_NAME + File.separator + FILE_NAME_WITHOUT_EXTENSION + FILE_EXTENSION;
    }

    public List<String> readFromFile() {
        List<String> list = new ArrayList<>();
        String filePath = getFullPathToFile();
        InputStream is =
                ReadData.class.getClassLoader().getResourceAsStream(filePath);
        String line;
        try(InputStreamReader isR = new InputStreamReader(
                Objects.requireNonNull(is), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isR)) {
            while ((line = br.readLine()) != null) {
                if (line.strip().length() > 0) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while trying to read from file: ", e);
        }
        return list;
    }
}