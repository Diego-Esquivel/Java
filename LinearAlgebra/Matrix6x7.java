public class Matrix6x7 {
    private double[][] matrix = {{0.,0.,0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.,0.,0.}};
    //String[] values = {"","","",""};
    public Matrix6x7 ( ) {
        for ( int r = 0; r < 6; r ++ ) {
            for ( int c = 0; c < 7; c ++ ) {
                matrix[r][c] = 0.;
            }
        }
    }
    
    public void setMatrix(int r, int c, double value) {
        matrix[r][c] = value;
    }
    public void setDiagonal(double v1, double v2, double v3, double v4, double v5, double v6){
        matrix[0][0] = v1;
        matrix[1][1] = v2;
        matrix[2][2] = v3;
        matrix[3][3] = v4;
        matrix[4][4] = v5;
        matrix[5][5] = v6;
    }
    public void setDiagonal(double v1, double v2, double v3, double v4, double v5){
        matrix[0][1] = v1;
        matrix[1][2] = v2;
        matrix[2][3] = v3;
        matrix[3][4] = v4;
        matrix[4][5] = v5;
        matrix[1][0] = v1;
        matrix[2][1] = v2;
        matrix[3][2] = v3;
        matrix[4][3] = v4;
        matrix[5][4] = v5;
    }
    public void setDiagonal(double v1, double v2, double v3, double v4) {
        matrix[0][2] = v1;
        matrix[1][3] = v2;
        matrix[2][4] = v3;
        matrix[3][5] = v4;
        matrix[2][0] = v1;
        matrix[3][1] = v2;
        matrix[4][2] = v3;
        matrix[5][3] = v4;
    }
    public void setDiagonal(double v1, double v2, double v3) {
        matrix[0][3] = v1;
        matrix[1][4] = v2;
        matrix[2][5] = v3;
        matrix[3][0] = v1;
        matrix[4][1] = v2;
        matrix[5][2] = v3;
    }
    public void setDiagonal(double v1, double v2) {
        matrix[0][4] = v1;
        matrix[1][5] = v2;
        matrix[4][0] = v1;
        matrix[5][1] = v2;
    }
    public void setDiagonal(double v1) {
        matrix[0][5] = v1;
        matrix[5][0] = v1;
    }
    public void setConstantTerms(double c1, double c2, double c3, double c4, double c5, double c6){
        matrix[0][6] = c1;
        matrix[1][6] = c2;
        matrix[2][6] = c3;
        matrix[3][6] = c4;
        matrix[4][6] = c5;
        matrix[5][6] = c6;
    }

    private void rrefRow1(double w) {
        if(w != 0.)
            for(int c = 0; c < 7; c++){
                matrix[0][c] = matrix[0][c]/w;
            }
        
    }
    private void rrefRow2(double w) {
        if(w != 0.)
        for(int c = 0; c < 7; c++){
            matrix[1][c] = matrix[1][c]/w;
        }
    }
    private void rrefRow3(double w) {
        if(w != 0.)
        for(int c = 0; c < 7; c++){
            matrix[2][c] = matrix[2][c]/w;
        }
    }
    private void rrefRow4(double w) {
        if(w != 0.)
        for(int c = 0; c < 7; c++){
            matrix[3][c] = matrix[3][c]/w;
        }
    }
    private void rrefRow5(double w) {
        if(w != 0.)
        for(int c = 0; c < 7; c++){
            matrix[4][c] = matrix[4][c]/w;
        }
    }
    private void rrefRow6(double w) {
        if(w != 0.)
        for(int c = 0; c < 7; c++){
            matrix[5][c] = matrix[5][c]/w;
        }
    }

    private void rowSub(int track1, int track2){
        if(matrix[track2][track1] != 0.)
        for(int c = 0; c < 7; c++){
            matrix[track2][c] -= matrix[track1][c];
        }
    }

    public void rref() {
        double w1 = matrix[0][0];
        double w2 = matrix[1][0];
        double w3 = matrix[2][0];
        double w4 = matrix[3][0];  
        double w5 = matrix[4][0];
        double w6 = matrix[5][0];
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(0,1);
        rowSub(0,2);
        rowSub(0,3);
        rowSub(0,4);
        rowSub(0,5);
   
        w1 = matrix[0][1];
        w2 = matrix[1][1];
        w3 = matrix[2][1];
        w4 = matrix[3][1]; 
        w5 = matrix[4][1]; 
        w6 = matrix[5][1]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(1,0);
        rowSub(1,2);
        rowSub(1,3);
        rowSub(1,4);
        rowSub(1,5);
        
        w1 = matrix[0][2];
        w2 = matrix[1][2];
        w3 = matrix[2][2];
        w4 = matrix[3][2]; 
        w5 = matrix[4][2]; 
        w6 = matrix[5][2]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(2,0);
        rowSub(2,1);
        rowSub(2,3);
        rowSub(2,4);
        rowSub(2,5);
       
        w1 = matrix[0][3];
        w2 = matrix[1][3];
        w3 = matrix[2][3];
        w4 = matrix[3][3]; 
        w5 = matrix[4][3]; 
        w6 = matrix[5][3]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(3,0);
        rowSub(3,2);
        rowSub(3,1);
        rowSub(3,4);
        rowSub(3,5);

        w1 = matrix[0][4];
        w2 = matrix[1][4];
        w3 = matrix[2][4];
        w4 = matrix[3][4]; 
        w5 = matrix[4][4]; 
        w6 = matrix[5][4]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(4,0);
        rowSub(4,2);
        rowSub(4,3);
        rowSub(4,1);
        rowSub(4,5);

        w1 = matrix[0][5];
        w2 = matrix[1][5];
        w3 = matrix[2][5];
        w4 = matrix[3][5]; 
        w5 = matrix[4][5]; 
        w6 = matrix[5][5]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
        rowSub(5,0);
        rowSub(5,2);
        rowSub(5,3);
        rowSub(5,4);
        rowSub(5,1);

        w1 = matrix[0][0];
        w2 = matrix[1][1];
        w3 = matrix[2][2];
        w4 = matrix[3][3]; 
        w5 = matrix[4][4]; 
        w6 = matrix[5][5]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rrefRow5(w5);
        rrefRow6(w6);
    }

    public String to_print() {
        String output = "";
        for ( int r = 0; r < 6; r ++ ) {
            for ( int c = 0; c < 7; c ++ ) {
                output += String.format("%.2f",matrix[r][c]) + "\t";
            }
            output += "\n";
        }
        return output;
    }
}