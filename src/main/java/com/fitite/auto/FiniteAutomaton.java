package com.fitite.auto;

public class FiniteAutomaton {
    public State processString(String input) {
        if (input == null) return State.S;

        State currentState = State.S;

        for (char c : input.toCharArray()) {
            switch (currentState) {
                case S:
                    if (c == 'T') {
                        currentState = State.T1;
                    }
                    break;

                case T1:
                    if (c == 'E') {
                        currentState = State.TE;
                    } else if (c == 'T') {
                        currentState = State.T1;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case TE:
                    if (c == 'S') {
                        currentState = State.TES;
                    } else if (c == 'T') {
                        currentState = State.T1;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case TES:
                    if (c == 'T') {
                        currentState = State.F;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case F:
                    break;
            }
        }
        return currentState;
    }
}