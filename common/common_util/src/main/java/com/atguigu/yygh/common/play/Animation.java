package com.atguigu.yygh.common.play;

public class Animation extends Thread{

    /** 音符 */
    private String[] notes;
    /** 间隔时间（单位：毫秒） */
    private int times;

    public Animation(int times) {
        this.times = times;
    }


    //设置音符
    public Animation loadNotes(String notes) {
        this.notes = notes.split(" ");
        return this;
    }
    //进程方法
    @Override
    public void run() {
        try {
            int times = this.times;
            new Audio("audio/test.mp3").start();
            sleep(1000);
            int no = 1;
//            System.out.print(no+": ");
            for (int i = 0; i < this.notes.length; i++)
            {
                if (notes[i].length()<1){
                    continue;
                }
                //将【-、+】这两个字符替换成空
                String n = this.notes[i].replace("+","").replace("-","");
                if (n.equals("\n")||n.equals("\r")){
                    System.out.print("\n");
                    no++;
//                    System.out.print(no+": ");
                    continue;
                }
                switch (n)
                {
                    case "0":
                        System.out.print("_");
                        break;
                    case "1":
                        System.out.print("▁");
                        break;
                    case "2":
                        System.out.print("▂");
                        break;
                    case "3":
                        System.out.print("▃");
                        break;
                    case "4":
                        System.out.print("▄");
                        break;
                    case "5":
                        System.out.print("▅");
                        break;
                    case "6":
                        System.out.print("▆");
                        break;
                    case "7":
                        System.out.print("▇");
                        break;
                }
                System.out.print(" ");
                sleep(times);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
