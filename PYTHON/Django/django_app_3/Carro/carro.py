
class Carro:
    def __init__(self, request):
        self.request = request
        self.session = request.session
        self.carro = self.session.get("carro", {})  # Inicializar carro como un diccionario vacío si no existe
        self.guardar_carro()  # Guardar el carro después de inicializarlo
    
    def agregar(self, producto):
        if (str(producto.id) not in self.carro.keys()):
            self.carro[producto.id] = {
                "producto_id": producto.id,
                "nombre": producto.nombre,
                "precio": str(producto.precio),
                "cantidad": 1,
                "imagen": producto.imagen.url
            }
        else:
            for key, value in self.carro.items():
                if key == str(producto.id):
                    value["cantidad"] += 1
                    break
        self.guardar_carro()
        
    def guardar_carro(self):
        self.session["carro"] = self.carro
        self.session.modified = True
        
    def eliminiar(self, producto):
        producto.id = str(producto.id)
        if producto.id in self.carro:
            del self.carro[producto.id]
            self.guardar_carro()
            
    def restar_producto(self, producto):
        for key, value in self.carro.items():
                if key == str(producto.id):
                    value["cantidad"] -= 1
                    if value["cantidad"]<1:
                        self.eliminiar(producto)
                    break
        self.guardar_carro()
    
    def limpiar_carro(self):
        self.carro = {}
        self.session.modified=True