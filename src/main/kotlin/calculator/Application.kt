package calculator

import calculator.controller.Calculator
import calculator.model.PriorityCalculator
import calculator.model.SequentialCalculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val sequentialCalculator = SequentialCalculator()
    val priorityCalculator = PriorityCalculator()
    val calculator = Calculator(inputView, outputView, sequentialCalculator, priorityCalculator)
    calculator.execute()
}
