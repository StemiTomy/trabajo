from django.urls import path
from .views import VRegitro

urlpatterns = [
    path('', VRegitro.as_view(), name="Autenticacion"),
]
