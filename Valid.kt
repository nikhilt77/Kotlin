fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty() || s[0].isDigit()) return false

    fun isValidCharacter(ch: Char): Boolean {
        return ch == '_' || ch.isLetterOrDigit() || ch in 'a'..'z' || ch in 'A'..'Z'
    }

    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}

fun isValidIdentifierWithCustomRules(
    s: String, 
    additionalRules: (Char) -> Boolean = { true }
): Boolean {
    if (s.isEmpty() || s[0].isDigit()) return false

    fun isValidCharacter(ch: Char): Boolean {
        return ch == '_' || ch.isLetterOrDigit() || additionalRules(ch)
    }

    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   
    println(isValidIdentifier("_name"))  
    println(isValidIdentifier("_12"))    
    println(isValidIdentifier(""))       
    println(isValidIdentifier("012"))    
    println(isValidIdentifier("no$"))    

    val additionalRules: (Char) -> Boolean = { ch -> ch in "!@#$%^&*()[]{}" }
    println(isValidIdentifierWithCustomRules("name"))              
    println(isValidIdentifierWithCustomRules("_name"))             
    println(isValidIdentifierWithCustomRules("_12"))               
    println(isValidIdentifierWithCustomRules(""))                  
    println(isValidIdentifierWithCustomRules("012"))               
    println(isValidIdentifierWithCustomRules("no$"))               
    println(isValidIdentifierWithCustomRules("name!"))             
    println(isValidIdentifierWithCustomRules("valid_identifier!")) 
}
