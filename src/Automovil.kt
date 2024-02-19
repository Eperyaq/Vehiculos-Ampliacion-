class Automovil(
    marca:String,
    modelo:String,
    capacidadCombustible: Double,
    combustibleActual:Double,
    kilometrosActuales:Int,
    var esElectrico: Boolean,
    var condicionBritanica: Boolean)
    : Vehiculo( marca,  modelo, capacidadCombustible, combustibleActual,  kilometrosActuales) {

    override fun calcularAutonomia(): Int {
        if (esElectrico == true){
            var recorrer2 = combustibleActual * 5 // Cada litro por 5km si es electrico
            return recorrer2.toInt()
        }else{
            return super.calcularAutonomia()
        }
    }

    fun cambiarCondicionBritanica(nuevaCondicion : Boolean){
        esElectrico = nuevaCondicion
    }

    fun realizarDerrape():Double{
        var derrapar = combustibleActual - (combustibleActual *5)
        return derrapar
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Electrico: $esElectrico, Condicion Britancia : $condicionBritanica"
    }
}