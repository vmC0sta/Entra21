<%@ page import="controller.ContatoController" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="model.Contato" %>
<%
    ContatoController controller = new ContatoController();
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Contatos</title>
    </head>
    <body>
        <header>
           <p>opcoes</p>
            <nav>
                <ul>
                    <li>notificacoes</li>
                    <li>eu</li>
                </ul>
            </nav>
        <header>
        <main>
            <div>
                <h1>Contatos</h1>
            </div>
            <table border="1">
                <thead>
                  <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Celular</th>
                  </tr>
                </thead>
                   <%
                        List<Contato> contatos = controller.findAll();
                        for(Contato contato : contatos){
                            out.print("<tr>");
                            out.print("<td>"+ contato.getId()+"</td>");
                            out.print("<td>"+ contato.getNome()+"</td>");
                            out.print("<td>"+ contato.getEmail() +"</td>");
                            out.print("<td>"+ contato.getTelefone() +"</td>");
                            out.print("</tr>");
                        }
                   %>
              </table>
              <div>
                    <a href="cadastrarContato.html">Cadastrar usuario</a>
              </div>
        </main>
    </body>
</html>
