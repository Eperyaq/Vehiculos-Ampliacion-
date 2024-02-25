class Motocicleta(nombre:String,
                  marca:String,
                  modelo:String,
                  capacidadCombustible: Float,
                  combustibleActual:Float,
                  kilometrosActuales:Float,
                  cilindrada:Int):Vehiculo(nombre,marca, modelo,capacidadCombustible,combustibleActual,kilometrosActuales) {

    var cilindrada = 0
        set(value) {
            if (value !in 125..1000) {
                println("Error, no puede ser menor que 125 ni mayor que 1000 cilindradas")
                return
            }
            field = value
        }

    companion object{
        const val KM_POR_LITRO_MOTO = 20.0f

    }

    init {
        this.cilindrada = cilindrada // el set y el get creo que esta mal porque me salta el error pero me sigue creando la instancia del objeto
    }
    /**
     * Se calcula la autonomía de la moto
     *
     * @return kilometros que puede realizar con el combustibel actual de la moto*/
    override fun calcularAutonomia(): Float {
        var recorrer2 = combustibleActual * KM_POR_LITRO_MOTO
        return recorrer2
    }
    /**
     * Realiza un viaje en moto adaptado para el gasto de combustible de esta
     *
     * @param distancia:Float Distancia para hacer el viaje
     *
     * @return viaje Kilometros hechos
     */

    override fun realizaViaje(distancia: Float): Float {
        val kilometros = KM_POR_LITRO_MOTO - (cilindrada /1000)

        var viaje =  distancia - (combustibleActual * kilometros) // son los kilometros que puede hacer
        return viaje

    }

    /**
     * Hace el caballito y consume gasolina
     *
     * @return caballito, combustible que le queda despues de haber hecho el caballito*/
    fun realizaCaballito():Float{
        var caballito = combustibleActual - (combustibleActual *6.5f)
        return caballito
    }

    /**
     * Hace el caballito y gasta combustible adaptado para la carrera
     *
     * @return caballito: combustible que le queda despues de haber hecho el caballito*/
    fun realizaCaballito(numeroFiligranas:Int):Float{
        var caballito = combustibleActual - (combustibleActual *6.5f)
        return caballito
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Cilindrada:$cilindrada"
    }
}