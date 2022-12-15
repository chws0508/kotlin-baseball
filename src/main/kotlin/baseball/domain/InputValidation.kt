package baseball.domain

class InputValidation {
    fun checkUserNumberInputLength(input:String){
        if(input.length> USER_NUMBER_OF_DIGITS) throw IllegalArgumentException(USER_NUMBER_LENGTH_ERROR_MESSAGE)
    }

    fun checkUserNumberInputIsNaturalNumber(input: String){
        if(!input.all { char->
                char in '1'..'9'
        }) throw IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
    }

    fun checkRetryInputLength(input:String){
        if(input.length> RETRY_INPUT_LENGTH) throw IllegalArgumentException(RETRY_INPUT_LENGTH_ERROR_MESSAGE)
    }

    fun checkRetryInputNumber(input: String){
        if(!(input!= RETRY_NUMBER ||input!= QUIT_NUMBER)) throw IllegalArgumentException(
            INVALID_RETRY_INPUT_ERROR_MESSAGE
        )
    }

    companion object{
        const val USER_NUMBER_OF_DIGITS = 3
        const val USER_NUMBER_LENGTH_ERROR_MESSAGE ="너무 많거나 적은 숫자를 입력하였습니다. 3개의 숫자만 입력해 주세요."
        const val NOT_NATURAL_NUMBER_ERROR_MESSAGE = "1~9 에 포함되는 숫자만 입력해주세요."
        const val RETRY_INPUT_LENGTH = 1
        const val RETRY_INPUT_LENGTH_ERROR_MESSAGE ="너무 많거나 적은 숫자를 입력하였습니다. 1개의 숫자만 입력해 주세요."
        const val RETRY_NUMBER = "1"
        const val QUIT_NUMBER = "2"
        const val INVALID_RETRY_INPUT_ERROR_MESSAGE = "1 또는 2만 입력해 주세요"
    }
}