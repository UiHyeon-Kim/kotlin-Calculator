package calculator.model

import calculator.utils.Const

abstract class Calculation {
    abstract operator fun invoke(numbers: List<Double>, operators: List<String>): Double

    fun arithmetic(numbers: List<Double>, operators: List<String>): Double {
        var result = numbers.first()
        var index = Const.INITIAL_INDEX

        operators.forEach { operator ->
            when (operator) {
                Const.ADDITION -> result += numbers[++index]
                Const.SUBTRACTION -> result -= numbers[++index]
                Const.MULTIPLICATION -> result *= numbers[++index]
                Const.DIVISION -> result /= numbers[++index]
            }
        }
        return result
    }
}