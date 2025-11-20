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
                    <asp:BoundField HeaderText="Id del Almacén" DataField="almacenId"/>
                    <asp:BoundField HeaderText="Nombre del Almacén" DataField="nombre"/>
                    <asp:BoundField HeaderText="¿Almacén Central?" DataField="almacen_central"/>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit'></i>" CommandArgument='<%# Eval("almacenId") %>' OnClick="lbModificar_Click"/>
                            <asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash'></i>" CommandArgument='<%# Eval("almacenId") %>' OnClick="lbEliminar_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="container row">
            <div class="text-end">
                <asp:Button ID="btnInsertar" runat="server" CssClass="float-start btn btn-secondary" Text="Insertar" OnClick="btnInsertar_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
