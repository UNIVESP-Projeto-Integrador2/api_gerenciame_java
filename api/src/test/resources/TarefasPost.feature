#language: pt
Funcionalidade:

  @TarefasPost
  Esquema do Cenário: Verificar se o endpoint TarefasPost realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint TarefasPost
    Quando preenchermos o body "<body>" do endpoint TarefasPost
    E realizarmos a chamada do endpoint TarefasPost
    Entao o resultado da chamada sera <status> do endpoint TarefasPost
    E o retorno sera "<resposta>" do endpoint TarefasPost

    Exemplos:
        |  body   | status | resposta |
        |  valido |   201  |    ok    |
        | tipoDif |   400  |badRequest|
        | limites |   400  |badRequest|
        |   obg   |   201  |    ok    |
        |  vazio  |   400  |badRequest|
        |  nulo   |   400  |badRequest|

