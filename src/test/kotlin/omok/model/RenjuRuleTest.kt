package omok.model

import io.kotest.matchers.booleans.shouldBeFalse
import omok.fixtures.createBlackBoard
import omok.fixtures.createBlackStone
import omok.fixtures.createPoint
import omok.fixtures.createWhiteBoard
import omok.fixtures.createWhiteStone
import omok.model.rule.GeneralStonePlaceRule
import omok.model.rule.RenjuRule
import org.junit.jupiter.api.Test

class RenjuRuleTest {
    @Test
    fun `장목이면 금수다`() {
        // given
        val blackBoard =
            createBlackBoard(
                createPoint(1, 1),
                createPoint(1, 2),
                createPoint(1, 3),
                createPoint(1, 4),
                createPoint(1, 5),
            )
        val blackStone = createBlackStone(1, 6)
        // when
        val canPut = RenjuRule.canPlace(blackStone, blackBoard)
        // then
        canPut.shouldBeFalse()
    }

    @Test
    fun `3-3이면 금수다`() {
        // given
        val blackBoard =
            createBlackBoard(
                createPoint(4, 5),
                createPoint(4, 6),
                createPoint(5, 4),
                createPoint(6, 4),
            )
        val blackStone = createBlackStone(4, 4)
        // when
        val canPut = RenjuRule.canPlace(blackStone, blackBoard)
        // then
        canPut.shouldBeFalse()
    }

    @Test
    fun `4-4이면 금수다`() {
        val blackBoard =
            createBlackBoard(
                createPoint(1, 2),
                createPoint(1, 3),
                createPoint(1, 4),
                createPoint(2, 1),
                createPoint(3, 1),
                createPoint(4, 1),
            )
        val blackStone = createBlackStone(1, 1)
        // when
        val canPut = RenjuRule.canPlace(blackStone, blackBoard)
        // then
        canPut.shouldBeFalse()
    }

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