package com.gerenciame.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/TarefasGet.feature",
                    "src/test/resources/TarefasPost.feature",
                    "src/test/resources/TarefasPut.feature",
                    "src/test/resources/TarefasDelete.feature",
                    "src/test/resources/SubtarefasPost.feature",
                    "src/test/resources/SubtarefasPut.feature",
                    "src/test/resources/SubtarefasDelete.feature"
        },
        glue = "com.gerenciame.api.tests",
        //tags = "@TarefasPost",
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE
        //dryRun = true // verifica os passos, ajuda com os testes funcionais, que demoram p rodar
)

public class CucumberTestRunner {
}
