#language: pt
Funcionalidade:

  @SubtarefasPut
  Esquema do Cenário: Verificar se o endpoint SubtarefasPut realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint SubtarefasPut
    Quando preenchermos o body "<body>" do endpoint SubtarefasPut
    E realizarmos a chamada do endpoint SubtarefasPut com "<id_subtarefa>"
    Entao o resultado da chamada sera <status> do endpoint SubtarefasPut
    E o retorno sera "<resposta>" do endpoint SubtarefasPut

    Exemplos:
      | id_subtarefa |  body   | status | resposta |
      |      2       |  valido |   200  |    ok    |
      |      2       | tipoDif |   400  |badRequest|
      |      2       | limites |   400  |badRequest|
      |      2       |   obg   |   200  |    ok    |
      |      2       |  vazio  |   400  |badRequest|
      |      2       |  nulo   |   400  |badRequest|
      |      teste   |  valido |   400  |badRequest|
      |  12345162783 |  valido |   404  | notFound |

