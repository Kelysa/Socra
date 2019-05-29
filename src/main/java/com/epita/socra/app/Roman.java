package com.epita.socra.app;

public final class Roman implements Convert
{
    static int[] numbers = {1000, 900 , 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] letters = {"M", "CM", "D", "CD", "C" , "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    @Override
    public String convertTo(int value)
    {
        String roman = "";
        for (int i = 0; i < numbers.length; i++)
        {
            while (value >= numbers[i])
            {
                roman += letters[i];
                value -= numbers[i];
            }
        }
        return roman;
    }
    public int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    @Override
    public int convertFrom(String str)
    {
        int res = 0;
        for (int i=0; i<str.length(); i++)
        {
            int s1 = value(str.charAt(i));

            if (i+1 < str.length())
            {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2)
                    res = res + s1;
                else
                {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is
                }
            }
            else
            {
                res = res + s1;
                i++;
            }
        }
        return res;
    }


    public static boolean valid_input(String value)
    {
        return (value.length() == 0 || value.chars().allMatch(x -> Character.isDigit(x)) == false);
    }
}
