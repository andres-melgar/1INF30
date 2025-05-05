<%@ Page Title="" Language="C#" MasterPageFile="~/SoftVen.Master" AutoEventWireup="true" CodeBehind="producto_listado.aspx.cs" Inherits="SoftVenWA.producto_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Productos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Productos</h2>
        <div class="container row">
            <asp:GridView ID="dgvProducto" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Código" DataField="ProductoId" />
                    <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                    <asp:BoundField HeaderText="Descripcion" DataField="Descripcion" />
                    <asp:BoundField HeaderText="Precio" DataField="Precio" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit' ps-2></i>" CommandArgument='<%# Eval("ProductoId") %>' OnClick="lbModificar_Click"/>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash' ps-2></i>" CommandArgument='<%# Eval("ProductoId") %>' OnClick="lbEliminar_Click"/>                            
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="container row">
            <div class="text-end">
                <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertar_Click"/>        
            </div>
        </div>
    </div>
</asp:Content>
