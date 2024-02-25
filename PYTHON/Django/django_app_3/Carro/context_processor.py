def importe_total_carro(request):
    carro = request.session.get("carro", {})  # Usar get() con un valor por defecto evita KeyError
    total = 0
    for key, value in carro.items():
        total += value
    return {"importe_total_carro": total}