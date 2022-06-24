# api_gerenciame_java
Pré requisitos:

1. Instalar o JDK &quot;Java SE Development Kit 8u333&quot; através do link [https://www.oracle.com/java/technologies/downloads/#java8-windows](https://www.oracle.com/java/technologies/downloads/#java8-windows)

- Instruções de instalação e configuração do JDK: [https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749](https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749)

2. Baixar e instalar o Maven 3.8.6 Source zip archive: https://maven.apache.org/download.cgi
3. Baixar e instalar o MySQL Workbench: https://dev.mysql.com/downloads/windows/installer/8.0.html- 
-  Crie uma nova conexão, a ser mencionada em application.properties, presente em api > src > main > resources:
![image](https://user-images.githubusercontent.com/56417970/175749285-d39ba82d-c339-47d4-a766-0e81fa7d6c97.png)
![image](https://user-images.githubusercontent.com/56417970/175749501-80a68055-1f8c-4d73-ad2e-5fd6fc786de0.png)
- Crie uma base com o mesmo nome presente em application.properties, gerenciame_db:
![image](https://user-images.githubusercontent.com/56417970/175749629-ad152b01-b3f6-44e5-8226-a18ab18f8087.png)

4. Baixar e instalar o IntelliJ: https://www.jetbrains.com/idea/download/#section=windows
5. Ao abrir o IntelliJ, clique em “Open” e escolha o caminho onde o projeto se encontra. Clique em “OK”:

![image](https://user-images.githubusercontent.com/56417970/175539044-cef6b2a1-a401-4afc-81c4-18c5a42d7f76.png)

6. Para rodar o projeto no IntelliJ, abra o arquivo src > main > java > com.gerenciame.api > gerenciameApplication, clique no botão direito e selecione “Run gerenciameApplication”:

![image](https://user-images.githubusercontent.com/56417970/175538983-fe91fa38-51a7-4a3a-9877-2fb9f1b2eaa4.png)

7. Pronto! Agora é só chamar os endpoints via Postman ou Insomnia.

# PARA COMPILAR O PROJETO (necessário para publicação na AWS)
## File -> Project Structure -> Project Settings -> Artifacts -> Clique no "+" -> Jar -> From modules with dependencies... > selecione qual é a classe Main  > OK <br>
![image](https://user-images.githubusercontent.com/56417970/175747014-06c168de-1a0b-40b8-b280-8ea76bc918d3.png)
![image](https://user-images.githubusercontent.com/56417970/175747540-1273302b-7d00-4b94-8db6-85d900ae983c.png)
![image](https://user-images.githubusercontent.com/56417970/175748001-cf1cdc01-9ccc-45f6-97bd-76123a2f4cdf.png)
<br><br> O projeto poderá ser encontrado em api_gerenciame_java\api\out\artifacts, dentro da pasta criada mais recentemente: <br><br>
![image](https://user-images.githubusercontent.com/56417970/175748595-14057732-f648-49ea-82f7-a29b845301ba.png)
<br><br> Este é o projeto compilado: <br><br>
![image](https://user-images.githubusercontent.com/56417970/175748615-b74a9d91-3670-4728-83c0-b1b090aa314f.png)
