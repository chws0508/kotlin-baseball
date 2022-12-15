package baseball.domain

import baseball.ComputerNumberGenerator

class Computer(private val computerNumberGenerator: ComputerNumberGenerator) {
    val number = computerNumberGenerator.generate()
}