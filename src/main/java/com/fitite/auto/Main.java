package com.fitite.auto;

public class Main {
    public static void main(String[] args) {
        FiniteAutomaton automaton = new FiniteAutomaton();

        String[] testInputs = {
                "TEST",
                "abcTESTabc",
                "TETEST",
                "abcTES",
                "abc",
                "TEEST"
        };

        for (String input : testInputs) {
            State result = automaton.processString(input);
            boolean isAccepted = (result == State.F);

            System.out.println(input + " " + result + " " + isAccepted);
        }
    }
}