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
        this.cilindrada = cilindrada // el set y el get creo que esta mal porque me salta el error pero me sigue creando la isntancia del objeto
    }

    override fun calcularAutonomia(): Float {
        var recorrer2 = combustibleActual * KM_POR_LITRO_MOTO
        return recorrer2
    }

    override fun realizaViaje(distancia: Float): Float {
        val kilometros = KM_POR_LITRO_MOTO - (cilindrada /1000)

        var viaje =  distancia - (combustibleActual * kilometros) // son los kilometros que puede hacer
        return viaje

    }

    fun realizaCaballito():Double{
        var caballito = combustibleActual - (combustibleActual *6.5)
        return caballito
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Cilindrada:$cilindrada"
    }
}