package baseball.controller

import baseball.*
import baseball.domain.BaseballGame
import baseball.domain.Computer
import baseball.domain.GameResult
import baseball.domain.User
import baseball.view.InputView
import baseball.view.OutputView

class Controller {


    val baseballGame = BaseballGame()
    val inputView = InputView()
    val outputView = OutputView()
    lateinit var user: User
    lateinit var computer: Computer
    val gameResult = GameResult()

    fun getUserNumber() {
        user = User(inputView.getUserNumber())
    }

    fun getComputerNumber() {
        computer = Computer(ComputerRandomNumberGenerator())
    }

    fun getGameResult() {
        gameResult.strike = baseballGame.getStrikeCount(computer.number,user.number)
        gameResult.ball= baseballGame.getBallCount(computer.number,user.number,gameResult.strike)
        outputView.printGameResult(gameResult.strike,gameResult.ball)
    }

    fun gameStart() {
        getComputerNumber()
        do {
            getUserNumber()
            getGameResult()
        } while (!baseballGame.isGameFinish(gameResult.strike))
        gameRetry()
    }

    fun gameRetry(){
        outputView.printGameEnd()
        val retryNumber = inputView.getRetryNumber()
        if(retryNumber== RETRY) gameStart()
    }

    fun run(){
        outputView.printStartMessage()
        gameStart()
    }

    companion object{
        const val RETRY = 1
    }
}