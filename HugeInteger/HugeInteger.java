
//hw1 8.16


public class HugeInteger {
	int[] num;    
	
	//constructor
	HugeInteger(String str) {
	    parse(str);
	}
	HugeInteger(int len) {
		num = new int[len]; 
	}
	void parse(String str) {
	    num = new int[str.length()];
	    for(int i = 0; i < str.length(); i++) 
	    	num[i] = str.charAt(i) - '0';//to dig
	}
	    
	public String toString() {
	    String str = "";
	    int len = num.length-1;
	    for(int i = len; i >= 0; i--) 
	        str = num[i] + str;
	    return str;
	}

	public boolean isEqualTo(HugeInteger X) {
	    if(this.num.length!=X.num.length)
	    	return false;
	    for (int i = 0; i < this.num.length; i++)
	        if (this.num[i] != X.num[i])
	            return false;
	    return true;
	}
	    
	public boolean isNotEqualTo(HugeInteger X) {
	    if(!this.isEqualTo(X))
		    return true;
	    return false;
	}
	    
	public boolean isGreaterThan(HugeInteger X) {
	    if(this.num.length>X.num.length)
	        return true;
	    else if(this.num.length == X.num.length) {
	        for (int i = 0; i < this.num.length; i++) {
	            if (num[i] > X.num[i])
	                return true;
	            if (num[i] < X.num[i])
	                return false;
	        }
	        return false;
	    }
	    else
	        return false; 
	}
	    
	public boolean isLessThan(HugeInteger X) {
	    if(!this.isEqualTo(X) && !this.isGreaterThan(X))
	    	return true;
	    return false;
	}
	    
	    
	    
	public boolean isGreaterThanOrEqualTo(HugeInteger X) {
	    if(this.isEqualTo(X) || this.isGreaterThan(X))
	    	return true;
	    return false;
	}
	    
	public boolean isLessThanOrEqualTo(HugeInteger X) {
	    if(this.isLessThan(X) || this.isEqualTo(X))
	    	return true;
	    return false;
	}
	    
	public boolean isZero() {
	    if (this.num[0]==0)
	        return true;
	    return false;
	}
	        
	public HugeInteger add(HugeInteger X) {	
	    //deal with different number of digits
	    HugeInteger x = this;
	    HugeInteger y = X;
	    int offset = x.num.length-y.num.length;
	    int len = y.num.length;
	    HugeInteger result  = new HugeInteger(this.num.length);
	        
	    if(X.num.length > this.num.length) {
	        x = X;
	        y = this;
	        offset = X.num.length-this.num.length;
	        len = this.num.length;
	        result = new HugeInteger(X.num.length + 1);
	    }
	    // start to add
	    int carry = 0;
	    int i=this.num.length-1;
	    for(int j=len-1;j>=0; i--,j--) {
	        result.num[i] = x.num[i] + y.num[j] + carry;
	            
	        if(result.num[i] < 10) 
	            carry = 0;
	        else {
	            carry = 1;
	            result.num[i] %= 10;
	        }
	    }
	        
	    //deal with different number of digits
	    while(offset>0) {
            offset--;
	        result.num[offset] = carry+x.num[offset];
	        carry = 0;
	    }
	    //deal with overflow
	    if(carry !=0) {
	        HugeInteger overflowResult = new HugeInteger(this.num.length + 1);
	        overflowResult.num[0] = 1;
	        for(int j=1; j<=this.num.length; j++) 
	        	overflowResult.num[i] = result.num[i-1];
	        return overflowResult;
	    }    
	    return result;
	}
	    
	public HugeInteger subtract(HugeInteger X) {
	    //deal with different number of digits
	    int offset = this.num.length-X.num.length; 
	    int len = X.num.length;
	    HugeInteger result  = new HugeInteger(this.num.length);
	    	
	    //start to subtract
	    int borrow = 0;
	    for(int i = len+offset-1,j=len-1; i >= 0 && j>=0; i--,j--) {
	        result.num[i] = this.num[i] - X.num[j] - borrow;
	        if(result.num[i] >= 0) 
	            borrow = 0;
	        else{
	            result.num[i] += 10;
	            borrow = 1;
	        }
	    }
	    //deal with different number of digits
	    while(offset>0) {
	        offset--;
	        result.num[offset] = this.num[offset]-borrow;
	        if(result.num[offset] >= 0) 
	            borrow = 0;
	        else{
	            result.num[offset] += 10;
	            borrow = 1;
	        }   
	    }
	    //deal with the problem that first number is 0    
	    if(result.num[0]==0) {
	        HugeInteger newResult  = new HugeInteger(this.num.length-1);
	        for(int i=0;i<this.num.length-1;i++) 
	            newResult.num[i] = result.num[i+1]; 
	        return newResult;
	    }
	    return result;
	}
}

