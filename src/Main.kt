fun main() {
    val contactos = mutableListOf<Contacto>()
    val maxContactos = 4
    while (true) {
        println("\nMenú:")
        println("1. Añadir contacto")
        println("2. Listar contactos")
        println("3. Buscar contacto")
        println("4. Existe contacto")
        println("5. Eliminar contacto")
        println("6. Contacto disponible")
        println("7. Agenda llena")
        println("8. Salir")
        print("Escribe una de las opciones")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                if (contactos.size >= maxContactos) {
                    println("La agenda está llena. No se pueden añadir más contactos.")
                } else {
                    print("Introduce el nombre: ")
                    val nombre = readLine() ?: ""
                    if (contactos.any { it.nombre == nombre }) {
                        println("El contacto con ese nombre ya existe en la agenda.")
                    } else {
                        print("Introduce el teléfono: ")
                        val telefono = readLine() ?: ""
                        contactos.add(Contacto(nombre, telefono))
                        println("Contacto añadido.")
                    }
                }
            }

            2 -> {
                if (contactos.isEmpty()) {
                    println("La agenda está vacía.")
                } else {
                    println("Contactos en la agenda:")
                    contactos.forEach { println("Nombre: ${it.nombre}, Teléfono: ${it.telefono}") }
                }
            }

            3 -> {
                print("Introduce el nombre a buscar: ")
                val nombre = readLine() ?: ""
                val contacto = contactos.find { it.nombre == nombre }
                if (contacto != null) {
                    println("Teléfono de $nombre: ${contacto.telefono}")
                } else {
                    println("No se encontró un contacto con el nombre $nombre.")
                }
            }

            4 -> {
                print("Introduce el nombre a comprobar: ")
                val nombre = readLine() ?: ""
                if (contactos.any { it.nombre == nombre }) {
                    println("El contacto $nombre existe en la agenda.")
                } else {
                    println("El contacto $nombre no existe en la agenda.")
                }
            }

            5 -> {
                print("Introduce el nombre del contacto a eliminar: ")
                val nombre = readLine() ?: ""
                if (contactos.removeIf { it.nombre == nombre }) {
                    println("El contacto $nombre ha sido eliminado.")
                } else {
                    println("No se encontró un contacto con el nombre $nombre.")
                }
            }

            6 -> {
                val libres = maxContactos - contactos.size
                println("Huecos libres en la agenda: $libres")
            }

            7 -> {
                if (contactos.size >= maxContactos) {
                    println("La agenda está llena.")
                } else {
                    println("La agenda no está llena.")
                }
            }

            8 -> {
                println("Saliendo del programa...")
                break
            }

            else -> {
                println("Opción no válida. Por favor, selecciona una opción del 1 al 8.")
            }
        }
    }
}

data class Contacto(val nombre: String, val telefono: String)
