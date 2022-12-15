package baseball.domain

class BaseballGame {

    fun getStrikeCount(computer: List<Int>, user: List<Int>):Int{
        var strikeCount = 0
        for(i in 0 until NUMBER_DIGITS){
            if(computer[i]==user[i]) strikeCount++
        }
        return strikeCount
    }

    fun getBallCount(computer:List<Int>,user:List<Int>,strikeCount:Int):Int{
        var ballCount = 0
        user.forEach {number->
            if(computer.contains(number)) ballCount++
        }
        return ballCount - strikeCount
    }

    fun isGameFinish(strikeCount:Int):Boolean{
        if(strikeCount == GAME_END_STRIKE_COUNT ) return true
        return false
    }

    companion object{
        const val NUMBER_DIGITS = 3
        const val GAME_END_STRIKE_COUNT = 3
    }
}