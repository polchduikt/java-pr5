package com.fitite.auto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FiniteAutomatonTest {
    private final FiniteAutomaton automaton = new FiniteAutomaton();

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("", State.S),
                Arguments.of("abc", State.S),
                Arguments.of("TEST", State.F),
                Arguments.of("abcTESTabc", State.F),

                Arguments.of("T", State.T1),
                Arguments.of("TE", State.TE),
                Arguments.of("TES", State.TES),
                Arguments.of("abcTES", State.TES),

                Arguments.of("TES", State.TES),
                Arguments.of("EST", State.T1),
                Arguments.of("TEEST", State.T1),
                Arguments.of("test", State.S),

                Arguments.of("TETEST", State.F),
                Arguments.of("TESTEST", State.F),
                Arguments.of("TTETEST", State.F),
                Arguments.of("TTEST", State.F),
                Arguments.of("TESTTEST", State.F)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testAutomaton(String input, State expectedState) {
        assertEquals(expectedState, automaton.processString(input));
    }
}