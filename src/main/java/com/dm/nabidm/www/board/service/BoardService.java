package com.dm.nabidm.www.board.service;

import com.dm.nabidm.orm.domain.Board;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("boardService")
public interface BoardService {
    List<Board> boardListDataService();

    boolean insertBoardService(Board board);

    boolean updateBoardService(Board board);

}
