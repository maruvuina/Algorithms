package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Platforms {
    public Map<Integer, List<Integer>> getPlatformsEnergyWithPath(int platformCount, int []height) {
        int []energy = new int[platformCount + 1];
        int []numberPlatformFrom = new int[platformCount + 1];
        int []platformPath = new int[platformCount + 1];
        energy[1] = 0;
        energy[2] = Math.abs(height[2] - height[1]);
        numberPlatformFrom[1] = -1;
        numberPlatformFrom[2] = 1;
        for(int i = 3; i <= platformCount; i++) {
            int firstFoundedPlatform = energy[i - 1] + Math.abs(height[i] - height[i - 1]);
            int secondFoundedPlatform = energy[i - 2] + 3 * Math.abs(height[i] - height[i - 2]);
            if (firstFoundedPlatform < secondFoundedPlatform) {
                energy[i] = firstFoundedPlatform;
                numberPlatformFrom[i] = i - 1;
            } else {
                energy[i] = secondFoundedPlatform;
                numberPlatformFrom[i] = i - 2;
            }
        }
        int neededPlatformCount = 0;
        for(int i = platformCount; i > 0; i = numberPlatformFrom[i]) {
            platformPath[neededPlatformCount++] = i;
        }
        Map<Integer, List<Integer>> platformsEnergyWithPath = new HashMap<>();
        List<Integer> neededPath = new ArrayList<>();
        for(int i = neededPlatformCount - 1; i >= 0; i--) {
            neededPath.add(platformPath[i]);
        }
        platformsEnergyWithPath.put(energy[platformCount], neededPath);
        return platformsEnergyWithPath;
    }
}
