package woowacourse.omok.view

import woowacourse.omok.model.Board
import woowacourse.omok.model.OmokStone

interface OmokOutputView {
    fun showStartMessage()

    fun showProgress(
        board: Board,
        stone: OmokStone?,
    )

    fun showGameResult(
        board: Board,
        stone: OmokStone,
    )
}
