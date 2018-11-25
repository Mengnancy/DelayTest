package com.qm.Interview;

import java.util.Stack;

/**
 * 非递归解决汉诺塔问题
 *
 * @Author: Linglingxin
 * @Date: 2018/11/6 23:24
 */
public class HanoiProblem2 {

    public static void main(String[] args) {
        new HanoiProblem2().resolve(2, "left", "mid", "right");
    }

    public int resolve(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();

        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }

        Action[] record = {Action.NO};
        int step = 0;

        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MTol, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MTol, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RTom, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RTom, rS, mS, right, mid);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record, Action preNoAct, Action nowAct,
                                     Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}

