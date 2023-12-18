enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int = 60,
    val nivel: Nivel = Nivel.BASICO
)

data class Formacao(val nome: String, var conteudos: Map<String, ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun printarMaterias() {
        println("\nMatérias da formação $nome:")
        for ((materia, conteudo) in conteudos) {
            println("$materia - Nível: ${conteudo.nivel}")
        }
    }
}

fun main() {
    val engehariaDeSoftware = mapOf(
        "Banco de Dados" to ConteudoEducacional("Banco de Dados", 45, Nivel.INTERMEDIARIO),
        "Lógica de Programação" to ConteudoEducacional("Lógica de Programação", 75, Nivel.BASICO),
        "Programação Mobile" to ConteudoEducacional("Programação Mobile", 50, Nivel.DIFICIL)
    )

    val musica = mapOf(
        "Teoria Musical" to ConteudoEducacional("Teoria Musical", 85, Nivel.BASICO),
        "Violão" to ConteudoEducacional("Violão", 35, Nivel.INTERMEDIARIO),
        "Composição" to ConteudoEducacional("Composição", 50, Nivel.DIFICIL)
    )

    val nutricao = mapOf(
        "Saúde" to ConteudoEducacional("Saude", 50, Nivel.INTERMEDIARIO),
        "Fisiologia" to ConteudoEducacional("Fisiologia", 60, Nivel.INTERMEDIARIO),
        "Biologia" to ConteudoEducacional("Biologia", 55, Nivel.DIFICIL)
    )

    val formacaoEngenhariaSoftware = Formacao("Engenharia de Software", engehariaDeSoftware)
    val formacaoMusica = Formacao("Musica", musica)
    val formacaoNutricao = Formacao("Nutrição", nutricao)

    val usuario1 = Usuario("Vinicius")
    val usuario2 = Usuario("Hugo")
    val usuario3 = Usuario("Ana")

    formacaoEngenhariaSoftware.matricular(usuario1)
    formacaoMusica.matricular(usuario2)
    formacaoNutricao.matricular(usuario3)

    // Printar matérias de cada formação
    formacaoEngenhariaSoftware.printarMaterias()
    formacaoMusica.printarMaterias()
    formacaoNutricao.printarMaterias()
}
