#language: pt
Funcionalidade:

  @SubtarefasDelete
  Esquema do Cenário: Verificar se o endpoint SubtarefasDelete realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint SubtarefasDelete
    Quando realizarmos a chamada do endpoint SubtarefasDelete com "<id_subtarefa>"
    Entao o resultado da chamada sera <status> do endpoint SubtarefasDelete
    E o retorno sera "<resposta>" do endpoint SubtarefasDelete

    Exemplos:
      | id_subtarefa | status | resposta |
      |      7       |   200  |    ok    |
      |   67891626   |   404  | notFound |
      |    teste     |   400  |BadRequest|


