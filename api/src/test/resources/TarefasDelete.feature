#language: pt
Funcionalidade:

  @TarefasDelete
  Esquema do Cenário: Verificar se o endpoint TarefasDelete realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint TarefasDelete
    Quando realizarmos a chamada do endpoint TarefasDelete com "<id_tarefa>"
    Entao o resultado da chamada sera <status> do endpoint TarefasDelete
    E o retorno sera "<resposta>" do endpoint TarefasDelete

    Exemplos:
      | id_tarefa | status | resposta |
      |     4     |   200  |    ok    |
      | 67891626  |   404  | notFound |
      |    teste  |   400  |BadRequest|


