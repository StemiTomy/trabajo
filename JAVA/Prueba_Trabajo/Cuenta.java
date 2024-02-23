package JAVA.Prueba_Trabajo;

class Cuenta {
    private String titular;
    private double cantidad = 0;

    public Cuenta(String titular) {
        this.titular = titular;
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.setCantidad(cantidad + this.getCantidad());
        }
    }

    public void retirar(double cantidad) {
        if (this.getCantidad() - cantidad < 0) {
            this.setCantidad(0);
        } else {
            this.setCantidad(cantidad - this.getCantidad());
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta [titular = " + titular + ", cantidad = " + cantidad + "]";
    }

    public static void main(String args[]) {
        Cuenta cuenta1 = new Cuenta("Pepe");
        Cuenta cuenta2 = new Cuenta("Pepito", 2.0);

        System.out.println(cuenta1.toString());

        cuenta2.ingresar(2);
        // 4.0
        System.out.println(cuenta2.getCantidad());

        cuenta2.retirar(60);
        // -2.0
        System.out.println(cuenta2.getCantidad());
    }
}