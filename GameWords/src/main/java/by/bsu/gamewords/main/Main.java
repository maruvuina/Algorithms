package by.bsu.gamewords.main;

import by.bsu.gamewords.entity.CityGame;
import by.bsu.gamewords.file.ReadData;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadData data = new ReadData();
        List<String> cities = data.readFromFile();
        List<String> gameResult = CityGame.getCycleOfWords(cities);
        for (String city : gameResult) {
            System.out.println(city);
        }
    }
}
