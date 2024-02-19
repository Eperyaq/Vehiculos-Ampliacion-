fun main() {
    var pepino = Vehiculo("Seat","Ibiza",12.3, 10.0, 144)
    println(pepino.realizaViaje(50)) // Si sale negativo es porque falta combustible para realizar el viaje completp

    println(pepino.repostar(6.40))
}