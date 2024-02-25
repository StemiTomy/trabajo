from django.shortcuts import render, redirect
from .forms import FormularioContacto
from django.http import HttpResponseRedirect
from django.core.mail import EmailMessage

# Create your views here.
def contacto(request):
    form = FormularioContacto(request.POST)
    
    if request.method == "POST":
        formset = FormularioContacto(data = request.POST)
        # check whether it's valid:
        if form.is_valid():
            nombre = request.POST.get("nombre")
            email = request.POST.get("email")
            contenido = request.POST.get("contenido")
            # process the data in form.cleaned_data as required
            nombre2 = form.cleaned_data.get("nombre")
            
            email = EmailMessage("Mensaje desde App Django", "El usuario con nombre {} con la dirección {} escribe lo siguiente:\n\n{}".format(nombre, email, contenido),
                                 "", ["estemitomy@gmail.com"], reply_to = [email])
            
            try:
                email.send()
                # return redirect("/contacto/?valido")
            except:
                # return redirect("/contacto/?invalido")
                pass
            # ...
            # redirect to a new URL:
        # if a GET (or any other method) we'll create a blank form
        else:
            form = FormularioContacto()
    return render(request, "Contacto/contacto.html", {"form": form})