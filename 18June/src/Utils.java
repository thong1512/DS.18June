import com.google.gson.Gson;

public class Utils {
    public static Book jsonString2Object(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Book.class);
    }

    public static String Object2jsonString(Book book){
        Gson gson = new Gson();
        return gson.toJson(book);
    }
}
