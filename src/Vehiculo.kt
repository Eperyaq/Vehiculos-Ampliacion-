

open class Vehiculo(val marca:String, val modelo:String, val capacidadCombustible: Double, val combustibleActual:Double, val kilometrosActuales:Double) {

    /*
    * Obtienes los km que se pueden recorrer con los litros de gasolina que tienes
    *
    **/
    fun obtenerInformacion():String{
         var recorrer = combustibleActual *10 //Cada L recorre 10 km
        return "Con $combustibleActual L de combustible se pueden recorrer %.2f".format(recorrer)
    }

    /**
     * Calcula la autonomia del vehiculo
     */
    open fun calcularAutonomia(): Double{
         var recorrer2 = combustibleActual * 10
         return recorrer2
     }

    /*
    * Realiza un viaje y resta gasolina, si sale negativo son los km que le faltan para llegar al destino
    * problemitass
    **/
    open fun realizaViaje(distancia:Double): Double{
        var viaje = 0.0
        while (distancia > combustibleActual){
             viaje =  (combustibleActual * 10) - distancia // son los kilometros que puede hacer
            if (distancia > viaje){
                repostar(12.0) // Se queda en un bucle infinito, porque no se cambia el valor de combustible actual??

            }
        }
        return viaje
    }
/*
* Echas gasolina
*
* @Params Cantidad- Double -> Cantidad a repostar
*
* @Return echargasolina- Float -> Gasolina echada si es mayor que la capacidad queda al tope, si no, se suma al combustible actual
* */
    fun repostar(cantidad:Double):Double{

        if (cantidad > capacidadCombustible){
            var echargasolina= capacidadCombustible
            return  echargasolina
        }else if(cantidad <= 0){
            var echargasolina= capacidadCombustible
            return  echargasolina
        } else{
            var echargasolina = cantidad + combustibleActual
            return echargasolina // o cantidad? porque dice que devuelve la cantidad respostada es decir lo que ha metido, la variable cantidad
        }
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales"
    }


}