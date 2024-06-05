package org.example.project

class Calculator {
    fun add(left: Double, right: Double): Double {
        return left + right
    }

    fun subtract(left: Double, right: Double): Double {
        return left - right
    }

    fun multiply(left: Double, right: Double): Double {
        return left * right
    }

    fun divide(left: Double, right: Double): Double {
        if (right == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        return left / right
    }
}