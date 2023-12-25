package software.ulpgc;

public interface Command {
    Output execute(Input input);

    interface Output{
        String result();

        int code();
    }

    interface Input{
        String get(String key);
    }

    static Output output(int code, String result){
        return new Output() {
            @Override
            public String result() {
                return result;
            }

            @Override
            public int code() {
                return code;
            }
        };
    }
}
