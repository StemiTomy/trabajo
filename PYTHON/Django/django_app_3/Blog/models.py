from django.db import models
from django.contrib.auth.models import User # importamos el usuario

# Create your models here.
class Categoria(models.Model):
    nombre = models.CharField(max_length = 50)
    created = models.DateTimeField(auto_now_add = True)
    updated = models.DateTimeField(auto_now_add = True)
    
    class Meta:
        verbose_name = 'Categoria'
        verbose_name_plural = 'Categorias'
    
    def __str__(self):
        return self.nombre
    
class Post(models.Model):
    titulo = models.CharField(max_length = 50)
    contenido = models.CharField(max_length = 50)
    imagen = models.ImageField(upload_to = 'Blog', null = True, blank = True) # algo opcional
    autor = models.ForeignKey(User, on_delete = models.CASCADE)# si un autor se va, todos se van con el, 1 a M
    categorias = models.ManyToManyField(Categoria) # realacion M a M, un post puede estar en varias categorias y viceversa
    created = models.DateTimeField(auto_now_add = True)
    updated = models.DateTimeField(auto_now_add = True)
    
    class Meta:
        verbose_name = 'Post'
        verbose_name_plural = 'Posts'
    
    def __str__(self):
        return self.titulo