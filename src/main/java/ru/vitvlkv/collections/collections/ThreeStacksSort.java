package ru.vitvlkv.collections.collections;
import java.util.ArrayDeque;
import java.util.Deque;


public class ThreeStacksSort {

    public static void sortStack(Deque<Integer> stack) {
        State state = new State();
        state.completeGroupsCount = stack.size();
        do {
            splitGroups(state, stack);
            mergeGroups(state, stack);
            state.completeGroupSize *= 2;
        } while (state.completeGroupsCount > 1 || state.totalRemindersCount() > 0);
    }

    private static class State {
        public int completeGroupSize = 1;
        public int completeGroupsCount;
        public int[] remainderGroupSizes = new int[2];
        public Deque<Integer>[] stacks = new Deque[] {new ArrayDeque<>(), new ArrayDeque<>()};

        public int totalRemindersCount() {
            return remainderGroupSizes[0] + remainderGroupSizes[1];
        }
    }

    private static void splitGroups(State st, Deque<Integer> stack) {

        st.remainderGroupSizes[0] = 0;
        st.remainderGroupSizes[1] = 0;

        // get number of complete groups. Poll them and split into two stacks
        // poll the remainder group
        st.completeGroupsCount = (st.completeGroupsCount / 2) * 2;

        int dst = 0;
        for (int i = 0; i < st.completeGroupsCount; ++i) {
            pollOneGroup(stack, st.stacks[dst % 2], st.completeGroupSize);
            dst++;
        }

        for (int i = 0; i < 2; ++i) {
            int count = pollOneGroup(stack, st.stacks[dst % 2], st.completeGroupSize);
            if (count == 0) {
                break;
            }
            st.remainderGroupSizes[dst % 2] = count;

            dst++;
        }
    }

    private static int pollOneGroup(Deque<Integer> stack, Deque<Integer> stackTo, int groupSize) {
        int count = 0;
        while (!stack.isEmpty() && count < groupSize) {
            Integer i = stack.pollLast();
            stackTo.addLast(i);
            count++;
        }
        return count;
    }

    private static void mergeGroups(State state, Deque<Integer> stack) {

        // First merge the remainder groups (if there are two).
        // If there is only one remainder group, simply move it to the original stack without merge

        boolean isFirst = true;
        state.completeGroupsCount = 0;
        while (!state.stacks[0].isEmpty() || !state.stacks[1].isEmpty()) {
            int leftCount = isFirst ? state.remainderGroupSizes[0] : state.completeGroupSize;
            int rightCount = isFirst ? state.remainderGroupSizes[1] : state.completeGroupSize;

            state.completeGroupsCount += isFirst ? 0 : 1; // First group is not a complete group
            isFirst = false;

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