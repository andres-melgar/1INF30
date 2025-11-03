<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="almacen_gestion.aspx.cs" Inherits="SoftInvWA.almacen_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Creación de Almacén
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card">
        <div class="card-header">
            <h2>Creación de Almacén</h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIdAlmacen" runat="server" Text="Id Almacén: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtIdAlmacen" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNombre" runat="server" Text="Nombre: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblCentral" runat="server" Text="¿Almacén Central?" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:CheckBox ID="cbCentral" runat="server" CssClass="form-check-input"></asp:CheckBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-primary" Text="Regresar" OnClick="btnRegresar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-secondary" Text="Guardar" OnClick="btnGuardar_Click"/>
        </div>      
    </div>
</asp:Content>
