package ru.vitvlkv.collections;

import java.util.List;

public class MajorityElement {

    public static int majorityElement(final List<Integer> a) {
        int maj = a.get(0);
        int count = 1;
        for (int i = 1; i < a.size(); ++i) {
            int elem = a.get(i);
            count += (elem == maj ? 1 : -1);
            if (count == 0) {
                maj = elem;
                count = 1;
            }
        }
        return maj;
    }
}
