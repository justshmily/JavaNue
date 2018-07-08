package txr.io;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

//app,java
public class KaisaWriter extends FilterWriter{

	Writer out;
	
	protected KaisaWriter(Writer out) {
		super(out);
		this.out=out;
	}
	
	@Override
	public void write(String str) throws IOException {
		
		char[] data=str.toCharArray();
		for(int i=0;i<data.length;i++) {
			data[i]+=1;
		}
		out.write(data,0,data.length);
	}
	
	@Override
	public void write(int src) throws IOException {
		out.write(src+1);
	}
}
