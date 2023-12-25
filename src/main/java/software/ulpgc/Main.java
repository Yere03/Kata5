package software.ulpgc;

import spark.Request;
import spark.Response;
import spark.Spark;

import java.util.Spliterator;

public class Main {
    public static void main(String[] args) {
        Spark.port(8080);
        Spark.get("/factorial",(request, response) -> new CommandExecutor(request,response).execute(new FactorialCommand()));
    }

    private record CommandExecutor(Request request, Response response) {
        public String execute(Command command) {
            Command.Output output = command.execute(input());
            response.status(output.code());
            return output.result();
        }

        private Command.Input input() {
            return new Command.Input() {
                @Override
                public String get(String key) {return OnOfThose(request.queryParams(key),request.params(key));}

                private String OnOfThose(String a, String b) {return a != null ? a : b;}
            }
        }
    }
}
