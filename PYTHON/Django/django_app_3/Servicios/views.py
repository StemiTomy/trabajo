from django.shortcuts import render
from Servicios.models import Servicio

# Create your views here.
def servicios(request):
    servicios = (
        Servicio.objects.all()
    )  # importa todos los objetos que tengo dentro de la clase Servicio
    return render(request, "servicios/servicios.html", {"servicios": servicios})