package org.example;

public class Constraints {
    private final String start;
    private final String end;
    private final Double p;

    public Constraints(String start, String end,  Double p) {
        this.start = start;
        this.end = end;
        this.p = p;
    }

    public String getA() {
        return start;
    }

    public String getB() {
        return end;
    }


    public Double getProbability() {
        return p;
    }
}
