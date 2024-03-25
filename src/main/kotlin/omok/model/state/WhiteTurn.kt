package omok.model.state

import omok.model.Board
import omok.model.OmokStone
import omok.model.StoneColor
import omok.model.event.PutEvent
import omok.model.rule.BlackPutRule
import omok.model.rule.PutRule

class WhiteTurn(putRule: PutRule, board: Board) : Running(putRule, board) {
    override fun put(putEvent: PutEvent): GameState {
        val position = putEvent.onPutWhite.onPlace()
        val newStone = OmokStone(position, StoneColor.WHITE)
        if (canPut(newStone)) {
            val newBoard = board + newStone
            if (newBoard.isInOmok(position)) return Finish(newBoard)
            return BlackTurn(BlackPutRule, newBoard)
        }
        return put(putEvent)
    }
}
