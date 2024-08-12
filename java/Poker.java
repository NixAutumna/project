


import java.util.Arrays;

/**
 * 梭哈各牌型出现频率一览
 * @author NixAutumna
 */
public class Poker{
    public static void main(String[] args) {
        Probability probability = new Probability();
        probability.use();
    }
}

class Probability {
    int low = 0;
    int onePair = 0;
    int towPairs = 0;
    int threeOfaKind = 0;
    int straight = 0;
    int flush = 0;
    int fullHouse = 0;
    int fourOfaKing = 0;
    int straightFlush = 0;
    int used = 0;
    public void see(int[] num, int[] col) {
        used++;
        int a = pair(num);
        boolean b = equ(col[0], col[1], col[2], col[3], col[4]);
        boolean c = con(num);
        
        if (b && c) {
            straightFlush++;
        } else if (a == 6) {
            fourOfaKing++;
        } else if (a == 4) {
            fullHouse++;
        } else if (b) {
            flush++;
        } else if (c) {
            straight++;
        } else if (a == 3) {
            threeOfaKind++;
        } else if (a == 2) {
            towPairs++;
        } else if (a == 1) {
            onePair++;
        } else {
            low++;
        }
    }
    
    public boolean equ(int... num) {
        if (num.length <= 1)
            return false;
        for (int i = 1; i < num.length; i++) {
            if (num[0] != num[i])
                return false;
        }
        return true;
    }
    public boolean unequ(int... num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j])
                    return false;
            }
        }
        return true;
    }
    
    public boolean con(int[] num) {
        Arrays.sort(num);
        return  num[0] + 1 == num[1] && num[1] + 1 == num[2] &&
                num[2] + 1 == num[3] && num[3] + 1 == num[4];
    }
    
    public int pair(int[] num) {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (num[i] == num[j]) {
                    a++;
                }
            }
        }
        return a;
    }
    
    public void use() {
        int[] num = new int[52];
        for (int i = 0; i < 52; i++) {
            num[i] = i / 4 + 1;
        }
        int[] col = new int[52];
        for (int i = 0; i < 52; i++) {
            col[i] = i / 13 + 1;
        }
    
        int[] catchNum = new int[5];
        int[] catchCol = new int[5];
    
        for (int i = 0; i < 52; i++) {
            catchNum[0] = num[i];
            catchCol[0] = col[i];
        
            for (int j = 0; j < 52; j++) {
                if (j != i) {
                    catchNum[1] = num[j];
                    catchCol[1] = col[j];
                    for (int k = 0; k < 52; k++) {
                        if (unequ(i, j, k)) {
                            catchNum[2] = num[k];
                            catchCol[2] = col[k];
                            for (int l = 0; l < 52; l++) {
                                if (unequ(i, j, k, l)) {
                                    catchNum[3] = num[l];
                                    catchCol[3] = col[l];
                                    for (int m = 0; m < 52; m++) {
                                        if (unequ(i, j, k, l, m)) {
                                            catchNum[4] = num[m];
                                            catchCol[4] = col[m];
                                            see(catchNum, catchCol);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(toString());
    }
    
    @Override
    public String toString() {
        return "low=" + low + " pro:" + (float)low / used + "\n" +
                "onePair=" + onePair + " pro:" + (float)onePair / used + "\n" +
                "towPairs=" + towPairs + " pro:" + (float)towPairs / used + "\n" +
                "threeOfaKind=" + threeOfaKind + " pro:" + (float)threeOfaKind / used + "\n" +
                "straight=" + straight + " pro:" + (float)straight / used + "\n" +
                "flush=" + flush + " pro:" + (float)flush / used + "\n" +
                "fullHouse=" + fullHouse + " pro:" + (float)fullHouse / used + "\n" +
                "fourOfaKing=" + fourOfaKing + " pro:" + (float)fourOfaKing / used + "\n" +
                "straightFlush=" + straightFlush + " pro:" + (float)straightFlush / used + "\n" +
                "used=" + used;
    }
}