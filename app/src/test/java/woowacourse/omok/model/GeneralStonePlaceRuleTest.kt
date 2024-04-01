package omok.model

import io.kotest.matchers.booleans.shouldBeFalse
import omok.fixtures.createPoint
import omok.fixtures.createWhiteBoard
import omok.fixtures.createWhiteStone
import org.junit.jupiter.api.Test
import woowacourse.omok.model.rule.GeneralStonePlaceRule

class GeneralStonePlaceRuleTest {
    @Test
    fun `이미 알이 있으면 금수`() {
        val whiteBoard =
            createWhiteBoard(
                createPoint(1, 2),
            )
        val whiteStone = createWhiteStone(1, 2)
        // when
        val canPut = GeneralStonePlaceRule.canPlace(whiteStone, whiteBoard)
        // then
        canPut.shouldBeFalse()
    }

    @Test
    fun `범위 밖에 놓으면 금수`() {
        val whiteBoard = createWhiteBoard()
        val whiteStone = createWhiteStone(0, 0)
        // when
        val canPut = GeneralStonePlaceRule.canPlace(whiteStone, whiteBoard)
        // then
        canPut.shouldBeFalse()
    }
}