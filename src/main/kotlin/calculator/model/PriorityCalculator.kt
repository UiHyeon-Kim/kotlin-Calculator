package calculator.model

import calculator.utils.Const.DIVISION
import calculator.utils.Const.INITIAL_INDEX
import calculator.utils.Const.MULTIPLICATION

class PriorityCalculator : Calculation() {
    override fun invoke(numbers: List<Double>, operators: List<String>): Double {
        val localOperators = operators.toMutableList()
        val localNumbers = numbers.toMutableList()

        firstOperation(localNumbers, localOperators)
        return arithmetic(localNumbers, localOperators)
    }

    private fun firstOperation(numbers: MutableList<Double>, operators: MutableList<String>) {
        var index = INITIAL_INDEX
        while (index < operators.size) {
            val result = when (operators[index]) {
                MULTIPLICATION -> numbers.removeAt(index) * numbers.removeAt(index)
                DIVISION -> numbers.removeAt(index) / numbers.removeAt(index)
                else -> continue
            }
            numbers.add(index, result)
            operators.removeAt(index)
            index++
        }
    }
}