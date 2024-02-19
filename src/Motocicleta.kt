class Motocicleta(marca:String,
                  modelo:String,
                  capacidadCombustible: Double,
                  combustibleActual:Double,
                  kilometrosActuales:Int,
                  val cilindrada: Int):Vehiculo(marca, modelo,capacidadCombustible,combustibleActual,kilometrosActuales) {

    override fun calcularAutonomia(): Int {
        var recorrer2 = combustibleActual * 20
        return recorrer2.toInt()
    }

    override fun realizaViaje(distancia: Int): Int {
        var viaje =  (combustibleActual * 20) - distancia // son los kilometros que puede hacer
        return viaje.toInt()
    }

    fun realizaCaballito():Double{
        var caballito = combustibleActual - (combustibleActual *5)
        return caballito
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Cilindrada:$cilindrada"
    }
}