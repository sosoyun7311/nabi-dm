(this.webpackJsonpfront=this.webpackJsonpfront||[]).push([[0],{157:function(e,t,n){"use strict";n.r(t);var c=n(0),a=n.n(c),r=n(47),j=n.n(r),i=n(51),l=n(10),o=n(25),s=n(172),d=n(2),b=function(){var e=Object(c.useState)(""),t=Object(o.a)(e,2),n=t[0],a=t[1],r=function(e,t){var n=t.name;return a(n)};return Object(d.jsx)(d.Fragment,{children:Object(d.jsxs)(s.a,{children:[Object(d.jsx)(s.a.Item,{as:i.b,to:"/main",name:"main",active:"main"===n,onClick:r}),Object(d.jsx)(s.a.Item,{as:i.b,to:"/board",name:"board",active:"board"===n,onClick:r}),Object(d.jsx)(s.a.Menu,{position:"right",children:Object(d.jsx)(s.a.Item,{href:"/security_logout",name:"logout",active:"logout"===n,onClick:r})})]})})},O=n(29),x=n(65),h=n.n(x),u=n(158),g=n(174),p=n(173),m=n(170),f=n(171),C=function(e){var t=e.props,n=Object(c.useState)(t),a=Object(o.a)(n,2),r=a[0],j=a[1],i=Object(c.useState)(!1),l=Object(o.a)(i,2),s=l[0],b=l[1],x=function(e){var n;n="delete"===e?{id:t.id,deleteYn:"Y"}:{id:t.id,title:r.title,content:r.content,deleteYn:"N"},h.a.post("/api/boardUpdate",n).then((function(e){window.location.replace("/board")}))};return Object(d.jsxs)(d.Fragment,{children:[Object(d.jsx)(g.a,{celled:!0,padded:!0,children:Object(d.jsxs)(g.a.Body,{children:[Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{children:"\uc81c\ubaa9"}),Object(d.jsx)(g.a.Cell,{children:!0===s?Object(d.jsx)(m.a,{type:"text",value:r.title,onChange:function(e){return j(Object(O.a)(Object(O.a)({},r),{},{title:e.target.value}))}}):Object(d.jsx)("span",{children:t.title})})]}),Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{children:"\ub0b4\uc6a9"}),Object(d.jsx)(g.a.Cell,{children:!0===s?Object(d.jsx)(f.a,{style:{minHeight:100,minWidth:300},value:r.content,onChange:function(e){return j(Object(O.a)(Object(O.a)({},r),{},{content:e.target.value}))}}):Object(d.jsx)("span",{children:t.content})})]}),Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{children:"\ub4f1\ub85d\uc77c"}),Object(d.jsx)(g.a.Cell,{children:t.registrationDate})]})]})}),Object(d.jsxs)(p.a.Actions,{children:[!1===s?Object(d.jsx)(u.a,{color:"green",onClick:function(){return b(!0)},children:"\uc218\uc815\ud558\uae30"}):Object(d.jsxs)(d.Fragment,{children:[Object(d.jsx)(u.a,{color:"red",onClick:function(){return x("delete")},children:"\uc0ad\uc81c"}),Object(d.jsx)(u.a,{color:"green",onClick:function(){return x("update")},children:"\uc218\uc815"})]}),Object(d.jsx)(u.a,{color:"green",onClick:function(){return window.location.replace("/board")},children:"\ub2eb\uae30"})]})]})},v=function(){var e=Object(c.useState)([]),t=Object(o.a)(e,2),n=t[0],a=t[1];return Object(c.useEffect)((function(){h()({method:"get",url:"/api/boardList"}).then((function(e){a(e.data)}))}),[]),Object(d.jsxs)("div",{children:[Object(d.jsx)("div",{style:{marginBottom:"3px"},children:Object(d.jsx)(u.a,{color:"gray",as:i.b,to:"/board/enrollment",floated:"right",children:"\ub4f1\ub85d"})}),Object(d.jsxs)(g.a,{celled:!0,padded:!0,children:[Object(d.jsx)(g.a.Header,{children:Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{singleLine:!0,children:"\ubc88\ud638"}),Object(d.jsx)(g.a.HeaderCell,{children:"\uc81c\ubaa9"}),Object(d.jsx)(g.a.HeaderCell,{children:"\ub0b4\uc6a9"}),Object(d.jsx)(g.a.HeaderCell,{children:"\ub4f1\ub85d\uc77c"}),Object(d.jsx)(g.a.HeaderCell,{children:" "})]})}),Object(d.jsx)(g.a.Body,{children:n.map((function(e){return Object(d.jsx)(d.Fragment,{children:Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.Cell,{children:e.id}),Object(d.jsx)(g.a.Cell,{children:e.title}),Object(d.jsx)(g.a.Cell,{children:e.content}),Object(d.jsx)(g.a.Cell,{children:e.registrationDate}),Object(d.jsx)(g.a.Cell,{children:Object(d.jsx)(p.a,{trigger:Object(d.jsx)(u.a,{children:"\uc0c1\uc138\ubcf4\uae30"}),header:"\uc0c1\uc138\ubcf4\uae30",content:Object(d.jsx)(C,{props:e})})})]})})}))})]})]})};var w=function(){return Object(d.jsx)("div",{children:Object(d.jsx)("h2",{children:"Hello Word!!"})})},y=function(){var e=Object(c.useState)({title:"",content:""}),t=Object(o.a)(e,2),n=t[0],a=t[1];return Object(d.jsxs)("div",{children:[Object(d.jsx)(g.a,{celled:!0,padded:!0,children:Object(d.jsxs)(g.a.Body,{children:[Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{children:"\uc81c\ubaa9"}),Object(d.jsx)(g.a.Cell,{children:Object(d.jsx)(m.a,{type:"text",onChange:function(e){return a(Object(O.a)(Object(O.a)({},n),{},{title:e.target.value}))}})})]}),Object(d.jsxs)(g.a.Row,{children:[Object(d.jsx)(g.a.HeaderCell,{children:"\ub0b4\uc6a9"}),Object(d.jsx)(g.a.Cell,{children:Object(d.jsx)(f.a,{style:{minHeight:100,minWidth:600},onChange:function(e,t){return a(Object(O.a)(Object(O.a)({},n),{},{content:e.target.value}))}})})]})]})}),Object(d.jsx)("br",{}),Object(d.jsx)(u.a,{color:"gray",onClick:function(){h.a.post("/api/boardInsert",{title:n.title,content:n.content,deleteYn:"N"}).then((function(e){a({title:"",content:""}),window.location.replace("/board")}))},children:"\ub4f1\ub85d"}),Object(d.jsx)(u.a,{color:"gray",onClick:function(){return window.location.replace("/board")},children:"\ub4a4\ub85c"})]})},H=n(175);var k=function(){var e=Object(c.useState)(""),t=Object(o.a)(e,2),n=t[0],a=t[1],r=Object(c.useState)(""),j=Object(o.a)(r,2),i=j[0],l=j[1];return Object(d.jsxs)("div",{children:[Object(d.jsx)("h2",{children:"Login"}),Object(d.jsx)("br",{}),Object(d.jsxs)("form",{action:"/login.do",method:"post",id:"login_form",children:[Object(d.jsx)(m.a,{type:"text",name:"encId",value:n,onChange:function(e){return a(e.target.value)}}),Object(d.jsx)("br",{}),Object(d.jsx)("br",{}),Object(d.jsx)(m.a,{type:"password",name:"password",value:i,onChange:function(e){return l(e.target.value)}}),Object(d.jsx)("br",{}),Object(d.jsx)("br",{}),Object(d.jsx)(u.a,{color:"gray",type:"submit",className:"btn_login",children:"\ub85c\uadf8\uc778"})]})]})},F=function(){return Object(d.jsx)(d.Fragment,{children:Object(d.jsx)("div",{style:{margin:"0 auto",padding:"0 auto",width:"90%",marginTop:"3px"},children:Object(d.jsxs)(i.a,{children:[Object(d.jsx)(l.a,{path:["/main","/board"],component:b}),Object(d.jsx)(H.a,{children:Object(d.jsxs)(l.c,{children:[Object(d.jsx)(l.a,{exact:!0,path:"/",component:k}),Object(d.jsx)(l.a,{exact:!0,path:"/main",component:w}),Object(d.jsx)(l.a,{exact:!0,path:"/board",component:v}),Object(d.jsx)(l.a,{exact:!0,path:"/board/enrollment",component:y}),Object(d.jsx)(l.a,{render:function(){return Object(d.jsx)("div",{className:"error",children:"error"})}})]})})]})})})},S=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,177)).then((function(t){var n=t.getCLS,c=t.getFID,a=t.getFCP,r=t.getLCP,j=t.getTTFB;n(e),c(e),a(e),r(e),j(e)}))};n(156);j.a.render(Object(d.jsx)(a.a.StrictMode,{children:Object(d.jsx)(F,{})}),document.getElementById("root")),S()}},[[157,1,2]]]);
//# sourceMappingURL=main.52e6c968.chunk.js.map