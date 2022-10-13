import java.util.Scanner

fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)

    // création de l'entreprise
    val company = createCompany(reader)

    // affichage du menu
    menu(reader, company)

}

