package baseball.util

class Converter {

    fun stringToIntList(string:String):List<Int>{
        val result = mutableListOf<Int>()
        string.forEach {char ->
            result.add(char.code - 48)
        }
        return result
    }
}