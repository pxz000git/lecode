/**
 * @ author Allen
 * @ date 2020/8/27-23:50
 */
public class Solution {
    public String tictactoe(String[] board) {
        StringBuilder sb1=new StringBuilder(),sb2=new StringBuilder();
        for(int i=0;i<board.length;++i) {
            sb1.append('X');
            sb2.append('O');
        }
        String s1=sb1.toString(),s2=sb2.toString();
        char[][] chars=new char[board.length][board.length];
        boolean hasSpace=false;
        for(int i=0;i<board.length;++i) {
            String s=board[i];
            //将字符串数组转换为二维字符数组，这个过程可直接判断行
            if(s.equals(s1)) return "X";
            if(s.equals(s2)) return "O";
            for(int j=0;j<board.length;++j) {
                if(s.charAt(j)==' ') hasSpace=true;
                chars[i][j]=s.charAt(j);
            }
        }
        if(board.length==1) return "Pending";
        boolean slope=true;
        //判断列，途中可顺便判断斜向下的对角线
        for(int i=0;i<chars.length;++i) {
            //判断斜向下的对角线
            if(i!=0) {
                if(chars[i][i]==' ' || chars[i][i]!=chars[i-1][i-1]) slope=false;
            }
            boolean sign=true;
            for(int j=1;j<chars.length;++j) {
                if(chars[j][i]!=chars[j-1][i] || chars[j][i]==' ') {
                    sign=false;
                    break;
                }
            }
            //如果有列满足条件
            if(sign) return chars[0][i]=='X' ? "X":"O";
        }
        //如果斜向下对角线满足条件
        if(slope) return chars[0][0]=='X' ? "X":"O";
        //判断斜向上对角线
        boolean slope2=true;
        for(int i=0;i<chars.length-1;++i) {
            if(chars[i][chars.length-1-i]==' ' || chars[i][chars.length-1-i]!=chars[i+1][chars.length-2-i]) {
                slope2=false;
                break;
            }
        }
        //如果斜向上对角线满足条件
        if(slope2) return chars[0][chars.length-1]=='X' ? "X":"O";
        //行列和对角线都不满足，根据是否有空格返回不同答案
        return hasSpace ? "Pending":"Draw";
    }
}
