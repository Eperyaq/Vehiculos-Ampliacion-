class Automovil(
    marca:String,
    modelo:String,
    capacidadCombustible: Double,
    combustibleActual:Double,
    kilometrosActuales:Double,
    var esHibrido: Boolean,
    var condicionBritanica: Boolean)
    : Vehiculo( marca,  modelo, capacidadCombustible, combustibleActual,  kilometrosActuales) {

    override fun calcularAutonomia(): Double {
        if (esHibrido == true){
            var recorrer2 = combustibleActual * 5 // Cada litro por 5km si es electrico o 15??
            return recorrer2
        }else{
            return super.calcularAutonomia()
        }
    }

    fun cambiarCondicionBritanica(nuevaCondicion : Boolean):Boolean{
        var conduccionBritanica = nuevaCondicion
        return conduccionBritanica // se cambia aqui dentro pero en el toString no
    }

    fun realizarDerrape():Double{
        if (esHibrido == true){ // si es hibrido consume 6.25km
            var derrapar = combustibleActual - (combustibleActual * 6.25)
            return derrapar
        }else { //si no es hibrido consume 7.5km
            var derrapar = combustibleActual - (combustibleActual * 7.5)
            return derrapar
        }
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Hibrido: $esHibrido, Condicion Britancia : $condicionBritanica"
    }
}