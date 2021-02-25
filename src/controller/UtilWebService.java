package controller;

import java.io.BufferedReader;
import java.io.IOException;

public class UtilWebService {

  /**
   * Método conversor de JSON para String.
   * @param bufferedReader recebe o leitor de texto
   * @return o JSON convertido para String
   * @throws IOException
   */
  public static String convertJsonString(BufferedReader bufferedReader) throws IOException {
    String answer, jsonString = "";
    while ((answer = bufferedReader.readLine()) != null) {
      jsonString += answer;
    }
    return jsonString;
  }
}
