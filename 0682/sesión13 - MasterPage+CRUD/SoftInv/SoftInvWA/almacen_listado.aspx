﻿<%@ Page Title="" Language="C#" MasterPageFile="~/SoftInv.Master" AutoEventWireup="true" CodeBehind="almacen_listado.aspx.cs" Inherits="SoftInvWA.almacen_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Almacén
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Almacén</h2>
        <div class="container row">
            <asp:GridView ID ="dgvAlmacen" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id del Almacén" DataField="AlmacenID"/>
                    <asp:BoundField HeaderText="Nombre del Almacén" DataField="Nombre"/>
                    <asp:BoundField HeaderText="¿Almacén Central?" DataField="AlmacenCentral"/>
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("AlmacenId")%>' OnClick="lbModificar_Click"/>
                            <asp:LinkButton ID="lbEliminar" runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("AlmacenId")%>' OnClick="lbEliminar_Click"/>
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
