package by.bsu.substringsearch.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReadTextData {

    private static final Logger logger = LogManager.getLogger(ReadTextData.class);

    private static final String DEFAULT_FILE_EXTENSION = ".txt";

    private String dirName;

    private String fileNameWithoutExtension;

    public ReadTextData(String dirName, String fileNameWithoutExtension) {
        this.dirName = dirName;
        this.fileNameWithoutExtension = fileNameWithoutExtension;
    }

    private String getFullPathToFile() {
        return dirName + File.separator + fileNameWithoutExtension + DEFAULT_FILE_EXTENSION;
    }

    public String readFromFile() {
        StringBuilder stringBuilder = new StringBuilder();
        String filePath = getFullPathToFile();
        InputStream is =
                ReadTextData.class.getClassLoader().getResourceAsStream(filePath);
        int line;
        try(InputStreamReader isR = new InputStreamReader(
                Objects.requireNonNull(is), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isR)) {
            while ((line = br.read()) != -1) {
                stringBuilder.append((char)line);
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while trying to read from file: ", e);
        }
        return stringBuilder.toString();
    }
}
