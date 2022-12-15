package com.abujava;

import java.util.*;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 12/5/2022
 */
public class Array {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] letterArr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>(words.length);
        for (String word : words) {
            StringBuilder sum = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sum.append(letterArr[word.charAt(i) - 97]);
            }
            set.add(sum.toString());
        }
        return set.size();
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleans = new ArrayList<>(candies.length);

        int maxCandi = 0;
        for (int candy : candies) {
            maxCandi = Math.max(maxCandi, candy);
        }

        for (int i = 0; i < candies.length; i++) {
            booleans.add(i, candies[i] + extraCandies >= maxCandi);
        }
        return booleans;
    }

    public static int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        int toqSum = 0;
        int juftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                juftSum += nums[i];
            } else {
                toqSum += nums[i];
            }
        }
        return Math.max(toqSum, juftSum);
    }

    public static int deleteGreatestValue(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            int removableIndex = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0 && max < grid[i][j]) {
                    max = grid[i][j];
                    removableIndex = j;
                }
            }
            sum += max;
            grid[i][removableIndex] = 0;
        }
        return sum;
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }

        StringBuilder s2 = new StringBuilder();
        for (String s : word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int numberOfOdds = (arr.length % 2) == 1 ? arr.length / 2 + 1 : arr.length / 2;
        int sum = 0;
        for (int j : arr) {
            sum += j * numberOfOdds;
        }
        return sum;
    }

    public static String restoreString(String s, int[] indices) {
        String newStr = "";

        char[] strArr = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            newStr += strArr[indices[i]];
        }
        return newStr;
    }

    // hard
    public int strongPasswordChecker(String password) {
        int maxWeak = 5;

        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {

            }
        }
        return maxWeak;

    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    sum++;
                }
            }
            arr[i] = sum;
        }
        return arr;
    }

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            max = Math.max(max, sentences[i].split(" ").length);
        }
        return max;
    }

    public int mostWordsFoundV2(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            char[] chars = sentences[i].toCharArray();

            int sum = 1;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == ' ') sum++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = nums[j++];
            } else {
                arr[i] = nums[n++];
            }
        }
        return arr;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[0] >= target || target <= ints[ints.length - 1]) {
                return Arrays.binarySearch(ints, target) >= 0;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] >= target || target <= matrix[i][matrix[0].length - 1]) {
                int[] arr = new int[matrix[0].length];
                System.arraycopy(matrix[i], 0, arr, 0, matrix[i].length);
                return Arrays.binarySearch(arr, target) >= 0;
            }
        }
        return false;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new ArrayDeque<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int i = 0; i < students.length; i++) {
            studentQueue.add(students[i]);
            sandwichStack.add(sandwiches[sandwiches.length - (i + 1)]);
        }

        int size = 0;
        while (!studentQueue.isEmpty() && studentQueue.size() != size) {
            if (Objects.equals(sandwichStack.peek(), studentQueue.peek())) {
                sandwichStack.pop();
                studentQueue.poll();
                size = 0;
            } else {
                size++;
                studentQueue.add(studentQueue.poll());
            }
        }
        return studentQueue.size();
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() && ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
                sum += 2;
                max = Math.max(sum, max);
            } else {
                sum = 0;
            }
        }
        return max;
    }

    public static int rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {

        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) count++;
            }
        }
        return count;
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) return i;
        }
        return nums.length;
    }

    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] < nums[i] && (i + 1 == nums.length || nums[i + 1] < nums[i])) return i;
        }
        return 0;
    }

}