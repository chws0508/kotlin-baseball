package baseball

import camp.nextstep.edu.missionutils.Console

class InputView {

    private val inputValidation = InputValidation()
    private val converter = Converter()

    fun getUserNumber(): List<Int> {
        print(USER_NUMBER_INPUT_MESSAGE)
        var input = Console.readLine()
        inputValidation.checkUserNumberInputLength(input)
        inputValidation.checkUserNumberInputIsNaturalNumber(input)
        return converter.stringToIntList(input)
    }

    fun getRetryNumber(): Int{
        println(RETRY_NUMBER_INPUT_MESSAGE)
        var input = Console.readLine()
        inputValidation.checkRetryInputNumber(input)
        inputValidation.checkRetryInputLength(input)
        return input.toInt()
    }

    companion object{
        const val USER_NUMBER_INPUT_MESSAGE ="숫자를 입력해주세요 : "
        const val RETRY_NUMBER_INPUT_MESSAGE ="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}