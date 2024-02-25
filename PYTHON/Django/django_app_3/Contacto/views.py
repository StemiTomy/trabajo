from django.shortcuts import render
from .forms import FormularioContacto
from django.http import HttpResponseRedirect

# Create your views here.
def contacto(request):
    form = FormularioContacto(request.POST)
    # check whether it's valid:
    if form.is_valid():
        # process the data in form.cleaned_data as required
        # ...
        # redirect to a new URL:
        return HttpResponseRedirect("/thanks/")
     # if a GET (or any other method) we'll create a blank form
    else:
        form = FormularioContacto()
    return render(request, "Contacto/contacto.html", {"form": form})