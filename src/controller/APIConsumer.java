package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import model.entities.Book;

/**
 * Classe que realiza a criação dos links e comunicação com a API. Faz a leitura do arquivo JSON,
 * e armazena em um objeto do tipo Book.
 * @author Leticia Conde
 */
public class APIConsumer {

  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

  public static String urlWebServiceBook = "https://openlibrary.org/isbn/";

  public static String urlWebServiceAuthor = "https://openlibrary.org/";

  /**
   * Método responsável por toda comunicação com a API e leitura do arquivo json. Tem uma
   * particularidade referente a leitura da editora, pois o arquivo json retorna um array de
   * editoras, porém a estrutura do projeto não comporta, sendo assim, apenas armazeno a primeira
   * editora recebida do arquivo json. O mesmo ocorre para o autor, porém há outro detalhe, pois o
   * json retorna uma chave para outro json onde contém um array de autores, onde o método também
   * pega apenas o primeiro.
   *
   * @param isbn código isbn que será usado para retorno dos dados do livro
   * @return um objeto book com os dados do json armazenado
   * @throws Exception
   */

  public static Book registerBook(String isbn) throws Exception {
    // Como pediu como parametro o código isbn, juntei na url para acesso
    String urlBook = urlWebServiceBook + isbn + ".json";
    try {
      //Enviando a requisição
      String jsonBook = sendHttpRequest(urlBook);

      //Instanciando um Gson
      Gson gson = new Gson();

      //Convertendo o json no objeto book
      Book book = gson.fromJson(jsonBook, Book.class);

      //Pegando o array de editoras do arquivo json
      JsonArray jsonArrayPublishers = gson.fromJson(jsonBook, JsonObject.class).getAsJsonArray("publishers");

      //Salvando na variavel editora apenas o primeiro valor do array pego
      String publisher = jsonArrayPublishers.get(0).getAsString();

      //Pegando o array de autores no arquivo json
      JsonArray jsonArrayAuthor = gson.fromJson(jsonBook, JsonObject.class).getAsJsonArray("authors");

      //Como o autor recebe uma chave q leva para outro json, peguei o valor da chave e armazenei
      String authorKey = jsonArrayAuthor.get(0).getAsJsonObject().get("key").getAsString();

      //Montei a requisição passando a chave pega
      String urlAuthor = urlWebServiceAuthor + authorKey + ".json";

      //Fiz a requisição e armazenei
      String jsonAuthor = sendHttpRequest(urlAuthor);

      //Peguei o valor nome do arquivo json recebido e salvei
      String author = gson.fromJson(jsonAuthor, JsonObject.class).get("name").getAsString();

      //Setei o valores pré definidos
      book.setAuthor(author);
      book.setIsbn(isbn);
      book.setPublisher(publisher);

      return book;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Metódo responsável por enviar a requisição, caso retorne um código diferente de 200 (200 é o
   * código de sucesso) é lançada uma exceção.
   * Também faz a leitura do arquivo e converte utilizando o conversor convertJsonString da classe
   * UtilWebService
   * @param urlRequest url a ser enviada para a requisição
   * @return o arquivo json convertido em string
   * @throws IOException
   */
  private static String sendHttpRequest(String urlRequest) throws IOException {
    URL url = new URL(urlRequest);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    if (connection.getResponseCode() != 200) {
      throw new RuntimeException("Failed : Error code" + connection.getResponseCode());
    }

    BufferedReader answer = new BufferedReader(new InputStreamReader((connection.getInputStream())));
    String jsonString = UtilWebService.convertJsonString(answer);

    return jsonString;
  }
}
