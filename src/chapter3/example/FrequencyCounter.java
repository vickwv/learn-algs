package chapter3.example;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter
{
    public static void main(String[] args)
    {
        int minlen = Integer.parseInt(args[0]); // 最小键长
        ST<String, Integer> st =  new ST<>();
        In stream = new In(args[1]);
        while (!stream.isEmpty())
        {
            String word = stream.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word)+1);
        }

        String max = " ";
        st.put(max, 0);
        for (String word: st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
