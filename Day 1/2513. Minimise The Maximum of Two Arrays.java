class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

        long dlcm = lcm(divisor1, divisor2);
        long d = Integer.MAX_VALUE;
        long b = 0;
        while( b < d){
            long m = ( b + d) / 2;
            if( mumkin(divisor1, divisor2, uniqueCnt1, uniqueCnt2, dlcm, m) ){
                d = m;
            }
            else{
                b = m + 1;
            }
        }
        return (int) b;
    }

    static boolean mumkin( int d1, int d2, int uc1, int uc2, long dlcm, long m){
        long tatkal1 = m - m/d1;
        long tatkal2 = m - m/d2;
        long puratatkal = m - m/dlcm;
        return tatkal1 >= uc1 && tatkal2 >= uc2 && puratatkal >= uc1 + uc2;
    }

    static long lcm( int a, int b){
        return a * (b / hcf(a,b)) ;
    }
    static long hcf(int a, int b){
        return b == 0 ? a : hcf( b, a % b);
    }
}