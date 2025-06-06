<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="almacen_gestion.aspx.cs" Inherits="SoftInvWA.almacen_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
<%--    Creación de Almacén--%>
    <%: CabeceraPagina %>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card">
        <div class="card-header">
            <%--<h2> Creación de Almacén</h2>--%>
            <h2> <%: CabeceraPagina %></h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIdAlmacen" runat="server" Text="Id Almacén: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtIdAlmacen" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNombre" runat="server" Text="Nombre del Almacén: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblCentral" runat="server" Text="¿Almacén central?: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:CheckBox ID="cbCentral" runat="server" CssClass="form-check-input"></asp:CheckBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" CssClass="float-start btn btn-primary" runat="server" Text="Regresar" OnClick="btnRegresar_Click"/>
            <asp:Button ID="btnGuardar" CssClass="float-end btn btn-secondary" runat="server" Text="Guardar" OnClick="btnGuardar_Click"/>
        </div>
    </div>
</asp:Content>
