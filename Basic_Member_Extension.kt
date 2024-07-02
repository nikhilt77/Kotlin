class A {
    var name: String = "DefaultName"
    var age: Int = 0

    fun foo() = "member"

    fun displayInfo() = "Name: $name, Age: $age"

    fun setInfo(name: String, age: Int) {
        this.name = name
        this.age = age
    }
}

fun A.foo(i: Int) = "extension ($i)"

fun A.greet() = "Hello, my name is $name and I am $age years old."

fun main() {
    val a = A()
    println(a.foo(2))
    println(a.foo())
    println(a.displayInfo())
    a.setInfo("Alice", 25)
    println(a.displayInfo())
    println(a.greet())
}
