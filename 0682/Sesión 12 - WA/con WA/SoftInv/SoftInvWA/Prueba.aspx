<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Prueba.aspx.cs" Inherits="SoftInvWA.Prueba" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Id Almacen</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">¿Central?</th>
                </tr>
            </thead>
            <tbody>
                <% foreach (var almacen in ListaAlmacenes)
                    { %>
                <tr>
                    <td><%: almacen.AlmacenId %></td>
                    <td><%: almacen.Nombre %></td>
                    <td><%: almacen.AlmacenCentral %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </form>
</body>
</html>
