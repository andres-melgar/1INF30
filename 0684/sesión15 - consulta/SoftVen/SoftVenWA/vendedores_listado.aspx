<%@ Page Title="" Language="C#" MasterPageFile="~/SoftVen.Master" AutoEventWireup="true" CodeBehind="vendedores_listado.aspx.cs" Inherits="SoftVenWA.vendedores_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Consulta de Vendedores
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Consulta de Vendedores</h2>
            </div>
            <div class="card-body">
                <div class="row mb-3 align-items-center g-2">
                    <%--Grupo Tienda--%>
                    <div class="col md-7">
                        <asp:Label ID="lblTienda" runat="server" Text="Tienda:" CssClass="form-label" />
                        <asp:DropDownList ID="ddlTienda" runat="server" CssClass="form-select" />
                    </div>
                    <%--Grupo Nombre--%>
                    <div class="col md-4">
                        <asp:Label ID="lblNombre" runat="server" Text="Nombre:" CssClass="form-label" />
                        <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" />
                    </div>
                    <%--Grupo botón--%>
                    <div class="col md-2 d-flex justify-content-end">
                        <asp:Button ID="btnConsultarVendedores" runat="server" Text="Consultar" CssClass="btn btn-primary" OnClick="btnConsultarVendedores_Click" />
                    </div>
                </div>
                <div class="row">
                    <asp:GridView ID="gvVendedores" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                        <Columns>
                            <asp:BoundField HeaderText="Tienda" DataField="Tienda.Nombre" />
                            <asp:BoundField HeaderText="Matricula" DataField="VendedorId" />
                            <asp:BoundField HeaderText="Ap. Paterno" DataField="Paterno" />
                            <asp:BoundField HeaderText="Ap. Materno" DataField="Materno" />
                            <asp:BoundField HeaderText="Nombres" DataField="Nombre" />
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
         </div>
        <div class="card-footer clearfix">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-primary" OnClick="btnRegresar_Click"/>
        </div>
    </div>
</asp:Content>
