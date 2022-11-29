package com.atguigu.yygh.common.utils;

import com.atguigu.yygh.common.play.Animation;
import com.atguigu.yygh.common.play.AudioPlay;
import lombok.Data;


/**
 * @version 1.0
 * @ClassName Test1
 * @Author q.s.j
 * @Date 2022/10/25 19:16
 * @Decription
 **/
@Data
public class CanonPiano {

    public static void main(String[] args) {
        String sub =" 3+ 0 0 0 0  0  0  0  2+ 0 0  0  0  0 0  0 1+ 0 0  0 0  0 0  0 7  0 0  0 0  0 0  0 6  0 0  0 0  0 0  0 \n" +
                " 5  0 0 0 0  0  0  0  6  0 0  0  0  0 0  0 7  0 0  0 0  0 0  0 3+ 0 0  0 3+ 0 1+ 0 2+ 0 0  0 0  0 7  0 \n" +
                " 1+ 0 0 0 1+ 0  6  0  7  0 0  0  0  0 5  0 6  0 0  0 6  0 4  0 5  0 0  0 0  0 3  0 6  0 0  0 6  0 1+ 0 \n" +
                " 7  0 0 0 1+ 0  2+ 0  3+ 0 2+ 0  3+ 0 4+ 0 5+ 0 2+ 0 5+ 0 4+ 0 3+ 0 6+ 0 5+ 0 4+ 0 5+ 0 4+ 0 3+ 0 2+ 0 \n" +
                " 1+ 0 6 0 6+ 0 7+ 0 1++ 0 7+ 0 6+ 0 5+ 0 4+ 0 3+ 0 2+ 0 6+ 0 5+ 0 6+ 0 5+ 0 4+ 0 5+ 0 3+ 4+ 5+ 0 3+ 4+ \n" +
                " 5+ 5 6 7 1+ 2+ 3+ 4+ 3+ 0 1+ 2+ 3+ 0 3  4 5  6 5  4 5  3 4  5 4  0 6  5 4  0 3  2 3  2 1  2 3  4 5  6 \n" +
                " 4  0 6 5 6  0  7  1+ 5  6 7  1+ 2+ 3+ 4+ 5+ 5+ 0  0 0  0 0  5+ 5+ 0 6+ 0 5+ 0 4+ 0 3+ 0 0 0 0 0  3+ 0 \n" +
                " 3+ 0 4+ 0 3+ 0 2+ 0  1+ 0 0  0  0  0 1+ 0 1+ 0 2+ 0 1+ 0 7  0 6 0 0  0 0  0 1+ 0 7  0 0  0 1+ 0 2+ 0 \n" +
                " 3+ 0 0 0 0 0 0 0 2+ 0 0 0 0 0 0 0 1+ 0 0 0 0 0 0 0 7 0 0 0 0 0 0 0 6 0 0 0 0 0 0 0 \n" +
                " 5 0 0 0 0 0 0 0 6 0 0 0 0 0 1+ 0 7 1+ 7 1+ 7 1+ 6 7 1+ 0 0 0 0 0 0 0";

        String main = " 1  0  3  0 5  0 0 0 5- 0  7- 0 2  0 0 0 6-  0 1   0 3  0 0 0 3-  0 5- 0 7- 0 0 0 4-  0 6-  0 1  0 0 0 \n" +
                " 1- 0  3- 0 5- 0 0 0 4- 0  6- 0 1  0 0 0 5-  0 7-  0 2  0 0 0 1   0 3  0 5  0 0 0 5-  0 7-  0 2  0 0 0 \n" +
                " 6- 0  1  0 3  0 0 0 3- 0  5- 0 7- 0 0 0 4-  0 6-  0 1  0 0 0 1-  0 3- 0 5- 0 0 0 4-  0 6-  0 1  0 0 0 \n" +
                " 5- 0  7- 0 2  0 0 0 1- 0  5- 0 3  0 0 0 5-- 0 2-  0 7- 0 0 0 6-- 0 3- 0 1  0 0 0 3-- 0 7-- 0 5- 0 0 0 \n" +
                " 4-- 0 1- 0 6- 0 0 0 1-- 0 5-- 0 3- 0 0 0 4-- 0 1- 0 6- 0 0 0 5-- 0 2- 0 7- 0 0 0 1-  0 5-  0 3  0 0 0 \n" +
                " 5-- 0 2- 0 7- 0 0 0 6-- 0 3- 0 1  0 0 0 3-- 0 7-- 0 5- 0 0 0 4-- 0 1- 0 6- 0 0 0 1-- 0 5-- 0 3- 0 0 0 \n" +
                " 4-- 0 1- 0 6- 0 0 0 5-- 0 2- 0 7- 0 0 0 1-  0 5-  0 3  0 0 0 5-- 0 2- 0 7- 0 0 0 6-- 0 3-  0 1  0 0 0 \n" +
                " 3-- 0 7-- 0 5- 0 0 0 4-- 0 1- 0 6- 0 0 0 1-- 0 5-- 0 3- 0 0 0 4-- 0 1- 0 6- 0 0 0 5-- 0 2- 0 7- 0 0 0 \n" +
                " 1   0 3  0 5  0 0 0 5- 0  7- 0 2  0 0 0 6- 0 1 0  3 0  0 0 3- 0 5- 0 7- 0 0 0 4- 0 6- 0 1 0 0 0 \n" +
                " 1-  0 3- 0 5- 0 0 0 4- 0  6- 0 1 0 0 0 5- 0 7- 0 2 0 0 0 1 0 0 0 0 0";
//        String mainQ = " 7-  1   2   3   0   5-  5   3   0   0   0   0   0   0   0   0\n" +
//                " 7-  1   2   3   0   5-  5   3   2   3   1   2   7-  1   5-  0\n" +
//                " 7-  1   2   3   0   5-  5   3   0   0   0   0   0   0   0   0\n" +
//                " 7-  1   2   3   0   5-  5   3   2   3   1   2   7-  1   5-  0\n" +
//                " 7   1+  2+  3+  0   5   5+  3+  0   0   0   0   0   0   0   0\n" +
//                " 7   1+  2+  3+  0   5   5+  3+  2+  3+  1+  2+  7   1+  5   0\n" +
//                " 7   1+  2+  3+  0   5   5+  3+  0   0   0   0   0   0   0   0\n" +
//                " 2   0   0   0   0   0   0   0   1   0   0   0   0   0   0   0\n" +
//                " 2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   1   2   0   0   1   2   3   2   1   6-  0   0   0\n" +
//                " 2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   3   2   0   1   2   2   0   0   0   0   0   0   0\n" +
//                " 2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   3   2   0   1   0   6-  0   0   0\n" +
//                " 3   2   1   2   1   0   0   0\n" +
//                " 3   2   1   2   1   0   0\n" +
//                " 5-  3   2   1   2   0   0   1   0   0   0   0   0\n" +
//                " 1   0   2   0   3   0   1   0   6   0   5   6   0   0   0\n" +
//                " 2   7   0   6   7   0   0   0   0\n" +
//                " 7   0   6   7   0   0   3   0   1+  2+  1+  7   6   0   0\n" +
//                " 5   6   0   5   6   0   5   6   5   6   0   5   1   0   5   0   3   3   0   0   0   0   0   0   0\n" +
//                " 1   0   2   0   3   0   1   0   6   0   5   6   0   0   0\n" +
//                " 2   7   0   6   7   0   0   0   0\n" +
//                " 7   0   6   7   0   0   3   0   1+  2+  1+  7   6   0   0\n" +
//                " 5   6   0   3+  3+  0   0   5   0   6   0   3+  3+  0\n" +
//                " 5   0   6   6   0   3-  0   3-  0   3-  0   3-  0   0   0\n" +
//                " 1+  0   2+  0   3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   2+  0   0\n" +
//                " 3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   3+  0   0\n" +
//                " 2+  0   1+  6   0   1+  0   1+  2+  0   1+  6   0   0   1+  0   3+  0   0   0   0   0   3+  0   2+  0   0   0\n" +
//                " 1+  0   2+  0   3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   0\n" +
//                " 2+  0   3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   0\n" +
//                " 3+  0   2+  0   1+  6   0   0   3+  0   2+  0   1+\n" +
//                " 6   0   1+  0   0   1+  0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 6   3+  0   0   2+  0   1+  6   0   3+  0   0   2+  0   1+\n" +
//                " 6   0   1+  0   0   1+  0   0   0   0   0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 7   1+  2+  3+  0   5   5+  3+  2+  3+  7   1+  6   7   5   0\n" +
//                " 7   1+  2+  3+  0   5   5+  3+  0   0   0   0   0   0   0   0\n" +
//                " 6+  3+  2+  6   3   6   2+  3+  6+  0   0   0   0   0   0   0\n" +
//                "    2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   1   2   0   0   1   2   3   2   1   5-  0   0   0\n" +
//                " 2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   3   2   0   1   0   2   0   0   0   0   0   0   0\n" +
//                " 2   0   0   1   2   0   0   1   2   0   3   0   5   0   3   0\n" +
//                " 2   0   0   3   2   0   1   0   6-  0   0   0   3   2   1   2\n" +
//                " 1   0   0   0   3   2   1   2   1   0   0   5-  3   2   1   2\n" +
//                " 1   0   0   0   0   0   0   0   1   0   2   0   3   0   1   0\n" +
//                " 6   0   5   6   0   0   0   1   7   0   6   7   0   0   0   0\n" +
//                " 7   0   6   7   0   0   3   0   1+  2+  1+  7   6   0   5   0\n" +
//                " 6   0   5   6   0   5   6   5   6   0   5   2   0   5   0   0\n" +
//                " 3   0   0   0   0   0   0   0   1   0   2   0   3   0   1   0\n" +
//                " 6   0   5   6   0   0   0   1   7   0   6   7   0   0   0   0\n" +
//                " 7   0   6   7   0   0   3   0   1+  2+  1+  7   6   0   5   0\n" +
//                " 6   0   3+  3+  0   0   5   0   6   0   3+  3+  0   5   0   6\n" +
//                " 6   0   0   0   0   0   0   0   0   0   0   0   1+  0   2+  0\n" +
//                " 3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   0   2+  3+\n" +
//                " 0   0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   3+  0   0\n" +
//                " 2+  0   1+  6   0   1+  0   0   2+  0   1+  6   0   1+  0   0\n" +
//                " 3+  0   0   0   0   4+  3+  0   3+  2+  0   0   1+  0   2+  0\n" +
//                " 3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   0   2+  0\n" +
//                " 3+  0   6+  5+  0   0   6+  5+  0   0   6+  5+  0   3+  0   0\n" +
//                " 2+  0   1+  6   0   3+  0   0   2+  0   1+  6   0   1+  0   0\n" +
//                " 1+  0   0   0   0   0   0   0   0   0   0   0   6   3+  0   0\n" +
//                " 2+  0   0   0   1+  0   6   0   0   0   3+  0   0   0   0   0\n" +
//                " 2+  0   0   0   1+  0   6   0   0   0   1+  0   0   0   0   0\n" +
//                " 1+  0   0   0   0   0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0";
//
//        String subQ = " 4-- 0   1-  0   3-  0   0   0   5-- 0   7-- 0   2-  0   0   0\n" +
//                " 3-- 0   7-- 0   2-  0   0   0   6-- 0   1-  0   3-  0   0   0\n" +
//                " 4-- 0   1-  0   3-  0   0   0   5-- 0   7-- 0   2-  0   0   0\n" +
//                " 3-- 0   7-- 0   2-  0   0   0   6-- 0   1-  0   3-  0   0   0\n" +
//                " 4-  0   1-  0   3-  0   0   0   5-- 0   7-- 0   2-  0   0   0\n" +
//                " 3-- 0   7-- 0   2-  0   0   0   6-- 0   1-  0   3-  0   0   0\n" +
//                " 4-- 0   1-  0   3-  0   0   0   5-- 0   7-- 0   2-  0   0   0\n" +
//                " 3-  0   0   0   0   0   0   0   1-  0   0   0   0   0   0   0\n" +
//                " 1-- 0   0   0   3-  0   0   0   3-  0   0   0   3-  0   0   0\n" +
//                " 7-- 0   0   0   2-  0   0   0   2-  0   0   0   2-  0   0   0\n" +
//                " 7-- 0   0   0   2-  0   0   0   2-  0   0   0   2-  0   0   0   4--\n" +
//                " 0   0   0   4-  0   0   0   4-  0   0   0   4-  0   0   0\n" +
//                " 2-- 0   0   0   2-  0   0   0   5-- 0   0   0   2-  0   0   0   6-- 0   0   0   3-  0   0   0   6-- 0   0   0\n" +
//                " 0   0   0   0   4-- 0   0   0\n" +
//                " 0   0   0   0   4-  0   0\n" +
//                " 0   0   0   0   0   1-- 0   5-- 0   1-  0   3-  0\n" +
//                " 1   0   0   0   1-  0   0   0   4-- 1-  4-  6-  1   0   4-\n" +
//                " 0   5-- 2-  5-  7-  2   0   5-  0\n" +
//                " 3-- 7-- 3-  5-  7-  0   0   0   6-- 3-  6-  3-  1   0   0\n" +
//                " 0   4-- 1-  4-  6-  1   0   4-  0   5-- 2-  5-  7-  2-  0   5-  0   1-- 5-- 1-  3-  5-  0   3-  0\n" +
//                " 1   0   0   0   5-  0   0   0   4-- 1-  4-  1-  6-  0   1-\n" +
//                " 0   5-- 2-  5-  2-  7-  0   2-  0\n" +
//                " 3-- 7-- 3-  5-  7-  0   3-  0   6-- 3-  6-  3-  1   0   3-\n" +
//                " 0   4-- 1-  4-  6-  3   0   4-  0   5-- 2-  5-  7-  2   0\n" +
//                " 5-  0   6-- 0   6-- 0   6-- 0   6-- 0   6-- 0   0   0\n" +
//                " 0   0   0   0   4-- 0   1-  0   4-  0   0   0   5-- 0   2-  0   5-  0   0   0\n" +
//                " 3-- 0   7-- 0   3-  0   0   0   6-- 0   3-  0   6-  0   0   0\n" +
//                " 4-- 0   1-  0   4-  0   0   0   5-- 0   2-  0   5-  0   0   0\n" +
//                " 1-  0   5-  0   1   0   0   0   3-  0   7-  0\n" +
//                " 3   0   0   0   4-- 0   1-  0   4-  0   0   0   5-- 0   2-  0   5-  0   0\n" +
//                " 0   3-- 0   7-- 0   3-  0   0   0   6-- 0   3-  0   6-  0\n" +
//                " 0   0   4-- 0   1-  0   4-  0   0   0   5-- 0   2-  0   5-  0   0\n" +
//                " 0   1-  0   5-  0   1   0   5-  0   3-  0   0   0\n" +
//                " 0   0   0   0   4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 4-- 0   1-  0   6-  0   1-  0   5-- 0   2-  0   5-  0   2-  0\n" +
//                " 3-- 0   7-- 0   5-  0   7-- 0   6-- 0   3-  0   1   0   3-  0\n" +
//                " 4-- 0   1-  0   6-  0   1-  0   5-- 0   2-  0   7-  0   2-  0\n" +
//                " 6-- 0   3-  0   6-  0   3-  0   1   0   0   0   3-  0   0   0\n" +
//                "    1-- 0   0   0   3-  0   0   0   3-  0   0   0   3-  0   0   0\n" +
//                " 7-- 0   0   0   2-  0   0   0   2-  0   0   0   2-  0   0   0\n" +
//                " 7-- 0   0   0   2-  0   0   0   2-  0   0   0   2-  0   0   0\n" +
//                " 4-- 0   0   0   4-  0   0   0   4-  0   0   0   4-  0   0   0\n" +
//                " 2-- 0   0   0   2-  0   0   0   5-- 0   0   0   2-  0   0   0\n" +
//                " 6-- 0   0   0   3-  0   0   0   6-- 0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 1-  0   0   0   0   0   0   0   1-  0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 3-- 0   0   0   0   0   0   0   6-- 0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 1-  0   0   0   0   0   0   0   1-  0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 3-- 0   0   0   0   0   0   0   6-- 0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   5-- 0   0   0   0   0   0   0\n" +
//                " 6-- 0   0   0   3-  0   0   0   6-  0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   4-  0   0   0   5-- 0   0   0   5-  0   0   0\n" +
//                " 3-- 0   0   0   3-  0   0   0   6-- 0   0   0   6-  0   0   0\n" +
//                " 4-- 0   0   0   4-  0   0   0   5-- 0   0   0   5-  0   0   0\n" +
//                " 1-- 0   0   0   1-  0   0   0   3-- 0   0   0   3-  0   0   0\n" +
//                " 4-- 0   0   0   4-  0   0   0   5-- 0   0   0   5-  0   0   0\n" +
//                " 3-- 0   0   0   3-  0   0   0   6-- 0   0   0   6-  0   0   0\n" +
//                " 4-- 0   0   0   4-  0   0   0   5-- 0   0   0   5-  0   0   0\n" +
//                " 6-- 0   0   0   3-  0   0   0   6-- 0   0   0   0   0   0   0\n" +
//                " 4-- 0   0   0   0   0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 5-- 0   0   0   0   0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0\n" +
//                " 0   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0";
        // 播放
        new AudioPlay(150).loadNotes(main).start();
        new AudioPlay(150).loadNotes(sub).start();

        //控制台打印
        new Animation(150).loadNotes(main).start();
    }
}