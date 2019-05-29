package com.epita.socra.app;

import com.epita.socra.app.tools.*;
import org.mockito.internal.matchers.Null;

import static java.lang.System.*;

/**
 * Hello world!
 */
public final class App {
    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        //application.run();
        int input = 0;
        Roman r = new Roman();
        while(true)
        {
            String name = application.adapter.read();
            if (Roman.valid_input(name) == false) {
                String arabic = application.runRoman(name);
                input = application.add(input, arabic);
            }
            else {
                input += application.runArabic(name);
            }
            System.out.println(input);
        }
    }
    public void run(){
        adapter.write("Hello, what's your name ?");
        String name = adapter.read();
        adapter.write("Nice to meet you, " + name + " !");
    }
    public String  runRoman(String arabic){
        Roman roman = new Roman();
        String res = roman.convertTo(Integer.parseInt(arabic));
        return res;
    }
    public int  runArabic(String arabic)
    {
        Roman roman = new Roman();
        int res = roman.convertFrom(arabic);
        return res;
    }

    public int add (int input, String roman)
    {
        Roman roman1 = new Roman();
        int res = roman1.convertFrom(roman);
        return input + res;
    }
}
