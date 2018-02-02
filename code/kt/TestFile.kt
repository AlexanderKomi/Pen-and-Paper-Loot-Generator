@file: JvmName("TestFile")
@file:JvmMultifileClass

package kt

// Reference : https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html

object testingObject {
    const val constant = "Constant String"
}


class TestFile {


    fun printStuff(message: String) {
        println(message)
    }

}
