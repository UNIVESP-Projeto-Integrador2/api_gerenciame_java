#language: pt
Funcionalidade:

  @TarefasGet
  Cenário: Verificar se o endpoint TarefasGet realiza  a chamada e traz o retorno conforme esperado
    Dado que estamos realizando uma chamada para o endpoint TarefasGet
    Quando realizarmos a chamada do endpoint TarefasGet
    Entao o resultado da chamada sera 200 do endpoint TarefasGet
    E o retorno sera ok do endpoint TarefasGet

