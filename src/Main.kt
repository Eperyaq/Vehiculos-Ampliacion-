fun main() {
    var pepino = Vehiculo("Seat","Ibiza",12.3, 10.0, 144.0)
    println(pepino.obtenerInformacion())
    println(pepino.realizaViaje(101.0)) // Si sale negativo es porque falta combustible para realizar el viaje completp



    /*
    var coche = Automovil("Cupra","Formentor",10.0,10.0,100,false, false)
    println(coche)
    println(coche.realizarDerrape())
    println(coche.cambiarCondicionBritanica(true))
    println(coche)

    var moto = Motocicleta("BMW","SI",5.0,1.0,2000,125)
    println(moto)
    println(moto.realizaCaballito())
    println(moto.calcularAutonomia())
    println(moto.repostar(200.0))

     */
}