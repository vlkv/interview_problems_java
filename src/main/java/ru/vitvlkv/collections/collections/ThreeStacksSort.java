package ru.vitvlkv.collections.collections;
import java.util.ArrayDeque;
import java.util.Deque;


public class ThreeStacksSort {

    public static void sortStack(Deque<Integer> stack) {
        State state = new State();

        do {
            state.groupsCount = 0;
            splitGroups(state, stack);
            mergeGroups(state, stack);
            state.groupSize *= 2;
        } while (state.groupsCount > 1);
    }

    private static class State {
        public int groupSize = 1;
        public int groupsCount;
        public int[] restCounts = new int[2];
        public Deque<Integer>[] stacks = new Deque[] {new ArrayDeque<>(), new ArrayDeque<>()};
    }

    private static void splitGroups(State state, Deque<Integer> stack) {
        int dst = 0;
        while (!stack.isEmpty()) {
            int count = 1;
            while (!stack.isEmpty() && count <= state.groupSize) {
                Integer i = stack.pollLast();
                state.stacks[dst % 2].addLast(i);
                count++;
            }

            if (count < state.groupSize) {
                // it's a rest elems
                state.restCounts[dst % 2] = count;
            } else {
                // It's a complete group
                state.groupsCount++;
            }

            //switch the destinations
            dst++;
        }
    }

    private static void mergeGroups(State state, Deque<Integer> stack) {
        state.groupsCount = 0;
        while (!state.stacks[0].isEmpty() && !state.stacks[1].isEmpty()) {
            int leftCount = state.restCounts[0] > 0 ? state.restCounts[0] : state.groupSize;
            state.restCounts[0] = 0;
            int rightCount = state.restCounts[1] > 0 ? state.restCounts[1] : state.groupSize;
            state.restCounts[1] = 0;

            state.groupsCount++;
            while (leftCount > 0 || rightCount > 0) {
                Integer left = leftCount > 0 ? state.stacks[0].peekLast() : null;
                Integer right = rightCount > 0 ? state.stacks[1].peekLast() : null;
                if (left == null && right == null) {
                    break;
                } else if (right == null) {
                    stack.addLast(left);
                    state.stacks[0].pollLast();
                    leftCount--;
                } else if (left == null) {
                    stack.addLast(right);
                    state.stacks[1].pollLast();
                    rightCount--;
                } else if (left < right) { // TODO: use predicate here
                    stack.addLast(left);
                    state.stacks[0].pollLast();
                    leftCount--;
                } else {
                    stack.addLast(right);
                    state.stacks[1].pollLast();
                    rightCount--;
                }
            }
        }
    }
}