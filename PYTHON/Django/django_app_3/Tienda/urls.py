from django.urls import path
from Tienda import views

urlpatterns = [
    path('tienda/', views.tienda, name="Tienda"),
]