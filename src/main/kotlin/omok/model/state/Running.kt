package omok.model.state

import omok.model.Board
import omok.model.OmokStone
import omok.model.rule.PutRule

sealed class Running(private val putRule: PutRule, board: Board) : GameState(board) {
    protected fun canPut(stone: OmokStone): Boolean {
        return putRule.canPut(stone, board)
    }
}
