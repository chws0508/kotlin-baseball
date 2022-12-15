package baseball

class BaseballGame {

    fun getStrikeCount(computer: List<Int>, user: List<Int>):Int{
        var strikeCount = 0
        for(i in 0 until NUMBER_DIGITS){
            if(computer[i]==user[i]) strikeCount++
        }
        return strikeCount
    }



    companion object{
        const val NUMBER_DIGITS = 3
        const val GAME_END_STRIKE_COUNT = 3
    }
}