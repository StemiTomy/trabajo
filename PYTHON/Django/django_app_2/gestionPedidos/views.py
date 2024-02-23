from django.shortcuts import render
from django.http import HttpResponse
from django_app_2 import settings
from django.core.mail import send_mail
from gestionPedidos.models import Articulos
from gestionPedidos.forms import FromularioContacto

# Create your views here.
def busqueda_productos(request):
    return render(request, "busqueda_productos.html")

def buscar(request):
    if request.GET["producto"]:
        #mensaje = "Artículo buscado: %r" % request.GET["producto"] # es el name del input del form
        nombre_producto = request.GET["producto"]
        if len(nombre_producto)>20:
            mensaje = "Texto de búsqueda demasiado largo."
        else:
            articulos = Articulos.objects.filter(nombre__icontains = nombre_producto) # __icontains es el método equivalente a LIKE
            return render(request, "resultados_busqueda.html", {"articulos":articulos, "query":nombre_producto})
    mensaje = "No has introducido nada."
    return HttpResponse(mensaje)

def contacto(request):
    if request.method == "POST":
        subject = request.POST["asunto"] # los "strings" son los "name" en el form de contacto.html
        message = request.POST["mensaje"] + " " + request.POST["email"]
        
        email_form = settings.EMAIL_HOST_USER # quien lo envia
        recipient_list = ["stemitomy@gmail.com"] # a donde llega
        
        send_mail(subject, message, email_form, recipient_list)
        
        return render(request, "gracias.html")
    
    return render(request, "contacto.html")

def contactoForms(request):
    if request.method == "POST":
        mi_formulario = FromularioContacto(request.POST)
        if mi_formulario.is_valid():
            inf_form = mi_formulario.cleaned_data
            recipient_list = ["stemitomy@gmail.com"] # a donde llega
            send_mail(inf_form["asunto"], inf_form["mensaje"], inf_form.get("email",settings.EMAIL_HOST_USER), recipient_list)
            
            return render(request, "gracias.html")
    else:
        mi_formulario = FromularioContacto()
    return render(request, "formulario_contacto.html", {"form":mi_formulario})