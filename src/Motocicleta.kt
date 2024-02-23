class Motocicleta(nombre:String,
                  marca:String,
                  modelo:String,
                  capacidadCombustible: Float,
                  combustibleActual:Float,
                  kilometrosActuales:Float,
                  val cilindrada: Int):Vehiculo(nombre,marca, modelo,capacidadCombustible,combustibleActual,kilometrosActuales) {

    override fun calcularAutonomia(): Float {
        var recorrer2 = combustibleActual * 20
        return recorrer2
    }

    override fun realizaViaje(distancia: Float): Float {
        if (cilindrada == 1000){
            var viaje =  (combustibleActual * 20F) - distancia // son los kilometros que puede hacer
            return viaje
        }else if (cilindrada == 500){
            var viaje =  (combustibleActual * 19.5F) - distancia // son los kilometros que puede hacer
            return viaje
        }else if (cilindrada == 125){
            var viaje =  (combustibleActual * 19.125F) - distancia // son los kilometros que puede hacer
            return viaje
        }

        KM_POR_LITRO - (cilindrada /1000)

        return 0.0f
    }

    fun realizaCaballito():Double{
        var caballito = combustibleActual - (combustibleActual *6.5)
        return caballito
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Cilindrada:$cilindrada"
    }
}