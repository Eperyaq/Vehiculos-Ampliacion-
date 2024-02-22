class Automovil(
    nombre: String,
    marca:String,
    modelo:String,
    capacidadCombustible: Float,
    combustibleActual:Float,
    kilometrosActuales:Float,
    var esHibrido: Boolean)
    : Vehiculo( nombre, marca,  modelo, capacidadCombustible, combustibleActual,  kilometrosActuales) {

        //poner un companion object con la condicionbritanica y cambiar la condicion
        companion object {
            const val KM_POR_LITRO_HIBRIDO = 15f //Cada L recorre 15 km
            //kmporlitro si hibrido

            var condicionBritanica: Boolean = false
            fun cambiarCondicionBritanica(nuevaCondicion : Boolean) {
                condicionBritanica = nuevaCondicion
            }

            fun cambiarCondicionBritanica() {
                condicionBritanica = !condicionBritanica
            }
        }
    override fun calcularAutonomia(): Float {
        if (esHibrido == true){
            return combustibleActual * KM_POR_LITRO_HIBRIDO // Cada litro por 5km si es electrico o 15??
        } else {
            return super.calcularAutonomia()
        }
    }

    override fun actualizarCombustible(distancia: Float) {
        if (esHibrido == true){
            combustibleActual -= distancia / KM_POR_LITRO_HIBRIDO
        }
        else {
            super.actualizarCombustible(distancia)
        }
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