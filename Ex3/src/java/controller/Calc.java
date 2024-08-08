package controller;

import java.util.ArrayList;

public class Calc {
    public String text;
    public boolean isOdd;
    public int result;

    public Calc(String text, boolean isOdd) {
        this.text = text;
        this.isOdd = isOdd;
        this.result = getResult(getArray(text, isOdd));
    }

    public String getText() {
        return text;
    }

    public String getIsOdd() {
        return isOdd ? "Odd" : "Even";
    }

    public int getResult() {
        return result;
    }

    public boolean isEquals(Calc h) {
        return this.text.equals(h.text) && this.isOdd == h.isOdd;
    }

    public static int getResult(ArrayList<Integer> list) {
        int result = 0;
        for (int num : list) {
            result += num;
        }
        return result;
    }

    public static boolean checkNumber(int num, boolean isOdd) {
        return isOdd ? num % 2 != 0 : num % 2 == 0;
    }

    public static ArrayList<Integer> getArray(String array, boolean isOdd) {
        String[] words = array.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        try {
            for (String word : words) {
                if (Calc.checkNumber(Integer.parseInt(word), isOdd)) {
                    list.add(Integer.parseInt(word));
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return list;
    }
}