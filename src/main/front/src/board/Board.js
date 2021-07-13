import axios from 'axios';
import React, {useEffect, useState} from "react";
import { Link } from 'react-router-dom';
import {Button, Table, Modal, Input, TextArea} from 'semantic-ui-react'


const Board = () =>{
  const [list, setList] = useState([])

  const initData = () =>{
    axios({
      method:'get',
      url:'/api/boardList'
    }).then((res) => {
      setList(res.data);
    })

  }

  useEffect(() => {
    initData();
  },[])


  return (
    <div>
      <div style={{marginBottom:'3px'}}>
        <Button color='gray' as={Link} to='/board/enrollment' floated={'right'}>등록</Button>
      </div>
      <Table celled padded>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell singleLine>번호</Table.HeaderCell>
            <Table.HeaderCell>제목</Table.HeaderCell>
            <Table.HeaderCell>내용</Table.HeaderCell>
            <Table.HeaderCell>등록일</Table.HeaderCell>
            <Table.HeaderCell> </Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
        {
          list.map(val => {
            return (
              <>
                <Table.Row>
                  <Table.Cell>{val.id}</Table.Cell>
                  <Table.Cell>{val.title}</Table.Cell>
                  <Table.Cell>{val.content}</Table.Cell>
                  <Table.Cell>{val.registrationDate}</Table.Cell>
                  <Table.Cell>

                    <Modal
                        trigger={<Button>상세보기</Button>}
                        header='상세보기'
                        content={<ModalCustom props={val} />}
                    ></Modal>
                  </Table.Cell>
                </Table.Row>
              </>
            )
          })
        }
        </Table.Body>
      </Table>
    </div>
  );
}


const ModalCustom = ({props}) => {
  const [updateData, setUpdateData] = useState(props);
  const [updateModalData, setUpdateModalData] = useState(false);


  const boardDataUpdateFun = (type) => {

    let obj ;

    if(type === 'delete'){
      obj = {
          "id": props.id,
          "deleteYn" : 'Y'
      };
    }else {
      obj = {
        "id": props.id,
        "title":updateData.title,
        "content" : updateData.content,
        "deleteYn" : 'N'
      };
    }

    axios.post('/api/boardUpdate', obj)
        .then(function(res){
          window.location.replace("/board");
        })
  }

  return (
    <>
    <Table celled padded>
      <Table.Body>
        <Table.Row>
          <Table.HeaderCell>제목</Table.HeaderCell>
          <Table.Cell>
            {
              updateModalData === true ? <Input type="text" value={updateData.title} onChange={(e) => setUpdateData({...updateData, title : e.target.value }) } />  : <span>{props.title}</span>
            }

          </Table.Cell>
        </Table.Row>
        <Table.Row>
          <Table.HeaderCell>내용</Table.HeaderCell>
          <Table.Cell>
            {
              updateModalData === true ? <TextArea style={{ minHeight: 100, minWidth:300 }} value={updateData.content} onChange={(e) => setUpdateData({...updateData, content : e.target.value }) } /> : <span>{props.content}</span>
            }
            </Table.Cell>
        </Table.Row>
        <Table.Row>
          <Table.HeaderCell>등록일</Table.HeaderCell>
          <Table.Cell>{props.registrationDate}</Table.Cell>
        </Table.Row>
      </Table.Body>
    </Table>
      <Modal.Actions>
        {
          updateModalData === false ?
            <Button color='green' onClick={() => setUpdateModalData(true)}>
              수정하기
            </Button>
              :
              <>
              <Button color='red' onClick={() => boardDataUpdateFun('delete')}>
                삭제
              </Button>
                <Button color='green' onClick={() => boardDataUpdateFun('update')}>
                  수정
                </Button>
              </>
        }
        <Button color='green' onClick={() => window.location.replace("/board")}>
          닫기
        </Button>
      </Modal.Actions>
    </>
  )
}





export default Board;
