<%@ page import="controller.ContatoController" %>
<%@ page import="model.Contato" %>
<%
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String telefone = request.getParameter("telefone");
    Contato contato = new Contato(nome, email, telefone);
    ContatoController controller = new ContatoController();
    if(controller.save(contato)) {
       response.sendRedirect("./index.jsp");
     }
%>
