package calculator.controller

import calculator.model.Calculation
import calculator.model.Formula
import calculator.model.PriorityCalculator
import calculator.model.SequentialCalculator
import calculator.utils.retryInput
import calculator.view.InputView
import calculator.view.OutputView

class Calculator(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val sequentialCalculator: SequentialCalculator,
    private val priorityCalculator: PriorityCalculator,
) {

    fun execute() {
        val (numbers, operators) = getFormula()
        sequenceCalculation(numbers, operators)
        priorityCalculation(numbers ,operators)
    }

    private fun getFormula(): Pair<List<Double>, List<String>> {
        return retryInput(
            runBlock = {
                outputView.printCalculateMessage()
                val formula = inputView.readFormula().run { Formula(this) }
                formula.converter()
            },
            onError = {
                outputView.printErrorMessage(it)
            }
        )
    }

    private fun sequenceCalculation(numbers: List<Double>, operators: List<String>) {
        val result = sequentialCalculator(numbers, operators)
        outputView.printOperationResults(result)
    }

    private fun priorityCalculation(numbers: List<Double>, operators: List<String>) {
        val result = priorityCalculator(numbers, operators)
        outputView.printOperationResults(result)
    }
}
