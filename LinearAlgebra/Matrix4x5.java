public class Matrix4x5 {
    private double[][] matrix = {{0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.},{0.,0.,0.,0.,0.}};
    String[] values = {"","","",""};
    public Matrix4x5 ( ) {
        for ( int r = 0; r < 4; r ++ ) {
            for ( int c = 0; c < 5; c ++ ) {
                matrix[r][c] = 0.;
            }
        }
    }
    
    public void setMatrix(int r, int c, double value) {
        matrix[r][c] = value;
    }
    public void setDiagonal(double v1, double v2, double v3, double v4){
        matrix[0][0] = v1;
        matrix[1][1] = v2;
        matrix[2][2] = v3;
        matrix[3][3] = v4;
    }
    public void setDiagonal(double v1, double v2, double v3) {
        matrix[0][1] = v1;
        matrix[1][2] = v2;
        matrix[2][3] = v3;
        matrix[1][0] = v1;
        matrix[2][1] = v2;
        matrix[3][2] = v3;
    }
    public void setDiagonal(double v1, double v2) {
        matrix[0][2] = v1;
        matrix[1][3] = v2;
        matrix[2][0] = v1;
        matrix[3][1] = v2;
    }
    public void setDiagonal(double v1) {
        matrix[0][3] = v1;
        matrix[3][0] = v1;
    }
    public void setConstantTerms(double c1, double c2, double c3, double c4){
        matrix[0][4] = c1;
        matrix[1][4] = c2;
        matrix[2][4] = c3;
        matrix[3][4] = c4;
    }

    private void rrefRow1(double w) {
        if(w != 0.)
            for(int c = 0; c < 5; c++){
                matrix[0][c] = matrix[0][c]/w;
            }
        
    }
    private void rrefRow2(double w) {
        if(w != 0.)
        for(int c = 0; c < 5; c++){
            matrix[1][c] = matrix[1][c]/w;
        }
    }
    private void rrefRow3(double w) {
        if(w != 0.)
        for(int c = 0; c < 5; c++){
            matrix[2][c] = matrix[2][c]/w;
        }
    }
    private void rrefRow4(double w) {
        if(w != 0.)
        for(int c = 0; c < 5; c++){
            matrix[3][c] = matrix[3][c]/w;
        }
    }

    private void rowSub(int track1, int track2){
        if(matrix[track2][track1] != 0.)
        for(int c = 0; c < 5; c++){
            matrix[track2][c] -= matrix[track1][c];
        }
    }

    public void rref() {
        double w1 = matrix[0][0];
        double w2 = matrix[1][0];
        double w3 = matrix[2][0];
        double w4 = matrix[3][0];  
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rowSub(0,1);
        rowSub(0,2);
        rowSub(0,3);
   
        w1 = matrix[0][1];
        w2 = matrix[1][1];
        w3 = matrix[2][1];
        w4 = matrix[3][1]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rowSub(1,0);
        rowSub(1,2);
        rowSub(1,3);
        
        w1 = matrix[0][2];
        w2 = matrix[1][2];
        w3 = matrix[2][2];
        w4 = matrix[3][2]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rowSub(2,0);
        rowSub(2,1);
        rowSub(2,3);
       
        w1 = matrix[0][3];
        w2 = matrix[1][3];
        w3 = matrix[2][3];
        w4 = matrix[3][3]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
        rowSub(3,0);
        rowSub(3,2);
        rowSub(3,1);

        w1 = matrix[0][0];
        w2 = matrix[1][1];
        w3 = matrix[2][2];
        w4 = matrix[3][3]; 
        rrefRow1(w1);
        rrefRow2(w2);
        rrefRow3(w3);
        rrefRow4(w4);
    }

    public String to_print() {
        String output = "";
        for ( int r = 0; r < 4; r ++ ) {
            for ( int c = 0; c < 5; c ++ ) {
                output += String.valueOf(matrix[r][c]) + "\t";
            }
            output += "\n";
        }
        return output;
    }
}