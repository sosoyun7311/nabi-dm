import React, {useState} from 'react';
import { Button, Table, Input } from 'semantic-ui-react'


function Login() {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");

  return (
      <div>
          <h2>Login</h2>
          <br/>
          <form action="/login.do" method="post" id="login_form">
              <Input type="text" name="encId" value={id} onChange={(e) => setId(e.target.value)}/>
              <br/>
              <br/>
              <Input type="password" name="password" value={password} onChange={(e) => setPassword(e.target.value)}/>
              <br/>
              <br/>
              <Button color='gray' type="submit" className="btn_login">로그인</Button>
          </form>
      </div>
  );
}

export default Login;
