import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarHistorial {
public void historial(List<String> divisas) throws IOException {
    Gson gson=new GsonBuilder().setPrettyPrinting().create();
    FileWriter escritura=new FileWriter("Historial");
    escritura.write(gson.toJson(divisas));
    escritura.close();
}
}
