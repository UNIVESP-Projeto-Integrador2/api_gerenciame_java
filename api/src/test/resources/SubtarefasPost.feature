#language: pt
Funcionalidade:

  @SubtarefasPost
  Esquema do Cenário: Verificar se o endpoint SubtarefasPost realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint SubtarefasPost
    Quando preenchermos o body "<body>" do endpoint SubtarefasPost
    E realizarmos a chamada do endpoint SubtarefasPost
    Entao o resultado da chamada sera <status> do endpoint SubtarefasPost
    E o retorno sera "<resposta>" do endpoint SubtarefasPost

    Exemplos:
      |  body   | status | resposta |
      |  valido |   201  |    ok    |
      | tipoDif |   400  |badRequest|
      | limites |   400  |badRequest|
      |   obg   |   201  |    ok    |
      |  vazio  |   400  |badRequest|
      |  nulo   |   400  |badRequest|

