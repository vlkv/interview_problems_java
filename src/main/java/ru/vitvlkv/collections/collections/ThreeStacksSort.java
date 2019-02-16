package ru.vitvlkv.collections.collections;
import java.util.ArrayDeque;
import java.util.Deque;


public class ThreeStacksSort {

    public static void sortStack(Deque<Integer> stack) {
        State state = new State(stack.size());
        do {
            state.splitGroups(stack);
            state.mergeGroups(stack);
            state.completeGroupSize *= 2;
        } while (state.completeGroupsCount > 1 || state.totalRemindersCount() > 0);
    }

    private static class State {
        public int completeGroupSize = 1;
        public int completeGroupsCount;
        public int[] remainderGroupSizes = new int[2];
        public Deque<Integer>[] stacks = new Deque[] {new ArrayDeque<>(), new ArrayDeque<>()};

        public State(int stackSize) {
            completeGroupsCount = stackSize;
        }

        public int totalRemindersCount() {
            return remainderGroupSizes[0] + remainderGroupSizes[1];
        }


        private void splitGroups(Deque<Integer> stack) {

            remainderGroupSizes[0] = 0;
            remainderGroupSizes[1] = 0;

            // get number of complete groups. Poll them and split into two stacks
            // poll the remainder group
            completeGroupsCount = (completeGroupsCount / 2) * 2;

            int dst = 0;
            for (int i = 0; i < completeGroupsCount; ++i) {
                pollOneGroup(stack, stacks[dst % 2], completeGroupSize);
                dst++;
            }

            for (int i = 0; i < 2; ++i) {
                int count = pollOneGroup(stack, stacks[dst % 2], completeGroupSize);
                if (count == 0) {
                    break;
                }
                remainderGroupSizes[dst % 2] = count;

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

        private void mergeGroups(Deque<Integer> stack) {
            // First merge the remainder groups (if there are two).
            // If there is only one remainder group, simply move it to the original stack without merge

            boolean isFirst = true;
            completeGroupsCount = 0;
            while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
                int leftCount = isFirst ? remainderGroupSizes[0] : completeGroupSize;
                int rightCount = isFirst ? remainderGroupSizes[1] : completeGroupSize;

                completeGroupsCount += isFirst ? 0 : 1; // First group is not a complete group
                isFirst = false;

                while (leftCount > 0 || rightCount > 0) {
                    Integer left = leftCount > 0 ? stacks[0].peekLast() : null;
                    Integer right = rightCount > 0 ? stacks[1].peekLast() : null;
                    if (left == null && right == null) {
                        break;
                    } else if (right == null) {
                        stack.addLast(left);
                        stacks[0].pollLast();
                        leftCount--;
                    } else if (left == null) {
                        stack.addLast(right);
                        stacks[1].pollLast();
                        rightCount--;
                    } else if (left < right) { // TODO: use predicate here
                        stack.addLast(left);
                        stacks[0].pollLast();
                        leftCount--;
                    } else {
                        stack.addLast(right);
                        stacks[1].pollLast();
                        rightCount--;
                    }
                }
            }
        }
    }


}