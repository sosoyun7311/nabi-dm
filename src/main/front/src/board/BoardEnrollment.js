import React, { useState} from "react";
import axios from 'axios';
import { Button, Table, Input , TextArea} from 'semantic-ui-react'


const BoardEnrollment = () =>{
		const [insertData , setInsertData] = useState({
				title:'',
				content:''
		})
		const insertDataFun = () =>{

				axios.post('/api/boardInsert', {"title":insertData.title, "content" : insertData.content, "deleteYn" : 'N'})
						.then(function(res){
								setInsertData({title:'',content:''});
								window.location.replace("/board");
						})
		}


		return (
				<div>
						<Table celled padded>
								<Table.Body>
									<Table.Row>
											<Table.HeaderCell>제목</Table.HeaderCell>
											<Table.Cell><Input type="text" onChange={(e) => setInsertData({...insertData, title:e.target.value})} /></Table.Cell>
									</Table.Row>
									<Table.Row>
											<Table.HeaderCell>내용</Table.HeaderCell>
											<Table.Cell><TextArea style={{ minHeight: 100, minWidth:600 }} onChange={(e, d) => setInsertData({...insertData,  content:e.target.value})} /></Table.Cell>
									</Table.Row>
								</Table.Body>
						</Table>
					<br/>
						<Button color='gray' onClick={() => insertDataFun()}  >등록</Button>
						<Button color='gray' onClick={() => window.location.replace("/board")} >뒤로</Button>
				</div>
		)
}

export default BoardEnrollment;