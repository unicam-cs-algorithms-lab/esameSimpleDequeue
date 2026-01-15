package it.unicam.cs.asdl2526.esamesimpledequeue;

import org.junit.jupiter.api.Test;

class SecretStressOracleTest {

    @Test
    void stress_seed_2026_small() {
        SecretOracleUtils.runStressTest(2026L, 300, 8);
    }

    @Test
    void stress_seed_42_medium() {
        SecretOracleUtils.runStressTest(42L, 600, 10);
    }
}