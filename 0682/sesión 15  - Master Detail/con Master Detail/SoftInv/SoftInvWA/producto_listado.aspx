<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="producto_listado.aspx.cs" Inherits="SoftInvWA.producto_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Productos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SoftInvScripts/gestionar_modales_productos.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Mantenimiento de Productos</h2>
            </div>
            <div class="card-body">
                <div class="card border">
                    <div class="card-header">
                        <h5>Información del Tipo de Producto</h5>
                    </div>
                    <div class="card-body">
                        <div class="mb-3 row">
                            <asp:Label ID="lblTipoProductoId" runat="server" Text="Identificador: " CssClass="col-sm-2 col-form-label"/>
                        
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtTipoProductoId" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                            <asp:Button ID="btnBuscarTipoProducto" CssClass="btn btn-primary col-sm-1" runat="server" Text="Buscar" OnClick="btnBuscarTipoProducto_Click"/>
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre: " CssClass="col-sm-2 col-form-label"/>
                            <div class="col-sm-8">
                                <asp:TextBox ID="txtNommbreProducto" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblDescripción" runat="server" Text="Descripción: " CssClass="col-sm-2 col-form-label"/>
                            <div class="col-sm-8">
                                <asp:TextBox ID="txtDescripcionProducto" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer">

            </div>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal" id="form-modal-tipo">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Tipo de Producto</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar tipo:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalTipoProducto_txtTipoProductoNombre" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalTipoProducto_lbBuscarTipoProducto" runat="server" CssClass="btn btn-info" OnClick="ModalTipoProducto_lbBuscarTipoProducto_Click" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar"  />
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="ModalTipoProducto_gvTipoProductos" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="TipoProductoId" />
                                            <asp:BoundField HeaderText="Nombre" DataField="Nombre" />
                                            <asp:BoundField HeaderText="Descripcion" DataField="Descripcion" />
                                            <asp:TemplateField>
                                            <ItemTemplate>
                                                <asp:LinkButton ID="ModalTipoProducto_lbSeleccionar" class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="ModalTipoProducto_lbSeleccionar_Click" CommandArgument='<%# Eval("TipoProductoId") %>' />
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                        </Columns>
                                    </asp:GridView>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
