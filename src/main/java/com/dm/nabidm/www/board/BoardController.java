package com.dm.nabidm.www.board;


import com.dm.nabidm.orm.domain.Board;
import com.dm.nabidm.www.board.service.BoardService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
public class BoardController {

    @Resource
    private BoardService boardService;


    @RequestMapping(value = "/api/boardList" , method = {RequestMethod.GET})
    public List<Board> boardListController(){
        List<Board> list = boardService.boardListDataService();
        return list;
    }


    @ResponseBody
    @RequestMapping(value = "/api/boardInsert" , method = {RequestMethod.POST}, produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean boardInsertController(@RequestBody Board board){

        return boardService.insertBoardService(board);
    }


    @ResponseBody
    @RequestMapping(value = "/api/boardUpdate" , method = {RequestMethod.POST}, produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean boardUpdateController(@RequestBody Board board){
        return boardService.updateBoardService(board);
    }


}
