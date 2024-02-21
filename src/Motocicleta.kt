class Motocicleta(marca:String,
                  modelo:String,
                  capacidadCombustible: Double,
                  combustibleActual:Double,
                  kilometrosActuales:Double,
                  val cilindrada: Int):Vehiculo(marca, modelo,capacidadCombustible,combustibleActual,kilometrosActuales) {

    override fun calcularAutonomia(): Double {
        var recorrer2 = combustibleActual * 20
        return recorrer2
    }

    override fun realizaViaje(distancia: Double): Double {
        if (cilindrada == 1000){
            var viaje =  (combustibleActual * 20) - distancia // son los kilometros que puede hacer
            return viaje
        }else if (cilindrada == 500){
            var viaje =  (combustibleActual * 19.5) - distancia // son los kilometros que puede hacer
            return viaje
        }else if (cilindrada == 125){
            var viaje =  (combustibleActual * 19.125) - distancia // son los kilometros que puede hacer
            return viaje
        }
        //este error me ralla, entiendo que me falta un return para el body de la funcion pero tengo 3 en los if que pongo en el return de fuera??
    }

    fun realizaCaballito():Double{
        var caballito = combustibleActual - (combustibleActual *6.5)
        return caballito
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales, Cilindrada:$cilindrada"
    }
}