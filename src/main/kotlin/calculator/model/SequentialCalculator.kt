package calculator.model

import calculator.utils.Const


class SequentialCalculator : Calculation() {
    override fun invoke(numbers: List<Double>, operators: List<String>): Double {
        if (numbers.isEmpty()) return Const.INITIAL_DOUBLE_VALUE
        return arithmetic(numbers, operators)
    }
}