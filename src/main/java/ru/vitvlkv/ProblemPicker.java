package ru.vitvlkv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ProblemPicker {


    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new RuntimeException("Program requires an argument, path to json config file");
        }
        Config config = readConfig(args[0]);
        ProblemPicker pp = new ProblemPicker(config);
        String result = pp.pickRandom();
        System.out.println(result);
    }

    private static Config readConfig(String configPath) throws IOException {
        File configFile = new File(configPath);
        long configLength = configFile.length();
        char[] configChars = new char[(int)configLength];
        try (FileReader fr = (new FileReader(configPath))) {
            fr.read(configChars, 0, configChars.length);
        }
        String configStr = String.valueOf(configChars);

        Gson gson = new GsonBuilder().create();
        Config config = gson.fromJson(configStr, Config.class);
        return config;
    }

    private final Config config;

    public ProblemPicker(Config config) {
        this.config = config;
    }

    public String pickRandom() {
        Random rnd = new Random(System.currentTimeMillis());
        int chapterIndex = rnd.nextInt(config.chapters.size());
        Chapter chapter = config.chapters.get(chapterIndex);
        int problemNumber = rnd.nextInt(chapter.questionsCount) + 1;
        return String.format("Today's problem is %d.%d from \"%s\" chapter", chapterIndex + 1, problemNumber + 1, chapter.title);
    }
}
