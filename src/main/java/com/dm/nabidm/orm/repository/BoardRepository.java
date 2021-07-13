package com.dm.nabidm.orm.repository;

import com.dm.nabidm.orm.domain.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer>, JpaSpecificationExecutor<Board> {

    List<Board> findBoardByDeleteYn(String delYN , Sort sort);

    Board findBoardByid(Integer id);

}
