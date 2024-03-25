package omok.model.rule

import omok.model.Board
import omok.model.OmokStone

object WhitePutRule : PutRule {
    override fun canPut(
        stone: OmokStone,
        board: Board,
    ): Boolean {
        val isEmptyPosition = board.isEmptyPosition(stone)
        val isInRange = board.isInRange(stone)
        return isEmptyPosition && isInRange
    }
}
