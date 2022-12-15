package baseball

import camp.nextstep.edu.missionutils.Randoms

class ComputerRandomNumberGenerator:ComputerNumberGenerator {
    override fun generate(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < NUMBER_OF_DIGITS) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
        return computerNumber
    }

    companion object{
        const val NUMBER_OF_DIGITS = 3
    }
}