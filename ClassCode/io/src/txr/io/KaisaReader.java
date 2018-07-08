package txr.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class KaisaReader extends FilterReader{

	Reader in;
	
	protected KaisaReader(Reader in) {
		super(in);
		this.in=in;	
	}
	
	@Override
	public int read(char[] arg0) throws IOException {
		for(int i=0;i<arg0.length;i++){
			arg0[i]-=1;
		}
		return in.read(arg0);
	}
	
	@Override
	public int read() throws IOException {
		return in.read()-1;
	}
}
