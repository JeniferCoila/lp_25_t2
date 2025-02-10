<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@ page import="java.util.*"%>
    <style>
        body {
            background: #f8f9fa;
        }
        .table th, .table td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-sm {
            margin: 2px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <a href="login.jsp" class="btn btn-success">Cerrar sesión</a>
    
        <h1 class="text-center text-primary">Listado de Proveedores</h1>
        
        <div class="d-flex justify-content-between mb-3">
            <h4 class="text-secondary">Gestión de proveedores</h4>
            <a href="addProveedor.jsp" class="btn btn-success">Registrar Proveedor</a>
        </div>
        
        <div class="table-responsive">
            <table class="table table-hover table-bordered bg-white">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>RUC</th>
                        <th>Razón Social</th>
                        <th>Email</th>
                        <th>Fecha de Ingreso</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    List<model.TblProveedor> proveedores = (List<model.TblProveedor>) request.getAttribute("listado");
                    if (proveedores != null && !proveedores.isEmpty()) {
                        for (model.TblProveedor proveedor : proveedores) {
                    %>
                    <tr>
                        <td><%= proveedor.getIdproveedor() %></td>
                        <td><%= proveedor.getNomproveedor() %></td>
                        <td><%= proveedor.getRucproveedor() %></td>
                        <td><%= proveedor.getRsocialproveedor() %></td>
                        <td><%= proveedor.getEmailproveedor() %></td>
                        <td><%= proveedor.getFeingproveedor() %></td>
                        <td>
                            <a href="ControladorProveedor?action=editar&idproveedor=<%= proveedor.getIdproveedor() %>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="ControladorProveedor?action=eliminar&idproveedor=<%= proveedor.getIdproveedor() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de eliminar este proveedor?');">Eliminar</a>
                        </td>
                    </tr>
                    <% 
                        }
                    } else { 
                    %>
                    <tr>
                        <td colspan="7" class="text-center text-muted">No hay proveedores registrados</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
