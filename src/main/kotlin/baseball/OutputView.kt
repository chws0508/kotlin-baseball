package baseball

class OutputView {

    fun printStartMessage() {
        println(GAME_START_MESSAGE)
    }

    fun printBall(ball: Int) {
        if (ball != 0) print("${ball}${BALL} ")
    }

    fun printStrike(strike: Int) {
        if (strike != 0) print("${strike}${STRIKE}")
        println()
    }

    fun printGameResult(strike: Int,ball: Int){
        if(strike==0 && ball == 0) print("낫싱")
        printBall(ball)
        printStrike(strike)
    }

    fun printGameEnd() {
        println(GAME_END)
    }

    companion object {
        const val GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val BALL = "볼"
        const val STRIKE = "스트라이크"
        const val GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
}