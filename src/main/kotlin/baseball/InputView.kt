package baseball

import camp.nextstep.edu.missionutils.Console

class InputView {

    private val inputValidation = InputValidation()
    private val converter = Converter()

    fun getUserNumber(): List<Int> {
        var input = Console.readLine()
        inputValidation.checkUserNumberInputLength(input)
        inputValidation.checkUserNumberInputIsNaturalNumber(input)
        return converter.stringToIntList(input)
    }
}