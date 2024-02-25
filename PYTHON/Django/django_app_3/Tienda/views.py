from django.shortcuts import render
from Tienda.models import CategoriaProd, Producto

# Create your views here.
def tienda(request):
    productos = (Producto.objects.all())
    return render(request, "Tienda/tienda.html", {"productos": productos})

def categoria(request, categoria_id):
    categoria = (CategoriaProd.objects.get(id = categoria_id))
    productos = (Producto.objects.filter(categorias = categoria))
    return render(request, "Tienda/categorias.html", {"categoria": categoria, "productos": productos})