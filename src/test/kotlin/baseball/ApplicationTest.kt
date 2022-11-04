package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `3자리 예외 테스트`() {
        val testCase1 = listOf('1', '2', '3', '4')
        val testCase2 = listOf<Char>()
        assertThrows<IllegalArgumentException> { throwThreeLetterException(testCase1) }
        assertThrows<IllegalArgumentException> { throwThreeLetterException(testCase2) }
    }

    @Test
    fun `숫자 예외 테스트`() {
        val testCase1 = listOf('a', 'b', 'c')
        val testCase2 = listOf('가',']','.')
        assertThrows<IllegalArgumentException> { throwNonNumberException(testCase1) }
        assertThrows<IllegalArgumentException> { throwNonNumberException(testCase2) }
    }

    @Test
    fun `중복 예외 테스트`() {
        val testCase1 = listOf('1', '1', '3')
        assertThrows<IllegalArgumentException> { throwDuplicateNumberException(testCase1) }
    }

    @Test
    fun `Character 타입으로된 리스트를 Int로 바꿔서 유저 숫자를 얻는 기능 테스트`() {
        val userNumber= convertCharacterListToIntList(listOf('1','2','3'))
        assertThat(userNumber).isEqualTo(listOf(1,2,3))
    }

    @Test
    fun `볼 개수 반환 테스트`() {
        val userNumber= listOf(1,2,3)
        val computerNumber= listOf(2,3,4)
        assertThat(countBall(userNumber,computerNumber)).isEqualTo(2)
    }

    @Test
    fun `스트라이크 개수 반환 테스트`() {
        val userNumber= listOf(1,2,3)
        val computerNumber= listOf(1,3,4)
        assertThat(countStrike(userNumber,computerNumber)).isEqualTo(1)
    }

    @Test
    fun `최종 스트라이크,볼 개수 반환 테스트`() {
        val userNumber= listOf(1,2,3)
        val computerNumber= listOf(1,3,4)
        var ball= countBall(userNumber,computerNumber)
        val strike= countStrike(userNumber,computerNumber)
        ball= getFinalNumberOfBallBySubtractStrikeFromBall(ball,strike)
        assertThat(ball).isEqualTo(1)
        assertThat(strike).isEqualTo(1)
    }

    @Test
    fun `입력값 1,2 예외 테스트`() {
        val input="12"
        assertThrows<IllegalArgumentException> { throwInvalidRestartNumber(input) }
    }


    override fun runMain() {
        main()
    }
}
