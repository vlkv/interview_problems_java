package ru.vitvlkv.collections;
import java.util.ArrayDeque;
import java.util.Deque;

/* You are given three stacks. One stack is filled with random numbers. Sort the numbers using the three stacks.
* */
public class ThreeStacksSortN2 {

    public static void sortStack(Deque<Integer> stack) {

        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer>[] stacks = new Deque[] {stack, stack2};
        Deque<Integer> stackResult = new ArrayDeque<>();
        int stackIndex = 0;

        while (!stack.isEmpty() || !stack2.isEmpty()) {
            int srcIndex = stackIndex % 2;
            int dstIndex = (stackIndex + 1) % 2;

            Integer elemTop = null;
            while (!stacks[srcIndex].isEmpty()) {
                elemTop = elemTop == null ? stacks[srcIndex].pollLast() : elemTop;
                Integer elemNext = stacks[srcIndex].peekLast();
                if (elemNext == null) {
                    stacks[dstIndex].addLast(elemTop);
                    elemTop = null;
                } else if (elemTop < elemNext) { // TODO: use predicate here
                    stacks[dstIndex].addLast(elemTop);
                    elemTop = null;
                } else {
                    stacks[dstIndex].addLast(elemNext);
                    stacks[srcIndex].pollLast();
                }
            }
            Integer elem = elemTop != null ? elemTop : stacks[dstIndex].pollLast();
            stackResult.addLast(elem);
            stackIndex++;
        }

        while (!stackResult.isEmpty()) {
            Integer elem = stackResult.pollLast();
            stack.addLast(elem);
        }
    }
}