<%@ page import="Modele.Emp" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FindAll test</title>
</head>

<body>
    <h1>FindAll</h1>
    <% 
        out.println("Oh la la");
        List<Emp> listeemp = (List<Emp>) request.getAttribute("lst");
        for(Emp emp : listeemp){ %>        
            <p><% out.println(emp.getNom()); %></p>
        <%
        }
     %>
</body>

</html>