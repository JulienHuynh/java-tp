package fr.hetic;

public class Multiplication implements Operation {
    @Override
    public Long apply(Long num1, Long num2) {
        return num1 * num2;
    }
}
