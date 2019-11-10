package com.sicongHe;

/**
 * @Author: Hsc
 * @Date: 2019/11/10
 * @Description: com.sicongHe KMP算法的JAVA实现
 */
public class KMP
{
    private int[][] dfa;
    private String pat;
    private int len;
    public KMP(String pat)
    {
        this.pat = pat;
        this.len = pat.length();
        this.KMP();

    }

    public void KMP()
    {
        dfa = new int[len][256];
        dfa[0][pat.charAt(0)] = 1;
        int X = 0;

        for (int j = 1; j < len; j++)
        {
            for (char c = 0; c <= 255; c++)
            {
                if (c == pat.charAt(j))
                {
                    dfa[j][c] = j + 1;
                }
                else
                {
                    dfa[j][c] = dfa[X][c];
                }
            }
            X = dfa[X][pat.charAt(j)];
        }

    }

    public int search(String target)
    {
        int state = 0;
        for (int i = 0; i < target.length(); i++)
        {

            state = dfa[state][target.charAt(i)];
            if(state == this.len){
                return i-len+1;
            }

        }

        return -1;
    }



    public static void main(String[] args)
    {
        KMP k = new KMP("issip");
        System.out.println(k.search("mississippi"));
    }
}
