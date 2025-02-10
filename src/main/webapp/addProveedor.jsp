<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Proveedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <style>
        body {
            background: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container mt-5 d-flex justify-content-center">
        <div class="form-container">
            <h2 class="text-center text-primary mb-4">Agregar Proveedor</h2>
            <form action="ControladorProveedor" method="post">
                <input type="hidden" name="action" value="registrar">
                <div class="mb-3">
                    <label for="nomproveedor" class="form-label">Nombre del Proveedor</label>
                    <input type="text" class="form-control" id="nomproveedor" name="nomproveedor" required>
                </div>
                <div class="mb-3">
                    <label for="rucproveedor" class="form-label">RUC</label>
                    <input type="text" class="form-control" id="rucproveedor" name="rucproveedor" required>
                </div>
                <div class="mb-3">
                    <label for="rsocialproveedor" class="form-label">Razón Social</label>
                    <input type="text" class="form-control" id="rsocialproveedor" name="rsocialproveedor" required>
                </div>
                <div class="mb-3">
                    <label for="emailproveedor" class="form-label">Email</label>
                    <input type="email" class="form-control" id="emailproveedor" name="emailproveedor" required>
                </div>
                <div class="mb-3">
                    <label for="feingproveedor" class="form-label">Fecha de Ingreso</label>
                    <input type="text" class="form-control" id="feingproveedor" name="feingproveedor" required>
                </div>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">Registrar</button>
                    <a href="ControladorProveedor" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
    <script>
        flatpickr("#feingproveedor", {
            dateFormat: "Y-m-d",
            locale: "es",
            allowInput: true
        });
    </script>
</body>
</html>