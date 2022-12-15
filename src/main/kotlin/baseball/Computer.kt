package baseball

class Computer(private val computerNumberGenerator: ComputerNumberGenerator) {
    val number = computerNumberGenerator.generate()
}