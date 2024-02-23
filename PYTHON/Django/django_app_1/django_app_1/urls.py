"""
URL configuration for django_app_1 project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django_app_1.views import saludo, dame_fecha, calcula_edad, saludo_plantilla_contexto, curso_c, curso_css

urlpatterns = [
    path('admin/', admin.site.urls),
    path('saludo/', saludo),
    path('fecha_actual/', dame_fecha),
    path('edades/<int:edad>/<int:year>', calcula_edad), # por defecto los params se pasan como str, para que sea un int hay que decirselo
    path('saludo_plantilla/', saludo_plantilla_contexto), # cargando primera plantilla
    path('curso_c/', curso_c), # cargando primera plantilla con herencia
    path('curso_css/', curso_css),
]
