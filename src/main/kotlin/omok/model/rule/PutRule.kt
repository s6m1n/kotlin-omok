package omok.model.rule

import omok.model.Board
import omok.model.OmokStone

interface PutRule {
    fun canPut(
        stone: OmokStone,
        board: Board,
    ): Boolean
}
