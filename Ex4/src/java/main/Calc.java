package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calc {
    public String text;
    public String operation;
    public ArrayList<Integer> values;
    public ArrayList<Integer> results = new ArrayList<>();
    public String error = "";

    public Calc(String array, String operation) {
        text = array;
        this.operation = operation;
        exec();
    }

    public boolean isEquals(Calc c) {
        return this.text.equals(c.text) && this.operation.equals(c.operation);
    }

    public void exec() {
        values = getArray(text);

        switch (operation) {
            case "max":
                getSecondMax();
                break;
            case "prime":
                getPrimes();
                break;
            case "perfect":
                getPerfects();
                break;
        }
    }

    public ArrayList<Integer> getArray(String array) {
        String[] words = array.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        try {
            for (String word : words) {
                if (Integer.parseInt(word) < 0) {
                    error = "You must input positive integers";
                    return list;
                }
                list.add(Integer.parseInt(word));
            }
        } catch (NumberFormatException e) {
            error = "You must input positive integers";
        }
        return list;
    }

    public void getPerfects() {
        for (int num : values) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                results.add(num);
            }
        }
    }

    public void getPrimes() {
        results = new ArrayList<>();
        for (int num : values) {
            if (num < 2) {
                continue;
            }
            boolean isPrime = true;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                results.add(num);
            }
        }
    }

    public void getSecondMax() {
        if (values.size() < 2) {
            error = "You must input at least 2 numbers";
        }

        int max = values.get(0);
        int maxIndex = 0;

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
                maxIndex = i;
            }
        }

        int secondMax = 0;
        int secondMaxIndex = 0;

        for (int i = 0; i < values.size(); i++) {
            if (i == maxIndex) {
                continue;
            }
            if (values.get(i) > secondMax) {
                secondMax = values.get(i);
                secondMaxIndex = i;
            }
        }

        results.add(secondMaxIndex);
    }

    public String getText() {
        return text;
    }

    public String getOperation() {
        return operation;
    }

    public String getResults() {
        String result = "";
        for (Integer i : results) {
            result += i + " ";
        }
        return result;
    }
}