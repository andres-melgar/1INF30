<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Prueba.aspx.cs" Inherits="SoftVenWA.Prueba" %>

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
                    <th scope="col">Id Producto</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Precio</th>
                </tr>
            </thead>
            <tbody>
                <%foreach(var producto in ListaProductos) { %>
                <tr>
                    <td><%: producto.ProductoId%></td>
                    <td><%: producto.Nombre%></td>
                    <td><%: producto.Descripcion%></td>
                    <td><%: producto.Precio%></td>
                </tr>
                <%}%>
            </tbody>    
        </table>
    </form>
</body>
</html>
