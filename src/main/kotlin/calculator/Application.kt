package calculator

import calculator.controller.Calculator
import calculator.model.Calculation
import calculator.model.PriorityCalculator
import calculator.model.SequentialCalculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val calculation = SequentialCalculator()
    val calculator = Calculator(inputView, outputView, calculation)
    calculator.execute()
}
