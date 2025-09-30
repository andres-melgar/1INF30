<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="almacen_listado.aspx.cs" Inherits="SoftInvWA.almacen_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Almacen
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Almacenes</h2>
        <div class="container row">
            <asp:GridView ID="dgvAlmacen" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id del Almacén" DataField="AlmacenId"/>
                    <asp:BoundField HeaderText="Nombre del Almacén" DataField="Nombre"/>
                    <asp:BoundField HeaderText="¿Almacén Central?" DataField="AlmacenCentral"/>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
