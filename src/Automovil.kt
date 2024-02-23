class Automovil(
    nombre: String,
    marca:String,
    modelo:String,
    capacidadCombustible: Float,
    combustibleActual:Float,
    kilometrosActuales:Float,
    var esHibrido: Boolean)
    : Vehiculo( nombre, marca,  modelo, capacidadCombustible, combustibleActual,  kilometrosActuales) {

        companion object {
            const val KM_POR_LITRO_HIBRIDO = 15f //Cada L recorre 15 km si es hibrido

            var condicionBritanica: Boolean = false
            fun cambiarCondicionBritanica(nuevaCondicion : Boolean) {
                condicionBritanica = nuevaCondicion
            }

            fun cambiarCondicionBritanica() { // condicion britanica si no le dan parametro
                condicionBritanica = !condicionBritanica
            }
        }

    /**
     * Calcula la autonomia del vehiculo
     * Si es híbrido consume mas que si es gasolina
     */
    override fun calcularAutonomia(): Float {
        if (esHibrido == true){
            return combustibleActual * KM_POR_LITRO_HIBRIDO
        } else {
            return super.calcularAutonomia()
        }
    }

    override fun actualizarCombustible(distancia: Float) { // porque cuando uso el debugger en estas funciones me mira el padre? para mirar el override?? o porque me esta cogiendo datos de la funcion padre?
        if (esHibrido == true){
            combustibleActual -= distancia / KM_POR_LITRO_HIBRIDO
        }
        else {
            super.actualizarCombustible(distancia)
        }
    }


    //sobreescribir el realizar viaje para el combustible por si es hibrido
    override fun realizaViaje(distancia: Float): Float {
        if (esHibrido == true) {
            val distanciaARecorrer = minOf(calcularAutonomia(), distancia)

            actualizarCombustible(distanciaARecorrer)

            return distancia - distanciaARecorrer // esto esta mal, siempre va a ser 0        }else {

        }else{
            return super.realizaViaje(distancia)
        }
    }

    /**
     * Realzia un derrape y gasta combustible dependiendo el tipo de coche que sea
     * */
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