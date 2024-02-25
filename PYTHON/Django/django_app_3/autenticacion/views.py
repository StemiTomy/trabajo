from django.shortcuts import render, redirect
from django.urls import reverse_lazy
from django.views.generic import View
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import login
from django.contrib import messages

# Create your views here.
class VRegitro(View):
    def get(self, request):
        form = UserCreationForm()
        return render(request, "registro/registro.html", {"form":form})
    
    def post(self, request):
        form = UserCreationForm(request.POST) # ususario y password que viene desde el form
        if form.is_valid():
            usuario = form.save() # guardamos la información aquí, esto hace que se guarde automáticamente en la tabla auth_user
            # ahora queremos hacer un login
            login(request, usuario)
            return redirect(reverse_lazy('Home'))
        else:
            for msg in form.error_messages:
                messages.error(request, form.error_messages[msg])
            return render(request, "registro/registro.html", {"form": form})