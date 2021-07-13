import React, {useEffect} from "react";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Menu from "./Menu";
import Board from "../board/Board";
import Main from "../main/Main";
import BoardEnrollment from "../board/BoardEnrollment";
import {Grid, Segment} from 'semantic-ui-react'
import Login from "../login/login";

const Layout = () => {
		return (
				<>
						<div style={{margin: '0 auto', padding: '0 auto', width: '90%', marginTop:'3px'}}>
								<Router>
										<Route path={['/main', '/board']} component={Menu}/>
										<Segment>
												<Switch>
														<Route exact path='/' component={Login}/>
														<Route exact path='/main' component={Main}/>
														<Route exact path='/board' component={Board}/>
														<Route exact path="/board/enrollment" component={BoardEnrollment}/>
														<Route render={() => <div className='error'>error</div>}/>
												</Switch>
										</Segment>
								</Router>
						</div>
				</>
		);
}

export default Layout;
