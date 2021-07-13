import React, {useState} from 'react';
import {Menu, Grid} from "semantic-ui-react";

import {Link} from 'react-router-dom'

const Main = () => {
		const [activeName, setActiveName] = useState('');

		const clickedMenu = (e,{name}) => setActiveName(name)

		return (
				<>
						<Menu>
								<Menu.Item as={Link} to='/main'  name='main' active={activeName === 'main'}
								           onClick={clickedMenu}/>
								<Menu.Item as={Link} to='/board'  name='board' active={activeName === 'board'}
								            onClick={clickedMenu}/>
								<Menu.Menu position='right'>
										<Menu.Item href='/security_logout'  name='logout' active={activeName === 'logout'}
										           onClick={clickedMenu}/>
								</Menu.Menu>
						</Menu>
				</>
		);
}

export default Main;
