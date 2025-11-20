<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="almacen_listado.aspx.cs" Inherits="SoftInvWA.almacen_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Almacén
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Almacenes</h2>
        <div class="container row">
            <asp:GridView ID="dgvAlmacen" runat="server" AllowPaging="false"
                AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id del Almacén" DataField="almacenId" />
                    <asp:BoundField HeaderText="Nombre del Almacén" DataField="nombre" />
                    <asp:TemplateField HeaderText =" ¿Almacén Central?">
                        <ItemStyle HorizontalAlign="Center" />
                        <ItemTemplate>
                            <asp:CheckBox ID="chkAlmacenCentral" runat="server" Enabled="false" Checked='<%# Convert.ToBoolean(Eval("almacen_central"))%>' />
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lblModificar" runat="server" Text="<i class='fa-solid fa-edit'></i>" CommandArgument='<%# Eval("almacenId") %>' OnClick="lblModificar_Click"/>
                            <asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash'></i>" CommandArgument='<%# Eval("almacenId") %>' OnClick="lbEliminar_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="container row">
            <div class="text-end">
                <asp:Button ID="btnInsertar" CssClass="float-start btn btn-secondary" runat="server" Text="Insertar" OnClick="btnInsertar_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
