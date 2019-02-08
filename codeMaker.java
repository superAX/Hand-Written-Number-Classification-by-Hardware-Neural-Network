package codeMaker;

import java.io.*;

public class codeMaker {
	public static void getCode() {
		try {
			PrintWriter out = new PrintWriter("code.v"); 
			
			// Weight Counter
			int outCounterWgt = 0;
			// Pixel Counter
			int outCounterPix = 0;
			// Case Counter
			int caseCounter = 1;
			
			// For each out
			for(int x=0; x<10; x++) {
				for(int i=0; i<56; i++) {
					out.write("    10'd");
					out.write(Integer.toString(caseCounter));
					caseCounter++;
					out.write(":\n");
					out.write("        begin\n");
					for(int j=0; j<14; j++) {
						if(j == 0) {
							out.write("            wr");
						} else {
							out.write("wr");
						}
						out.write(Integer.toString(j));
						out.write("<=w_");
						out.write(Integer.toString(x));
						out.write("_");
						out.write(Integer.toString(outCounterWgt));
						out.write("; ");
						outCounterWgt++;
					}
					out.write("\n");
					for(int k=0; k<14; k++) {
						if(k==0) {
							out.write("            r");
						} else {
							out.write("r");
						}
						out.write(Integer.toString(k));
						out.write("<=Pix_");
						out.write(Integer.toString(outCounterPix));
						out.write("; ");
						outCounterPix++;
					}
					out.write("\n");
					out.write("            select<=select+1");
					out.write(";\n");
					out.write("        end\n");
				}
				outCounterWgt = 0;
				outCounterPix = 0;
				out.write("    10'd");
				out.write(Integer.toString(caseCounter));
				caseCounter++;
				out.write(":\n");
				out.write("        begin\n");
				out.write("            bias_p<=px_784;\n");
				out.write("            bias_w<=w_");		
				out.write(Integer.toString(x));
				out.write("_784;\n");
				out.write("            select<=select+1;\n");
				out.write("        end\n");
			}
			out.write("    default: seq=10'bxxxxxxxxxx;\n");
			out.write("endcase");
			
			out.close();
			
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();		
		}	
	} 
	
	
 	
	public static void main(String[] args) throws IOException {
		getCode();
	}	
}
