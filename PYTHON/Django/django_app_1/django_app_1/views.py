from django.http import HttpResponse
from django.template import Template, Context
import datetime
#from django.template import loader
#from django.template.loader import get_template # lo mismo que arriba pero más específico todavía
from django.shortcuts import render # mejor que el de arriba!


class Persona(object):
    def __init__(self, nombre, apellido) -> None:
        self.nombre = nombre
        self.apellido = apellido


def saludo(request):  # primera vista
    return HttpResponse("Hola mundo")


def dame_fecha(request):  # contenido dinámico
    fecha_actual = datetime.datetime.now()
    documento = (
        """
    <html>
    <body>
    <h1>Fecha y hora actual: %s</h1>
    </body>
    </html>
    """
        % fecha_actual
    )
    return HttpResponse(documento)


def calcula_edad(request, edad, year):
    periodo = year - 2024
    edad_futura = edad + periodo
    documento = """
    <html>
    <body>
    <h1>En el año %s, tendrás %s años</h1>
    </body>
    </html>
    """ % (
        year,
        edad_futura,
    )
    return HttpResponse(documento)


# hasta aqui no eran la forma correcta de usar plantillas, hay que separar la parte lógica de la parte de diseño
"""
def saludo_plantilla(request):  # primera plantilla
    documento_externo = open(
        "./django_app_1/plantillas/primeraplantilla.html"
    )  # lo suyo es usar cargadores, pero aqui lo hacemos de forma manual
    template = Template(documento_externo.read())
    documento_externo.close()
    contexto = Context()
    documento = template.render(contexto)
    return HttpResponse(documento)
"""

def saludo_plantilla_contexto(request):
    nombre = " Profesor Juan"
    apellido = "Pérez"
    p1 = Persona(nombre, apellido)
    fecha_actual = datetime.datetime.now()
    temas = ["Plantillas", "Modelos", "Formularios", "Vistas", "Despliegue"]
    
    # 1.º Manera
    # documento_externo = open("./django_app_1/plantillas/primeraplantilla.html")  # lo suyo es usar cargadores, pero aqui lo hacemos de forma manual
    # template = Template(documento_externo.read())
    # documento_externo.close()
    #contexto = Context({"nombre_persona": p1.nombre,"apllido_persona": p1.apellido,"fecha_actual": fecha_actual,"temas": temas,})
    
    # 2.º Manera
    # documento_externo = loader.get_template('primeraplantilla.html') # ya no se usa loader sino la función directo
    # documento_externo = get_template('primeraplantilla.html')
    # documento = documento_externo.render({"nombre_persona": p1.nombre,"apllido_persona": p1.apellido,"fecha_actual": fecha_actual,"temas": temas,})
    
    
    # antigua manera 2 y 3
    # return HttpResponse(documento)
    
    # 3.º Manera
    return render(request, 'primeraplantilla.html', {"nombre_persona": p1.nombre,"apllido_persona": p1.apellido,"fecha_actual": fecha_actual,"temas": temas,})

def curso_c(request):
    fecha_actual = datetime.datetime.now()
    return render(request, 'CursoC.html', {"dame_fecha": fecha_actual})

def curso_css(request):
    fecha_actual = datetime.datetime.now()
    return render(request, 'CursoCss.html', {"dame_fecha": fecha_actual})