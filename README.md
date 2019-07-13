# Automação de Testes por Processamento de Imagens com SikuliX integrado com Selenium WebDriver
No diretório resources dentro do projeto sikulix-tdc/test/imgs temos as imagens para validação, em alguns computadores a resolução pode ser diferente, assim pode falhar seu teste.

# Teste Visual primeira classe de exemplo - Orange HRM:
mvn -Dtest=TestOrange#testFunctionalAndVisual test -DtestContext="visual" <br/>
mvn -Dtest=TestOrange#testFunctionalAndVisual test -DtestContext="funcional"

Link do Orange HRM: https://orangehrm-demo-6x.orangehrmlive.com/

# Teste Visual segunda classe de exemplo - Google:
mvn -Dtest=TestGoogle#testFunctionalAndVisual test -DtestContext="visual" <br/>
mvn -Dtest=TestGoogle#testFunctionalAndVisual test -DtestContext="funcional"

# Para demonstrar a integração do SikuliX com Selenium WebDriver com upload file:
mvn -Dtest=TestOrangeUploadFile#testUploadFile test

