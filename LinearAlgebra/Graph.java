import java.io.*;

public class Graph {
    private DoublyLinkedList vertices;
    
        Graph ( ) {
            vertices = new DoublyLinkedList();
        }
        Graph (String data) {
            vertices = new DoublyLinkedList(new Node(data));
        }
        
        String getAdjacent ( String source ) {
            String adj_list = "";
            adj_list += vertices.getRight(source);
            return adj_list;
        }

        Boolean isAdjacent ( String source, String data ) {
            return vertices.isAdjacent(source, data);
        }

        void addVertice( String data ){
            vertices.add(data);
        }
        void addTo( String source, String data ) {
            vertices.insertTo(source, data);
        }
        void print ( ) {
            vertices.print();
        }
        String to_print() {
            return vertices.to_print();
        }

        Matrix4x5 toMatrix4x5 ( ) {
            Matrix4x5 matrix = new Matrix4x5();
            int[] values = {0,0,0,0};
            double[] constants = {0,0,0,0};
            String ia = "IA";
            String il = "IL";
            String pu = "PU";
            String in = "IN";
            values[0] = vertices.getRightSize(ia) + (isAdjacent(il,ia) ? 1:0) + (isAdjacent(pu,ia)?1:0) + (isAdjacent(in,ia)?1:0) + 2;
            values[1] = vertices.getRightSize(il) + (isAdjacent(ia,il) ? 1:0) + (isAdjacent(pu,il)?1:0) + (isAdjacent(in,il)?1:0) + 2;
            values[2] = vertices.getRightSize(pu) + (isAdjacent(il,pu) ? 1:0) + (isAdjacent(ia,pu)?1:0) + (isAdjacent(in,pu)?1:0) + 2;
            values[3] = vertices.getRightSize(in) + (isAdjacent(il,in) ? 1:0) + (isAdjacent(pu,in)?1:0) + (isAdjacent(ia,in)?1:0) + 2;
            matrix.setDiagonal(values[0], values[1], values[2], values[3]);
            values[0] = -1 * ((isAdjacent(ia,il) ? 1:0) + (isAdjacent(il,ia) ? 1:0));
            values[1] = -1 * ((isAdjacent(il,pu) ? 1:0) + (isAdjacent(pu,il) ? 1:0));
            values[2] = -1 * ((isAdjacent(pu,in) ? 1:0) + (isAdjacent(in,pu) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2]);
            values[0] = -1 * ((isAdjacent(ia,pu) ? 1:0) + (isAdjacent(pu,ia) ? 1:0));
            values[1] = -1 * ((isAdjacent(il,in) ? 1:0) + (isAdjacent(in,il) ? 1:0));
            matrix.setDiagonal(values[0],values[1]);
            values[0] = -1 * ((isAdjacent(ia,in) ? 1:0) + (isAdjacent(in,ia) ? 1:0));
            matrix.setDiagonal(values[0]);
            constants[0] = 1. + (.5 * (vertices.getRightSize(ia) - ((isAdjacent(il,ia) ? 1:0) + (isAdjacent(pu,ia)?1:0) + (isAdjacent(in,ia)?1:0)) ));
            constants[1] = 1. + (.5 * (vertices.getRightSize(il) - ((isAdjacent(ia,il) ? 1:0) + (isAdjacent(pu,il)?1:0) + (isAdjacent(in,il)?1:0)) ));
            constants[2] = 1. + (.5 * (vertices.getRightSize(pu) - ((isAdjacent(il,pu) ? 1:0) + (isAdjacent(ia,pu)?1:0) + (isAdjacent(in,pu)?1:0)) ));
            constants[3] = 1. + (.5 * (vertices.getRightSize(in) - ((isAdjacent(il,in) ? 1:0) + (isAdjacent(pu,in)?1:0) + (isAdjacent(ia,in)?1:0)) ));
            matrix.setConstantTerms(constants[0], constants[1], constants[2], constants[3]);
            return matrix;
        }

        Matrix6x7 toMatrix6x7_Colley ( ) {
            Matrix6x7 matrix = new Matrix6x7();
            int[] values = {0,0,0,0,0,0};
            double[] constants = {0,0,0,0,0,0};
            String tn = "TN";
            String mo = "MO";
            String ky = "KY";
            String ga = "GA";
            String fl = "FL";
            String sc = "SC";
            values[0] = vertices.getRightSize(tn) + (isAdjacent(mo,tn) ? 1:0) + (isAdjacent(ky,tn)?1:0) + (isAdjacent(ga,tn)?1:0) + (isAdjacent(fl,tn)?1:0) + (isAdjacent(sc,tn)?1:0) + 2;
            values[1] = vertices.getRightSize(mo) + (isAdjacent(tn,mo) ? 1:0) + (isAdjacent(ky,mo)?1:0) + (isAdjacent(ga,mo)?1:0) + (isAdjacent(fl,mo)?1:0) + (isAdjacent(sc,mo)?1:0) + 2;
            values[2] = vertices.getRightSize(ky) + (isAdjacent(tn,ky) ? 1:0) + (isAdjacent(mo,ky)?1:0) + (isAdjacent(ga,ky)?1:0) + (isAdjacent(fl,ky)?1:0) + (isAdjacent(sc,ky)?1:0) + 2;
            values[3] = vertices.getRightSize(ga) + (isAdjacent(tn,ga) ? 1:0) + (isAdjacent(mo,ga)?1:0) + (isAdjacent(ky,ga)?1:0) + (isAdjacent(fl,ga)?1:0) + (isAdjacent(sc,ga)?1:0) + 2;
            values[4] = vertices.getRightSize(fl) + (isAdjacent(tn,fl) ? 1:0) + (isAdjacent(mo,fl)?1:0) + (isAdjacent(ky,fl)?1:0) + (isAdjacent(ga,fl)?1:0) + (isAdjacent(ga,sc)?1:0) + 2;
            values[5] = vertices.getRightSize(sc) + (isAdjacent(tn,sc) ? 1:0) + (isAdjacent(mo,sc)?1:0) + (isAdjacent(ky,sc)?1:0) + (isAdjacent(ga,sc)?1:0) + (isAdjacent(fl,tn)?1:0) + 2;
            matrix.setDiagonal(values[0], values[1], values[2], values[3], values[4],values[5]);
            values[0] = -1 * ((isAdjacent(tn,mo) ? 1:0) + (isAdjacent(mo,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,ky) ? 1:0) + (isAdjacent(ky,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,ga) ? 1:0) + (isAdjacent(ga,ky) ? 1:0));
            values[3] = -1 * ((isAdjacent(ga,fl) ? 1:0) + (isAdjacent(fl,ga) ? 1:0));
            values[4] = -1 * ((isAdjacent(fl,sc) ? 1:0) + (isAdjacent(sc,fl) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2], values[3], values[4]);
            values[0] = -1 * ((isAdjacent(tn,ky) ? 1:0) + (isAdjacent(ky,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,ga) ? 1:0) + (isAdjacent(ga,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,fl) ? 1:0) + (isAdjacent(fl,ky) ? 1:0));
            values[3] = -1 * ((isAdjacent(ga,sc) ? 1:0) + (isAdjacent(sc,ga) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2], values[3]);
            values[0] = -1 * ((isAdjacent(tn,ga) ? 1:0) + (isAdjacent(ga,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,fl) ? 1:0) + (isAdjacent(fl,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,sc) ? 1:0) + (isAdjacent(sc,ky) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2]);
            values[0] = -1 * ((isAdjacent(tn,fl) ? 1:0) + (isAdjacent(fl,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,sc) ? 1:0) + (isAdjacent(sc,mo) ? 1:0));
            matrix.setDiagonal(values[0],values[1]);
            values[0] = -1 * ((isAdjacent(tn,sc) ? 1:0) + (isAdjacent(sc,tn) ? 1:0));
            matrix.setDiagonal(values[0]);
            constants[0] = 1. + (.5 * (vertices.getRightSize(tn) - ((isAdjacent(mo,tn) ? 1:0) + (isAdjacent(ky,tn)?1:0) + (isAdjacent(ga,tn)?1:0) + (isAdjacent(fl,tn)?1:0) + (isAdjacent(sc,tn)?1:0)) ));
            constants[1] = 1. + (.5 * (vertices.getRightSize(mo) - ((isAdjacent(tn,mo) ? 1:0) + (isAdjacent(ky,mo)?1:0) + (isAdjacent(ga,mo)?1:0) + (isAdjacent(fl,mo)?1:0) + (isAdjacent(sc,mo)?1:0)) ));
            constants[2] = 1. + (.5 * (vertices.getRightSize(ky) - ((isAdjacent(tn,ky) ? 1:0) + (isAdjacent(mo,ky)?1:0) + (isAdjacent(ga,ky)?1:0) + (isAdjacent(fl,ky)?1:0) + (isAdjacent(sc,ky)?1:0)) ));
            constants[3] = 1. + (.5 * (vertices.getRightSize(ga) - ((isAdjacent(tn,ga) ? 1:0) + (isAdjacent(mo,ga)?1:0) + (isAdjacent(ky,ga)?1:0) + (isAdjacent(fl,ga)?1:0) + (isAdjacent(sc,ga)?1:0)) ));
            constants[4] = 1. + (.5 * (vertices.getRightSize(fl) - ((isAdjacent(tn,fl) ? 1:0) + (isAdjacent(mo,fl)?1:0) + (isAdjacent(ky,fl)?1:0) + (isAdjacent(ga,fl)?1:0) + (isAdjacent(sc,fl)?1:0)) ));
            constants[5] = 1. + (.5 * (vertices.getRightSize(sc) - ((isAdjacent(tn,sc) ? 1:0) + (isAdjacent(mo,sc)?1:0) + (isAdjacent(ky,sc)?1:0) + (isAdjacent(ga,sc)?1:0) + (isAdjacent(fl,sc)?1:0)) ));
            matrix.setConstantTerms(constants[0], constants[1], constants[2], constants[3], constants[4], constants[5]);
            return matrix;
        }

        Matrix6x7 toMatrix6x7_Massey ( ) {
            Matrix6x7 matrix = new Matrix6x7();
            int[] values = {0,0,0,0,0,0};
            double[] constants = {0,0,0,0,0,0};
            String tn = "TN";
            String mo = "MO";
            String ky = "KY";
            String ga = "GA";
            String fl = "FL";
            String sc = "SC";
            values[0] = vertices.getRightSize(tn) + (isAdjacent(mo,tn) ? 1:0) + (isAdjacent(ky,tn)?1:0) + (isAdjacent(ga,tn)?1:0) + (isAdjacent(fl,tn)?1:0) + (isAdjacent(sc,tn)?1:0);
            values[1] = vertices.getRightSize(mo) + (isAdjacent(tn,mo) ? 1:0) + (isAdjacent(ky,mo)?1:0) + (isAdjacent(ga,mo)?1:0) + (isAdjacent(fl,mo)?1:0) + (isAdjacent(sc,mo)?1:0);
            values[2] = vertices.getRightSize(ky) + (isAdjacent(tn,ky) ? 1:0) + (isAdjacent(mo,ky)?1:0) + (isAdjacent(ga,ky)?1:0) + (isAdjacent(fl,ky)?1:0) + (isAdjacent(sc,ky)?1:0);
            values[3] = vertices.getRightSize(ga) + (isAdjacent(tn,ga) ? 1:0) + (isAdjacent(mo,ga)?1:0) + (isAdjacent(ky,ga)?1:0) + (isAdjacent(fl,ga)?1:0) + (isAdjacent(sc,ga)?1:0);
            values[4] = vertices.getRightSize(fl) + (isAdjacent(tn,fl) ? 1:0) + (isAdjacent(mo,fl)?1:0) + (isAdjacent(ky,fl)?1:0) + (isAdjacent(ga,fl)?1:0) + (isAdjacent(ga,sc)?1:0);
            values[5] = vertices.getRightSize(sc) + (isAdjacent(tn,sc) ? 1:0) + (isAdjacent(mo,sc)?1:0) + (isAdjacent(ky,sc)?1:0) + (isAdjacent(ga,sc)?1:0) + (isAdjacent(fl,tn)?1:0);
            matrix.setDiagonal(values[0], values[1], values[2], values[3], values[4],values[5]);
            values[0] = -1 * ((isAdjacent(tn,mo) ? 1:0) + (isAdjacent(mo,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,ky) ? 1:0) + (isAdjacent(ky,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,ga) ? 1:0) + (isAdjacent(ga,ky) ? 1:0));
            values[3] = -1 * ((isAdjacent(ga,fl) ? 1:0) + (isAdjacent(fl,ga) ? 1:0));
            values[4] = -1 * ((isAdjacent(fl,sc) ? 1:0) + (isAdjacent(sc,fl) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2], values[3], values[4]);
            values[0] = -1 * ((isAdjacent(tn,ky) ? 1:0) + (isAdjacent(ky,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,ga) ? 1:0) + (isAdjacent(ga,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,fl) ? 1:0) + (isAdjacent(fl,ky) ? 1:0));
            values[3] = -1 * ((isAdjacent(ga,sc) ? 1:0) + (isAdjacent(sc,ga) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2], values[3]);
            values[0] = -1 * ((isAdjacent(tn,ga) ? 1:0) + (isAdjacent(ga,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,fl) ? 1:0) + (isAdjacent(fl,mo) ? 1:0));
            values[2] = -1 * ((isAdjacent(ky,sc) ? 1:0) + (isAdjacent(sc,ky) ? 1:0));
            matrix.setDiagonal(values[0],values[1],values[2]);
            values[0] = -1 * ((isAdjacent(tn,fl) ? 1:0) + (isAdjacent(fl,tn) ? 1:0));
            values[1] = -1 * ((isAdjacent(mo,sc) ? 1:0) + (isAdjacent(sc,mo) ? 1:0));
            matrix.setDiagonal(values[0],values[1]);
            values[0] = -1 * ((isAdjacent(tn,sc) ? 1:0) + (isAdjacent(sc,tn) ? 1:0));
            matrix.setDiagonal(values[0]);
            
            constants[0] = -45.;
            constants[1] = 90.;
            constants[2] = -55.;
            constants[3] = -9.;
            constants[4] = 4.;
            constants[5] = 15;
            matrix.setConstantTerms(constants[0], constants[1], constants[2], constants[3], constants[4], constants[5]);
            matrix.setMatrix(5,0,1.);
            matrix.setMatrix(5,1,1.);
            matrix.setMatrix(5,2,1.);
            matrix.setMatrix(5,3,1.);
            matrix.setMatrix(5,4,1.);
            matrix.setMatrix(5,5,1.);
            matrix.setMatrix(5,6,0.);
            return matrix;
        }

        public static void main (String[] args) {
            /*Graph graph = new Graph();
            String ia = "IA";
            String il = "IL";
            String pu = "PU";
            String in = "IN";
            graph.addVertice(ia);
            graph.addVertice(il);
            graph.addVertice(pu);
            graph.addVertice(in);
            graph.addTo(ia, il);
            graph.addTo(il, in);
            graph.addTo(pu, il);
            graph.addTo(pu, in);
            graph.addTo(in, ia);
            graph.print();
            Matrix4x5 matrix = graph.toMatrix4x5();
            String output = matrix.to_print();
            System.out.println(output);
            matrix.rref();
            output = matrix.to_print();
            System.out.println(output);*/
            String answer_1 = "\n\n\n\n\n\n1) Given the directed graph in problem one I can create a matrix from is by applying the Colley method. First writing the table as a list, with the item most left of the list being the team we are analyzing and the rest the teams the source won against, I get the list: \n";

            Graph graph = new Graph();
            String tn = "TN";
            String mo = "MO";
            String ky = "KY";
            String ga = "GA";
            String fl = "FL";
            String sc = "SC";
            graph.addVertice(tn);
            graph.addVertice(mo);
            graph.addVertice(ky);
            graph.addVertice(ga);
            graph.addVertice(fl);
            graph.addVertice(sc);
            graph.addTo(ga, tn);
            graph.addTo(fl, tn);
            graph.addTo(mo, tn);
            graph.addTo(sc, mo);
            graph.addTo(mo, ky);
            graph.addTo(fl, ky);
            graph.addTo(sc, ky);
            graph.addTo(mo, ga);
            graph.addTo(ga, fl);
            graph.addTo(mo, fl);
            graph.addTo(sc, fl);
            graph.print();
            answer_1+= graph.to_print() + "\n";

            answer_1 += "Tranforming this into a matrix by applying the Colley Method produces the matrix:\n";
            
            Matrix6x7 matrix = graph.toMatrix6x7_Colley();
            String output = matrix.to_print();
            System.out.println(output);
            answer_1 += output + "\n";
            answer_1+= "Tranforming it into its RREF matrix I get:\n";
            matrix.rref();
            output = matrix.to_print();
            answer_1 += output + "\n";
            System.out.println(output);
            answer_1 += "The matrix shows us that the rankings of the teams is #1 - Missouri, #2 - South Carolina, #3 - Georgia, #4 - Florida, #5 Kentucky, #6 Tennessee.\n\n\n\n\n";

            //Begin prob 2;
            String answer_2 = "1) Given the directed graph in problem two I can create a matrix from is by applying the Massey method. First writing the table as a list, with the item most left of the list being the team we are analyzing and the rest the teams the source won against, I get the list: \n";
            answer_2+= graph.to_print() + "\n";
            answer_2 += "Tranforming this into a matrix by applying the Massey Method produces the matrix:\n";
            
            Matrix6x7 matrix_m = graph.toMatrix6x7_Massey();
            output = matrix_m.to_print();
            System.out.println(output);
            answer_2 += output + "\n";
            answer_2+= "Tranforming it into its RREF matrix I get:\n";
            matrix_m.rref();
            output = matrix_m.to_print();
            answer_2 += output + "\n";
            System.out.println(output);
            answer_2 += "The matrix shows us that the rankings of the teams is #1 - Missouri, #2 - South Carolina, #3 - Florida, #4 - Georgia, #5 - Tennessee, #6 Kentucky.\n\n\n\n\n";

            String answer_3 = "";
            answer_3 += "Question: Based on the ranking of the six teams I would expect Georgia to win if they play against Kentucky. I expect this because Georgia is much more highly ranked when compared to Kentucky in the six teams. I would expect Georgia to win by a total of it Massey ranking minus Kentucky's Massey ranking which is -1.1 - (-10.1) = 9 points margin of victory for Georgia.";

            //File iFile = new File("ProjZen.txt");
            try{
            FileWriter iWriter = new FileWriter("ProjZen.txt");
            iWriter.write(answer_1 + answer_2 + answer_3);
            iWriter.close();
            } catch(Exception e){
                System.out.println(e);
            }
        }
}