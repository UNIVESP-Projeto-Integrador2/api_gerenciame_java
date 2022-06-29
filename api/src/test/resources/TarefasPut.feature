#language: pt
Funcionalidade:

  @TarefasPut
  Esquema do Cenário: Verificar se o endpoint TarefasPut realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint TarefasPut
    Quando preenchermos o body "<body>" do endpoint TarefasPut
    E realizarmos a chamada do endpoint TarefasPut com "<id_tarefa>"
    Entao o resultado da chamada sera <status> do endpoint TarefasPut
    E o retorno sera "<resposta>" do endpoint TarefasPut

    Exemplos:
      |  id_tarefa |  body   | status | resposta |
      |    2       |  valido |   200  |    ok    |
      |    2       | tipoDif |   400  |badRequest|
      |    2       | limites |   400  |badRequest|
      |    2       |   obg   |   200  |    ok    |
      |    2       |  vazio  |   400  |badRequest|
      |    2       |  nulo   |   400  |badRequest|
      |  12345654  |  valido |   404  | notFound |

