from django.db import models

# Create your models here.
class Clientes(models.Model):
    nombre = models.CharField(max_length=30)
    direccion = models.CharField(max_length=50, verbose_name="La dirección")
    email = models.EmailField(blank=True, null=True) # ya tiene la validación
    tfno = models.CharField(max_length=9)
    
    def __str__(self) -> str:
        return self.nombre
    
class Articulos(models.Model):
    nombre = models.CharField(max_length=30)
    seccion = models.CharField(max_length=20)
    precio = models.IntegerField()
    
    def __str__(self) -> str:
        return "El nombre es %s, la sección es %s y el precio es %s" %(self.nombre, self.seccion, self.precio)

class Pedidos(models.Model):
    numero = models.IntegerField()
    fecha = models.DateField()
    entregado = models.BooleanField()