package leetcode_ZigZagConversion;

import java.util.ArrayList;

public class Solution {
	public String convert(String s, int nRows) {
		if(nRows==1) {
			return s;
		}
		int len = s.length();
		if(len<=nRows) {
			return s;
		}
		int nCol, num = nRows, empty, pos=0;
		boolean upDown = true;//true goes up, false goes down
		String col;
		ArrayList<String> charM = new ArrayList<String>();
		while(len>0) {
			col = new String();
			empty = (nRows-num)/2;
			for(int i=0; i<empty; i++) {
				col += '#';
			}
			for(int i=empty; i<nRows-empty; i++) {
				if(pos+i-empty<s.length()) {
					col += s.charAt(pos+i-empty);
				}
				else {
					col += '#';
				}				
			}
			pos += nRows - 2*empty;
			for(int i=nRows-empty; i<nRows; i++) {
				col += '#';
			}
			charM.add(col);
			len -= num;
			if(num-2<=0 || num+2>nRows) {
				upDown = !upDown;
			}
			if(upDown) {
				num += 2;
			}
			else {
				num -= 2;
			}
		}
		nCol = charM.size();
		char tmp;
		String result = new String();
		for(int i=0; i<nRows; i++) {
			for(int j=0; j<nCol; j++) {
				tmp = charM.get(j).charAt(i);
				if(tmp!='#') {
					result += tmp;
				}
			}
		}
		return result;
    }
}
