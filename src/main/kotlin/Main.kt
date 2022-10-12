import java.util.Scanner

fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)

    // création de l'entreprise
    var company = createCompany(reader)

    // affichage du menu
    menu(reader, company)

}

