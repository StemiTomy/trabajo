from django.urls import path
from . import views

urlpatterns = [
    path('', views.blog, name = "Blog"),
    path('categoria/<int:categoria_id>/', views.categoria, name = "Categoria"), # categoria_id hace referencia al id en models de la categoria
]