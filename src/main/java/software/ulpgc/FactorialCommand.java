package software.ulpgc;

import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;
import static software.ulpgc.Command.output;

public class FactorialCommand implements Command{
    @Override
    public Output execute(Input input) {
        return factorial(input.get("number"));
    }

    private Output factorial(String number) {return factorial(parseInt(number));
    }

    private Output factorial(int n) {
        if (n > 15) return output(400,null);
        long factorial = LongStream.range(1,n+1).reduce(1,(a,i) -> a*i);
        return output(200,String.valueOf(factorial));
    }
}
