class Automovil(
    marca:String,
    modelo:String,
    capacidadCombustible: Float,
    combustibleActual:Float,
    kilometrosActuales:Float,
    var esHibrido: Boolean,
    var condicionBritanica: Boolean)
    : Vehiculo( marca,  modelo, capacidadCombustible, combustibleActual,  kilometrosActuales) {

        //poner un companion object con la condicionbritanica y cambiar la condicion
        companion object {
            const val KM_POR_LITRO = 10f //Cada L recorre 10 km
            //kmporlitro si hibrido
        }
    override fun calcularAutonomia(): Float {
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
    //sobreescribir el realizar viaje para el combustible por si es hibrido
    fun realizarDerrape():Float{
        if (esHibrido == true){ // si es hibrido consume 6.25km
            var derrapar = combustibleActual - (combustibleActual * 6.25F)
            return derrapar
        }else { //si no es hibrido consume 7.5km
            var derrapar = combustibleActual - (combustibleActual * 7.5F)
            return derrapar
        }
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Hibrido: $esHibrido, Condicion Britancia : $condicionBritanica"
    }
}