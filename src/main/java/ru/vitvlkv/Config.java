package ru.vitvlkv;

import java.util.ArrayList;
import java.util.List;

public class Config {
    String title;
    List<Chapter> chapters = new ArrayList<>();
}

class Chapter {
    String title;
    int questionsCount;
}
