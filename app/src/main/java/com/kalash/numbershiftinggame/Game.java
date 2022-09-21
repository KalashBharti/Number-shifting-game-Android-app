package com.kalash.numbershiftinggame;
import android.widget.TextView;
import android.widget.Toast;

import com.kalash.numbershiftinggame.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static Object MainActivity;
    private static ActivityMainBinding binding;
    private int i=3,j=3;

    private String temp;

    public void setBinding(ActivityMainBinding binding)
    {
        this.binding=binding;
    }
    static String[][] board = new String[4][4];
    private void setEveryThing()
    {
        binding.bt0.setText(board[0][0]);
        binding.bt1.setText(board[0][1]);
        binding.bt2.setText(board[0][2]);
        binding.bt3.setText(board[0][3]);
        binding.bt4.setText(board[1][0]);
        binding.bt5.setText(board[1][1]);
        binding.bt6.setText(board[1][2]);
        binding.bt7.setText(board[1][3]);
        binding.bt8.setText(board[2][0]);
        binding.bt9.setText(board[2][1]);
        binding.bt10.setText(board[2][2]);
        binding.bt11.setText(board[2][3]);
        binding.bt12.setText(board[3][0]);
        binding.bt13.setText(board[3][1]);
        binding.bt14.setText(board[3][2]);
        binding.bt15.setText(board[3][3]);


    }
    static private boolean check(ArrayList<Integer> ar, int num) {
        for (int i : ar) {
            if (i == num)
                return false;
        }
        return true;
    }

    static private void convert(ArrayList<Integer> v)  //function to put vector array element into board element
    {

        int temp = 0;
        for (short i = 0; i < 4; i++) {
            for (short j = 0; j < 4 && temp!=15; j++) {
                board[i][j] = String.valueOf(v.get(temp));
                temp++;
            }
        }
        board[3][3]=" ";

    }

    public void create() {
        Random random = new Random();
        int num;
        ArrayList<Integer> array
                = new ArrayList<Integer>();

        while (true) {
            num = random.nextInt(15) + 1;
            if (array.size() == 15)
                break;
            if (check(array, num)) {
                array.add(num);
            }
        }
        convert(array);
       setEveryThing();
    }

    static private void checkWinning()  //function to check the winning state
    {
        int temp = 1;
        boolean result = true;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (i == 3 && j == 3 && board[3][3].equals(" "))
                    break;

                if (!board[i][j].equals(String.valueOf(temp)))
                {
                    result = false;
                    break;
                }
                temp++;
            }
        }
        if (result)
        {
            binding.gameTitle.setText("\n You WON");

        }
    }

    //moves
    public void swipeUp() {
        if (i > 0 && i <= 3) {
            temp = board[i - 1][j];
            board[i][j] = temp;
            board[i - 1][j] = " ";
            i--;

            setEveryThing();
        }
    }
    public void swipeDown()
    { if (i >= 0 && i < 3)
    {
        temp = board[i + 1][j];
        board[i][j] = temp;
        board[i + 1][j] = " ";
        i++;
        setEveryThing();
    }
    }
    public void swipeRight() {
        if (j >= 0 && j < 3)
        {
            temp = board[i][j + 1];
            board[i][j] = temp;
            board[i][j + 1] = " ";
            j++;
            setEveryThing();
        }
    }
    public void swipeLeft() {
        if (j > 0 && j <= 3) {
            temp = board[i][j - 1];
            board[i][j] = temp;
            board[i][j - 1] = " ";
            j--;
            setEveryThing();
        }
    }
}