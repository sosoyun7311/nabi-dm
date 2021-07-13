package com.dm.nabidm.www.board.service.impl;

import com.dm.nabidm.orm.domain.Board;
import com.dm.nabidm.orm.repository.BoardRepository;
import com.dm.nabidm.www.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;


    @Override
    public List<Board> boardListDataService() {
        return boardRepository.findBoardByDeleteYn("N" , Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public boolean insertBoardService( Board board) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new java.util.Date());
        java.sql.Date day= java.sql.Date.valueOf(dateStr);

        board.setRegistrationDate(day);
        board.setRegistrationId(0);
        board.setRegistrationIp("127.0.0.1");

        boardRepository.save(board);

        return true;
    }

    @Override
    public boolean updateBoardService(Board board) {

        Board selectData = boardRepository.findBoardByid(board.getId());

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new java.util.Date());
        java.sql.Date day= java.sql.Date.valueOf(dateStr);


        if(board.getDeleteYn().equals("Y")){
            selectData.setDeleteYn("Y");
        }else {
            selectData.setTitle(board.getTitle());
            selectData.setContent(board.getContent());
        }

        selectData.setModificationDate(day);
        selectData.setModificationId(0);
        selectData.setModificationIp("127.0.0.1");

        boardRepository.saveAndFlush(selectData);

        return false;
    }

}
