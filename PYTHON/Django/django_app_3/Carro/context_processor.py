def importe_total_carro(request):
    carro = request.session.get("carro", {})  # Usar get() con un valor por defecto evita KeyError
    total = 0
    for key, value in carro.items():
        precio = float(value['precio'])  # Convertir el precio a flotante
        cantidad = int(value['cantidad'])  # Convertir la cantidad a entero
        total += precio * cantidad
    return {"importe_total_carro": total}