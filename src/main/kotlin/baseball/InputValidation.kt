package baseball

class InputValidation {
    fun checkInputLength(input:String){
        if(input.length>NUMBER_OF_DIGITS) throw IllegalArgumentException(LENGTH_ERROR_MESSAGE)
    }

    fun checkInputIsNaturalNumber(input: String){
        if(!input.all { char->
                char in '1'..'9'
        }) throw IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE)
    }

    companion object{
        const val NUMBER_OF_DIGITS = 3
        const val LENGTH_ERROR_MESSAGE ="너무 많거나 적은 숫자를 입력하였습니다. 3개의 숫자만 입력해 주세요."
        const val NOT_NATURAL_NUMBER_ERROR_MESSAGE = "1~9 에 포함되는 숫자만 입력해주세요."
    }
}